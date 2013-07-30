/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys;

/**
 *
 * @author Bonke
 */
import de.kuub.stachys.model.old.Fundort;
import de.kuub.stachys.model.old.Personen;
import de.kuub.stachys.model.old.Taxonomisch;
import de.kuub.stachys.model.old.Users;
import de.kuub.stachys.model.old.Zaehldaten;
import de.kuub.stachys.thenew.SearchPlace;
import de.kuub.stachys.thenew.Species;
import de.kuub.stachys.thenew.Syslog;
import de.kuub.utils.ExceptionHelper;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class JavaGIS {

    private static final String PERSISTENCE_UNIT_NAME = "stachys";

    private static final String PERSISTENCE_UNIT_NAME2 = "stachysnew";

    private static EntityManagerFactory factory, fac2;

    public static void main(String[] args) {

        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            Query q = em.createQuery(" from Taxonomisch");
            List<Taxonomisch> todoList = q.getResultList();

            q = em.createQuery(" from Personen");
            List<Personen> pList = q.getResultList();
            q = em.createQuery(" from Userso");
            List<Users> uList = q.getResultList();
            q = em.createQuery(" from Zaehldaten");
            List<Zaehldaten> zLi = q.getResultList();
            q = em.createQuery(" from Fundort");
            List<Fundort> foLi = q.getResultList();

            fac2 = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME2);
            EntityManager em2 = fac2.createEntityManager();
            //Transfer all Species to Stachys01
            SpeciesMapper map = new SpeciesMapper(em2);
            Map<Integer, Species> speli = map.TransferSpecies(todoList);
            PersonMapper map2 = new PersonMapper(em2);
            Map<Integer, de.kuub.stachys.thenew.User> uLi = map2.TransferUsers(uList);
            Map<Integer, de.kuub.stachys.thenew.Person> pLi = map2.TransferPersons(pList, uLi);
            Map<Integer, SearchPlace> fol = map2.TransferFODatas(foLi);
            map2.TransferZDatas(zLi, pLi, fol, speli);
            em2.close();
        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
        }
    }

    public static <T extends Syslog> T FillSysLog(T tmp) {
        tmp.setSyslogcreatedOn(new Date());
        tmp.setSyslogcreatedby("STEVE!");
        tmp.setSysloglastChangedBy("Steve");
        tmp.setSysloglastChangedOn(new Date());
        return tmp;
    }
}
