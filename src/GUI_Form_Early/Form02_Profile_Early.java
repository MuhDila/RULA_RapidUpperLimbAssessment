/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Form_Early;

import Database.Database;
import GUI_Custom.ScrollBarCustom;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import static java.awt.image.ImageObserver.ABORT;
import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhammad Dila
 */
public class Form02_Profile_Early extends javax.swing.JFrame {
    
    // Set Database
    Connection con =null;
    Statement st = null;
            
    // Setting untuk mengecek kondisi apabila ada field yang belum terisi
    public void CheckEmptyTextField(){
        try {
            if (TFNIM.getText().equals("") || TFNama.getText().equals("") || TFAlamat.getText().equals("") || TFUmur.getText().equals("")
                || TFPekerjaan.getText().equals("") || ComboBoxKelamin.getSelectedItem().equals("")||TFUmur.getText().equals("")
                || TFTelepon.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/db_rula", "root" ,"");
                st=con.createStatement();
                
                // Untuk menyimpan ke database
                String simpan = "INSERT INTO t_rula VALUES ('"+ TFNIM.getText() + "','" + TFNama.getText() +  "','" 
                                + TFAlamat.getText() + "','" + TFUmur.getText()+ "','" + TFPekerjaan.getText() + "','" 
                                + ComboBoxKelamin.getSelectedItem() + "','" + TFTelepon.getText() + "','" + "" + 
                        "','" + "" + "','" + "" + "','" +
                        "" + "','" + "" + "','" +
                        "" + "','" + "" + "','" +
                        "" + "','" + "" + "','" + "" + "')";
                
                // Untuk menyimpan ke database t_adjustdata
                String simpanAjust = "INSERT INTO t_adjustdata VALUES ('"+ TFNIM.getText() + "','" + "" +  "','" 
                                + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + ""
                        + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "')";
                
                int SA = st.executeUpdate(simpan);
                int SA2 = st.executeUpdate(simpanAjust);
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
                
                // Masuk ke from selanjutnya
                this.dispose();
                new Form1_UpperArm_Early().setVisible(true);
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "NIM Sudah Terdaftar \nSilahkan Coba Lagi", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Untuk menampilkan field profile agar tidak hilang
    public void TampilkanDataYangAda(){ 
        
        try{
            String sql="SELECT * FROM t_rula WHERE nim ='" + TFNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                String NIM = res.getString("nim");
                String Nama = res.getString("nama");
                String Alamat = res.getString("alamat");
                String Umur = res.getString("umur");
                String Pekerjaan = res.getString("pekerjaan");
                String JenisKelamin = res.getString("jeniskelamin");
                String NoTelepon = res.getString("notelepon");
                TFNIM.setText(NIM);           
                TFNama.setText(Nama);      
                TFAlamat.setText(Alamat);
                TFUmur.setText(Umur);
                TFPekerjaan.setText(Pekerjaan);
                ComboBoxKelamin.setSelectedItem(JenisKelamin);
                TFTelepon.setText(NoTelepon);
                }
            
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public Form02_Profile_Early() {
        initComponents();
        
        // Set Database
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost/db_rula","root","");
                st = con.createStatement();
            }
            catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Gagal Terkoneksi ke Database", "Pesan", JOptionPane.ERROR_MESSAGE);
            }
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
        PanelHistory = new GUI_Custom.PanelRound();
        ButtonHistory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PanelNIM = new GUI_Custom.PanelRound();
        icon1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFNIM = new javax.swing.JTextField();
        PanelNama = new GUI_Custom.PanelRound();
        icon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFNama = new javax.swing.JTextField();
        PanelAlamat = new GUI_Custom.PanelRound();
        icon2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TFAlamat = new javax.swing.JTextField();
        PanelUmur = new GUI_Custom.PanelRound();
        icon3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TFUmur = new javax.swing.JTextField();
        PanelPekerjaan = new GUI_Custom.PanelRound();
        icon5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TFPekerjaan = new javax.swing.JTextField();
        PanelKelamin = new GUI_Custom.PanelRound();
        icon6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxKelamin = new GUI_Custom.ComboBoxSuggestion();
        PanelTelepon = new GUI_Custom.PanelRound();
        icon4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TFTelepon = new javax.swing.JTextField();
        PanelLanjut = new GUI_Custom.PanelRound();
        ButtonLanjut = new javax.swing.JButton();
        PanelBack = new GUI_Custom.PanelRound();
        ButtonBack = new javax.swing.JButton();
        Gambar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1042, 768));
        setMinimumSize(new java.awt.Dimension(1042, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1042, 575));
        jPanel1.setMinimumSize(new java.awt.Dimension(1042, 575));
        jPanel1.setPreferredSize(new java.awt.Dimension(1040, 480));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelHistory.setBackground(new java.awt.Color(40, 167, 69));
        PanelHistory.setPreferredSize(new java.awt.Dimension(100, 40));
        PanelHistory.setRoundBottomLeft(25);
        PanelHistory.setRoundBottomRight(25);
        PanelHistory.setRoundTopLeft(25);
        PanelHistory.setRoundTopRight(25);

        ButtonHistory.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonHistory.setForeground(new java.awt.Color(255, 255, 255));
        ButtonHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-time-machine-20.png"))); // NOI18N
        ButtonHistory.setText("RIWAYAT");
        ButtonHistory.setContentAreaFilled(false);
        ButtonHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonHistory.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonHistoryMouseMoved(evt);
            }
        });
        ButtonHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHistoryLayout = new javax.swing.GroupLayout(PanelHistory);
        PanelHistory.setLayout(PanelHistoryLayout);
        PanelHistoryLayout.setHorizontalGroup(
            PanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHistoryLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelHistoryLayout.setVerticalGroup(
            PanelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(PanelHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 120, 40));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RULA - Rapid Upper Limb Assessment");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 1022, -1));

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Detail pribadi");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 1022, -1));

        PanelNIM.setBackground(new java.awt.Color(255, 255, 255));
        PanelNIM.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon1.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        icon1.setForeground(new java.awt.Color(21, 0, 53));
        icon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-id-verified-30.png"))); // NOI18N
        PanelNIM.add(icon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 50));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NIM");
        PanelNIM.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 400, -1));

        TFNIM.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        TFNIM.setForeground(new java.awt.Color(40, 167, 69));
        TFNIM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFNIM.setBorder(null);
        TFNIM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelNIM.add(TFNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 400, 30));

        jPanel1.add(PanelNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 380, 50));

        PanelNama.setBackground(new java.awt.Color(255, 255, 255));
        PanelNama.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        icon.setForeground(new java.awt.Color(21, 0, 53));
        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-name-30.png"))); // NOI18N
        PanelNama.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 50));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nama");
        PanelNama.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 400, -1));

        TFNama.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        TFNama.setForeground(new java.awt.Color(40, 167, 69));
        TFNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFNama.setBorder(null);
        TFNama.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelNama.add(TFNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 400, 30));

        jPanel1.add(PanelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 380, 50));

        PanelAlamat.setBackground(new java.awt.Color(255, 255, 255));
        PanelAlamat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon2.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        icon2.setForeground(new java.awt.Color(21, 0, 53));
        icon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-home-address-30.png"))); // NOI18N
        PanelAlamat.add(icon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 50));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Alamat");
        PanelAlamat.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 400, -1));

        TFAlamat.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        TFAlamat.setForeground(new java.awt.Color(40, 167, 69));
        TFAlamat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFAlamat.setBorder(null);
        TFAlamat.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelAlamat.add(TFAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 400, 30));

        jPanel1.add(PanelAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 380, 50));

        PanelUmur.setBackground(new java.awt.Color(255, 255, 255));
        PanelUmur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon3.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        icon3.setForeground(new java.awt.Color(21, 0, 53));
        icon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-age-30.png"))); // NOI18N
        PanelUmur.add(icon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 50));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Umur");
        PanelUmur.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 400, -1));

        TFUmur.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        TFUmur.setForeground(new java.awt.Color(40, 167, 69));
        TFUmur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFUmur.setBorder(null);
        TFUmur.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelUmur.add(TFUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 400, 30));

        jPanel1.add(PanelUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 380, 50));

        PanelPekerjaan.setBackground(new java.awt.Color(255, 255, 255));
        PanelPekerjaan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon5.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        icon5.setForeground(new java.awt.Color(21, 0, 53));
        icon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-job-seeker-30.png"))); // NOI18N
        PanelPekerjaan.add(icon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 50));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Pekerjaan");
        PanelPekerjaan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 400, -1));

        TFPekerjaan.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        TFPekerjaan.setForeground(new java.awt.Color(40, 167, 69));
        TFPekerjaan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPekerjaan.setBorder(null);
        TFPekerjaan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelPekerjaan.add(TFPekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 400, 30));

        jPanel1.add(PanelPekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 380, 50));

        PanelKelamin.setBackground(new java.awt.Color(255, 255, 255));
        PanelKelamin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon6.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        icon6.setForeground(new java.awt.Color(21, 0, 53));
        icon6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-gender-equality-30.png"))); // NOI18N
        PanelKelamin.add(icon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 50));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Jenis Kelamin");
        PanelKelamin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 400, -1));

        ComboBoxKelamin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ComboBoxKelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Laki-laki", "Perempuan" }));
        ComboBoxKelamin.setToolTipText("");
        ComboBoxKelamin.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelKelamin.add(ComboBoxKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 150, 28));

        jPanel1.add(PanelKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 380, 50));

        PanelTelepon.setBackground(new java.awt.Color(255, 255, 255));
        PanelTelepon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon4.setFont(new java.awt.Font("Urbanist", 1, 14)); // NOI18N
        icon4.setForeground(new java.awt.Color(21, 0, 53));
        icon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/icons8-phone-book-30.png"))); // NOI18N
        PanelTelepon.add(icon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 40, 50));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("No Telepon");
        PanelTelepon.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 400, -1));

        TFTelepon.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        TFTelepon.setForeground(new java.awt.Color(40, 167, 69));
        TFTelepon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFTelepon.setBorder(null);
        TFTelepon.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PanelTelepon.add(TFTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 400, 30));

        jPanel1.add(PanelTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 380, 50));

        PanelLanjut.setBackground(new java.awt.Color(40, 167, 69));
        PanelLanjut.setRoundBottomLeft(25);
        PanelLanjut.setRoundBottomRight(25);
        PanelLanjut.setRoundTopLeft(25);
        PanelLanjut.setRoundTopRight(25);

        ButtonLanjut.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonLanjut.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLanjut.setText("LANJUT");
        ButtonLanjut.setContentAreaFilled(false);
        ButtonLanjut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jPanel1.add(PanelLanjut, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 620, 170, 40));

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

        jPanel1.add(PanelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 100, -1));

        Gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/WidgetProfile.png"))); // NOI18N
        jPanel1.add(Gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1042, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLanjutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLanjutMouseMoved
        // TODO add your handling code here:
        PanelLanjut.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonLanjutMouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        PanelLanjut.setBackground(new java.awt.Color(40,167,69));
        PanelBack.setBackground(new java.awt.Color(40,167,69));
        PanelHistory.setBackground(new java.awt.Color(40,167,69));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void ButtonLanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLanjutActionPerformed
        // TODO add your handling code here:
        CheckEmptyTextField();
    }//GEN-LAST:event_ButtonLanjutActionPerformed

    private void ButtonBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseMoved
        // TODO add your handling code here:
        PanelBack.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonBackMouseMoved

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form01_Home_Early().setVisible(true);
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ButtonHistoryMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonHistoryMouseMoved
        // TODO add your handling code here:
        PanelHistory.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonHistoryMouseMoved

    private void ButtonHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonHistoryActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form03_Riwayat_Early().setVisible(true);
    }//GEN-LAST:event_ButtonHistoryActionPerformed

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
            java.util.logging.Logger.getLogger(Form02_Profile_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form02_Profile_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form02_Profile_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form02_Profile_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form02_Profile_Early().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonHistory;
    private javax.swing.JButton ButtonLanjut;
    private GUI_Custom.ComboBoxSuggestion ComboBoxKelamin;
    private javax.swing.JLabel Gambar;
    private GUI_Custom.PanelRound PanelAlamat;
    private GUI_Custom.PanelRound PanelBack;
    private GUI_Custom.PanelRound PanelHistory;
    private GUI_Custom.PanelRound PanelKelamin;
    private GUI_Custom.PanelRound PanelLanjut;
    private GUI_Custom.PanelRound PanelNIM;
    private GUI_Custom.PanelRound PanelNama;
    private GUI_Custom.PanelRound PanelPekerjaan;
    private GUI_Custom.PanelRound PanelTelepon;
    private GUI_Custom.PanelRound PanelUmur;
    private javax.swing.JTextField TFAlamat;
    public static javax.swing.JTextField TFNIM;
    private javax.swing.JTextField TFNama;
    private javax.swing.JTextField TFPekerjaan;
    private javax.swing.JTextField TFTelepon;
    private javax.swing.JTextField TFUmur;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
