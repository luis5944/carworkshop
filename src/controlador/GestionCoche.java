/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Coche;
import modelo.Reparacion;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Luis
 */
public class GestionCoche {

    /**
     * Método que devuelve si existe o no un cliente y el cliente mismo.
     *
     * @param codiCli
     * @return
     */
    public static Object[] existeCliente(int codiCli) {

        Cliente c = null;
        boolean existe = false;

        c = (Cliente) Conexion.getSession().get(Cliente.class, codiCli);

        if (c == null) {
            existe = false;
        } else {
            existe = true;
        }

        return new Object[]{c, existe};
    }

    /**
     * Método para saber si un coche ya existe con su matricula
     *
     * @param matricula
     * @return
     */
    public static boolean existeCoche(String matricula) {

        String consulta = "from Coche c where c.matricula = ?";
        boolean existe = false;

        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, matricula);

        Coche c = (Coche) q.uniqueResult();

        if (c != null) {
            existe = true;
        }

        return existe;
    }

    /**
     * Método para agregar un coche
     *
     * @param matricula
     * @param c
     * @param marca
     * @param modelo
     */
    public static void agregarCoche(String matricula, Cliente c, String marca, String modelo) {
        Coche coche = null;
        coche = new Coche(matricula, c, marca, modelo);

        Conexion.getSession().save(coche);

    }

    /**
     * Método para rellenar el combo con los coches de un cliente especifico
     *
     * @param cbCoches
     * @param codcli
     */
    public static void rellenarCombo(JComboBox cbCoches, int codcli) {
        String consulta = "select c from Coche c, c.cliente cliente where cliente.codcli = ?";
        Coche c = new Coche();

        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codcli);
        ArrayList resultado = (ArrayList) q.list();
        if (!resultado.isEmpty()) {
            for (Object object : resultado) {
                c = (Coche) object;
                cbCoches.addItem(c);
            }
        }
    }

    //PARA BORRAR SON DOS MÉTODOS
    /**
     * Método para saber si el coche (matricula) está en reparación
     *
     * @param matricula
     * @return
     */
    public static boolean estaCocheEnReparacion(String matricula) {
        String consulta = "from Coche co, co.reparacions where co.matricula = ? and fechaf is null";

        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, matricula);
        ArrayList resultado = (ArrayList) q.list();
        if (resultado.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * Borrar un coche dada su matricula. 1º Borramos las reparaciones,
     * previamente sabiendo que ya están finalizadas con el método
     * estaCocheEnReparacion(). 2º Borramos el coche del cliente
     *
     * @param matricula
     * @param modeloCoche
     */
    public static void borrarCoche(String matricula, JComboBox modeloCoche) {
        String consulta = "select reparacion from Coche coche, coche.reparacions reparacion where coche.matricula= ?";
        if (estaCocheEnReparacion(matricula)) {
            JOptionPane.showMessageDialog(null, "El coche está en reparación. No se puede borrar.");
            return;
        }
        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, matricula);
        ArrayList resultado = (ArrayList) q.list();
        Reparacion r = new Reparacion();

        for (Object object : resultado) {
            r = (Reparacion) object;
            Conexion.getSession().delete(r);
        }

        Coche c = (Coche) modeloCoche.getSelectedItem();
        Conexion.getSession().delete(c);

    }

}
