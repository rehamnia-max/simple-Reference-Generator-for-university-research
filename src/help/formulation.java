/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.awt.Desktop;
import static java.awt.Desktop.getDesktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author R-Walid Pro_Book
 */
public class formulation extends javax.swing.JFrame {
    
    private static String nomAuteur;
    public static String prenomAuteur;
    public static String titreAuvrage;
    public static String edition;
    public static String lienEdition;
    public static String editeurCommercial;
    public static String annnePublication;
    public static String[] nbrPage = new String[2];
    public static String titreCollection;
    public static String nbrCollection;
    public static String isbn;
    public static String nomAuteur2;
    public static String prenomAuteur2;
    public static String titreChamp;
    public static String nomOrganisme;
    public static String url;
    private String typeTitle;
    private int nbrOfInputData;
    
    private void initAttributes() {
        nomAuteur = "";
        prenomAuteur = "";
        titreAuvrage = "";
        edition = "";
        lienEdition = "";
        editeurCommercial = "";
        annnePublication = "";
        nbrPage[0] = "";
        nbrPage[1] = "";
        titreCollection = "";
        nbrCollection = "";
        isbn = "";
        nomAuteur2 = "";
        prenomAuteur2 = "";
        titreChamp = "";
        nomOrganisme = "";
        url = "";
        typeTitle = "";
        nbrOfInputData = 0;
    }
    
    private void initField() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        t13.setText("");
        t14.setText("");
        t15.setText("");
        t16.setText("");
        t17.setText("");
        t18.setText("");
        t19.setText("");
        t20.setText("");
        referenceTextArea.setText("");
    }
    
    private String upperCaseFirstChar(String str) {
        char charU = str.toUpperCase().charAt(0);
        char[] strL = str.toLowerCase().toCharArray();
        str = charU + "";
        for (int i = 1; i < strL.length; i++) {
            str += strL[i];
        }
        return str;
    }
    
    private void checkFile() {
        File f = new File("C:\\Created Account");
        if (f.exists() == false) {
            f.mkdir();
        }
    }
    
    private void modifyAndStroreContent() {
        int i = 0;
        if (t1.getText().equals("") == false) {
            nomAuteur = t1.getText().toUpperCase() + ", ";
            i++;
        }
        if (!t2.getText().equals("")) {
            prenomAuteur = upperCaseFirstChar(t2.getText()) + ". ";
            i++;
        }
        if (!t3.getText().equals("")) {
            titreAuvrage = upperCaseFirstChar(t3.getText()) + ". ";
            i++;
        }
        if (!t4.getText().equals("")) {
            edition = upperCaseFirstChar(t4.getText()) + ". ";
            i++;
        }
        if (!t5.getText().equals("")) {
            lienEdition = upperCaseFirstChar(t5.getText()) + " : ";
            i++;
        }
        if (!t6.getText().equals("")) {
            editeurCommercial = upperCaseFirstChar(t6.getText()) + ", ";
            i++;
        }
        if (!t7.getText().equals("")) {
            annnePublication = upperCaseFirstChar(t7.getText()) + ", ";
            i++;
        }
        if ((((t8.getText()).equals("")) == false) && (!((t9.getText()).equals("")))) {
            nbrPage[0] = "P. " + t8.getText() + "-";
            nbrPage[1] = t9.getText() + ". ";
            i += 2;
        } else if (!t8.getText().equals("")) {
            nbrPage[0] = "P. " + t8.getText() + ". ";
            i++;
        }
        if (!t10.getText().equals("")) {
            titreCollection = upperCaseFirstChar(t10.getText()) + ", ";
            i++;
        }
        if (!t11.getText().equals("")) {
            nbrCollection = upperCaseFirstChar(t11.getText()) + ". ";
            i++;
        }
        if (!t12.getText().equals("")) {
            isbn = "(" + upperCaseFirstChar(t12.getText()) + ")";
            i++;
        }
        if (!t13.getText().equals("")) {
            nomAuteur2 = t13.getText().toUpperCase() + ", ";
            i++;
        }
        if (!t14.getText().equals("")) {
            prenomAuteur2 = upperCaseFirstChar(t14.getText()) + ". ";
            i++;
        }
        if (!t15.getText().equals("")) {
            titreChamp = upperCaseFirstChar(t15.getText()) + ". ";
            i++;
        }
        if (!t16.getText().equals("")) {
            nomOrganisme = upperCaseFirstChar(t16.getText()) + ". ";
            i++;
        }
        if ((!t17.getText().equals("")) && (!t18.getText().equals("")) && (!t19.getText().equals("")) && (!t20.getText().equals(""))) {
            url = "[en ligne]. disponible sur :<" + t17.getText() + "> (consulté le " + t18.getText() + "/" + t19.getText() + "/" + t20.getText() + ").";
            i += 4;
        }
        typeTitle = type.getSelectedItem().toString();
        nbrOfInputData = i;
    }
    
    
    private String getFinalReference(String type) {
        String str = "";
        switch (typeTitle) {
            case "Ouvrage (Livre)": {
                str = formulation.nomAuteur + formulation.prenomAuteur + formulation.nomAuteur2 + formulation.prenomAuteur2
                        + formulation.titreAuvrage + formulation.edition + formulation.lienEdition + formulation.editeurCommercial
                        + formulation.annnePublication + formulation.nbrPage[0] + formulation.nbrPage[1] + formulation.titreCollection + formulation.nbrCollection
                        + formulation.isbn;
            }
            break;
            case "Champ d'un (Livre)": {
                str = formulation.nomAuteur + formulation.prenomAuteur + formulation.nomAuteur2 + formulation.prenomAuteur2
                        + formulation.titreChamp
                        + formulation.titreAuvrage + formulation.edition + formulation.lienEdition + formulation.editeurCommercial
                        + formulation.annnePublication + formulation.nbrPage[0] + formulation.nbrPage[1] + formulation.titreCollection + formulation.nbrCollection
                        + formulation.isbn;
            }
            break;
            case "Thèse mémoire rapport": {
                str = formulation.nomAuteur + formulation.prenomAuteur + formulation.nomAuteur2 + formulation.prenomAuteur2
                        + formulation.titreAuvrage + "Thèse  de doctorant*Mémoire de Master Proffessionnel, "
                        + formulation.lienEdition + formulation.editeurCommercial + formulation.annnePublication + formulation.nbrPage[0] + formulation.nbrPage[1];
            }
            break;
            case "Site web": {
                str = formulation.nomAuteur + formulation.prenomAuteur + formulation.nomAuteur2 + formulation.prenomAuteur2
                        + formulation.nomOrganisme + formulation.titreAuvrage + formulation.url;
            }
            break;
        }//switch end
        return str;
    }
    
    @SuppressWarnings("empty-statement")
    
    
    public formulation() {
        initComponents();
        Image img;
        try {
            img = ImageIO.read(Help.class.getResource("3.png"));
            this.setIconImage(img);
        } catch (IOException ex) {
            Logger.getLogger(formulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setResizable(false);
        this.setTitle("وثيقة المعلومات");
        nbrPage[0] = "";
        nbrPage[1] = "";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        t12 = new javax.swing.JTextField();
        t13 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        t8 = new javax.swing.JTextField();
        t14 = new javax.swing.JTextField();
        t15 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t16 = new javax.swing.JTextField();
        t17 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        t10 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        t11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        t18 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        t19 = new javax.swing.JTextField();
        t20 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        t6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        referenceTextArea = new javax.swing.JTextArea();
        displayResult = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        copyBtn = new javax.swing.JButton();
        cancelBtn1 = new javax.swing.JButton();
        cancelBtn2 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(977, 540));
        setMinimumSize(new java.awt.Dimension(977, 540));
        setPreferredSize(new java.awt.Dimension(977, 540));
        setResizable(false);
        setSize(new java.awt.Dimension(977, 540));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Type de references :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 170, 30);

        t1.setBackground(new java.awt.Color(240, 240, 240));
        t1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t1.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t1);
        t1.setBounds(210, 60, 200, 28);

        t2.setBackground(new java.awt.Color(240, 240, 240));
        t2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t2.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t2);
        t2.setBounds(210, 100, 200, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Prénom (Auteur)  :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 150, 22);

        t3.setBackground(new java.awt.Color(240, 240, 240));
        t3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t3.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t3);
        t3.setBounds(210, 140, 200, 28);

        t5.setBackground(new java.awt.Color(240, 240, 240));
        t5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t5.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t5);
        t5.setBounds(210, 220, 200, 28);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Lieu d'édition : ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 220, 123, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Titre de l'ouvrage :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 140, 164, 22);

        t9.setBackground(new java.awt.Color(240, 240, 240));
        t9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t9.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t9);
        t9.setBounds(340, 370, 70, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("N° de la page :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 370, 120, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Année de publication :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 320, 177, 22);

        t12.setBackground(new java.awt.Color(240, 240, 240));
        t12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t12.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t12);
        t12.setBounds(710, 100, 200, 28);

        t13.setBackground(new java.awt.Color(240, 240, 240));
        t13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t13.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t13);
        t13.setBounds(710, 140, 200, 28);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Nom 2 (Auteur) :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(530, 140, 148, 22);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("ISBN facultatif :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(530, 100, 148, 22);

        t8.setBackground(new java.awt.Color(240, 240, 240));
        t8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t8.setForeground(new java.awt.Color(51, 102, 255));
        t8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t8ActionPerformed(evt);
            }
        });
        getContentPane().add(t8);
        t8.setBounds(230, 370, 60, 28);

        t14.setBackground(new java.awt.Color(240, 240, 240));
        t14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t14.setForeground(new java.awt.Color(51, 102, 255));
        t14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t14ActionPerformed(evt);
            }
        });
        getContentPane().add(t14);
        t14.setBounds(710, 180, 200, 28);

        t15.setBackground(new java.awt.Color(240, 240, 240));
        t15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t15.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t15);
        t15.setBounds(710, 220, 200, 28);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Titre de chapitre :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(530, 220, 141, 22);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Prénom 2 (Auteur) :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(530, 180, 160, 22);

        t16.setBackground(new java.awt.Color(240, 240, 240));
        t16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t16.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t16);
        t16.setBounds(710, 260, 200, 28);

        t17.setBackground(new java.awt.Color(240, 240, 240));
        t17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t17.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t17);
        t17.setBounds(710, 300, 200, 28);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("URL (le lien) :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(530, 300, 110, 22);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Nom de l'organisme :");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(530, 260, 169, 22);

        t10.setBackground(new java.awt.Color(240, 240, 240));
        t10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t10.setForeground(new java.awt.Color(51, 102, 255));
        t10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t10ActionPerformed(evt);
            }
        });
        getContentPane().add(t10);
        t10.setBounds(710, 20, 200, 28);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Titre de la collection :");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(530, 20, 171, 22);

        t11.setBackground(new java.awt.Color(240, 240, 240));
        t11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t11.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t11);
        t11.setBounds(710, 60, 200, 28);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("N° de la collection :");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(530, 60, 155, 22);

        t18.setBackground(new java.awt.Color(240, 240, 240));
        t18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t18.setForeground(new java.awt.Color(51, 102, 255));
        t18.setText("JJ");
        getContentPane().add(t18);
        t18.setBounds(710, 340, 37, 28);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Date consultation :");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(530, 340, 149, 22);

        t19.setBackground(new java.awt.Color(240, 240, 240));
        t19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t19.setForeground(new java.awt.Color(51, 102, 255));
        t19.setText("mm");
        t19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t19ActionPerformed(evt);
            }
        });
        getContentPane().add(t19);
        t19.setBounds(770, 340, 37, 28);

        t20.setBackground(new java.awt.Color(240, 240, 240));
        t20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t20.setForeground(new java.awt.Color(51, 102, 255));
        t20.setText("aaaa");
        t20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t20ActionPerformed(evt);
            }
        });
        getContentPane().add(t20);
        t20.setBounds(830, 340, 80, 28);

        t4.setBackground(new java.awt.Color(240, 240, 240));
        t4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t4.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t4);
        t4.setBounds(210, 180, 200, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Edition :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 170, 66, 22);

        t7.setBackground(new java.awt.Color(240, 240, 240));
        t7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t7.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t7);
        t7.setBounds(210, 320, 200, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Editeur commercial :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 270, 161, 22);

        t6.setBackground(new java.awt.Color(240, 240, 240));
        t6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t6.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(t6);
        t6.setBounds(210, 270, 200, 28);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("à");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(330, 370, 20, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("(Lieu de soutenance)");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(20, 240, 128, 17);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("(Thèse, mémoire, page web)");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(20, 190, 180, 17);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("(université de soutenance)");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(20, 290, 170, 17);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("(Année soutenance)");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(40, 340, 130, 20);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("de");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(210, 370, 20, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Nom (Auteur)  :");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(20, 60, 150, 22);

        type.setBackground(new java.awt.Color(255, 255, 153));
        type.setFont(new java.awt.Font("Arabic Typesetting", 3, 24)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ouvrage (Livre)", "Champ d'un (Livre)","Thèse mémoire rapport","Site web"}));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        getContentPane().add(type);
        type.setBounds(210, 20, 200, 30);

        referenceTextArea.setColumns(20);
        referenceTextArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        referenceTextArea.setRows(5);
        jScrollPane1.setViewportView(referenceTextArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(530, 380, 380, 60);

        displayResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        displayResult.setForeground(new java.awt.Color(0, 0, 255));
        displayResult.setText("معاينة");
        displayResult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 102), new java.awt.Color(0, 255, 255), new java.awt.Color(255, 0, 204), new java.awt.Color(0, 255, 255)));
        displayResult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        displayResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayResultActionPerformed(evt);
            }
        });
        getContentPane().add(displayResult);
        displayResult.setBounds(840, 440, 70, 30);

        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 0, 0));
        cancelBtn.setText("خــــــــروج");
        cancelBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 204), new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 255)));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn);
        cancelBtn.setBounds(410, 480, 120, 30);

        copyBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        copyBtn.setForeground(new java.awt.Color(0, 0, 255));
        copyBtn.setText("نسـخ");
        copyBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 51), new java.awt.Color(0, 255, 255), new java.awt.Color(51, 255, 51), new java.awt.Color(0, 255, 255)));
        copyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyBtnActionPerformed(evt);
            }
        });
        getContentPane().add(copyBtn);
        copyBtn.setBounds(530, 440, 70, 30);

        cancelBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtn1.setForeground(new java.awt.Color(0, 0, 255));
        cancelBtn1.setText("مسح المحتوى");
        cancelBtn1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 204), new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 255)));
        cancelBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cancelBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn1ActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn1);
        cancelBtn1.setBounds(280, 440, 130, 30);

        cancelBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtn2.setForeground(new java.awt.Color(0, 0, 255));
        cancelBtn2.setText("عرض السجل");
        cancelBtn2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 204), new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 255)));
        cancelBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn2.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cancelBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn2ActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn2);
        cancelBtn2.setBounds(20, 440, 130, 30);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/help/formulationBack.jpg"))); // NOI18N
        jLabel25.setText("jLabel25");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(0, 0, 970, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t10ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_formWindowOpened

    private void t8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t8ActionPerformed

    private void t14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t14ActionPerformed

    private void t20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t20ActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void displayResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayResultActionPerformed
        //Storing the data entered by the formulation in the static attributes
        initAttributes();
        modifyAndStroreContent();
        if (this.nbrOfInputData < 2) {
            JOptionPane.showMessageDialog(null, "يجب ملء المزيد من الخنات للمتابعة       ");
        } else {
            referenceTextArea.setText(getFinalReference(this.typeTitle));
        }
    }//GEN-LAST:event_displayResultActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void copyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyBtnActionPerformed
        //This part is using to copy the result to clipboard 
        try {
            StringSelection stringSelection = new StringSelection(this.referenceTextArea.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ملاحظة : حدث خطأ أثناء نسخ الناتج");
        }
        ///This part is to handle files/folders
        try {
            if (this.referenceTextArea.getText().equals("") == false) {
                checkFile();
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH-mm-ss");  
                 LocalDateTime now = LocalDateTime.now();  
                 System.out.println(dtf.format(now));  
                PrintWriter file = new PrintWriter("C:\\References History\\"+this.typeTitle+dtf.format(now)+ ".txt");
                file.println(this.referenceTextArea.getText());
                file.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(result.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "error in creating file !");
        }
    }//GEN-LAST:event_copyBtnActionPerformed

    private void cancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn1ActionPerformed
        // TODO add your handling code here:
        this.initField();
    }//GEN-LAST:event_cancelBtn1ActionPerformed

    private void t19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t19ActionPerformed

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed
        try {
            // TODO add your handling code here:
            checkFile();
            getDesktop().open(new File("C:\\Created Account"));
        } catch (IOException ex) {
            Logger.getLogger(formulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cancelBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(formulation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formulation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formulation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formulation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formulation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton cancelBtn1;
    private javax.swing.JButton cancelBtn2;
    private javax.swing.JButton copyBtn;
    private javax.swing.JButton displayResult;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea referenceTextArea;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t10;
    private javax.swing.JTextField t11;
    private javax.swing.JTextField t12;
    private javax.swing.JTextField t13;
    private javax.swing.JTextField t14;
    private javax.swing.JTextField t15;
    private javax.swing.JTextField t16;
    private javax.swing.JTextField t17;
    private javax.swing.JTextField t18;
    private javax.swing.JTextField t19;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t20;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t9;
    private javax.swing.JComboBox type;
    // End of variables declaration//GEN-END:variables
}
