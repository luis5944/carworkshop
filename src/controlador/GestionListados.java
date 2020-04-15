/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Coche;
import modelo.Empleado;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Luis
 */
public class GestionListados {

    /**
     * Método que ordena los coches por modelo en una tabla dado un determinado
     * cliente.
     *
     * @param codcliente
     * @param modelo
     */
    public static void listarCochesPorModelo(int codcliente, DefaultTableModel modelo) {

        Coche c = null;

        String consulta = "select co from Cliente c, c.coches co where c.codcli =? order by co.modelo";
        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codcliente);
        ArrayList resulList = (ArrayList) q.list();
        for (Object o : resulList) {
            c = (Coche) o;
            modelo.setRowCount(modelo.getRowCount() + 1);
            modelo.setValueAt(c.getMarca(), modelo.getRowCount() - 1, 0);
            modelo.setValueAt(c.getModelo(), modelo.getRowCount() - 1, 1);
            modelo.setValueAt(c.getMatricula(), modelo.getRowCount() - 1, 2);
        }
    }

    /**
     * Método que ordena los coches por marca en una tabla dado un determinado
     * cliente
     *
     * @param codcliente
     * @param modelo
     */
    public static void listarCochesPorMarca(int codcliente, DefaultTableModel modelo) {

        Coche c = null;

        String consulta = "select co from Cliente c, c.coches co where c.codcli =? order by co.marca";
        Query q = Conexion.getSession().createQuery(consulta);
        q.setInteger(0, codcliente);
        ArrayList resulList = (ArrayList) q.list();
        for (Object o : resulList) {
            c = (Coche) o;
            modelo.setRowCount(modelo.getRowCount() + 1);
            modelo.setValueAt(c.getMarca(), modelo.getRowCount() - 1, 0);
            modelo.setValueAt(c.getModelo(), modelo.getRowCount() - 1, 1);
            modelo.setValueAt(c.getMatricula(), modelo.getRowCount() - 1, 2);
        }

    }

    /**
     * Método para listar los empleados con nombre y salario en una tabla
     *
     * @param mes
     * @param modeloT
     */
    public static void listarTablaEmpleados(String mes, DefaultTableModel modeloT) {
        String consulta = "select e from Empleado e order by e.nomemp";

        Empleado e = null;

        Query q = Conexion.getSession().createQuery(consulta);
        ArrayList resultList = (ArrayList) q.list();

        for (Object object : resultList) {
            e = (Empleado) object;
            modeloT.setRowCount(modeloT.getRowCount() + 1);
            modeloT.setValueAt(e.getNomemp(), modeloT.getRowCount() - 1, 0);
            modeloT.setValueAt(e.getSalario(), modeloT.getRowCount() - 1, 1);
        }

    }

    /**
     * Método que dado el empleado y el mes que elijamos, lista las
     * bonificaciones de ese mes concreto
     *
     * @param mes
     * @param nomemp
     * @return
     */
    public static Object listarBonificaciones(String mes, String nomemp) {

        String consulta = "select e.nomemp, COALESCE(b.importebonificado,0) from Empleado e, e.bonificacions b where b.id.mes = ?  and e.nomemp = ?";
        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, mes);
        q.setString(1, nomemp);
        Object[] b = (Object[]) q.uniqueResult();
        if (b != null) {
            return b[1];
        }

        return 0;
    }

    /**
     * Método para listar los empleados con su facturación
     *
     * @param mes
     * @param modeloT
     */
    public static void listarFacturacionMes(String mes, DefaultTableModel modeloT) {

        String consulta = "select e.nomemp, COALESCE(sum(r.importe),0) from Empleado e,  e.reparacions r where MONTH(r.fechaf) = ? group by e.nomemp order by sum(r.importe) desc";

        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, mes);
        ArrayList result = (ArrayList) q.list();
        Iterator it = result.iterator();
        while (it.hasNext()) {
            Object[] ob = (Object[]) it.next();
            modeloT.setRowCount(modeloT.getRowCount() + 1);
            modeloT.setValueAt(ob[0], modeloT.getRowCount() - 1, 0);
            modeloT.setValueAt(ob[1], modeloT.getRowCount() - 1, 1);
        }

    }

    /**
     * Listamos los coches que están en el taller
     *
     * @param modeloT
     */
    public static void listarCochesTaller(DefaultTableModel modeloT) {
        String consulta = "select c.marca, c.modelo, c.matricula, c.cliente.nomcli, r.empleado.nomemp, r.id.fechai from Coche c, c.reparacions r where r.fechaf is null";
        ;
        Query q = Conexion.getSession().createQuery(consulta);
        ArrayList result = (ArrayList) q.list();
        Iterator it = result.iterator();

        while (it.hasNext()) {
            Object[] o = (Object[]) it.next();
            modeloT.setRowCount(modeloT.getRowCount() + 1);
            modeloT.setValueAt(o[0], modeloT.getRowCount() - 1, 0);
            modeloT.setValueAt(o[1], modeloT.getRowCount() - 1, 1);
            modeloT.setValueAt(o[2], modeloT.getRowCount() - 1, 2);
            modeloT.setValueAt(o[3], modeloT.getRowCount() - 1, 3);
            modeloT.setValueAt(o[4], modeloT.getRowCount() - 1, 4);
            modeloT.setValueAt(o[5], modeloT.getRowCount() - 1, 5);
        }

    }

    /**
     * Listamos las reparaciones historicas dado un cliente
     *
     * @param nomcli
     * @param modeloT
     */
    public static void listadoReparacionesHistorico(String nomcli, DefaultTableModel modeloT) {

        String consulta = "select c.nomcli, co.marca, co.modelo, count(*) from Cliente c left  join c.coches co, co.reparacions r where r.fechaf is not null and c.nomcli = ? group by r.id.matricula";

        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, nomcli);
        ArrayList result = (ArrayList) q.list();
        Iterator it = result.iterator();
        while (it.hasNext()) {
            Object[] o = (Object[]) it.next();

            modeloT.setRowCount(modeloT.getRowCount() + 1);
            modeloT.setValueAt(o[0], modeloT.getRowCount() - 1, 0);
            modeloT.setValueAt(o[1], modeloT.getRowCount() - 1, 1);
            modeloT.setValueAt(o[2], modeloT.getRowCount() - 1, 2);
            modeloT.setValueAt(o[3], modeloT.getRowCount() - 1, 3);

        }

    }

    /**
     * Método para dar la suma del importe gastado por un cliente en
     * reparaciones
     *
     * @param nombre
     * @param txt
     */
    public static void totalReparacionesPorCliente(String nombre, JTextField txt) {
        String consulta = "select COALESCE(sum(r.importe),0) from Cliente c left join c.coches co, co.reparacions r where c.nomcli = ?";

        Query q = Conexion.getSession().createQuery(consulta);
        q.setString(0, nombre);
        Object b = q.uniqueResult();
        if (b != null) {
            txt.setText(Double.parseDouble(b.toString()) + "€");
        }
    }
}
