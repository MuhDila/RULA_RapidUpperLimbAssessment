/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Form_Early;

import Database.Database;
import GUI_Custom.ScrollBarCustom;
import static GUI_Form_Early.Form10_Result_Early.ScoreA;
import static GUI_Form_Early.Form10_Result_Early.ScoreFinal;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muhammad Dila
 */
public class Form11_FullResult_Early extends javax.swing.JFrame {
    
    // Setting size gambar otomatis
    public void ImageSize() {
        ImageIcon ii = new ImageIcon(getClass().getResource("/Iamges_Early/neck5.jpg"));
        Image image = (ii).getImage().getScaledInstance(GambarCheckBoxLangkah6.getWidth(), GambarCheckBoxLangkah6.getHeight(), Image.SCALE_SMOOTH);
        ii = new ImageIcon(image);
        GambarCheckBoxLangkah6.setIcon(ii);
        
        ImageIcon ii2 = new ImageIcon(getClass().getResource("/Iamges_Early/trunk5.jpg"));
        Image image2 = (ii2).getImage().getScaledInstance(GambarCheckBoxLangkah7.getWidth(), GambarCheckBoxLangkah7.getHeight(), Image.SCALE_SMOOTH);
        ii2 = new ImageIcon(image2);
        GambarCheckBoxLangkah7.setIcon(ii2);
    }
    
    // Set warna panel score rula dan keterangannya
    public void WarnaPanel(){
                if (ScoreFinal.getText().equals("1") || ScoreFinal.getText().equals("2")) {
                    PanelScoreRula.setBackground(new java.awt.Color(40,167,69));
                    LabelLevel.setText("Tingkat tindakan: 1");
                    LabelKeterangan.setText("Postur tubuh yang dapat diterima");
                }
                else if (ScoreFinal.getText().equals("3") || ScoreFinal.getText().equals("4")) {
                    PanelScoreRula.setBackground(new java.awt.Color(0,123,255));
                    LabelLevel.setText("Tingkat tindakan: 2");
                    LabelKeterangan.setText("Investigasi lebih lanjut, perubahan mungkin diperlukan");
                }
                else if (ScoreFinal.getText().equals("5") || ScoreFinal.getText().equals("6")) {
                    PanelScoreRula.setBackground(new java.awt.Color(255,193,7));
                    LabelLevel.setText("Tingkat tindakan: 3");
                    LabelKeterangan.setText("Investigasi lebih lanjut, segera lakukan perubahan");
                }
                else if (ScoreFinal.getText().equals("7")) {
                    PanelScoreRula.setBackground(new java.awt.Color(220,53,69));
                    LabelLevel.setText("Tingkat tindakan: 4");
                    LabelKeterangan.setText("Selidiki dan terapkan perubahan");
                }
        
    }
    
    // Set detail personal
    public void GetDetailPersonal() {
        try{
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form02_Profile_Early.TFNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                String Nim = res.getString("nim");
                String Nama = res.getString("nama");
                String Alamat = res.getString("alamat");
                String Umur = res.getString("umur");
                String Pekerjaan = res.getString("pekerjaan");
                String JenisKelamin = res.getString("jeniskelamin");
                String NoTelepon = res.getString("notelepon");
                LabelIsiNIM.setText(Nim);
                LabelIsiNama.setText(Nama);
                LabelIsiAlamat.setText(Alamat);
                LabelIsiUmur.setText(Umur);
                LabelIsiPekerjaan.setText(Pekerjaan);
                LabelIsiKelamin.setText(JenisKelamin);
                LabelIsiTelepon.setText(NoTelepon);
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 1
    public void PanelLangkah1() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int UpperArm = res.getInt("upperarm");
                int AUpperArm = res.getInt("a_upperarm");
                switch (UpperArm) {
                    case 1:
                        GambarLangka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/upperarm1.jpg")));
                        break;
                    case 2:
                        GambarLangka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/upperarm2.jpg")));
                        break;
                    case 3:
                        GambarLangka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/upperarm3.jpg")));
                        break;
                    case 4:
                        GambarLangka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/upperarm4.jpg")));
                        break;
                    case 5:
                        GambarLangka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/upperarm5.jpg")));
                        break;
                    default:
                        break;
                }
                switch (AUpperArm) {
                    case 1:
                        CheckBox1Langkah1.setSelected(true);
                        CheckBox1Langkah1.setEnabled(true);
                        break;
                    case 2:
                        CheckBox2Langkah1.setSelected(true);
                        CheckBox2Langkah1.setEnabled(true);
                        break;
                    case 3:
                        CheckBox1Langkah1.setSelected(true);
                        CheckBox1Langkah1.setEnabled(true);
                        CheckBox2Langkah1.setSelected(true);
                        CheckBox2Langkah1.setEnabled(true);
                        break;
                    case 4:
                        CheckBox3Langkah1.setSelected(true);
                        CheckBox3Langkah1.setEnabled(true);
                        break;
                    case 5:
                        CheckBox1Langkah1.setSelected(true);
                        CheckBox1Langkah1.setEnabled(true);
                        CheckBox2Langkah1.setSelected(true);
                        CheckBox2Langkah1.setEnabled(true);
                        CheckBox3Langkah1.setSelected(true);
                        CheckBox3Langkah1.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 2
    public void PanelLangkah2() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int LowerArm = res.getInt("lowerarm");
                int ALowerArm = res.getInt("a_lowerarm");
                switch (LowerArm) {
                    case 1:
                        GambarLangkah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/lowerarm1.jpg")));
                        break;
                    case 2:
                        GambarLangkah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/lowerarm2.jpg")));
                        break;
                    case 3:
                        GambarLangkah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/lowerarm3.jpg")));
                        break;
                    default:
                        break;
                }
                switch (ALowerArm) {
                    case 1:
                        CheckBox1Langkah2.setSelected(true);
                        CheckBox1Langkah2.setEnabled(true);
                        GambarCheckBoxLangkah2.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 3
    public void PanelLangkah3() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int Wrist = res.getInt("wrist");
                int AWrist = res.getInt("a_wrist");
                switch (Wrist) {
                    case 1:
                        GambarLangkah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist1.jpg")));
                        break;
                    case 2:
                        GambarLangkah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist2.jpg")));
                        break;
                    case 3:
                        GambarLangkah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist3.jpg")));
                        break;
                    case 4:
                        GambarLangkah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist4.jpg")));
                        break;
                    default:
                        break;
                }
                switch (AWrist) {
                    case 1:
                        CheckBoxLangkah3.setSelected(true);
                        CheckBoxLangkah3.setEnabled(true);
                        GambarCheckBoxLangkah3.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 4
    public void PanelLangkah4() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int WristTwist = res.getInt("wristtwist");
                switch (WristTwist) {
                    case 1:
                        GambarLangkah4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist_twist1.jpg")));
                        break;
                    case 2:
                        GambarLangkah4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist_twist2.jpg")));
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 5
    public void PanelLangkah5() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int armwrist_muscle = res.getInt("armwrist_muscle");
                int a_armwrist_muscle = res.getInt("a_armwrist_muscle");
                switch (armwrist_muscle) {
                    case 1:
                        LabelScoreLangkah5.setText("Score 0");
                        LabelKetScoreLangkah5.setText("Jika beban < 2 kg (terputus-putus)");
                        break;
                    case 2:
                        LabelScoreLangkah5.setText("Score 1");
                        LabelKetScoreLangkah5.setText("Jika beban 2 kg hingga 10 kg (terputus-putus)");
                        break;
                    case 3:
                        LabelScoreLangkah5.setText("Score 2");
                        LabelKetScoreLangkah5.setText("Jika beban 2 kg hingga 10 kg (statis atau berulang)");
                        break;
                    case 4:
                        LabelScoreLangkah5.setText("Score 3");
                        LabelKetScoreLangkah5.setText("Jika lebih dari 10 kg. atau berulang atau guncangan");
                        break;
                    default:
                        break;
                }
                switch (a_armwrist_muscle) {
                    case 1:
                        ChecKBoxLangkah5.setSelected(true);
                        ChecKBoxLangkah5.setEnabled(true);
                        LabelKetCheckBoxLangkah5.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 6
    public void PanelLangkah6() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int location_neck = res.getInt("location_neck");
                int a_location_neck = res.getInt("a_location_neck");
                switch (location_neck) {
                    case 1:
                        GambarLangkah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/neck1.jpg")));
                        break;
                    case 2:
                        GambarLangkah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/neck2.jpg")));
                        break;
                    case 3:
                        GambarLangkah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/neck3.jpg")));
                        break;
                    case 4:
                        GambarLangkah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/neck4.jpg")));
                        break;
                    default:
                        break;
                }
                switch (a_location_neck) {
                    case 1:
                        CheckBoxLangkah6.setSelected(true);
                        CheckBoxLangkah6.setEnabled(true);
                        GambarCheckBoxLangkah6.setEnabled(true);
                        ImageIcon ii = new ImageIcon(getClass().getResource("/Iamges_Early/neck5.jpg"));
                        Image image = (ii).getImage().getScaledInstance(GambarCheckBoxLangkah6.getWidth(), GambarCheckBoxLangkah6.getHeight(), Image.SCALE_SMOOTH);
                        ii = new ImageIcon(image);
                        GambarCheckBoxLangkah6.setIcon(ii);
                        break;
                    case 2:
                        CheckBoxLangkah6.setSelected(true);
                        CheckBoxLangkah6.setEnabled(true);
                        GambarCheckBoxLangkah6.setEnabled(true);
                        ImageIcon iii = new ImageIcon(getClass().getResource("/Iamges_Early/neck6.jpg"));
                        Image image2 = (iii).getImage().getScaledInstance(GambarCheckBoxLangkah6.getWidth(), GambarCheckBoxLangkah6.getHeight(), Image.SCALE_SMOOTH);
                        iii = new ImageIcon(image2);
                        GambarCheckBoxLangkah6.setIcon(iii);
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 7
    public void PanelLangkah7() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int locate_trunk = res.getInt("locate_trunk");
                int a_locate_trunk = res.getInt("a_locate_trunk");
                switch (locate_trunk) {
                    case 1:
                        GambarLangkah7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/trunk1.jpg")));
                        break;
                    case 2:
                        GambarLangkah7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/trunk2.jpg")));
                        break;
                    case 3:
                        GambarLangkah7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/trunk3.jpg")));
                        break;
                    case 4:
                        GambarLangkah7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/trunk4.jpg")));
                        break;
                    default:
                        break;
                }
                switch (a_locate_trunk) {
                    case 1:
                        CheckBoxLangkah7.setSelected(true);
                        CheckBoxLangkah7.setEnabled(true);
                        GambarCheckBoxLangkah7.setEnabled(true);
                        ImageIcon ii = new ImageIcon(getClass().getResource("/Iamges_Early/trunk5.jpg"));
                        Image image = (ii).getImage().getScaledInstance(GambarCheckBoxLangkah7.getWidth(), GambarCheckBoxLangkah7.getHeight(), Image.SCALE_SMOOTH);
                        ii = new ImageIcon(image);
                        GambarCheckBoxLangkah7.setIcon(ii);
                        break;
                    case 2:
                        CheckBoxLangkah7.setSelected(true);
                        CheckBoxLangkah7.setEnabled(true);
                        GambarCheckBoxLangkah7.setEnabled(true);
                        ImageIcon iii = new ImageIcon(getClass().getResource("/Iamges_Early/trunk6.jpg"));
                        Image image2 = (iii).getImage().getScaledInstance(GambarCheckBoxLangkah7.getWidth(), GambarCheckBoxLangkah7.getHeight(), Image.SCALE_SMOOTH);
                        iii = new ImageIcon(image2);
                        GambarCheckBoxLangkah7.setIcon(iii);
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 8
    public void PanelLangkah8() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int legs = res.getInt("legs");
                switch (legs) {
                    case 1:
                        GambarLangkah8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/legs1.jpg")));
                        break;
                    case 2:
                        GambarLangkah8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/legs2.jpg")));
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    // Get value untuk panel langkah 9
    public void PanelLangkah9() {
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + LabelIsiNIM.getText() + "'";
            java.sql.Connection conn = (Connection)Database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int necktrunklegs_muscle = res.getInt("a_necktrunklegs_muscle");
                int a_necktrunklegs_muscle = res.getInt("a_necktrunklegs_muscle");
                switch (necktrunklegs_muscle) {
                    case 1:
                        LabelScoreLangkah9.setText("Score 0");
                        LabelKetScoreLangkah9.setText("Jika beban < 2 kg (terputus-putus)");
                        break;
                    case 2:
                        LabelScoreLangkah9.setText("Score 1");
                        LabelKetScoreLangkah9.setText("Jika beban 2 kg hingga 10 kg (terputus-putus)");
                        break;
                    case 3:
                        LabelScoreLangkah9.setText("Score 2");
                        LabelKetScoreLangkah9.setText("Jika beban 2 kg hingga 10 kg (statis atau berulang)");
                        break;
                    case 4:
                        LabelScoreLangkah9.setText("Score 3");
                        LabelKetScoreLangkah9.setText("Jika lebih dari 10 kg. atau berulang atau guncangan");
                        break;
                    default:
                        break;
                }
                switch (a_necktrunklegs_muscle) {
                    case 1:
                        CheckBoxLangkah9.setSelected(true);
                        CheckBoxLangkah9.setEnabled(true);
                        LabelKetCheckBoxLangkah9.setEnabled(true);
                        break;
                    default:
                        break;
                }
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public Form11_FullResult_Early() {
        initComponents();
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        PanelBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        // Setting size gambar otomatis
        ImageSize();
        
        // Set warna panel score rula dan keterangannya
        WarnaPanel();
        
        // Final Score
        LabelScore.setText("Skor RULA: " +  ScoreFinal.getText());
        
        // Set detail personal
        GetDetailPersonal();
        
        // Get value untuk panel
        PanelLangkah1();
        PanelLangkah2();
        PanelLangkah3();
        PanelLangkah4();
        PanelLangkah5();
        PanelLangkah6();
        PanelLangkah7();
        PanelLangkah8();
        PanelLangkah9();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        LabelRula = new javax.swing.JLabel();
        LabelRingkasanLengkap = new javax.swing.JLabel();
        PanelScoreRula = new GUI_Custom.PanelRound();
        LabelScore = new javax.swing.JLabel();
        LabelLevel = new javax.swing.JLabel();
        LabelKeterangan = new javax.swing.JLabel();
        Artboard = new javax.swing.JLabel();
        PanelDetailProfile = new GUI_Custom.PanelRound();
        LabelDetailPribadi = new javax.swing.JLabel();
        LabelNIM = new javax.swing.JLabel();
        LabelTitikNIM = new javax.swing.JLabel();
        LabelIsiNIM = new javax.swing.JLabel();
        LabelNama = new javax.swing.JLabel();
        LabelTitikNama = new javax.swing.JLabel();
        LabelIsiNama = new javax.swing.JLabel();
        LabelAlamat = new javax.swing.JLabel();
        LabelTitikAlamat = new javax.swing.JLabel();
        LabelIsiAlamat = new javax.swing.JLabel();
        LabelUmur = new javax.swing.JLabel();
        LabelTitikUmur = new javax.swing.JLabel();
        LabelIsiUmur = new javax.swing.JLabel();
        LabelPekerjaan = new javax.swing.JLabel();
        LabelTitikPekerjaan = new javax.swing.JLabel();
        LabelIsiPekerjaan = new javax.swing.JLabel();
        LabelKelamin = new javax.swing.JLabel();
        LabelTitikKelamin = new javax.swing.JLabel();
        LabelIsiKelamin = new javax.swing.JLabel();
        LabelTelepon = new javax.swing.JLabel();
        LabelTitikTelepon = new javax.swing.JLabel();
        LabelIsiTelepon = new javax.swing.JLabel();
        PanelLangkah1 = new GUI_Custom.PanelRound();
        LabelLangkah1 = new javax.swing.JLabel();
        GambarLangka1 = new javax.swing.JLabel();
        LabelLangkah1a = new javax.swing.JLabel();
        CheckBox1Langkah1 = new GUI_Custom.JCheckBoxCustom();
        CheckBox2Langkah1 = new GUI_Custom.JCheckBoxCustom();
        CheckBox3Langkah1 = new GUI_Custom.JCheckBoxCustom();
        PanelLangkah2 = new GUI_Custom.PanelRound();
        LabelLangkah2 = new javax.swing.JLabel();
        GambarLangkah2 = new javax.swing.JLabel();
        LabelLangkah2a = new javax.swing.JLabel();
        CheckBox1Langkah2 = new GUI_Custom.JCheckBoxCustom();
        GambarCheckBoxLangkah2 = new javax.swing.JLabel();
        PanelLangkah3 = new GUI_Custom.PanelRound();
        LabelLangkah3 = new javax.swing.JLabel();
        GambarLangkah3 = new javax.swing.JLabel();
        LabelLangkah3a = new javax.swing.JLabel();
        CheckBoxLangkah3 = new GUI_Custom.JCheckBoxCustom();
        GambarCheckBoxLangkah3 = new javax.swing.JLabel();
        PanelLangkah4 = new GUI_Custom.PanelRound();
        LabelLangkah4 = new javax.swing.JLabel();
        GambarLangkah4 = new javax.swing.JLabel();
        PanelLangkah5 = new GUI_Custom.PanelRound();
        LabelLangkah5 = new javax.swing.JLabel();
        GambarBorderLangkah5 = new javax.swing.JLabel();
        LabelScoreLangkah5 = new javax.swing.JLabel();
        LabelKetScoreLangkah5 = new javax.swing.JLabel();
        LabelLangkah5a = new javax.swing.JLabel();
        ChecKBoxLangkah5 = new GUI_Custom.JCheckBoxCustom();
        LabelKetCheckBoxLangkah5 = new javax.swing.JLabel();
        PanelLangkah6 = new GUI_Custom.PanelRound();
        LabelLangkah6 = new javax.swing.JLabel();
        GambarLangkah6 = new javax.swing.JLabel();
        LabelLangkah6a = new javax.swing.JLabel();
        CheckBoxLangkah6 = new GUI_Custom.JCheckBoxCustom();
        GambarCheckBoxLangkah6 = new javax.swing.JLabel();
        PanelLangkah7 = new GUI_Custom.PanelRound();
        LabelLangkah7 = new javax.swing.JLabel();
        GambarLangkah7 = new javax.swing.JLabel();
        LabelLangkah7a = new javax.swing.JLabel();
        CheckBoxLangkah7 = new GUI_Custom.JCheckBoxCustom();
        GambarCheckBoxLangkah7 = new javax.swing.JLabel();
        PanelLangkah8 = new GUI_Custom.PanelRound();
        LabelLangkah8 = new javax.swing.JLabel();
        GambarLangkah8 = new javax.swing.JLabel();
        PanelLangkah9 = new GUI_Custom.PanelRound();
        LabelLangkah9 = new javax.swing.JLabel();
        GambarBorderLangkah9 = new javax.swing.JLabel();
        LabelScoreLangkah9 = new javax.swing.JLabel();
        LabelKetScoreLangkah9 = new javax.swing.JLabel();
        LabelLangkah9a = new javax.swing.JLabel();
        CheckBoxLangkah9 = new GUI_Custom.JCheckBoxCustom();
        LabelKetCheckBoxLangkah9 = new javax.swing.JLabel();
        PanelBack = new GUI_Custom.PanelRound();
        ButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1042, 768));
        setMinimumSize(new java.awt.Dimension(1042, 768));
        setPreferredSize(new java.awt.Dimension(1042, 768));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setEnabled(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(1020, 3090));
        jPanel1.setMinimumSize(new java.awt.Dimension(1020, 3090));
        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 3090));
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

        LabelRingkasanLengkap.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        LabelRingkasanLengkap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelRingkasanLengkap.setText("Ringkasan Lengkap Hasil RULA");
        jPanel1.add(LabelRingkasanLengkap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 1022, -1));

        PanelScoreRula.setBackground(new java.awt.Color(255, 193, 7));
        PanelScoreRula.setRoundBottomLeft(50);
        PanelScoreRula.setRoundBottomRight(50);
        PanelScoreRula.setRoundTopLeft(50);
        PanelScoreRula.setRoundTopRight(50);
        PanelScoreRula.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelScore.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelScore.setForeground(new java.awt.Color(255, 255, 255));
        LabelScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelScore.setText("Skor RULA: 5");
        PanelScoreRula.add(LabelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 480, -1));

        LabelLevel.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        LabelLevel.setForeground(new java.awt.Color(255, 255, 255));
        LabelLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLevel.setText("Tingkat tindakan: 3");
        PanelScoreRula.add(LabelLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 480, 30));

        LabelKeterangan.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        LabelKeterangan.setForeground(new java.awt.Color(255, 255, 255));
        LabelKeterangan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelKeterangan.setText("Investigasi lebih lanjut dan perubahan diperlukan segera");
        PanelScoreRula.add(LabelKeterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 480, -1));

        jPanel1.add(PanelScoreRula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 480, 270));

        Artboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/Artboard 1.png"))); // NOI18N
        Artboard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(Artboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 1010, 3010));

        PanelDetailProfile.setBackground(new java.awt.Color(255, 255, 255));
        PanelDetailProfile.setRoundBottomLeft(50);
        PanelDetailProfile.setRoundBottomRight(50);
        PanelDetailProfile.setRoundTopLeft(50);
        PanelDetailProfile.setRoundTopRight(50);
        PanelDetailProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelDetailPribadi.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelDetailPribadi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDetailPribadi.setText("Detail pribadi");
        PanelDetailProfile.add(LabelDetailPribadi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, -1));

        LabelNIM.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelNIM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelNIM.setText("NIM");
        PanelDetailProfile.add(LabelNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, -1));

        LabelTitikNIM.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTitikNIM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTitikNIM.setText(":");
        PanelDetailProfile.add(LabelTitikNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 50, 10, -1));

        LabelIsiNIM.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelIsiNIM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelIsiNIM.setText("123123123123123");
        PanelDetailProfile.add(LabelIsiNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 270, -1));

        LabelNama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelNama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelNama.setText("Nama");
        PanelDetailProfile.add(LabelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, -1));

        LabelTitikNama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTitikNama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTitikNama.setText(":");
        PanelDetailProfile.add(LabelTitikNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 10, -1));

        LabelIsiNama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelIsiNama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelIsiNama.setText("Muhammad Dila");
        PanelDetailProfile.add(LabelIsiNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 270, -1));

        LabelAlamat.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelAlamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelAlamat.setText("Alamat");
        PanelDetailProfile.add(LabelAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, -1));

        LabelTitikAlamat.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTitikAlamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTitikAlamat.setText(":");
        PanelDetailProfile.add(LabelTitikAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 10, -1));

        LabelIsiAlamat.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelIsiAlamat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelIsiAlamat.setText("Jl. Cempaka 1 No. 31233 Ra123123nk");
        PanelDetailProfile.add(LabelIsiAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 270, -1));

        LabelUmur.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelUmur.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelUmur.setText("Umur");
        PanelDetailProfile.add(LabelUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, -1));

        LabelTitikUmur.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTitikUmur.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTitikUmur.setText(":");
        PanelDetailProfile.add(LabelTitikUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 10, -1));

        LabelIsiUmur.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelIsiUmur.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelIsiUmur.setText("20");
        PanelDetailProfile.add(LabelIsiUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 270, -1));

        LabelPekerjaan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelPekerjaan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelPekerjaan.setText("Pekerjaan");
        PanelDetailProfile.add(LabelPekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 120, -1));

        LabelTitikPekerjaan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTitikPekerjaan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTitikPekerjaan.setText(":");
        PanelDetailProfile.add(LabelTitikPekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 10, -1));

        LabelIsiPekerjaan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelIsiPekerjaan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelIsiPekerjaan.setText("Mahasiswa");
        PanelDetailProfile.add(LabelIsiPekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 270, -1));

        LabelKelamin.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelKelamin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelKelamin.setText("Jenis Kelamin");
        PanelDetailProfile.add(LabelKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 120, -1));

        LabelTitikKelamin.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTitikKelamin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTitikKelamin.setText(":");
        PanelDetailProfile.add(LabelTitikKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 10, -1));

        LabelIsiKelamin.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelIsiKelamin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelIsiKelamin.setText("Laki-laki");
        PanelDetailProfile.add(LabelIsiKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 270, -1));

        LabelTelepon.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTelepon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTelepon.setText("No Telepon");
        PanelDetailProfile.add(LabelTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, -1));

        LabelTitikTelepon.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelTitikTelepon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTitikTelepon.setText(":");
        PanelDetailProfile.add(LabelTitikTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 10, -1));

        LabelIsiTelepon.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelIsiTelepon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelIsiTelepon.setText("123123123123123");
        PanelDetailProfile.add(LabelIsiTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 270, -1));

        jPanel1.add(PanelDetailProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 470, 270));

        PanelLangkah1.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah1.setRoundBottomLeft(50);
        PanelLangkah1.setRoundBottomRight(50);
        PanelLangkah1.setRoundTopLeft(50);
        PanelLangkah1.setRoundTopRight(50);
        PanelLangkah1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah1.setText("Langkah 1: Posisi Lengan Atas");
        PanelLangkah1.add(LabelLangkah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 480, -1));

        GambarLangka1.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarLangka1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarLangka1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/upperarm1.jpg"))); // NOI18N
        PanelLangkah1.add(GambarLangka1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 440, 220));

        LabelLangkah1a.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah1a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah1a.setText("Langkah 1a: Penyesuaian Posisi");
        PanelLangkah1.add(LabelLangkah1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 480, -1));

        CheckBox1Langkah1.setText("Bahu terangkat");
        CheckBox1Langkah1.setEnabled(false);
        CheckBox1Langkah1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah1.add(CheckBox1Langkah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        CheckBox2Langkah1.setText("Lengan atas diangkat (menjauh dari sisi tubuh)");
        CheckBox2Langkah1.setEnabled(false);
        CheckBox2Langkah1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah1.add(CheckBox2Langkah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        CheckBox3Langkah1.setText("Menyandarkan atau menopang berat lengan");
        CheckBox3Langkah1.setEnabled(false);
        CheckBox3Langkah1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah1.add(CheckBox3Langkah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jPanel1.add(PanelLangkah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 480, 490));

        PanelLangkah2.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah2.setRoundBottomLeft(50);
        PanelLangkah2.setRoundBottomRight(50);
        PanelLangkah2.setRoundTopLeft(50);
        PanelLangkah2.setRoundTopRight(50);
        PanelLangkah2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah2.setText("Langkah 2: Posisi Lengan Bawah");
        PanelLangkah2.add(LabelLangkah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, -1));

        GambarLangkah2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarLangkah2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarLangkah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/lowerarm1.jpg"))); // NOI18N
        PanelLangkah2.add(GambarLangkah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 220));

        LabelLangkah2a.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah2a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah2a.setText("Langkah 2a: Penyesuaian Posisi");
        PanelLangkah2.add(LabelLangkah2a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 470, -1));

        CheckBox1Langkah2.setText("Satu lengan bekerja di garis tengah / keluar sisi tubuh");
        CheckBox1Langkah2.setEnabled(false);
        CheckBox1Langkah2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah2.add(CheckBox1Langkah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 300, 400, -1));

        GambarCheckBoxLangkah2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarCheckBoxLangkah2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarCheckBoxLangkah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/lowerarm4.jpg"))); // NOI18N
        GambarCheckBoxLangkah2.setEnabled(false);
        PanelLangkah2.add(GambarCheckBoxLangkah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 450, 150));

        jPanel1.add(PanelLangkah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 470, 490));

        PanelLangkah3.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah3.setRoundBottomLeft(50);
        PanelLangkah3.setRoundBottomRight(50);
        PanelLangkah3.setRoundTopLeft(50);
        PanelLangkah3.setRoundTopRight(50);
        PanelLangkah3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah3.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah3.setText("Langkah 3: Posisi Pergelangan Tangan");
        PanelLangkah3.add(LabelLangkah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, -1));

        GambarLangkah3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarLangkah3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarLangkah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist1.jpg"))); // NOI18N
        PanelLangkah3.add(GambarLangkah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 170));

        LabelLangkah3a.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah3a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah3a.setText("Langkah 3a: Penyesuaian Posisi");
        PanelLangkah3.add(LabelLangkah3a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 470, -1));

        CheckBoxLangkah3.setText("pergelangan tangan ditekuk menjauh dari garis tengah");
        CheckBoxLangkah3.setEnabled(false);
        CheckBoxLangkah3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah3.add(CheckBoxLangkah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 410, -1));

        GambarCheckBoxLangkah3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarCheckBoxLangkah3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarCheckBoxLangkah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist5.jpg"))); // NOI18N
        GambarCheckBoxLangkah3.setEnabled(false);
        PanelLangkah3.add(GambarCheckBoxLangkah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 450, 200));

        jPanel1.add(PanelLangkah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 940, 480, 490));

        PanelLangkah4.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah4.setRoundBottomLeft(50);
        PanelLangkah4.setRoundBottomRight(50);
        PanelLangkah4.setRoundTopLeft(50);
        PanelLangkah4.setRoundTopRight(50);
        PanelLangkah4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah4.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah4.setText("Langkah 4: Posisi Putar Pergelangan Tangan");
        PanelLangkah4.add(LabelLangkah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 470, -1));

        GambarLangkah4.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarLangkah4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarLangkah4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/wrist_twist1.jpg"))); // NOI18N
        PanelLangkah4.add(GambarLangkah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 450, 220));

        jPanel1.add(PanelLangkah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 940, 470, 490));

        PanelLangkah5.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah5.setRoundBottomLeft(50);
        PanelLangkah5.setRoundBottomRight(50);
        PanelLangkah5.setRoundTopLeft(50);
        PanelLangkah5.setRoundTopRight(50);
        PanelLangkah5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah5.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah5.setText("Langkah 5: Beban Yang Mencerminkan Situasi");
        PanelLangkah5.add(LabelLangkah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 480, -1));

        GambarBorderLangkah5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/WidgetCornerMuscle.png"))); // NOI18N
        GambarBorderLangkah5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        PanelLangkah5.add(GambarBorderLangkah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 400, 80));

        LabelScoreLangkah5.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelScoreLangkah5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelScoreLangkah5.setText("Score 0");
        LabelScoreLangkah5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelLangkah5.add(LabelScoreLangkah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 390, 20));

        LabelKetScoreLangkah5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelKetScoreLangkah5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelKetScoreLangkah5.setText("Jika beban < 2 kg (terputus-putus)");
        LabelKetScoreLangkah5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelLangkah5.add(LabelKetScoreLangkah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 390, -1));

        LabelLangkah5a.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah5a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah5a.setText("Langkah 5a: Penyesuaian Beban");
        PanelLangkah5.add(LabelLangkah5a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 480, -1));

        ChecKBoxLangkah5.setText("Jika postur tubuh sebagian besar statis (yaitu ditahan ");
        ChecKBoxLangkah5.setEnabled(false);
        ChecKBoxLangkah5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah5.add(ChecKBoxLangkah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 410, -1));

        LabelKetCheckBoxLangkah5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelKetCheckBoxLangkah5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelKetCheckBoxLangkah5.setText(">10 menit) Jika beban < 2 kg (terputus-putus)");
        LabelKetCheckBoxLangkah5.setEnabled(false);
        LabelKetCheckBoxLangkah5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelLangkah5.add(LabelKetCheckBoxLangkah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 390, 30));

        jPanel1.add(PanelLangkah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1450, 480, 490));

        PanelLangkah6.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah6.setRoundBottomLeft(50);
        PanelLangkah6.setRoundBottomRight(50);
        PanelLangkah6.setRoundTopLeft(50);
        PanelLangkah6.setRoundTopRight(50);
        PanelLangkah6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah6.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah6.setText("Langkah 6: Posisi Leher");
        PanelLangkah6.add(LabelLangkah6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, -1));

        GambarLangkah6.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarLangkah6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarLangkah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/neck1.jpg"))); // NOI18N
        PanelLangkah6.add(GambarLangkah6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 220));

        LabelLangkah6a.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah6a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah6a.setText("Langkah 6a: Penyesuaian Posisi");
        PanelLangkah6.add(LabelLangkah6a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 470, -1));

        CheckBoxLangkah6.setText("Jika leher terpelintir");
        CheckBoxLangkah6.setEnabled(false);
        CheckBoxLangkah6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        CheckBoxLangkah6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PanelLangkah6.add(CheckBoxLangkah6, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 300, 160, -1));

        GambarCheckBoxLangkah6.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarCheckBoxLangkah6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarCheckBoxLangkah6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/neck5.jpg"))); // NOI18N
        GambarCheckBoxLangkah6.setEnabled(false);
        PanelLangkah6.add(GambarCheckBoxLangkah6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 200, 150));

        jPanel1.add(PanelLangkah6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 1450, 470, 490));

        PanelLangkah7.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah7.setRoundBottomLeft(50);
        PanelLangkah7.setRoundBottomRight(50);
        PanelLangkah7.setRoundTopLeft(50);
        PanelLangkah7.setRoundTopRight(50);
        PanelLangkah7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah7.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah7.setText("Langkah 7: Posisi Batang Tubuh");
        PanelLangkah7.add(LabelLangkah7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, -1));

        GambarLangkah7.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarLangkah7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarLangkah7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/neck1.jpg"))); // NOI18N
        PanelLangkah7.add(GambarLangkah7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 220));

        LabelLangkah7a.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah7a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah7a.setText("Langkah 7a: Penyesuaian Posisi");
        PanelLangkah7.add(LabelLangkah7a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 470, -1));

        CheckBoxLangkah7.setText("Jika batang terpelintir");
        CheckBoxLangkah7.setEnabled(false);
        CheckBoxLangkah7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah7.add(CheckBoxLangkah7, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 300, -1, -1));

        GambarCheckBoxLangkah7.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarCheckBoxLangkah7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarCheckBoxLangkah7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/trunk5.jpg"))); // NOI18N
        GambarCheckBoxLangkah7.setEnabled(false);
        PanelLangkah7.add(GambarCheckBoxLangkah7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 200, 150));

        jPanel1.add(PanelLangkah7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1960, 480, 490));

        PanelLangkah8.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah8.setRoundBottomLeft(50);
        PanelLangkah8.setRoundBottomRight(50);
        PanelLangkah8.setRoundTopLeft(50);
        PanelLangkah8.setRoundTopRight(50);
        PanelLangkah8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah8.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah8.setText("Langkah 8: Posisi Kaki");
        PanelLangkah8.add(LabelLangkah8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 470, -1));

        GambarLangkah8.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        GambarLangkah8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GambarLangkah8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/legs1.jpg"))); // NOI18N
        PanelLangkah8.add(GambarLangkah8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 450, 220));

        jPanel1.add(PanelLangkah8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 1960, 470, 490));

        PanelLangkah9.setBackground(new java.awt.Color(255, 255, 255));
        PanelLangkah9.setRoundBottomLeft(50);
        PanelLangkah9.setRoundBottomRight(50);
        PanelLangkah9.setRoundTopLeft(50);
        PanelLangkah9.setRoundTopRight(50);
        PanelLangkah9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLangkah9.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah9.setText("Langkah 9: Beban Yang Mencerminkan Situasi");
        PanelLangkah9.add(LabelLangkah9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 480, -1));

        GambarBorderLangkah9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iamges_Early/WidgetCornerMuscle.png"))); // NOI18N
        GambarBorderLangkah9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        PanelLangkah9.add(GambarBorderLangkah9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 400, 80));

        LabelScoreLangkah9.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelScoreLangkah9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelScoreLangkah9.setText("Score 0");
        LabelScoreLangkah9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelLangkah9.add(LabelScoreLangkah9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 390, 20));

        LabelKetScoreLangkah9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelKetScoreLangkah9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelKetScoreLangkah9.setText("Jika beban < 2 kg (terputus-putus)");
        LabelKetScoreLangkah9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelLangkah9.add(LabelKetScoreLangkah9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 390, -1));

        LabelLangkah9a.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        LabelLangkah9a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLangkah9a.setText("Langkah 9a: Penyesuaian Beban");
        PanelLangkah9.add(LabelLangkah9a, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 480, -1));

        CheckBoxLangkah9.setText("Jika postur tubuh sebagian besar statis (yaitu ditahan ");
        CheckBoxLangkah9.setEnabled(false);
        CheckBoxLangkah9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        PanelLangkah9.add(CheckBoxLangkah9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 410, -1));

        LabelKetCheckBoxLangkah9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        LabelKetCheckBoxLangkah9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelKetCheckBoxLangkah9.setText(">10 menit) Jika beban < 2 kg (terputus-putus)");
        LabelKetCheckBoxLangkah9.setEnabled(false);
        LabelKetCheckBoxLangkah9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelLangkah9.add(LabelKetCheckBoxLangkah9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 390, 30));

        jPanel1.add(PanelLangkah9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 2470, 480, 490));

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
            .addComponent(ButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        PanelBackLayout.setVerticalGroup(
            PanelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(PanelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 3010, 110, -1));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 1040, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        PanelBack.setBackground(new java.awt.Color(40,167,69));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void ButtonBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseMoved
        // TODO add your handling code here:
        PanelBack.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonBackMouseMoved

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form10_Result_Early().setVisible(true);
    }//GEN-LAST:event_ButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(Form11_FullResult_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form11_FullResult_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form11_FullResult_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form11_FullResult_Early.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form11_FullResult_Early().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Artboard;
    private javax.swing.JButton ButtonBack;
    private GUI_Custom.JCheckBoxCustom ChecKBoxLangkah5;
    private GUI_Custom.JCheckBoxCustom CheckBox1Langkah1;
    private GUI_Custom.JCheckBoxCustom CheckBox1Langkah2;
    private GUI_Custom.JCheckBoxCustom CheckBox2Langkah1;
    private GUI_Custom.JCheckBoxCustom CheckBox3Langkah1;
    private GUI_Custom.JCheckBoxCustom CheckBoxLangkah3;
    private GUI_Custom.JCheckBoxCustom CheckBoxLangkah6;
    private GUI_Custom.JCheckBoxCustom CheckBoxLangkah7;
    private GUI_Custom.JCheckBoxCustom CheckBoxLangkah9;
    private javax.swing.JLabel GambarBorderLangkah5;
    private javax.swing.JLabel GambarBorderLangkah9;
    private javax.swing.JLabel GambarCheckBoxLangkah2;
    private javax.swing.JLabel GambarCheckBoxLangkah3;
    private javax.swing.JLabel GambarCheckBoxLangkah6;
    private javax.swing.JLabel GambarCheckBoxLangkah7;
    private javax.swing.JLabel GambarLangka1;
    private javax.swing.JLabel GambarLangkah2;
    private javax.swing.JLabel GambarLangkah3;
    private javax.swing.JLabel GambarLangkah4;
    private javax.swing.JLabel GambarLangkah6;
    private javax.swing.JLabel GambarLangkah7;
    private javax.swing.JLabel GambarLangkah8;
    private javax.swing.JLabel LabelAlamat;
    private javax.swing.JLabel LabelDetailPribadi;
    private javax.swing.JLabel LabelIsiAlamat;
    private javax.swing.JLabel LabelIsiKelamin;
    private javax.swing.JLabel LabelIsiNIM;
    private javax.swing.JLabel LabelIsiNama;
    private javax.swing.JLabel LabelIsiPekerjaan;
    private javax.swing.JLabel LabelIsiTelepon;
    private javax.swing.JLabel LabelIsiUmur;
    private javax.swing.JLabel LabelKelamin;
    private javax.swing.JLabel LabelKetCheckBoxLangkah5;
    private javax.swing.JLabel LabelKetCheckBoxLangkah9;
    private javax.swing.JLabel LabelKetScoreLangkah5;
    private javax.swing.JLabel LabelKetScoreLangkah9;
    private javax.swing.JLabel LabelKeterangan;
    private javax.swing.JLabel LabelLangkah1;
    private javax.swing.JLabel LabelLangkah1a;
    private javax.swing.JLabel LabelLangkah2;
    private javax.swing.JLabel LabelLangkah2a;
    private javax.swing.JLabel LabelLangkah3;
    private javax.swing.JLabel LabelLangkah3a;
    private javax.swing.JLabel LabelLangkah4;
    private javax.swing.JLabel LabelLangkah5;
    private javax.swing.JLabel LabelLangkah5a;
    private javax.swing.JLabel LabelLangkah6;
    private javax.swing.JLabel LabelLangkah6a;
    private javax.swing.JLabel LabelLangkah7;
    private javax.swing.JLabel LabelLangkah7a;
    private javax.swing.JLabel LabelLangkah8;
    private javax.swing.JLabel LabelLangkah9;
    private javax.swing.JLabel LabelLangkah9a;
    private javax.swing.JLabel LabelLevel;
    private javax.swing.JLabel LabelNIM;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JLabel LabelPekerjaan;
    private javax.swing.JLabel LabelRingkasanLengkap;
    private javax.swing.JLabel LabelRula;
    private javax.swing.JLabel LabelScore;
    private javax.swing.JLabel LabelScoreLangkah5;
    private javax.swing.JLabel LabelScoreLangkah9;
    private javax.swing.JLabel LabelTelepon;
    private javax.swing.JLabel LabelTitikAlamat;
    private javax.swing.JLabel LabelTitikKelamin;
    private javax.swing.JLabel LabelTitikNIM;
    private javax.swing.JLabel LabelTitikNama;
    private javax.swing.JLabel LabelTitikPekerjaan;
    private javax.swing.JLabel LabelTitikTelepon;
    private javax.swing.JLabel LabelTitikUmur;
    private javax.swing.JLabel LabelUmur;
    private GUI_Custom.PanelRound PanelBack;
    private GUI_Custom.PanelRound PanelDetailProfile;
    private GUI_Custom.PanelRound PanelLangkah1;
    private GUI_Custom.PanelRound PanelLangkah2;
    private GUI_Custom.PanelRound PanelLangkah3;
    private GUI_Custom.PanelRound PanelLangkah4;
    private GUI_Custom.PanelRound PanelLangkah5;
    private GUI_Custom.PanelRound PanelLangkah6;
    private GUI_Custom.PanelRound PanelLangkah7;
    private GUI_Custom.PanelRound PanelLangkah8;
    private GUI_Custom.PanelRound PanelLangkah9;
    private GUI_Custom.PanelRound PanelScoreRula;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
