/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
 * from Cliente c, c.coches co where c.id = 10 para ver coches de un cliente
 */
public class GestionClientes {

    /**
     * Sirve para dar alta un cliente.
     *
     * @param codigoC
     * @param nomcli
     * @param direccion
     * @param email
     * @param tfno
     * @return
     */
    public static void altaCliente(int codigoC, String nomcli, String direccion, String email, String tfno) {
        Set coches = new HashSet(0);
        Cliente c = new Cliente(codigoC, nomcli, direccion, email, tfno, coches);
        Conexion.getSession().save(c);
    }

    /**
     * Sirve para coger los datos de un cliente existente
     *
     * @param codigoC
     * @return
     */
    public static Cliente getCliente(int codigoC) {
        String consulta = "from Cliente c\n"
                + "where codcli = ?";

        Cliente c = null;

        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codigoC);
        c = (Cliente) q.uniqueResult();

        return c;

    }

    /**
     * Sirve para actualizar los datos de un cliente dado
     *
     * @param c
     */
    public static void updateCliente(Cliente c) {

        Conexion.getSession().update(c);

    }

    //A partir de aquí es para borrar un clientes.
    /**
     * Sirve para meter los clientes en un combo
     *
     * @param cbCliente
     */
    public static void rellenarCombo(JComboBox cbCliente) {

        String consulta = "from Cliente c";
        Cliente c = new Cliente();

        Query q = Conexion.getSession().createQuery(consulta);
        ArrayList resultado = (ArrayList) q.list();
        if (!resultado.isEmpty()) {
            for (Object object : resultado) {
                c = (Cliente) object;
                cbCliente.addItem(c);
            }
        }

    }

    /**
     * Sirve para saber si el cliente tiene coches en reparación.
     *
     * @param codCli
     * @return
     */
    public static boolean hayCochesReparacion(int codCli) {
        String consulta = "from Cliente c, c.coches co, "
                + "co.reparacions where c.codcli= ? and fechaf is null";

        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codCli);
        ArrayList resultado = (ArrayList) q.list();
        if (resultado.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Borra el cliente previo comprobación de los anteriores métodos. 1º Borra
     * las reparaciones (si tiene) - en el método hayCochesReparacion
     * comprobamos que no tenga reparaciones en marcha 2º Borra los coches (si
     * tiene) 3º Borra el cliente
     *
     * @param codCli
     * @param modeloCliente
     */
    public static void borrarCliente(int codCli, JComboBox modeloCliente) {

        if (hayCochesReparacion(codCli)) {
            JOptionPane.showMessageDialog(null, "Tiene reparaciones en marcha");
            return;
        }
        
        String consulta = "select reparacion from Cliente cliente, cliente.coches coche, coche.reparacions reparacion where cliente.codcli= ?";
        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codCli);
        ArrayList resultado = (ArrayList) q.list();
        Reparacion r = new Reparacion();

        for (Object object : resultado) {
            r = (Reparacion) object;
            Conexion.getSession().delete(r);
        }

        consulta = "select coche from Clientesss cliente, cliente.coches coche where cliente.codcli= ?";
        q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codCli);
        resultado = (ArrayList) q.list();
        Coche c = new Coche();
        for (Object object : resultado) {
            c = (Coche) object;
            Conexion.getSession().delete(c);
        }

        Cliente cl = (Cliente) modeloCliente.getSelectedItem();
        Conexion.getSession().delete(cl);

    }

}
