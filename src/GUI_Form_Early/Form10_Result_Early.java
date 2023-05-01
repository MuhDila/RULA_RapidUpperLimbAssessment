package GUI_Form_Early;

import Database.Database;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhammad Dila
 */
public final class Form10_Result_Early extends javax.swing.JFrame {
    
    // Set Database
    Connection con =null;
    Statement st = null;
    
    // Perhitugnan Pada Tabel A
    public void HasilTabelA(){ 
        try{
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form02_Profile_Early.TFNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int upperarm = res.getInt("upperarm");
                int lowerarm = res.getInt("lowerarm");
                int wrist = res.getInt("wrist");
                int wristtwist = res.getInt("wristtwist");
                
            DefaultTableModel model = (DefaultTableModel)TabelA.getModel();
            int selectedRowIndex = 0;
            int selectedColoumIndex = 0;
            
            if (upperarm == 1 && lowerarm == 1) {
                 selectedRowIndex = 0;   
                }
            else if (upperarm == 1 && lowerarm == 2) {
                 selectedRowIndex = 1;   
                }
            else if (upperarm == 1 && lowerarm == 3) {
                 selectedRowIndex = 2;   
                }
            else if (upperarm == 2 && lowerarm == 1) {
                 selectedRowIndex = 3;   
                }
            else if (upperarm == 2 && lowerarm == 2) {
                 selectedRowIndex = 4;   
                }
            else if (upperarm == 2 && lowerarm == 3) {
                 selectedRowIndex = 5;   
                }
            else if (upperarm == 3 && lowerarm == 1) {
                 selectedRowIndex = 6;   
                }
            else if (upperarm == 3 && lowerarm == 2) {
                 selectedRowIndex = 7;   
                }
            else if (upperarm == 3 && lowerarm == 3) {
                 selectedRowIndex = 8;   
                }
            else if (upperarm == 4 && lowerarm == 1) {
                 selectedRowIndex = 9;   
                }
            else if (upperarm == 4 && lowerarm == 2) {
                 selectedRowIndex = 10;   
                }
            else if (upperarm == 4 && lowerarm == 3) {
                 selectedRowIndex = 11;   
                }
            else if (upperarm == 5 && lowerarm == 1) {
                 selectedRowIndex = 12;   
                }
            else if (upperarm == 5 && lowerarm == 2) {
                 selectedRowIndex = 13;   
                }
            else if (upperarm == 5 && lowerarm == 3) {
                 selectedRowIndex = 14;   
                }
            else if (upperarm == 6 && lowerarm == 1) {
                 selectedRowIndex = 15;   
                }
            else if (upperarm == 6 && lowerarm == 2) {
                 selectedRowIndex = 16;   
                }
            else if (upperarm == 6 && lowerarm == 3) {
                 selectedRowIndex = 17;   
                }
            if (wrist == 1 && wristtwist == 1) {
                 selectedColoumIndex = 0;   
                }
            else if (wrist == 1 && wristtwist == 2) {
                 selectedColoumIndex = 1;   
                }
            else if (wrist == 2 && wristtwist == 1) {
                 selectedColoumIndex = 2;   
                }
            else if (wrist == 2 && wristtwist == 2) {
                 selectedColoumIndex = 3;   
                }
            else if (wrist == 3 && wristtwist == 1) {
                 selectedColoumIndex = 4;   
                }
            else if (wrist == 3 && wristtwist == 2) {
                 selectedColoumIndex = 5;   
                }
            else if (wrist == 4 && wristtwist == 1) {
                 selectedColoumIndex = 6;   
                }
            else if (wrist == 4 && wristtwist == 2) {
                 selectedColoumIndex = 7;   
                }
        
                ScoreA.setText(model.getValueAt(selectedRowIndex, selectedColoumIndex).toString());
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Perhitugnan Pada Tabel B
    public void HasilTabelB(){ 
        try{
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form02_Profile_Early.TFNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int location_neck = res.getInt("location_neck");
                int locate_trunk = res.getInt("locate_trunk");
                int legs = res.getInt("legs");
                
            DefaultTableModel model = (DefaultTableModel)TabelB.getModel();
            int selectedRowIndex = 0;
            int selectedColoumIndex = 0;
            
            if (location_neck == 1) {
                 selectedRowIndex = 0;   
                }
            else if (location_neck == 2) {
                 selectedRowIndex = 1;   
                }
            else if (location_neck == 3) {
                 selectedRowIndex = 2;   
                }
            else if (location_neck == 4) {
                 selectedRowIndex = 3;   
                }
            else if (location_neck == 5) {
                 selectedRowIndex = 4;   
                }
            else if (location_neck == 6) {
                 selectedRowIndex = 5;   
                }
            if (locate_trunk == 1 && legs== 1) {
                 selectedColoumIndex = 0;   
                }
            else if (locate_trunk == 1 && legs== 2) {
                 selectedColoumIndex = 1;   
                }
            else if (locate_trunk == 2 && legs== 1) {
                 selectedColoumIndex = 2;   
                }
            else if (locate_trunk == 2 && legs== 2) {
                 selectedColoumIndex = 3;   
                }
            else if (locate_trunk == 3 && legs== 1) {
                 selectedColoumIndex = 4;   
                }
            else if (locate_trunk == 3 && legs== 2) {
                 selectedColoumIndex = 5;   
                }
            else if (locate_trunk == 4 && legs== 1) {
                 selectedColoumIndex = 6;   
                }
            else if (locate_trunk == 4 && legs== 2) {
                 selectedColoumIndex = 7;   
                }
            else if (locate_trunk == 5 && legs== 1) {
                 selectedColoumIndex = 8;   
                }
            else if (locate_trunk == 5 && legs== 2) {
                 selectedColoumIndex = 9;   
                }
            else if (locate_trunk == 6 && legs== 1) {
                 selectedColoumIndex = 10;   
                }
            else if (locate_trunk == 6 && legs== 2) {
                 selectedColoumIndex = 11;   
                }
        
                ScoreB.setText(model.getValueAt(selectedRowIndex, selectedColoumIndex).toString());
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Perhitugnan Score Akhir
    public void HasilTabelC(){ 
        try{
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form02_Profile_Early.TFNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int armwrist_muscle = res.getInt("armwrist_muscle");
                int necktrunklegs_muscle = res.getInt("necktrunklegs_muscle");
                int scoreTableA = Integer.parseInt(ScoreA.getText());
                int scoreTableB = Integer.parseInt(ScoreB.getText());
                
                int wristArmScore = scoreTableA + armwrist_muscle;
                int neckTrunkLegsScore = scoreTableB + necktrunklegs_muscle;
                
            DefaultTableModel model = (DefaultTableModel)TabelFinal.getModel();
            int selectedRowIndex = 0;
            int selectedColoumIndex = 0;
            
            if (wristArmScore == 1) {
                 selectedRowIndex = 0;   
                }
            else if (wristArmScore == 2) {
                 selectedRowIndex = 1;   
                }
            else if (wristArmScore == 3) {
                 selectedRowIndex = 2;   
                }
            else if (wristArmScore == 4) {
                 selectedRowIndex = 3;   
                }
            else if (wristArmScore == 5) {
                 selectedRowIndex = 4;   
                }
            else if (wristArmScore == 6) {
                 selectedRowIndex = 5;   
                }
            else if (wristArmScore == 7) {
                 selectedRowIndex = 6;   
                }
            else if (wristArmScore >= 8) {
                 selectedRowIndex = 7;   
                }
            if (neckTrunkLegsScore == 1) {
                 selectedColoumIndex = 0;   
                }
            else if (neckTrunkLegsScore == 2) {
                 selectedColoumIndex = 1;   
                }
            else if (neckTrunkLegsScore == 3) {
                 selectedColoumIndex = 2;   
                }
            else if (neckTrunkLegsScore == 4) {
                 selectedColoumIndex = 3;   
                }
            else if (neckTrunkLegsScore == 5) {
                 selectedColoumIndex = 4;   
                }
            else if (neckTrunkLegsScore == 6) {
                 selectedColoumIndex = 5;   
                }
            else if (neckTrunkLegsScore >= 7) {
                 selectedColoumIndex = 6;
            }
                ScoreFinal.setText(model.getValueAt(selectedRowIndex, selectedColoumIndex).toString());
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Menggambil value dari TFNIM
    public void GetValueNIM() {
        LabelIdentitas.setText("NIM: " + Form02_Profile_Early.TFNIM.getText());
    }
    
    // Set warna panel score rula dan keterangannya
    public void WarnaPanel(){
                if (ScoreFinal.getText().equals("1") || ScoreFinal.getText().equals("2")) {
                    PanelScoreRula.setBackground(new java.awt.Color(40,167,69));
                    LabelTingkatTindakan.setText("Tingkat tindakan: 1");
                    LabelKeterangan.setText("Postur tubuh yang dapat diterima");
                }
                else if (ScoreFinal.getText().equals("3") || ScoreFinal.getText().equals("4")) {
                    PanelScoreRula.setBackground(new java.awt.Color(0,123,255));
                    LabelTingkatTindakan.setText("Tingkat tindakan: 2");
                    LabelKeterangan.setText("Investigasi lebih lanjut, perubahan mungkin diperlukan");
                }
                else if (ScoreFinal.getText().equals("5") || ScoreFinal.getText().equals("6")) {
                    PanelScoreRula.setBackground(new java.awt.Color(255,193,7));
                    LabelTingkatTindakan.setText("Tingkat tindakan: 3");
                    LabelKeterangan.setText("Investigasi lebih lanjut, segera lakukan perubahan");
                }
                else if (ScoreFinal.getText().equals("7")) {
                    PanelScoreRula.setBackground(new java.awt.Color(220,53,69));
                    LabelTingkatTindakan.setText("Tingkat tindakan: 4");
                    LabelKeterangan.setText("Selidiki dan terapkan perubahan");
                }
        
    }
    
    public Form10_Result_Early() {
        initComponents();
        
        // Menggambil Value dari TFNIM
        GetValueNIM();
        
        // Hasil ahkir dari masing-masing tabel
        HasilTabelA();
        HasilTabelB();
        HasilTabelC();
        
        // Set warna panel score rula dan keterangannya
        WarnaPanel();
        
        // Final Score
        LabelFinalScoreRula.setText("Skor RULA: " +  ScoreFinal.getText());
        
         // Insert data final score ke database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_rula", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database
            String simpan = "UPDATE t_rula SET final_score ='" + ScoreFinal.getText() + "' WHERE nim='" + Form02_Profile_Early.TFNIM.getText()+"'";
            int SA = st.executeUpdate(simpan);
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
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
        LabelRula = new javax.swing.JLabel();
        LabelScoreAkhir = new javax.swing.JLabel();
        PanelScoreRula = new GUI_Custom.PanelRound();
        LabelFinalScoreRula = new javax.swing.JLabel();
        LabelTingkatTindakan = new javax.swing.JLabel();
        LabelKeterangan = new javax.swing.JLabel();
        PanelLihatRingkasanLengkap = new GUI_Custom.PanelRound();
        ButtonLihatRingkasanLengkap = new javax.swing.JButton();
        PanelBuatPerhitunganBaru = new GUI_Custom.PanelRound();
        ButtonBuatPerhitunganBaru = new javax.swing.JButton();
        PanelBack = new GUI_Custom.PanelRound();
        ButtonBack = new javax.swing.JButton();
        JTabelA = new javax.swing.JScrollPane();
        TabelA = new javax.swing.JTable();
        ScoreA = new javax.swing.JLabel();
        JTabelB = new javax.swing.JScrollPane();
        TabelB = new javax.swing.JTable();
        ScoreB = new javax.swing.JLabel();
        JTabelFinal = new javax.swing.JScrollPane();
        TabelFinal = new javax.swing.JTable();
        ScoreFinal = new javax.swing.JLabel();
        LabelIdentitas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1042, 480));

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

        LabelRula.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelRula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelRula.setText("RULA - Rapid Upper Limb Assessment");
        jPanel1.add(LabelRula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 32, 1022, -1));

        LabelScoreAkhir.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        LabelScoreAkhir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelScoreAkhir.setText("Skor akhir RULA");
        jPanel1.add(LabelScoreAkhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 1022, -1));

        PanelScoreRula.setBackground(new java.awt.Color(40, 167, 69));
        PanelScoreRula.setRoundBottomLeft(50);
        PanelScoreRula.setRoundBottomRight(50);
        PanelScoreRula.setRoundTopLeft(50);
        PanelScoreRula.setRoundTopRight(50);
        PanelScoreRula.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelFinalScoreRula.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelFinalScoreRula.setForeground(new java.awt.Color(255, 255, 255));
        LabelFinalScoreRula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFinalScoreRula.setText("0");
        PanelScoreRula.add(LabelFinalScoreRula, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 500, -1));

        LabelTingkatTindakan.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        LabelTingkatTindakan.setForeground(new java.awt.Color(255, 255, 255));
        LabelTingkatTindakan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTingkatTindakan.setText("0");
        PanelScoreRula.add(LabelTingkatTindakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 500, 30));

        LabelKeterangan.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        LabelKeterangan.setForeground(new java.awt.Color(255, 255, 255));
        LabelKeterangan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelKeterangan.setText("0");
        PanelScoreRula.add(LabelKeterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, -1));

        jPanel1.add(PanelScoreRula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 500, 130));

        PanelLihatRingkasanLengkap.setBackground(new java.awt.Color(40, 167, 69));
        PanelLihatRingkasanLengkap.setRoundBottomLeft(25);
        PanelLihatRingkasanLengkap.setRoundBottomRight(25);
        PanelLihatRingkasanLengkap.setRoundTopLeft(25);
        PanelLihatRingkasanLengkap.setRoundTopRight(25);

        ButtonLihatRingkasanLengkap.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonLihatRingkasanLengkap.setForeground(new java.awt.Color(255, 255, 255));
        ButtonLihatRingkasanLengkap.setText("LIHAT RINGKASAN LENGKAP");
        ButtonLihatRingkasanLengkap.setContentAreaFilled(false);
        ButtonLihatRingkasanLengkap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonLihatRingkasanLengkap.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonLihatRingkasanLengkapMouseMoved(evt);
            }
        });
        ButtonLihatRingkasanLengkap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLihatRingkasanLengkapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLihatRingkasanLengkapLayout = new javax.swing.GroupLayout(PanelLihatRingkasanLengkap);
        PanelLihatRingkasanLengkap.setLayout(PanelLihatRingkasanLengkapLayout);
        PanelLihatRingkasanLengkapLayout.setHorizontalGroup(
            PanelLihatRingkasanLengkapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonLihatRingkasanLengkap, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        PanelLihatRingkasanLengkapLayout.setVerticalGroup(
            PanelLihatRingkasanLengkapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonLihatRingkasanLengkap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(PanelLihatRingkasanLengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 270, 40));

        PanelBuatPerhitunganBaru.setBackground(new java.awt.Color(40, 167, 69));
        PanelBuatPerhitunganBaru.setRoundBottomLeft(25);
        PanelBuatPerhitunganBaru.setRoundBottomRight(25);
        PanelBuatPerhitunganBaru.setRoundTopLeft(25);
        PanelBuatPerhitunganBaru.setRoundTopRight(25);

        ButtonBuatPerhitunganBaru.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonBuatPerhitunganBaru.setForeground(new java.awt.Color(255, 255, 255));
        ButtonBuatPerhitunganBaru.setText("BUAT PERHITUNGAN BARU");
        ButtonBuatPerhitunganBaru.setContentAreaFilled(false);
        ButtonBuatPerhitunganBaru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonBuatPerhitunganBaru.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonBuatPerhitunganBaruMouseMoved(evt);
            }
        });
        ButtonBuatPerhitunganBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuatPerhitunganBaruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBuatPerhitunganBaruLayout = new javax.swing.GroupLayout(PanelBuatPerhitunganBaru);
        PanelBuatPerhitunganBaru.setLayout(PanelBuatPerhitunganBaruLayout);
        PanelBuatPerhitunganBaruLayout.setHorizontalGroup(
            PanelBuatPerhitunganBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonBuatPerhitunganBaru, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        PanelBuatPerhitunganBaruLayout.setVerticalGroup(
            PanelBuatPerhitunganBaruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonBuatPerhitunganBaru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(PanelBuatPerhitunganBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 270, 40));

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

        jPanel1.add(PanelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 100, -1));

        TabelA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "2", "2", "2", "2", "3", "3", "3"},
                {"2", "2", "2", "2", "3", "3", "3", "3"},
                {"2", "3", "3", "3", "3", "3", "4", "4"},
                {"2", "3", "3", "3", "3", "4", "4", "4"},
                {"3", "3", "3", "3", "3", "4", "4", "4"},
                {"3", "4", "4", "4", "4", "4", "5", "5"},
                {"3", "3", "4", "4", "4", "4", "5", "5"},
                {"3", "4", "4", "4", "4", "4", "5", "5"},
                {"4", "4", "4", "4", "4", "5", "5", "5"},
                {"4", "4", "4", "4", "4", "5", "5", "5"},
                {"4", "4", "4", "4", "4", "5", "5", "5"},
                {"4", "4", "4", "5", "5", "5", "6", "6"},
                {"5", "5", "5", "5", "5", "6", "6", "7"},
                {"5", "6", "6", "6", "6", "7", "7", "7"},
                {"6", "6", "6", "7", "7", "7", "7", "8"},
                {"7", "7", "7", "7", "7", "8", "8", "9"},
                {"8", "8", "8", "8", "8", "9", "9", "9"},
                {"9", "9", "9", "9", "9", "9", "9", "9"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        JTabelA.setViewportView(TabelA);

        jPanel1.add(JTabelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));
        jPanel1.add(ScoreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        TabelB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "3", "2", "3", "3", "4", "5", "5", "6", "6", "7", "7"},
                {"2", "3", "2", "3", "4", "5", "5", "5", "6", "7", "7", "7"},
                {"3", "3", "3", "4", "4", "5", "5", "6", "6", "7", "7", "7"},
                {"5", "5", "5", "6", "6", "7", "7", "7", "7", "7", "8", "8"},
                {"7", "7", "7", "7", "7", "8", "8", "8", "8", "8", "8", "8"},
                {"8", "8", "8", "8", "8", "8", "8", "9", "9", "9", "9", "9"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        JTabelB.setViewportView(TabelB);

        jPanel1.add(JTabelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));
        jPanel1.add(ScoreB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        TabelFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "2", "3", "3", "4", "5", "5"},
                {"2", "2", "3", "4", "4", "5", "5"},
                {"3", "3", "3", "4", "4", "5", "6"},
                {"3", "3", "3", "4", "5", "6", "6"},
                {"4", "4", "4", "5", "6", "7", "7"},
                {"4", "4", "5", "6", "6", "7", "7"},
                {"5", "5", "6", "6", "7", "7", "7"},
                {"5", "5", "6", "7", "7", "7", "7"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        JTabelFinal.setViewportView(TabelFinal);

        jPanel1.add(JTabelFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));
        jPanel1.add(ScoreFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        LabelIdentitas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        LabelIdentitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelIdentitas.setText("jLabel2");
        jPanel1.add(LabelIdentitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 45, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonLihatRingkasanLengkapMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLihatRingkasanLengkapMouseMoved
        // TODO add your handling code here:
        PanelLihatRingkasanLengkap.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonLihatRingkasanLengkapMouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        PanelLihatRingkasanLengkap.setBackground(new java.awt.Color(40,167,69));
        PanelBack.setBackground(new java.awt.Color(40,167,69));
        PanelBuatPerhitunganBaru.setBackground(new java.awt.Color(40,167,69));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void ButtonLihatRingkasanLengkapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLihatRingkasanLengkapActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form11_FullResult_Early().setVisible(true);
    }//GEN-LAST:event_ButtonLihatRingkasanLengkapActionPerformed

    private void ButtonBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseMoved
        // TODO add your handling code here:
        PanelBack.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonBackMouseMoved

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form9_NeckTrunkLegs_MuscleUse_Early().setVisible(true);
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void ButtonBuatPerhitunganBaruMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBuatPerhitunganBaruMouseMoved
        // TODO add your handling code here:
        PanelBuatPerhitunganBaru.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonBuatPerhitunganBaruMouseMoved

    private void ButtonBuatPerhitunganBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuatPerhitunganBaruActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form02_Profile_Early().setVisible(true);
    }//GEN-LAST:event_ButtonBuatPerhitunganBaruActionPerformed

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
            java.util.logging.Logger.getLogger(Form10_Result_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form10_Result_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form10_Result_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form10_Result_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form10_Result_Early().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JButton ButtonBuatPerhitunganBaru;
    private javax.swing.JButton ButtonLihatRingkasanLengkap;
    private javax.swing.JScrollPane JTabelA;
    private javax.swing.JScrollPane JTabelB;
    private javax.swing.JScrollPane JTabelFinal;
    private javax.swing.JLabel LabelFinalScoreRula;
    private javax.swing.JLabel LabelIdentitas;
    private javax.swing.JLabel LabelKeterangan;
    private javax.swing.JLabel LabelRula;
    private javax.swing.JLabel LabelScoreAkhir;
    private javax.swing.JLabel LabelTingkatTindakan;
    private GUI_Custom.PanelRound PanelBack;
    private GUI_Custom.PanelRound PanelBuatPerhitunganBaru;
    private GUI_Custom.PanelRound PanelLihatRingkasanLengkap;
    private GUI_Custom.PanelRound PanelScoreRula;
    public static javax.swing.JLabel ScoreA;
    public static javax.swing.JLabel ScoreB;
    public static javax.swing.JLabel ScoreFinal;
    private javax.swing.JTable TabelA;
    private javax.swing.JTable TabelB;
    private javax.swing.JTable TabelFinal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
