/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Luis
 */
public class Conexion {

    private static Session session;

    public static void abrirBD() {
        if (session == null) {
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
            } catch (HibernateException ex) {
                ex.getMessage();
            }
        }
    }

    public static void cerrarBD() {
        if (session != null) {
            try {
                session.close();
                session = null;

            } catch (HibernateException ex) {
                ex.getMessage();
            }
        }
    }

    public static Session getSession() {
        return session;
    }
}
