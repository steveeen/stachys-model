/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys;

import de.kuub.stachys.model.old.Fundort;
import de.kuub.stachys.model.old.Personen;
import de.kuub.stachys.model.old.Users;
import de.kuub.stachys.model.old.Zaehldaten;
import de.kuub.stachys.thenew.CountedSpecies;
import de.kuub.stachys.thenew.CountedSpeciesPerson;
import de.kuub.stachys.thenew.Person;
import de.kuub.stachys.thenew.SearchPlace;
import de.kuub.stachys.thenew.Species;
import de.kuub.utils.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author Bonke
 */
public class PersonMapper {

    private static EntityManager emr;

    public PersonMapper(EntityManager em) {
        emr = em;
    }

    public Map<Integer, Person> TransferPersons(List<Personen> persList, Map<Integer, de.kuub.stachys.thenew.User> uli) {
        try {
            emr.getTransaction().begin();
            Map<Integer, Person> pLi = new HashMap<>();
            for (Personen todo : persList) {

                System.out.println(todo.toString());
                Person bla = new Person();
                bla.setEmail(todo.getEmail());
                bla.setFirstname(todo.getVname());
                bla.setLastname(todo.getName());
                bla.setLocation(todo.getOrt());
                bla.setRole(todo.getRole());
                bla.setMiscellaneous(todo.getSonstiges());
                bla.setOldpid(todo.getPersId());
                if (todo.getUser() != null) {
                    bla.setOlduid(todo.getUser().getUserId());
                    bla.setUserId(uli.get(todo.getUser().getUserId()));
                }
                bla = JavaGIS.FillSysLog(bla);
                emr.persist(bla);
                pLi.put(bla.getOldpid(), bla);
            }

            emr.getTransaction().commit();
            emr.clear();
            return pLi;
        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
        }
        return null;
    }

    public Map<Integer, de.kuub.stachys.thenew.User> TransferUsers(List<Users> userlist) {
        try {
            emr.getTransaction().begin();
            Map<Integer, de.kuub.stachys.thenew.User> usrl = new HashMap<>();
            for (Users todo : userlist) {
                de.kuub.stachys.thenew.User us = new de.kuub.stachys.thenew.User();
                us.setOldid(todo.getUserId());
                us.setPassword(todo.getPass());
                us.setSalt(todo.getSalt());
                us.setTrusted(todo.getTrusted());
                us.setUsername(todo.getName());
                us = JavaGIS.FillSysLog(us);
                emr.persist(us);
                usrl.put(us.getOldid(), us);
            }

            emr.getTransaction().commit();
            emr.clear();
            return usrl;
        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
        }
        return null;
    }

    void TransferZDatas(List<Zaehldaten> zLi, Map<Integer, Person> pLi, Map<Integer, SearchPlace> foli, Map<Integer, Species> spli) {
        try {
            emr.getTransaction().begin();
            for (Zaehldaten zdn : zLi) {
                CountedSpecies bla = new CountedSpecies();
                bla.setOldid(zdn.getZdId());
                bla.setArea(foli.get(zdn.getFoId().getFoId()));
                bla.setComments(zdn.getErgaenzung());
                bla.setBlooming(zdn.getBNb());
                bla.setEstimation(zdn.getSchaetzwert());
                bla.setCountedUnits(zdn.getAnzahlabs());
                bla.setSpeciesId(spli.get(zdn.getArtId().getArtId()));
                bla.setYearofRecord(zdn.getAufnahmejahr());
                bla = JavaGIS.FillSysLog(bla);
                emr.persist(bla);
                Collection<CountedSpeciesPerson> plil = new ArrayList<>();
                if (zdn.getPersonenCollection() != null && !zdn.getPersonenCollection().isEmpty()) {
                    for (Personen karts : zdn.getPersonenCollection()) {
                        Person ttt = pLi.get(karts.getPersId());
                        CountedSpeciesPerson kartiers = new CountedSpeciesPerson(ttt.getPersId(), bla.getZdId());
                        JavaGIS.FillSysLog(kartiers);
                        plil.add(kartiers);
                    }
                }
                bla.setCountedSpeciespersonsCollection(plil);
                emr.merge(bla);
            }
            emr.getTransaction().commit();
            emr.clear();
        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
            emr.getTransaction().rollback();
            emr.clear();
        }
    }

    Map<Integer, SearchPlace> TransferFODatas(List<Fundort> foLi) {
        try {
            Map<Integer, SearchPlace> fol = new HashMap();
            emr.getTransaction().begin();
            for (Fundort fodn : foLi) {
                SearchPlace spn = new SearchPlace();
                spn.setRaster((int) fodn.getRaster());
                spn.setOldid(fodn.getFoId());
                spn.setArea(fodn.getArea());
                JavaGIS.FillSysLog(spn);
                emr.persist(spn);
                fol.put(spn.getOldid(), spn);

            }
            emr.getTransaction().commit();
            emr.clear();
            return fol;

        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
            emr.getTransaction().rollback();
            emr.clear();
        }
        return null;
    }
}
