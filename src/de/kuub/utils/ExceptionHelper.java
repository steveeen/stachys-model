/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.utils;

import java.sql.BatchUpdateException;
import javax.persistence.PersistenceException;

/**
 *
 * @author Bonke
 */
public class ExceptionHelper {

    public static void ParsePersistenceException(PersistenceException ex) {
        ex.printStackTrace();
        Throwable tt = ex.getCause();
        while (tt != null) {
            tt.getMessage();

            if (tt.getClass() == BatchUpdateException.class) {
                ((BatchUpdateException) tt).getNextException().printStackTrace();
            }
            tt = tt.getCause();
        }
    }
}
