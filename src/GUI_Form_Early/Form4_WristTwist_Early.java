package GUI_Form_Early;

import Database.Database;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Dila
 */
public class Form4_WristTwist_Early extends javax.swing.JFrame {
    
    // Setting apakah radiobutton telah di pilih dan merubah warna panel button menjadi warna hijau
    public void CheckEmpty(){
        if (!RadioBox1.isSelected()&&!RadioBox2.isSelected()) {
            JOptionPane.showMessageDialog(this, "Langkah 4 Tidak Boleh Kosong\nAtau Coba Pilih Lagi", "Pesan", JOptionPane.ERROR_MESSAGE);
        } else {
            PanelLanjut.setBackground(new java.awt.Color(40,167,69));
            PanelNext.setBackground(new java.awt.Color(40,167,69));
            ButtonLanjut.setEnabled(true);
            ButtonNext.setEnabled(true);
        }
    }
    
    // Setting apakah radiobutton telah di pilih dan merubah warna panel button menjadi warna hijau untuk database
    public void CheckEmptyDatabase(){
        if (!RadioBox1.isSelected()&&!RadioBox2.isSelected()) {
//            JOptionPane.showMessageDialog(this, "Langkah 1 Tidak Boleh Kosong\nAtau Coba Pilih Lagi", "Pesan", JOptionPane.ERROR_MESSAGE);
        } else {
            PanelLanjut.setBackground(new java.awt.Color(40,167,69));
            PanelNext.setBackground(new java.awt.Color(40,167,69));
            ButtonLanjut.setEnabled(true);
            ButtonNext.setEnabled(true);
        }
    }
    
    // Setting ganti warna panel button lanjut setelah radiobutton di pilih untuk event mouse move
    public void ChangeColorPanelButtonLanjut() {
        if (ButtonLanjut.isEnabled()) {
            PanelLanjut.setBackground(Color.BLUE);
        } else {
            PanelLanjut.setBackground(new java.awt.Color(153,153,153));
            JOptionPane.showMessageDialog(this, "Langkah 4 Tidak Boleh Kosong\nAtau Coba Pilih Lagi", "Pesan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Setting ganti warna panel button next setelah radiobutton di pilih untuk event mouse move
    public void ChangeColorPanelButtonNext() {
        if (ButtonLanjut.isEnabled()) {
            PanelNext.setBackground(Color.BLUE);
        } else {
            PanelNext.setBackground(new java.awt.Color(153,153,153));
            JOptionPane.showMessageDialog(this, "Langkah 4 Tidak Boleh Kosong\nAtau Coba Pilih Lagi", "Pesan", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Setting ganti warna semua panel button setelah radiobutton di pilih menjadi warna hijau
    public void ChangeColorJPanel(){
        if (ButtonLanjut.isEnabled()) {
            PanelLanjut.setBackground(new java.awt.Color(40,167,69));
            PanelNext.setBackground(new java.awt.Color(40,167,69));
            PanelBack.setBackground(new java.awt.Color(40,167,69));
        } else {
            PanelLanjut.setBackground(new java.awt.Color(153,153,153));
            PanelNext.setBackground(new java.awt.Color(153,153,153));
        }
    }
    
    // Menggambil value dari TFNIM
    public void GetValueNIM() {
        LabelIdentitas.setText("NIM: " + Form02_Profile_Early.TFNIM.getText());
    }
    
    // Set Database
    Connection con =null;
    Statement st = null;
    
    // Insert data upper arm
    public void InsertWristTwist() {
        try {
            // Kondisi untuk menentukan posisi upper arm
            int wristTwist = 0;
            int adjust = 0;
            int adjustWristTwist = 0;
            if (RadioBox1.isSelected()) {
                wristTwist = 1;
                adjustWristTwist = 1;
            } 
            else if (RadioBox2.isSelected()) {
                wristTwist = 2;
                adjustWristTwist = 2;
            }
            
            int SUpperArm = wristTwist + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_rula", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database
            String simpan = "UPDATE t_rula SET wristtwist ='" + SUpperArm + "' WHERE nim='" + Form02_Profile_Early.TFNIM.getText()+"'";
            
            // Untuk menyimpan ke database adjust
            String simpanAdjust = "UPDATE t_adjustdata SET wristtwist ='" + adjustWristTwist + "' WHERE nim='" + Form02_Profile_Early.TFNIM.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
            this.dispose();
            new Form5_ArmWrist_MuscleUse_Early().setVisible(true);
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Untuk menampilkan data yang ada
    public void TampilkanDataYangAda(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form02_Profile_Early.TFNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int LowerArm = res.getInt("wristtwist");
                if (LowerArm == 1) {
                    RadioBox1.setSelected(true);
                }
                else if (LowerArm == 2) {
                    RadioBox2.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Check button next
    public void CheckNext() {
        try{
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form02_Profile_Early.TFNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                String UpperArm = res.getString("wristtwist");
                if (UpperArm.equals("")) {
                    JOptionPane.showMessageDialog(this, "Tekan tombol Simpan & Lanjut \nuntuk menyimpan data yang telah dipilih", "Pesan", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    this.dispose();
                    new Form5_ArmWrist_MuscleUse_Early().setVisible(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public Form4_WristTwist_Early() {
        initComponents();
        
        // Menggambil Value dari TFNIM
        GetValueNIM();
        
        // Set Database
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost/db_rula","root","");
                st = con.createStatement();
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Gagal Terkoneksi ke Database", "Pesan", JOptionPane.ERROR_MESSAGE);
            }
        
        // Menampilkan data yang ada
        TampilkanDataYangAda();
        
        // Check Empty Radiobox
        CheckEmptyDatabase();
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
        jPanel1 = new javax.swing.JPanel();
        LabelBagianA = new javax.swing.JLabel();
        LabelLangkah4 = new javax.swing.JLabel();
        Gambar1 = new javax.swing.JLabel();
        Gambar2 = new javax.swing.JLabel();
        RadioBox1 = new GUI_Custom.RadioButtonCustom();
        RadioBox2 = new GUI_Custom.RadioButtonCustom();
        PanelLanjut = new GUI_Custom.PanelRound();
        ButtonLanjut = new javax.swing.JButton();
        PanelNext = new GUI_Custom.PanelRound();
        ButtonNext = new javax.swing.JButton();
        PanelBack = new GUI_Custom.PanelRound();
        ButtonBack = new javax.swing.JButton();
        GambarDasar = new javax.swing.JLabel();
        LabelIdentitas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1042, 550));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1042, 575));
        jPanel1.setMinimumSize(new java.awt.Dimension(1042, 575));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelBagianA.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelBagianA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelBagianA.setText("Bagian A. Analisis Lengan & Pergelangan Tangan");
        jPanel1.add(LabelBagianA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 1022, -1));

        LabelLangkah4.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        LabelLangkah4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah4.setText("Langkah 4: Putar Pergelangan Tangan");
        jPanel1.add(LabelLangkah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 1022, -1));

        Gambar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist_twist1.jpg"))); // NOI18N
        jPanel1.add(Gambar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 220, -1));

        Gambar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist_twist2.jpg"))); // NOI18N
        jPanel1.add(Gambar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 250, -1));

        buttonGroup1.add(RadioBox1);
        RadioBox1.setText("Pilih Posisi");
        RadioBox1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        RadioBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(RadioBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 360, 90, 30));

        buttonGroup1.add(RadioBox2);
        RadioBox2.setText("Pilih Posisi");
        RadioBox2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        RadioBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(RadioBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 360, 90, 30));

        PanelLanjut.setBackground(new java.awt.Color(153, 153, 153));
        PanelLanjut.setRoundBottomLeft(25);
        PanelLanjut.setRoundBottomRight(25);
        PanelLanjut.setRoundTopLeft(25);
        PanelLanjut.setRoundTopRight(25);

        ButtonLanjut.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonLanjut.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLanjut.setText("SIMPAN & LANJUT");
        ButtonLanjut.setContentAreaFilled(false);
        ButtonLanjut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonLanjut.setEnabled(false);
        ButtonLanjut.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonLanjutMouseMoved(evt);
            }
        });
        ButtonLanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLanjutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLanjutLayout = new javax.swing.GroupLayout(PanelLanjut);
        PanelLanjut.setLayout(PanelLanjutLayout);
        PanelLanjutLayout.setHorizontalGroup(
            PanelLanjutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonLanjut, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        PanelLanjutLayout.setVerticalGroup(
            PanelLanjutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonLanjut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(PanelLanjut, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 170, 40));

        PanelNext.setBackground(new java.awt.Color(153, 153, 153));
        PanelNext.setRoundBottomLeft(25);
        PanelNext.setRoundBottomRight(25);
        PanelNext.setRoundTopLeft(25);
        PanelNext.setRoundTopRight(25);

        ButtonNext.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonNext.setForeground(new java.awt.Color(255, 255, 255));
        ButtonNext.setText("NEXT >>>");
        ButtonNext.setContentAreaFilled(false);
        ButtonNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonNext.setEnabled(false);
        ButtonNext.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonNextMouseMoved(evt);
            }
        });
        ButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelNextLayout = new javax.swing.GroupLayout(PanelNext);
        PanelNext.setLayout(PanelNextLayout);
        PanelNextLayout.setHorizontalGroup(
            PanelNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNextLayout.createSequentialGroup()
                .addComponent(ButtonNext)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        PanelNextLayout.setVerticalGroup(
            PanelNextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(PanelNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 100, -1));

        PanelBack.setBackground(new java.awt.Color(40, 167, 69));
        PanelBack.setRoundBottomLeft(25);
        PanelBack.setRoundBottomRight(25);
        PanelBack.setRoundTopLeft(25);
        PanelBack.setRoundTopRight(25);

        ButtonBack.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        ButtonBack.setText("<<< BACK");
        ButtonBack.setContentAreaFilled(false);
        ButtonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonBack.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonBackMouseMoved(evt);
            }
        });
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBackLayout = new javax.swing.GroupLayout(PanelBack);
        PanelBack.setLayout(PanelBackLayout);
        PanelBackLayout.setHorizontalGroup(
            PanelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBackLayout.createSequentialGroup()
                .addComponent(ButtonBack)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        PanelBackLayout.setVerticalGroup(
            PanelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(PanelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 100, -1));

        GambarDasar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarDasar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/WidgetConerWirstTwist.png"))); // NOI18N
        jPanel1.add(GambarDasar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 520));

        LabelIdentitas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        LabelIdentitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelIdentitas.setText("jLabel2");
        jPanel1.add(LabelIdentitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 50, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLanjutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLanjutMouseMoved
        // TODO add your handling code here:
        ChangeColorPanelButtonLanjut();
    }//GEN-LAST:event_ButtonLanjutMouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        ChangeColorJPanel();
        PanelBack.setBackground(new java.awt.Color(40,167,69));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void RadioBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBox1ActionPerformed
        // TODO add your handling code here:
        CheckEmpty();
    }//GEN-LAST:event_RadioBox1ActionPerformed

    private void RadioBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBox2ActionPerformed
        // TODO add your handling code here:
        CheckEmpty();
    }//GEN-LAST:event_RadioBox2ActionPerformed

    private void ButtonLanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLanjutActionPerformed
        // TODO add your handling code here:
        InsertWristTwist();
    }//GEN-LAST:event_ButtonLanjutActionPerformed

    private void ButtonBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseMoved
        // TODO add your handling code here:
        PanelBack.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonBackMouseMoved

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form3_Wrist_Early().setVisible(true);
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ButtonNextMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonNextMouseMoved
        // TODO add your handling code here:
        ChangeColorPanelButtonNext();
    }//GEN-LAST:event_ButtonNextMouseMoved

    private void ButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNextActionPerformed
        // TODO add your handling code here:
        CheckNext();
    }//GEN-LAST:event_ButtonNextActionPerformed

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
            java.util.logging.Logger.getLogger(Form4_WristTwist_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form4_WristTwist_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form4_WristTwist_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form4_WristTwist_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form4_WristTwist_Early().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonLanjut;
    private javax.swing.JButton ButtonNext;
    private javax.swing.JLabel Gambar1;
    private javax.swing.JLabel Gambar2;
    private javax.swing.JLabel GambarDasar;
    private javax.swing.JLabel LabelBagianA;
    private javax.swing.JLabel LabelIdentitas;
    private javax.swing.JLabel LabelLangkah4;
    private GUI_Custom.PanelRound PanelBack;
    private GUI_Custom.PanelRound PanelLanjut;
    private GUI_Custom.PanelRound PanelNext;
    private GUI_Custom.RadioButtonCustom RadioBox1;
    private GUI_Custom.RadioButtonCustom RadioBox2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
