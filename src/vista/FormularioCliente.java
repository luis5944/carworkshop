/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Conexion;
import controlador.GestionClientes;
import java.awt.CardLayout;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Cliente;
import org.hibernate.HibernateException;

/**
 *
 * @author luisfn
 */
public class FormularioCliente extends javax.swing.JDialog {

    public FormularioCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btnModificar.setEnabled(false);
        cargarCombo();
        this.setLocationRelativeTo(null);

    }

    public FormularioCliente(javax.swing.JDialog parent, boolean modal, String codigoCliente) {
        super(parent, modal);
        initComponents();
        btnModificar.setEnabled(false);
        cargarCombo();
        rbtBorrar.setEnabled(false);
        rbtModificar.setEnabled(false);
        txtCodigo.setText(codigoCliente);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbtAgregar = new javax.swing.JRadioButton();
        rbtModificar = new javax.swing.JRadioButton();
        rbtBorrar = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTlf = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoModificar = new javax.swing.JTextField();
        txtNombreModificar = new javax.swing.JTextField();
        txtDireccionModificar = new javax.swing.JTextField();
        txtEmailModificar = new javax.swing.JTextField();
        txtTlfModificar = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cbClientes = new javax.swing.JComboBox<>();
        btnBorrar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup1.add(rbtAgregar);
        rbtAgregar.setSelected(true);
        rbtAgregar.setText("Añadir cliente");
        rbtAgregar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtAgregarStateChanged(evt);
            }
        });
        rbtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtAgregarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtModificar);
        rbtModificar.setText("Modificar Cliente");
        rbtModificar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtModificarStateChanged(evt);
            }
        });
        rbtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtModificarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtBorrar);
        rbtBorrar.setText("Borrar Cliente");
        rbtBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBorrarActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Código Cliente");

        jLabel3.setText("Nombre");

        jLabel4.setText("Dirección");

        jLabel5.setText("Email");

        jLabel6.setText("Teléfono");

        txtCodigo.setText("1");

        txtNombre.setText("Alberto");

        txtDireccion.setText("Calle J");

        txtEmail.setText("alberto@gmail.com");

        txtTlf.setText("618031415");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(txtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTlf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel2, "AgregarCliente");

        jLabel7.setText("Teléfono");

        txtCodigoModificar.setText("1");
        txtCodigoModificar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoModificarFocusLost(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel2.setText("Código Cliente");

        jLabel8.setText("Nombre");

        jLabel9.setText("Dirección");

        jLabel10.setText("Email");

        jLabel11.setText("(busca cuando pierde el foco)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(btnModificar)
                    .addComponent(txtTlfModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDireccionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEmailModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTlfModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(25, 25, 25))
        );

        jPanel1.add(jPanel3, "ModificarCliente");

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnBorrar))
                    .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnBorrar)
                .addGap(113, 113, 113))
        );

        jPanel1.add(jPanel4, "BORRAR");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(rbtAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(rbtModificar)
                .addGap(62, 62, 62)
                .addComponent(rbtBorrar)
                .addGap(48, 48, 48))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtAgregar)
                    .addComponent(rbtModificar)
                    .addComponent(rbtBorrar))
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 508, 482);
    }// </editor-fold>//GEN-END:initComponents

    private void rbtAgregarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtAgregarStateChanged

    }//GEN-LAST:event_rbtAgregarStateChanged

    private void rbtModificarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtModificarStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_rbtModificarStateChanged

    private void rbtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtModificarActionPerformed
        CardLayout lo = (CardLayout) jPanel1.getLayout();
        lo.show(jPanel1, "ModificarCliente");
    }//GEN-LAST:event_rbtModificarActionPerformed

    private void rbtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAgregarActionPerformed
        CardLayout lo = (CardLayout) jPanel1.getLayout();
        lo.show(jPanel1, "AgregarCliente");
    }//GEN-LAST:event_rbtAgregarActionPerformed
    private void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtTlf.setText("");
    }

    private void limpiarModificar() {
        txtCodigoModificar.setText("");
        txtNombreModificar.setText("");
        txtDireccionModificar.setText("");
        txtEmailModificar.setText("");
        txtTlfModificar.setText("");
    }

    private boolean comprobaciones() {
        boolean comprobar = true;
        if (txtCodigo.getText().isEmpty()) {
            comprobar = false;
        }
        if (txtDireccion.getText().isEmpty()) {
            comprobar = false;
        }
        if (txtEmail.getText().isEmpty()) {
            comprobar = false;
        }
        if (txtNombre.getText().isEmpty()) {
            comprobar = false;
        }
        if (txtTlf.getText().isEmpty()) {
            comprobar = false;
        }
        return comprobar;
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (comprobaciones()) {

            try {
                Conexion.abrirBD();
                GestionClientes.altaCliente(Integer.parseInt(txtCodigo.getText()), txtNombre.getText(), txtDireccion.getText(), txtEmail.getText(), txtTlf.getText());
                Conexion.getSession().getTransaction().commit();
                limpiar();
            } catch (HibernateException ex) {
                if (ex.getCause().toString().contains("Duplicate entry")) {
                    JOptionPane.showMessageDialog(this, "Ya existe");
                    limpiar();
                }
                Conexion.getSession().getTransaction().rollback();

            } finally {
                Conexion.cerrarBD();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Campos vacíos.");
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        try {
            Conexion.abrirBD();
            Cliente c = GestionClientes.getCliente(Integer.parseInt(txtCodigoModificar.getText()));
            c.setNomcli(txtNombreModificar.getText());
            c.setDireccion(txtDireccionModificar.getText());
            c.setEmail(txtEmailModificar.getText());
            c.setTfno(txtTlfModificar.getText());
            GestionClientes.updateCliente(c);
            JOptionPane.showMessageDialog(this, "Cliente modificado");
            limpiarModificar();
            Conexion.getSession().getTransaction().commit();
        } catch (HibernateException ex) {
            Conexion.getSession().getTransaction().rollback();
        } finally {
            Conexion.cerrarBD();
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtCodigoModificarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoModificarFocusLost
        if (txtCodigoModificar.getText().isEmpty()) {
            return;
        }
        try {
            Conexion.abrirBD();
            Cliente c = GestionClientes.getCliente(Integer.parseInt(txtCodigoModificar.getText()));
            if (c == null) {
                JOptionPane.showMessageDialog(this, "Ese cliente no existe");
                btnModificar.setEnabled(false);
                limpiarModificar();
                return;
            }
            btnModificar.setEnabled(true);
            txtNombreModificar.setText(c.getNomcli());
            txtDireccionModificar.setText(c.getDireccion());
            txtEmailModificar.setText(c.getEmail());
            txtTlfModificar.setText(c.getTfno());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Es un código numerico");
        } catch (HibernateException ex) {
            ex.getMessage();
        } finally {
            Conexion.cerrarBD();
        }
    }//GEN-LAST:event_txtCodigoModificarFocusLost
    private void cargarCombo() {
        cbClientes.removeAllItems();
        try {
            Conexion.abrirBD();
            GestionClientes.rellenarCombo(cbClientes);
        } catch (HibernateException ex) {
            ex.getMessage();
        } finally {
            Conexion.cerrarBD();
        }
    }
    private void rbtBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBorrarActionPerformed
        CardLayout lo = (CardLayout) jPanel1.getLayout();
        lo.show(jPanel1, "BORRAR");
        cargarCombo();
    }//GEN-LAST:event_rbtBorrarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (cbClientes.getSelectedIndex() == -1) {
            return;
        }

        Cliente c = (Cliente) cbClientes.getSelectedItem();
 
        try {
            Conexion.abrirBD();

            GestionClientes.borrarCliente(c.getCodcli(), cbClientes);
            Conexion.getSession().getTransaction().commit();
            cargarCombo();

        } catch (HibernateException ex) {
            Conexion.getSession().getTransaction().rollback();
        } finally {
            Conexion.cerrarBD();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioCliente dialog = new FormularioCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Cliente> cbClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton rbtAgregar;
    private javax.swing.JRadioButton rbtBorrar;
    private javax.swing.JRadioButton rbtModificar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoModificar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionModificar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailModificar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreModificar;
    private javax.swing.JTextField txtTlf;
    private javax.swing.JTextField txtTlfModificar;
    // End of variables declaration//GEN-END:variables
}