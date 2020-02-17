/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cabinet_veterinar_app;
import static Cabinet_veterinar_app.DBconnect.connect;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Date;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexa
 */
public class AngajatForm extends javax.swing.JFrame {

    /**
     * Creates new form AngajatForm
     */
    public AngajatForm() {
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
     
    String photopath="";
    public ImageIcon resetImageSize(String photopath,byte[] photo){
        ImageIcon myPhoto=null;
        if (photopath!=null) {
            myPhoto=new ImageIcon(photopath);
        }else{
               myPhoto=new ImageIcon(photo);
        }
        Image img=myPhoto.getImage();
        Image img1=img.getScaledInstance(label_photo.getWidth(),label_photo.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon ph=new ImageIcon(img1);
        return ph;        
    }
    
    
    public ArrayList<AngajatContainer> retrieveData(){
        ArrayList<AngajatContainer> al=null;
                al=new ArrayList<AngajatContainer>();
       
        try {
            Connection conn=getConnection();
            String qry="select * from Angajat";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            AngajatContainer Angajat;
            while (rs.next()) {
                Angajat =new AngajatContainer(rs.getInt("IdAngajat"),rs.getString("Nume"),rs.getString("Prenume"),
                        rs.getString("Telefon"), rs.getBytes("Poza"));                
                al.add(Angajat);
              }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       return al; 
    }
    
    
    public void fillTable(){
        ArrayList<AngajatContainer> al=retrieveData();
        DefaultTableModel model=(DefaultTableModel)Table_angajati.getModel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_nume = new javax.swing.JTextField();
        jTextField_prenume = new javax.swing.JTextField();
        jTextField_cnp = new javax.swing.JTextField();
        jTextField_telefon = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jTextField_adresa = new javax.swing.JTextField();
        jTextField_salariu = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_new = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jButton_insert = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_photo = new javax.swing.JButton();
        label_photo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_angajati = new javax.swing.JTable();
        jButton_meniu = new javax.swing.JButton();
        jTextField_search = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 255, 0));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 255, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informatii Angajati");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(358, 36, 410, 41);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 147, 11, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nume");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 180, 60, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prenume");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 220, 51, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CNP");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 260, 60, 16);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefon");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 300, 43, 16);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 340, 31, 16);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Adresa");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 380, 40, 16);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Angajarii");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 420, 81, 16);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Salariu");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 460, 40, 16);
        jPanel1.add(jTextField_id);
        jTextField_id.setBounds(150, 140, 59, 22);
        jPanel1.add(jTextField_nume);
        jTextField_nume.setBounds(150, 180, 102, 22);

        jTextField_prenume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_prenumeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField_prenume);
        jTextField_prenume.setBounds(150, 220, 110, 22);
        jPanel1.add(jTextField_cnp);
        jTextField_cnp.setBounds(150, 260, 133, 22);
        jPanel1.add(jTextField_telefon);
        jTextField_telefon.setBounds(150, 300, 123, 22);
        jPanel1.add(jTextField_email);
        jTextField_email.setBounds(150, 340, 133, 22);
        jPanel1.add(jTextField_adresa);
        jTextField_adresa.setBounds(150, 380, 202, 22);
        jPanel1.add(jTextField_salariu);
        jTextField_salariu.setBounds(150, 460, 119, 22);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(150, 420, 129, 22);

        jButton_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add.png"))); // NOI18N
        jButton_new.setText("New");
        jButton_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_new);
        jButton_new.setBounds(880, 130, 130, 57);

        jButton_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase.png"))); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_delete);
        jButton_delete.setBounds(880, 217, 130, 50);

        jButton_insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
        jButton_insert.setText("Insert");
        jButton_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insertActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_insert);
        jButton_insert.setBounds(880, 300, 130, 50);

        jButton_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_update);
        jButton_update.setBounds(880, 380, 130, 50);

        jButton_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/photo1.png"))); // NOI18N
        jButton_photo.setText("Selecteza Poza");
        jButton_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_photoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_photo);
        jButton_photo.setBounds(450, 340, 190, 59);

        label_photo.setBackground(new java.awt.Color(255, 255, 255));
        label_photo.setForeground(new java.awt.Color(255, 255, 255));
        label_photo.setText("jLabel11");
        label_photo.setOpaque(true);
        jPanel1.add(label_photo);
        label_photo.setBounds(450, 190, 190, 140);

        Table_angajati.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_angajati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_angajatiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_angajati);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(390, 580, 440, 97);

        jButton_meniu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_red.png"))); // NOI18N
        jButton_meniu.setText("Meniu");
        jButton_meniu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_meniuActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_meniu);
        jButton_meniu.setBounds(880, 470, 130, 40);

        jTextField_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchKeyReleased(evt);
            }
        });
        jPanel1.add(jTextField_search);
        jTextField_search.setBounds(150, 570, 90, 22);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cauta dupa nume");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(40, 570, 110, 16);

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

        setSize(new java.awt.Dimension(1125, 728));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_prenumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_prenumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_prenumeActionPerformed

    private void jButton_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_photoActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef=new FileNameExtensionFilter("*.images", "jpg","png");
        chooser.addChoosableFileFilter(fnef);
        int ans=chooser.showSaveDialog(null);
        if (ans==JFileChooser.APPROVE_OPTION) {
            File selectedPhoto=chooser.getSelectedFile();
            String path=selectedPhoto.getAbsolutePath();
            label_photo.setIcon(resetImageSize(path, null));
            this.photopath=path;
        }
    }//GEN-LAST:event_jButton_photoActionPerformed

    private void jButton_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insertActionPerformed
        if ((jTextField_nume!=null
        || jTextField_prenume!=null || jTextField_cnp!=null)&& photopath!=null) {
            try {
                Connection conn=getConnection();
                //String qry="insert into students values(id,name,fees,dob,photo) values (?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement("insert into Angajat"
                        + "(Nume,Prenume,Cnp,Telefon,Email,Adresa,DataAngajarii,Salariu,Poza) values (?,?,?,?,?,?,?,?,?)");
               // ps.setInt(1, Integer.parseInt(jTextField_id.getText()));
                ps.setString(1,jTextField_nume.getText());
                ps.setString(2,jTextField_prenume.getText());
                ps.setString(3,jTextField_cnp.getText());
                ps.setString(4,jTextField_telefon.getText());
                ps.setString(5,jTextField_email.getText());
                ps.setString(6,jTextField_adresa.getText());
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                String dob1=sdf.format(jDateChooser1.getDate());
                ps.setString(7,dob1);
                ps.setFloat(8, Float.parseFloat(jTextField_salariu.getText()));    
                InputStream is=new FileInputStream(new File(photopath));
                ps.setBlob(9, is);
                        
                int res=ps.executeUpdate();
                 fillTable();
                if (res>=1) {
                    JOptionPane.showMessageDialog(null, res+" Angajat"
                            + " inserted in baza de date.....");
                }else
                    JOptionPane.showMessageDialog(null, "Inserare esuata ....");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }           
           // jTextField_id.setText("");
            //jTextField_name.setText("");
            //jTextField_greutate.setText("");
            
        }else{
             JOptionPane.showMessageDialog(null, "Numele, prenumele, cnp-ul si poza sunt obligatorii ....");
        }
    }//GEN-LAST:event_jButton_insertActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        if ( jTextField_nume!=null
                    || jTextField_prenume!=null || jTextField_cnp!=null) {
              String qry=null;
              PreparedStatement ps=null;
              Connection conn=getConnection();
              
              if (photopath=="") {
                    try {        
                        qry="update Angajat set Nume=?, Prenume=?, Cnp=?, Telefon=?, Email=?, Adresa=?, DataAngajarii=?, Salariu=? where IdAngajat=?";
                        ps=conn.prepareStatement(qry);
                        ps.setString(1,jTextField_nume.getText());
                        ps.setString(2,jTextField_prenume.getText());
                        ps.setString(3,jTextField_cnp.getText());
                        ps.setString(4,jTextField_telefon.getText());
                        ps.setString(5,jTextField_email.getText());
                        ps.setString(6,jTextField_adresa.getText());
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                        String dob1=sdf.format(jDateChooser1.getDate());
                        ps.setString(7,dob1);
                        ps.setFloat(8, Float.parseFloat(jTextField_salariu.getText()));
                        ps.setInt(9, Integer.parseInt(jTextField_id.getText()));
                        
                        
                        int res=ps.executeUpdate();
                         fillTable();
                        if (res>=1) {
                            JOptionPane.showMessageDialog(null, res+" Angajat"
                                    + " actualizat in baza de date .....");
                        }else
                            JOptionPane.showMessageDialog(null, "Actualizare esuata ....");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }           
                    //jTextField_id.setText("");
                    //jTextField_name.setText("");
                    //jTextField_fees.setText("");

                    }else{
                        try {    
                            InputStream is=new FileInputStream(new File(photopath));
                            
                        qry="update Angajat set Nume=?, Prenume=?, Cnp=?, Telefon=?, Email=?, Adresa=?, DataAngajarii=?, Salariu=?, Poza=? where IdAngajat=?";
                        ps=conn.prepareStatement(qry);
                         ps.setString(1,jTextField_nume.getText());
                        ps.setString(2,jTextField_prenume.getText());
                        ps.setString(3,jTextField_cnp.getText());
                        ps.setString(4,jTextField_telefon.getText());
                        ps.setString(5,jTextField_email.getText());
                        ps.setString(6,jTextField_adresa.getText());
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                        String dob1=sdf.format(jDateChooser1.getDate());
                        ps.setString(7,dob1);
                        ps.setFloat(8, Float.parseFloat(jTextField_salariu.getText()));
                        ps.setBlob(9, is);
                        ps.setInt(10, Integer.parseInt(jTextField_id.getText()));                       
                                                
                        int res=ps.executeUpdate();
                         fillTable();
                        if (res>=1) {
                            JOptionPane.showMessageDialog(null, res+" Angajat"
                                    + " actualizat in baza de date .....");
                        }else
                            JOptionPane.showMessageDialog(null, "Actualizare esuata ....");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }           
                    //jTextField_id.setText("");
                    //jTextField_name.setText("");
                    //jTextField_fees.setText("");
     
                    }
          }else
              JOptionPane.showMessageDialog(null, "Numele, Prenumele si cnp-ul sunt obigatorii......");
            
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void Table_angajatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_angajatiMouseClicked
        try{
          int row = Table_angajati.getSelectedRow();
          String Table_click = (Table_angajati.getModel().getValueAt(row, 0).toString());
          String sql = "select * from Angajat where IdAngajat ='" + Table_click + "'";
          Connection conn=getConnection();
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          if(rs.next()){
                String add1 = rs.getString("IdAngajat");
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
                String add8 = rs.getString("DataAngajarii");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(add8);
                jDateChooser1.setDate(date);
                String add9 = rs.getString("Salariu");
                jTextField_salariu.setText(add9);
                
                label_photo.setIcon(resetImageSize(null, retrieveData().get(row).getPhoto()));
          }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Exe5");
        }
    }//GEN-LAST:event_Table_angajatiMouseClicked

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        if (jTextField_nume.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "Introduceti Numele");
        }else{             
                try{
                String qry="delete from Angajat where Nume=? AND Prenume=?";
                String qry2 = "delete from Vizita where IdDoctor IN (select IdAngajat from Angajat where Nume=? AND Prenume=?)";  
                String qry3 = "delete from VizitaProcedura where IdVizita IN (select IdVizita from Vizita where IdDoctor IN (select IdAngajat from Angajat where Nume=? AND Prenume=?))";
                Connection conn=getConnection();
                PreparedStatement ps3=conn.prepareStatement(qry3);
                ps3.setString(1,jTextField_nume.getText());
                ps3.setString(2,jTextField_prenume.getText());
                PreparedStatement ps2=conn.prepareStatement(qry2);
                int res3=ps3.executeUpdate();
                //ps.setInt(1, Integer.parseInt(jTextField_id.getText().toString()));
                ps2.setString(1,jTextField_nume.getText());
                ps2.setString(2,jTextField_prenume.getText());
                int res2=ps2.executeUpdate();
                
                //Connection conn2=getConnection();
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

    private void jButton_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newActionPerformed
        jTextField_id.setText("");
        jTextField_nume.setText("");
        jTextField_prenume.setText("");
        jTextField_cnp.setText("");
        jTextField_telefon.setText("");
        jTextField_email.setText("");
        jTextField_adresa.setText("");
        jTextField_salariu.setText("");
        
    }//GEN-LAST:event_jButton_newActionPerformed

    private void jTextField_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchKeyReleased
        try{
            String sql = "select * from Angajat where Nume = ?";
            Connection conn=getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, jTextField_search.getText());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String add1 = rs.getString("IdAngajat");
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
                String add8 = rs.getString("DataAngajarii");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(add8);
                jDateChooser1.setDate(date);
                String add9 = rs.getString("Salariu");
                jTextField_salariu.setText(add9);
                int idsearched = Integer.parseInt(add1);
                int rowsearched = 0;
                ArrayList<AngajatContainer> al=retrieveData();
                int row;
                for (int i = 0; i < al.size(); i++) {
                    row=al.get(i).getId();
                    if(row == idsearched){
                        rowsearched = i;
                        break;
                    }
                } 
               label_photo.setIcon(resetImageSize(null, retrieveData().get(rowsearched).getPhoto()));   
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
           // System.out.println("Exe");
        } 
    }//GEN-LAST:event_jTextField_searchKeyReleased

    private void jButton_meniuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_meniuActionPerformed
        close();
        Meniu f = new Meniu();
        f.setVisible(true);
    }//GEN-LAST:event_jButton_meniuActionPerformed

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
            java.util.logging.Logger.getLogger(AngajatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AngajatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AngajatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AngajatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AngajatForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_angajati;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_insert;
    private javax.swing.JButton jButton_meniu;
    private javax.swing.JButton jButton_new;
    private javax.swing.JButton jButton_photo;
    private javax.swing.JButton jButton_update;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField_adresa;
    private javax.swing.JTextField jTextField_cnp;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_nume;
    private javax.swing.JTextField jTextField_prenume;
    private javax.swing.JTextField jTextField_salariu;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JTextField jTextField_telefon;
    private javax.swing.JLabel label_photo;
    // End of variables declaration//GEN-END:variables
}
