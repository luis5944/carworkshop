/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.transaction.Transactional;
import modelo.Bonificacion;
import modelo.BonificacionId;
import modelo.Cliente;
import modelo.Coche;
import modelo.Empleado;
import modelo.Reparacion;
import modelo.ReparacionId;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Luis
 */
public class GestionReparaciones {

    /**
     * Método para dar de alta un empleado
     *
     * @param codigoE
     * @param nomemp
     * @param salario
     */
    public static void altaEmpleado(int codigoE, String nomemp, float salario) {
        Set reparacions = new HashSet(0);
        Set bonificacions = new HashSet(0);
        Empleado emp = new Empleado(codigoE, nomemp, salario, reparacions, bonificacions);
        if (comprobarEmpl(codigoE, nomemp)) {
            JOptionPane.showMessageDialog(null, "Ya existe el empleado");
            return;
        }
        Conexion.getSession().save(emp);
    }

    /**
     * Método para rellenar una lista con los clientes
     *
     * @param lista
     */
    public static void rellenarLista(DefaultListModel lista) {

        String consulta = "from Cliente c";
        Cliente c = new Cliente();

        Query q = Conexion.getSession().createQuery(consulta);
        ArrayList resultado = (ArrayList) q.list();
        if (!resultado.isEmpty()) {
            for (Object object : resultado) {
                c = (Cliente) object;
                lista.addElement(c);
            }
        }

    }

    /**
     * Método para comprobar si ya existe un empleado
     *
     * @param codigoE
     * @param nomemp
     * @return
     */
    public static boolean comprobarEmpl(int codigoE, String nomemp) {
        String consulta = "from Empleado e"
                + " where e.codemp= ? or e.nomemp =?";

        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codigoE);
        q.setString(1, nomemp);
        ArrayList resultado = (ArrayList) q.list();
        if (resultado.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Método para llenar el combo de empleados
     *
     * @param cbEmpleados
     */
    public static void llenarComboEmpleados(JComboBox cbEmpl) {

        String consulta = "from Empleado e";
        Empleado e = new Empleado();
        cbEmpl.removeAllItems();
        Query q = Conexion.getSession().createQuery(consulta);
        ArrayList resultado = (ArrayList) q.list();
        if (!resultado.isEmpty()) {
            for (Object object : resultado) {
                e = (Empleado) object;
                cbEmpl.addItem(e);
            }
        }

    }

    /**
     * Método para saber si el empleado puede hacer reparaciones (máximo 3 por
     * empleado a la vez)
     *
     * @param codemp
     * @return
     */
    public static boolean reparacionesEmpleado(long codemp) {
        String consulta = "select count(*) from Empleado e, e.reparacions r where e.codemp = ? and r.fechaf is null";
        Query q = null;

        q = Conexion.getSession().createQuery(consulta);
        q.setLong(0, codemp);
        long cantidad = (long) q.uniqueResult();
        System.out.println(cantidad);
        if (cantidad >= 3) {
            return false;
        }

        return true;
    }

    /**
     * Método para dar de alta una reparación. Para ello, primero necesitamos
     * crear una ReparacionId. Una vez hecha, podemos crear la reparación
     *
     * @param codemp
     * @param matricula
     * @param importe
     * @param fechai
     * @param e
     */
    public static void altaReparacion(int codemp, String matricula, double importe, Date fechai, Empleado e) {

        if (!reparacionesEmpleado(codemp)) {
            JOptionPane.showMessageDialog(null, "Este empleado ya está trabajando en 3 reparaciones.");
            return;
        }

        ReparacionId reparacionId = new ReparacionId(codemp, matricula, fechai);

        Coche c = (Coche) Conexion.getSession().get(Coche.class, matricula);
        Reparacion reparacion = new Reparacion(reparacionId, c, e, importe, null);

        Conexion.getSession().save(reparacion);
        JOptionPane.showMessageDialog(null, "Reparación agregada");

    }

    /**
     * Método para listar los coches de un determinado cliente en una tabla
     *
     * @param codcliente
     * @param modelo
     */
    public static void listarCoches(int codcliente, DefaultTableModel modelo) {
        Coche c = null;
        modelo.setRowCount(0);

        String consulta = "select co from Cliente c, c.coches co where c.codcli =?";
        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codcliente);
        ArrayList resulList = (ArrayList) q.list();
        for (Object o : resulList) {
            c = (Coche) o;
            modelo.setRowCount(modelo.getRowCount() + 1);
            modelo.setValueAt(c.getMatricula(), modelo.getRowCount() - 1, 0);
            modelo.setValueAt(c.getMarca(), modelo.getRowCount() - 1, 1);
            modelo.setValueAt(c.getModelo(), modelo.getRowCount() - 1, 2);

        }

    }

    /**
     * Método para listar las reparaciones de un determinado cliente en una
     * tabla
     *
     * @param codigo
     * @param modelo
     */
    public static void listarReparacion(int codigo, DefaultTableModel modelo) {
        modelo.setRowCount(0);
        String consulta = "select r from Cliente c, c.coches coche, coche.reparacions r where c.codcli = ? and fechaf is null";
        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codigo);
        ArrayList resulList = (ArrayList) q.list();

        for (Object o : resulList) {
            Reparacion r = (Reparacion) o;

            modelo.setRowCount(modelo.getRowCount() + 1);

            modelo.setValueAt(r.getId().getFechai(), modelo.getRowCount() - 1, 0);

            modelo.setValueAt(r.getCoche().getMatricula(), modelo.getRowCount() - 1, 1);
            modelo.setValueAt(r.getEmpleado().getCodemp(), modelo.getRowCount() - 1, 2);
            modelo.setValueAt(r.getEmpleado().getNomemp(), modelo.getRowCount() - 1, 3);
            modelo.setValueAt(r.getImporte(), modelo.getRowCount() - 1, 4);
        }

    }

    /**
     * Método para dar de baja una reparación. Mandando por parámetro la fecha
     * inicial de reparación y la matricula del coche. De esta manera, si dos
     * coches diferentes con la misma fecha de entrada ya no da error al dar de
     * baja esa reparación
     *
     * @param fechai
     * @param fechaf
     * @param importe
     * @param matricula
     * @return
     */
    public static void bajaReparacion(String fechai, Date fechaf, double importe, String matricula) {

        String consulta = "select r from Reparacion r, r.id where fechai = ? and r.coche.matricula = ?";

        Reparacion r = new Reparacion();

        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, fechai);
        q.setString(1, matricula);

        r = (Reparacion) q.uniqueResult();

        r.setFechaf(fechaf);
        r.setImporte(importe);
        Conexion.getSession().update(r);

    }

    /*
    Planteamiento de las bonificaciones:
    1º Cuando se da alta una reparacion de un empleados, se crea una bonificación con el mes actual y con la bonifiación en null
    2º Cuando se cierre una reparación, se hace un sumatorio de todas las reparaciones de ese empleado. 
    Si ese empleado tiene una facturación mayor a 1000€ se hace un update con el 0.05% del sumatorio y se mete en bonificacion.
    3º Así cada vez que se cierra una reparación se comprueba la facturación de ese empleado cada mes y si sobrepasa los 1000€ o va aumentando esa cantidad se va actualizando.
     */
    /**
     * Método para recoger una bonificacion dado un mes y un empleado
     *
     * @param mes
     * @param codemp
     * @return
     */
    public static Bonificacion getBonificacion(String mes, int codemp) {

        String consulta = "select b from Bonificacion b where b.id.mes = ? and b.id.codemp=?";
        Bonificacion b = new Bonificacion();

        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, mes);
        q.setInteger(1, codemp);
        b = (Bonificacion) q.uniqueResult();

        return b;

    }

    /**
     * Método para crear una bonificación de un empleado en un mes concreto. Con
     * el método getBonificacion podemos comprobar si existe o no esa
     * bonificacion y asi no da problema de duplicate key (aunque no rompe el
     * programa)
     *
     * @param codemp
     * @param mes
     */
    public static void crearBonificacionMesEmpleado(int codemp, String mes) {

        BonificacionId bId = new BonificacionId(codemp, mes);
        Empleado e = (Empleado) Conexion.getSession().get(Empleado.class, codemp);

        Bonificacion b = new Bonificacion(bId, e);

        Bonificacion bo = getBonificacion(mes, codemp);

        if (bo == null) {
            Conexion.getSession().save(b);

            System.out.println("Creamos bonificacion");

        } else {
            System.out.println("Ya existe esa bonificacion en ese mes");
        }

    }

    /**
     * Método para actualizar el importe de una bonificación dado un mes y un
     * empleado. Cada vez que se cierra/acaba una reparación se hace la
     * actualización. Para hacer esta actualización se necesita una suma de
     * +1000€ en ese mes para hacer esa bonificación.
     *
     * @param codemp
     * @param mes
     */
    public static void updateImporteBonificacion(int codemp, String mes) {

        String consulta = "select COALESCE(sum(r.importe),0) from Empleado e, e.reparacions r where e.codemp = ? and r.fechaf is not null and MONTH(r.fechaf) = ?";

        Bonificacion b = getBonificacion(mes, codemp);

        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codemp);
        q.setString(1, mes);

        double importe = (double) q.uniqueResult();
        System.out.println(importe);
        if (importe > 1000d) {

            b.setImportebonificado((float) (importe * 0.05));
        } else {
            b.setImportebonificado(null);
        }

        Conexion.getSession().update(b);

    }

}
