/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;

/**
 * This testCase object works in conjunction with a test persistence unit you
 * define in your persistence.xml. It sets up an entity manager that is aware of
 * all the classes in your build path.
 *
 * Inherit from this class to build unit tests which need an entity manager.
 *
 * @author shawn
 *
 */
public abstract class AbstractTest {

    private static final String TEST_PERSISTENCE_UNIT = "stachys";

    private static final String TEST_PERSISTENCE_UNIT2 = "stachysnew";

    private EntityManagerFactory emf, emf2;

    protected EntityManager em;

    protected EntityManager em2;

    public AbstractTest() {
        super();
    }

    @Before
    public void initEmfAndEm() {
        emf = Persistence.createEntityManagerFactory(TEST_PERSISTENCE_UNIT);
        em = emf.createEntityManager();
        emf2 = Persistence.createEntityManagerFactory(TEST_PERSISTENCE_UNIT2);
        em2 = emf.createEntityManager();
    }

    @After
    public void closeEmfAndEm() {
        em.close();
        emf.close();
        em2.close();
        emf2.close();
    }
}
