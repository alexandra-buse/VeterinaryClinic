/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cabinet_veterinar_app;

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexa
 */
public class ViziteForm extends javax.swing.JFrame {

    /**
     * Creates new form ViziteForm
     */
    public ViziteForm() {
        initComponents();
        fillTable();
        fillCombo();
        fillCombo2();
        fillCombo3();
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
     
     
     public ArrayList<VizitaContainer> retrieveData(){
        ArrayList<VizitaContainer> al=null;
                al=new ArrayList<VizitaContainer>();
       
        try {
            Connection conn=getConnection();
            String qry="select * from Vizita";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            //String qry2="select * from VizitaProcedura";
            //Statement st2=conn.createStatement();
            //ResultSet rs2=st2.executeQuery(qry2);
            VizitaContainer Vizita;
            while (rs.next()) {
                Vizita =new VizitaContainer(rs.getInt("IdVizita"),rs.getInt("IdPacient"),rs.getInt("IdDoctor"));                
                al.add(Vizita);
              }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       return al; 
    }
    
    
    public void fillTable(){
        ArrayList<VizitaContainer> al=retrieveData();
        try {
        Connection conn=getConnection();
        DefaultTableModel model=(DefaultTableModel)Table_vizite.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            int temp1 = al.get(i).getPacient();
            String qry="select * from Animal where IdAnimal = '" + temp1 + "'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            if(rs.next()){
            row[1]=rs.getString("Nume");
            }
            int temp2 = al.get(i).getDoctor();
            String qry2="select * from Angajat where IdAngajat = '" + temp2 + "'";
            Statement st2=conn.createStatement();
            ResultSet rs2=st2.executeQuery(qry2);
            if(rs2.next()){
            String n1 = rs2.getString("Nume");
            String n2 = rs2.getString("Prenume");
            row[2] = n1 + " " + n2;
            }
            //row[2]=al.get(i).getDoctor();
            //row[3]=al.get(i).getProcedura();
            String qry3="select * from VizitaProcedura where IdVizita = '" + row[0] + "'";
            Statement st3=conn.createStatement();
            ResultSet rs3=st3.executeQuery(qry3);
            while(rs3.next()){
                String n3 = rs3.getString("IdProcedura");
                String qry4="select * from Procedura where IdProcedura = '" + n3 + "'";
                Statement st4=conn.createStatement();
                ResultSet rs4=st4.executeQuery(qry4);
                if(rs4.next()){
                    String n4 = rs4.getString("Denumire");
                    row[3] = n4;
                    model.addRow(row);
                }
            }
            //model.addRow(row);
        }
        }catch(Exception e){
            System.out.println(e);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jButton_delete1 = new javax.swing.JButton();
        jButton_insert1 = new javax.swing.JButton();
        jButton_update1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_vizite = new javax.swing.JTable();
        jButton_meniu1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox_pacient = new javax.swing.JComboBox();
        jComboBox_doctor = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox_procedura = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        jTextField_cost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_status = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_prioritate = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setForeground(new java.awt.Color(0, 255, 0));
        jPanel3.setLayout(null);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Id");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(50, 130, 11, 16);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Pacient");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(50, 170, 41, 16);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Doctor");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(50, 221, 37, 16);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Data Vizita");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(50, 271, 61, 16);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Procedura");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(50, 394, 58, 16);
        jPanel3.add(jTextField_id);
        jTextField_id.setBounds(165, 127, 59, 22);

        jButton_delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase.png"))); // NOI18N
        jButton_delete1.setText("Delete");
        jButton_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_delete1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_delete1);
        jButton_delete1.setBounds(890, 151, 130, 50);

        jButton_insert1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
        jButton_insert1.setText("Insert");
        jButton_insert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insert1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_insert1);
        jButton_insert1.setBounds(890, 230, 130, 46);

        jButton_update1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton_update1.setText("Update");
        jButton_update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_update1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_update1);
        jButton_update1.setBounds(890, 307, 130, 50);

        Table_vizite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Pacient", "Doctor", "Procedura"
            }
        ));
        Table_vizite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_viziteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_vizite);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(340, 510, 452, 109);

        jButton_meniu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_red.png"))); // NOI18N
        jButton_meniu1.setText("Meniu");
        jButton_meniu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_meniu1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_meniu1);
        jButton_meniu1.setBounds(890, 390, 130, 50);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Informatii Vizite");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(350, 30, 410, 41);

        jPanel3.add(jComboBox_pacient);
        jComboBox_pacient.setBounds(165, 167, 160, 22);

        jPanel3.add(jComboBox_doctor);
        jComboBox_doctor.setBounds(165, 215, 150, 22);
        jPanel3.add(jDateChooser1);
        jDateChooser1.setBounds(165, 271, 134, 22);

        jPanel3.add(jComboBox_procedura);
        jComboBox_procedura.setBounds(165, 394, 134, 22);

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Cost");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(50, 445, 60, 16);
        jPanel3.add(jTextField_cost);
        jTextField_cost.setBounds(165, 442, 91, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\alexa\\OneDrive\\Documents\\NetBeansProjects\\test\\src\\images\\veterinary.png")); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(320, 110, 500, 370);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Status");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(50, 310, 41, 16);

        jComboBox_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Programata", "Realizata" }));
        jPanel3.add(jComboBox_status);
        jComboBox_status.setBounds(160, 310, 140, 22);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Prioritate");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(50, 350, 70, 16);

        jComboBox_prioritate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Scazuta", "Medie", "Ridicata" }));
        jPanel3.add(jComboBox_prioritate);
        jComboBox_prioritate.setBounds(160, 350, 140, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1158, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Table_viziteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_viziteMouseClicked
        try{
          int row = Table_vizite.getSelectedRow();
          String Table_click = (Table_vizite.getModel().getValueAt(row, 0).toString());
          jTextField_id.setText(Table_click);
          String Pacient1 = (Table_vizite.getModel().getValueAt(row, 1).toString());
          jComboBox_pacient.setSelectedItem(Pacient1);
          String Doctor1 = (Table_vizite.getModel().getValueAt(row, 2).toString());
          jComboBox_doctor.setSelectedItem(Doctor1);
          String Procedura1 = (Table_vizite.getModel().getValueAt(row, 3).toString());
          jComboBox_procedura.setSelectedItem(Procedura1);
          
          
          String sql = "select * from Vizita where IdVizita ='" + Table_click + "'";
          Connection conn=getConnection();
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
                String add1 = rs.getString("DataVizita");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(add1);
                jDateChooser1.setDate(date);
                String add2 = rs.getString("Status");
                jComboBox_status.setSelectedItem(add2);
                String add3 = rs.getString("Prioritate");
                jComboBox_status.setSelectedItem(add3);
          }
          
          
          String sql2 = "select * from Procedura where Denumire ='" + Procedura1 + "'";
          PreparedStatement ps2 = conn.prepareStatement(sql2);
          ResultSet rs2 = ps2.executeQuery();
          if(rs2.next()){
                String add2 = rs2.getString("Cost");
                jTextField_cost.setText(add2);
          }
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Exe5");
        } 
    }//GEN-LAST:event_Table_viziteMouseClicked

    private void jButton_insert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insert1ActionPerformed
        if ((jDateChooser1!=null)) {
            try {
                Connection conn=getConnection();
                //String qry="insert into students values(id,name,fees,dob,photo) values (?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement("insert into Vizita"
                        + "(IdPacient,IdDoctor,DataVizita, Status, Prioritate) values (?,?,?,?,?)");
                
                PreparedStatement another_ps=conn.prepareStatement("insert into VizitaProcedura"
                        + "(IdVizita,IdProcedura) values (?,?)");
                
                String sqlToGetVizita = "select * from Vizita where IdPacient=? AND IdDoctor=?";
                PreparedStatement psToGetVizita = conn.prepareStatement(sqlToGetVizita);
               
                
                String sql2 = "select * from Animal where Nume = ?";
                String temp = (String)jComboBox_pacient.getSelectedItem();
                        
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, temp);
                ResultSet rs2 = ps2.executeQuery();
                
                    if(rs2.next()){
                        String temp1 = rs2.getString("IdAnimal");
                        ps.setInt(1, Integer.parseInt(temp1));
                        psToGetVizita.setInt(1, Integer.parseInt(temp1));
                    }
                    
                    
                String sql3 = "select * from Angajat where Nume = ? AND Prenume=?";
                String temp2 = (String)jComboBox_doctor.getSelectedItem();
                PreparedStatement ps3 = conn.prepareStatement(sql3);
                String[] splited = temp2.split(" ");
                ps3.setString(1, splited[0]);
                ps3.setString(2, splited[1]);
                ResultSet rs3 = ps3.executeQuery();
                
                    if(rs3.next()){
                        String temp3 = rs3.getString("IdAngajat");
                        ps.setInt(2, Integer.parseInt(temp3));
                        psToGetVizita.setInt(2, Integer.parseInt(temp3));
                    }
                    
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String dob1=sdf.format(jDateChooser1.getDate());
                ps.setString(3,dob1);
                
                String stat = (String)jComboBox_status.getSelectedItem();
                String priority = (String)jComboBox_prioritate.getSelectedItem();
                ps.setString(4,stat);
                ps.setString(5,priority);
                    
                        
                int res=ps.executeUpdate();
                
                ResultSet rsToGetVizita = psToGetVizita.executeQuery();
                if(rsToGetVizita.next()){
                    String tempviz = rsToGetVizita.getString("IdVizita");
                    another_ps.setInt(1, Integer.parseInt(tempviz));
                }
                
                String sqlToGetProc = "select * from Procedura where Denumire=?";
                PreparedStatement psToGetProc = conn.prepareStatement(sqlToGetProc);
                String tempproc = (String)jComboBox_procedura.getSelectedItem();
                psToGetProc.setString(1, tempproc);
                ResultSet rsToGetProc = psToGetProc.executeQuery();
                
                    if(rsToGetProc.next()){
                        String tempprc = rsToGetProc.getString("IdProcedura");
                        another_ps.setInt(2, Integer.parseInt(tempprc));
                    }
                 int res2=another_ps.executeUpdate();
                 fillTable();
                if (res>=1) {
                    JOptionPane.showMessageDialog(null, res+" Vizita"
                            + " inserata in baza de date .....");
                }else
                    JOptionPane.showMessageDialog(null, "Inserare esuata ....");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }           
            
        }else{
             JOptionPane.showMessageDialog(null, "Data lipseste ....");
        }
    }//GEN-LAST:event_jButton_insert1ActionPerformed

    private void jButton_update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_update1ActionPerformed
        
              String qry=null;
              PreparedStatement ps=null;
              Connection conn=getConnection();
              
                    try {        
                        qry="update Vizita set IdPacient=?, IdDoctor=?, DataVizita=?, Status=?, Prioritate=? where IdVizita=?";
                        ps=conn.prepareStatement(qry);
                        String sql2 = "select * from Animal where Nume = ?";
                        String temp = (String)jComboBox_pacient.getSelectedItem();
                        
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setString(1, temp);
                        ResultSet rs2 = ps2.executeQuery();
                
                        if(rs2.next()){
                            String temp1 = rs2.getString("IdAnimal");
                            ps.setInt(1, Integer.parseInt(temp1));
                        }
                    
                    
                        String sql3 = "select * from Angajat where Nume = ? AND Prenume=?";
                        String temp2 = (String)jComboBox_doctor.getSelectedItem();
                        PreparedStatement ps3 = conn.prepareStatement(sql3);
                        String[] splited = temp2.split(" ");
                        ps3.setString(1, splited[0]);
                        ps3.setString(2, splited[1]);
                        ResultSet rs3 = ps3.executeQuery();
                
                        if(rs3.next()){
                            String temp3 = rs3.getString("IdAngajat");
                            ps.setInt(2, Integer.parseInt(temp3));
                        }
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                        String dob1=sdf.format(jDateChooser1.getDate());
                        ps.setString(3,dob1);
                        String stat = (String)jComboBox_status.getSelectedItem();
                        String priority = (String)jComboBox_prioritate.getSelectedItem();
                        ps.setString(4,stat);
                        ps.setString(5,priority);
                        ps.setInt(6, Integer.parseInt(jTextField_id.getText()));
                        
                        
                        int res=ps.executeUpdate();
                         fillTable();
                        if (res>=1) {
                            JOptionPane.showMessageDialog(null, res+" Vizita"
                                    + " actualizata .....");
                        }else
                            JOptionPane.showMessageDialog(null, "Actualizare esuata ....");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }           
                    

                    
          
    }//GEN-LAST:event_jButton_update1ActionPerformed

    private void jButton_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_delete1ActionPerformed
        if (jTextField_id.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "Introduceti id");
        }else{             
                try{
                String qry="delete from Vizita where IdVizita=?";
                String qry3 = "delete from VizitaProcedura where IdVizita =?";
                Connection conn=getConnection();
                PreparedStatement ps3=conn.prepareStatement(qry3);
                ps3.setString(1,jTextField_id.getText());
                int res3=ps3.executeUpdate();
                PreparedStatement ps=conn.prepareStatement(qry);
                ps.setString(1,jTextField_id.getText());
                int res=ps.executeUpdate();
                 fillTable();
                if (res>=1) {
                    JOptionPane.showMessageDialog(null, "Vizita stearsa cu succes ....");    
                }else
                    JOptionPane.showMessageDialog(null, "Stergere anulata ....");    
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton_delete1ActionPerformed

    private void jButton_meniu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_meniu1ActionPerformed
        close();
        Meniu m = new Meniu();
        m.setVisible(true);
    }//GEN-LAST:event_jButton_meniu1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViziteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViziteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViziteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViziteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViziteForm().setVisible(true);
            }
        });
    }
    
    
    private void fillCombo(){
        try{
          String sql = "select Nume from Animal ";
          Connection conn=getConnection();
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
              String name = rs.getString("Nume");
              jComboBox_pacient.addItem(name);
          }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Exe1");
        }
    }
    
    
     private void fillCombo2(){
        try{
          String sql = "select * from Angajat ";
          Connection conn=getConnection();
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
              String name = rs.getString("Nume") + " " + rs.getString("Prenume");
              jComboBox_doctor.addItem(name);
          }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Exe1");
        }
    }
     
     
      private void fillCombo3(){
        try{
          String sql = "select Denumire from Procedura ";
          Connection conn=getConnection();
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
              String name = rs.getString("Denumire");
              jComboBox_procedura.addItem(name);
          }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Exe1");
        }
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_vizite;
    private javax.swing.JButton jButton_delete1;
    private javax.swing.JButton jButton_insert1;
    private javax.swing.JButton jButton_meniu1;
    private javax.swing.JButton jButton_update1;
    private javax.swing.JComboBox jComboBox_doctor;
    private javax.swing.JComboBox jComboBox_pacient;
    private javax.swing.JComboBox jComboBox_prioritate;
    private javax.swing.JComboBox jComboBox_procedura;
    private javax.swing.JComboBox jComboBox_status;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField_cost;
    private javax.swing.JTextField jTextField_id;
    // End of variables declaration//GEN-END:variables
}
