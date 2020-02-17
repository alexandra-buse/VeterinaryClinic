/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cabinet_veterinar_app;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.*;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author alexa
 */
public class ClientForm extends javax.swing.JFrame {

    /**
     * Creates new form ClientForm
     */
    public ClientForm() {
        initComponents();
        fillTable();
    }
    
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
    
     public Connection getConnection()
    {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Cabinet_veterinar;user=alexandra;password=12345");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(FormularCabinet.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
   
    
    
    public ArrayList<ClientContainer> retrieveData(){
        ArrayList<ClientContainer> al=null;
                al=new ArrayList<ClientContainer>();
       
        try {
            Connection conn=getConnection();
            String qry="select * from Propietar";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            ClientContainer Client;
            while (rs.next()) {
                Client =new ClientContainer(rs.getInt("IdPropietar"),rs.getString("Nume"),rs.getString("Prenume"),
                        rs.getString("Telefon"));                
                al.add(Client);
              }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       return al; 
    }
    
    
    public void fillTable(){
        ArrayList<ClientContainer> al=retrieveData();
        DefaultTableModel model=(DefaultTableModel)Table_clienti.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getPrenume();
            row[3]=al.get(i).getTelefon();

            model.addRow(row);
        }
        //model.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_nume = new javax.swing.JTextField();
        jTextField_prenume = new javax.swing.JTextField();
        jTextField_cnp = new javax.swing.JTextField();
        jTextField_telefon = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_adresa = new javax.swing.JTextField();
        jButton_new = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_insert = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_clienti = new javax.swing.JTable();
        jButton_meniu = new javax.swing.JButton();
        jTextField_search = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setForeground(new java.awt.Color(0, 255, 0));
        jPanel3.setLayout(null);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Id");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(50, 130, 11, 16);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nume");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(50, 172, 70, 16);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Prenume");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(50, 218, 51, 16);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CNP");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(50, 258, 70, 16);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Telefon");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(50, 298, 43, 16);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Email");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(50, 339, 60, 16);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Adresa");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(50, 380, 40, 16);
        jPanel3.add(jTextField_id);
        jTextField_id.setBounds(155, 127, 59, 22);
        jPanel3.add(jTextField_nume);
        jTextField_nume.setBounds(155, 169, 102, 22);

        jTextField_prenume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_prenumeActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField_prenume);
        jTextField_prenume.setBounds(155, 215, 110, 22);
        jPanel3.add(jTextField_cnp);
        jTextField_cnp.setBounds(155, 255, 133, 22);
        jPanel3.add(jTextField_telefon);
        jTextField_telefon.setBounds(155, 295, 123, 22);
        jPanel3.add(jTextField_email);
        jTextField_email.setBounds(155, 336, 202, 22);
        jPanel3.add(jTextField_adresa);
        jTextField_adresa.setBounds(155, 377, 202, 22);

        jButton_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add.png"))); // NOI18N
        jButton_new.setText("New");
        jButton_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_new);
        jButton_new.setBounds(810, 100, 190, 50);

        jButton_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase.png"))); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_delete);
        jButton_delete.setBounds(810, 170, 190, 60);

        jButton_insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
        jButton_insert.setText("Insert");
        jButton_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insertActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_insert);
        jButton_insert.setBounds(810, 250, 190, 57);

        jButton_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_update);
        jButton_update.setBounds(810, 330, 190, 57);

        Table_clienti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nume", "Prenume", "Telefon"
            }
        ));
        Table_clienti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_clientiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_clienti);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(280, 480, 452, 124);

        jButton_meniu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_red.png"))); // NOI18N
        jButton_meniu.setText("Meniu");
        jButton_meniu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_meniuActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_meniu);
        jButton_meniu.setBounds(810, 410, 190, 60);

        jTextField_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextField_search);
        jTextField_search.setBounds(240, 440, 68, 22);

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Cautare in functie de nume");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(50, 440, 155, 16);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Informatii Clienti");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(291, 22, 410, 41);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/412TJ+4PpHL._SX425_1.jpg"))); // NOI18N
        jButton1.setText("Formular animale");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(810, 500, 187, 55);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1127, 694));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_prenumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_prenumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_prenumeActionPerformed

    private void jButton_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insertActionPerformed
        if ((jTextField_nume!=null
        || jTextField_prenume!=null || jTextField_cnp != null)) {
            try {
                Connection conn=getConnection();
                //String qry="insert into students values(id,name,fees,dob,photo) values (?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement("insert into Propietar"
                        + "(Nume,Prenume,Cnp,Telefon,Email,Adresa) values (?,?,?,?,?,?)");
               // ps.setInt(1, Integer.parseInt(jTextField_id.getText()));
                ps.setString(1,jTextField_nume.getText());
                ps.setString(2,jTextField_prenume.getText());
                ps.setString(3,jTextField_cnp.getText());
                ps.setString(4,jTextField_telefon.getText());
                ps.setString(5,jTextField_email.getText());
                ps.setString(6,jTextField_adresa.getText());
                        
                int res=ps.executeUpdate();
                 fillTable();
                if (res>=1) {
                    JOptionPane.showMessageDialog(null, res+" Client"
                            + " inserat in baza de date .....");
                }else
                    JOptionPane.showMessageDialog(null, "Inserare esuata ....");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }           
            
        }else{
             JOptionPane.showMessageDialog(null, "Numele, prenumele si cnp-ul sunt obligatorii....");
        }
    }//GEN-LAST:event_jButton_insertActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        if ( jTextField_nume!=null
                    || jTextField_prenume!=null  || jTextField_cnp!=null) {
              String qry=null;
              PreparedStatement ps=null;
              Connection conn=getConnection();
              
                    try {        
                        qry="update Propietar set Nume=?, Prenume=?, Cnp=?, Telefon=?, Email=?, Adresa=? where IdPropietar=?";
                        ps=conn.prepareStatement(qry);
                        ps.setString(1,jTextField_nume.getText());
                        ps.setString(2,jTextField_prenume.getText());
                        ps.setString(3,jTextField_cnp.getText());
                        ps.setString(4,jTextField_telefon.getText());
                        ps.setString(5,jTextField_email.getText());
                        ps.setString(6,jTextField_adresa.getText());
                        ps.setInt(7, Integer.parseInt(jTextField_id.getText()));
                        
                        
                        int res=ps.executeUpdate();
                         fillTable();
                        if (res>=1) {
                            JOptionPane.showMessageDialog(null, res+" Client"
                                    + " actualizat in baza de date .....");
                        }else
                            JOptionPane.showMessageDialog(null, "Actualizare esuata ....");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }           
                    

                    
          }else
              JOptionPane.showMessageDialog(null, "Numele, prenumele si cnp-ul sunt obligatorii.......");
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void Table_clientiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_clientiMouseClicked
        try{
          int row = Table_clienti.getSelectedRow();
          String Table_click = (Table_clienti.getModel().getValueAt(row, 0).toString());
          String sql = "select * from Propietar where IdPropietar ='" + Table_click + "'";
          Connection conn=getConnection();
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
                String add1 = rs.getString("IdPropietar");
                jTextField_id.setText(add1);
                String add2 = rs.getString("Nume");
                jTextField_nume.setText(add2);
                String add3 = rs.getString("Prenume");
                jTextField_prenume.setText(add3);
                String add4 = rs.getString("Cnp");
                jTextField_cnp.setText(add4);
                String add5 = rs.getString("Telefon");
                jTextField_telefon.setText(add5);
                String add6 = rs.getString("Email");
                jTextField_email.setText(add6);
                String add7 = rs.getString("Adresa");
                jTextField_adresa.setText(add7);
          }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Exe5");
        }
    }//GEN-LAST:event_Table_clientiMouseClicked

    private void jButton_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newActionPerformed
        jTextField_id.setText("");
        jTextField_nume.setText("");
        jTextField_prenume.setText("");
        jTextField_cnp.setText("");
        jTextField_telefon.setText("");
        jTextField_email.setText("");
        jTextField_adresa.setText("");
    }//GEN-LAST:event_jButton_newActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        if (jTextField_nume.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "Introduceti Numele");
        }else{             
                try{
                String qry="delete from Propietar where Nume=? AND Prenume=?";
                String qry4="delete from Animal where IdStapan IN (select IdPropietar from Propietar where Nume=? AND Prenume=?)";
                String qry2 = "delete from Vizita where IdPacient IN (select IdAnimal from Animal where IdStapan IN (select IdPropietar from Propietar where Nume=? AND Prenume=?))";  
                String qry3 = "delete from VizitaProcedura where IdVizita IN (select IdVizita from Vizita where IdPacient IN (select IdAnimal from Animal where IdStapan IN (select IdPropietar from Propietar where Nume=? AND Prenume=?)))";
                Connection conn=getConnection();
                PreparedStatement ps4=conn.prepareStatement(qry4);
                ps4.setString(1,jTextField_nume.getText());
                ps4.setString(2,jTextField_prenume.getText());
                int res4=ps4.executeUpdate();
                PreparedStatement ps3=conn.prepareStatement(qry3);
                ps3.setString(1,jTextField_nume.getText());
                ps3.setString(2,jTextField_prenume.getText());
                PreparedStatement ps2=conn.prepareStatement(qry2);
                int res3=ps3.executeUpdate();
                ps2.setString(1,jTextField_nume.getText());
                ps2.setString(2,jTextField_prenume.getText());
                int res2=ps2.executeUpdate();
                
                PreparedStatement ps=conn.prepareStatement(qry);
                ps.setString(1,jTextField_nume.getText());
                ps.setString(2,jTextField_prenume.getText());
                int res=ps.executeUpdate();
                 fillTable();
                if (res>=1) {
                    JOptionPane.showMessageDialog(null, "Angajat sters cu succes ....");    
                }else
                    JOptionPane.showMessageDialog(null, "Stergere anulata ....");    
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jTextField_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchKeyReleased
        try{
            String sql = "select * from Propietar where Nume = ?";
            Connection conn=getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jTextField_search.getText());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("IdPropietar");
                jTextField_id.setText(add1);
                String add2 = rs.getString("Nume");
                jTextField_nume.setText(add2);
                String add3 = rs.getString("Prenume");
                jTextField_prenume.setText(add3);
                String add4 = rs.getString("Cnp");
                jTextField_cnp.setText(add4);
                String add5 = rs.getString("Telefon");
                jTextField_telefon.setText(add5);
                String add6 = rs.getString("Email");
                jTextField_email.setText(add6);
                String add7 = rs.getString("Adresa");
                jTextField_adresa.setText(add7);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_jTextField_searchKeyReleased

    private void jButton_meniuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_meniuActionPerformed
        close();
        Meniu f = new Meniu();
        f.setVisible(true);
    }//GEN-LAST:event_jButton_meniuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        FormularCabinet m = new FormularCabinet();
        m.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_clienti;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_insert;
    private javax.swing.JButton jButton_meniu;
    private javax.swing.JButton jButton_new;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_adresa;
    private javax.swing.JTextField jTextField_cnp;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_nume;
    private javax.swing.JTextField jTextField_prenume;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JTextField jTextField_telefon;
    // End of variables declaration//GEN-END:variables
}
