/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys;

import de.kuub.stachys.model.old.Fundort;
import de.kuub.stachys.model.old.Personen;
import de.kuub.stachys.model.old.QuZeit;
import de.kuub.stachys.model.old.Quelle;
import de.kuub.stachys.model.old.Users;
import de.kuub.stachys.model.old.Zaehldaten;
import de.kuub.stachys.model.old.Zeitschrift;
import de.kuub.stachys.thenew.Authors;
import de.kuub.stachys.thenew.CountedSpecies;
import de.kuub.stachys.thenew.CountedSpeciesDataSource;
import de.kuub.stachys.thenew.DataSource;
import de.kuub.stachys.thenew.DataSourceMedium;
import de.kuub.stachys.thenew.Mapper;
import de.kuub.stachys.thenew.Person;
import de.kuub.stachys.thenew.PublicationMedium;
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

    Map<Integer, DataSource> TransferDaSoDatas(List<Quelle> quLi, Map<Integer, Person> pLi, Map<Integer, PublicationMedium> zeLi) {


        try {
            emr.getTransaction().begin();
            Map<Integer, DataSource> dslis = new HashMap<>();
            for (Quelle quell : quLi) {
                DataSource bla = new DataSource();
                bla.setPlace(quell.getOrt());
                bla.setPublished(quell.getPublikation());
                bla.setSrcTitle(quell.getTitel());
                bla.setType(quell.getQuellart());
                bla.setYear(quell.getJahr());
                bla.setOldid(quell.getQuellId());
                bla = JavaGIS.FillSysLog(bla);
                emr.persist(bla);
                Collection<Authors> auths = new ArrayList<>();
                if (quell.getPersonenCollection() != null && !quell.getPersonenCollection().isEmpty()) {
                    for (Personen author : quell.getPersonenCollection()) {
                        Person ttt = pLi.get(author.getPersId());
                        Authors auth2 = new Authors(bla.getDataSourceId(), ttt.getPersId());
                        JavaGIS.FillSysLog(auth2);
                        emr.persist(auth2);
                        auths.add(auth2);
                    }
                }
                bla.setAuthorsCollection(auths);
                emr.merge(bla);
                dslis.put(bla.getOldid(), bla);
                Collection<DataSourceMedium> dsms = new ArrayList<>();
                if (quell.getQuZeitCollection() != null && !quell.getQuZeitCollection().isEmpty()) {
                    for (QuZeit zor : quell.getQuZeitCollection()) {
                        PublicationMedium temp = zeLi.get(zor.getZeitschrift().getZeitschriftId());
                        DataSourceMedium dsss = new DataSourceMedium(bla.getDataSourceId(), temp.getPublicationMediumId());
                        dsss.setMediumValue(zor.getAusgabe());
                        JavaGIS.FillSysLog(dsss);
                        emr.persist(dsss);
                        dsms.add(dsss);
                    }
                }
                bla.setDatasourceMediumCollection(dsms);
                emr.merge(bla);
                dslis.put(bla.getOldid(), bla);
            }
            emr.getTransaction().commit();
            emr.clear();
            return dslis;
        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
            emr.getTransaction().rollback();
            emr.clear();
        }
        return null;
    }

    void TransferZDatas(List<Zaehldaten> zLi, Map<Integer, Person> pLi, Map<Integer, SearchPlace> foli, Map<Integer, Species> spli, Map<Integer, DataSource> dsli) {
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
                Collection<Mapper> plil = new ArrayList<>();
                if (zdn.getPersonenCollection() != null && !zdn.getPersonenCollection().isEmpty()) {
                    for (Personen karts : zdn.getPersonenCollection()) {
                        Person ttt = pLi.get(karts.getPersId());
                        Mapper kartiers = new Mapper(ttt.getPersId(), bla.getZdId());
                        JavaGIS.FillSysLog(kartiers);
                        plil.add(kartiers);
                    }
                }
                bla.setCountedSpeciespersonsCollection(plil);
                Collection<CountedSpeciesDataSource> csdsli = new ArrayList<>();
                if (zdn.getQuelleCollection() != null && !zdn.getQuelleCollection().isEmpty()) {
                    for (Quelle quelln : zdn.getQuelleCollection()) {
                        DataSource ttt = dsli.get(quelln.getQuellId());
                        CountedSpeciesDataSource csds = new CountedSpeciesDataSource(bla.getZdId(), ttt.getDataSourceId());
                        JavaGIS.FillSysLog(csds);
                        csdsli.add(csds);
                    }
                }
                bla.setCountedSpeciesDataSourceCollection(csdsli);
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

    Map<Integer, PublicationMedium> TransferPMediums(List<Zeitschrift> zeitLi) {
        try {
            Map<Integer, PublicationMedium> zeLi = new HashMap<>();
            emr.getTransaction().begin();
            for (Zeitschrift zeitschrift : zeitLi) {
                PublicationMedium zeit = new PublicationMedium();
                zeit.setPMediumTitle(zeitschrift.getTitel());
                zeit.setPMediumReference("Journal");
                JavaGIS.FillSysLog(zeit);
                zeit.setOldid(zeitschrift.getZeitschriftId());
                emr.persist(zeit);
                zeLi.put(zeit.getOldid(), zeit);
            }
            emr.getTransaction().commit();
            emr.clear();
            return zeLi;

        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
            emr.getTransaction().rollback();
            emr.clear();
        }
        return null;
    }
}
