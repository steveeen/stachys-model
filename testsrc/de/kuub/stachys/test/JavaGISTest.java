/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.test;

import de.kuub.stachys.thenew.Species;
import de.kuub.stachys.thenew.SpeciesScienceName;
import de.kuub.test.AbstractTest;
import de.kuub.utils.ExceptionHelper;
import java.util.Date;
import javax.persistence.PersistenceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bonke
 */
public class JavaGISTest extends AbstractTest {

    public JavaGISTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of mapSpecies method, of class JavaGIS.
     */
    @Test
    public void testMapSpecies() {
        System.out.println("mapSpecies");
        try {
            this.em2.getTransaction().begin();




            Species bla = new Species();
            bla.setOldid(23774);


            bla.setSyslogcreatedOn(new Date());
            bla.setSyslogcreatedby("STEVE!");
            bla.setSysloglastChangedBy("Steve");
            bla.setSysloglastChangedOn(new Date());


            em2.persist(bla);

            SpeciesScienceName tmp = new SpeciesScienceName();
            tmp.setFamily("fksldfjsldk");
            tmp.setNamesource("unknown");
            tmp.setSpecies("Jlkjdsflsdjf");
            tmp.setSubspecies("jkldjflsdkjfslk");
            tmp.setSyslogcreatedOn(new Date());
            tmp.setSyslogcreatedby("STEVE!");
            tmp.setSysloglastChangedBy("Steve");
            tmp.setSysloglastChangedOn(new Date());
            tmp.setSpeciesRef(bla);
            em2.persist(tmp);


            bla.setMainScienceName(tmp);



            em2.merge(bla);
            em2.getTransaction().commit();
            em2.clear();

            System.out.println("jkl$" + bla.getSpeciesId());
        } catch (PersistenceException ex) {
            ExceptionHelper.ParsePersistenceException(ex);
        }
    }
}
