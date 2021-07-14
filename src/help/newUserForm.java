
package help;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author R-Walid Pro_Book
 */
public class newUserForm extends javax.swing.JFrame {

    /**
     * Creates new form newUserForm
     */
    public newUserForm() {
        this.setUndecorated(true);
        initComponents();
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namenv = new javax.swing.JTextField();
        passwordnv1 = new javax.swing.JPasswordField();
        passwordnv2 = new javax.swing.JPasswordField();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(409, 263));
        setMinimumSize(new java.awt.Dimension(409, 263));
        setPreferredSize(new java.awt.Dimension(409, 263));
        setResizable(false);
        setSize(new java.awt.Dimension(409, 263));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("نـرحــــب بـك كـعضـو جـديــــد");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 0, 300, 62);

        jLabel5.setFont(new java.awt.Font("Arabic Typesetting", 1, 27)); // NOI18N
        jLabel5.setText("اسم المستــخـــــدم :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(250, 80, 130, 33);

        jLabel7.setFont(new java.awt.Font("Arabic Typesetting", 1, 27)); // NOI18N
        jLabel7.setText("تأكيد كلمــــة المرور :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(250, 160, 130, 33);

        jLabel8.setFont(new java.awt.Font("Arabic Typesetting", 1, 27)); // NOI18N
        jLabel8.setText("كلــمــــــة المــــرور :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(250, 120, 130, 33);

        namenv.setBackground(new java.awt.Color(255, 255, 153));
        namenv.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(namenv);
        namenv.setBounds(40, 80, 210, 30);

        passwordnv1.setBackground(new java.awt.Color(255, 255, 153));
        getContentPane().add(passwordnv1);
        passwordnv1.setBounds(40, 120, 210, 31);

        passwordnv2.setBackground(new java.awt.Color(255, 255, 153));
        getContentPane().add(passwordnv2);
        passwordnv2.setBounds(40, 160, 210, 31);

        confirmBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(0, 0, 255));
        confirmBtn.setText("تـــــم");
        confirmBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 51), new java.awt.Color(0, 255, 255), new java.awt.Color(51, 255, 51), new java.awt.Color(0, 255, 255)));
        confirmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        getContentPane().add(confirmBtn);
        confirmBtn.setBounds(40, 200, 70, 30);

        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(0, 0, 255));
        cancelBtn.setText("رجـــوع");
        cancelBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 204), new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 255)));
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelBtn);
        cancelBtn.setBounds(180, 200, 70, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/help/signIn.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 410, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        if (!(namenv.getText().equals("")) && !(passwordnv1.getText().equals(""))) {
            if ((passwordnv1.getText().length() >= 4) && (passwordnv1.getText().length() <= 20)) {
                if (passwordnv1.getText().equals(passwordnv2.getText())) {
                    if ((db.isExistBefore(namenv.getText(), passwordnv1.getText())) == false) {
                        System.out.println("icicicicic");
                        if (db.addUser(passwordnv1.getText(), namenv.getText())) {
                            this.dispose();
                            new formulation().setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "جرب إسم مستخدم آخر (لم يستعمل بعد)");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "كلمتي السر غير متطابقتين");
                }
            } else {
                JOptionPane.showMessageDialog(null, "أدخل كلمة مرور تتكون من 4 إلى 20 رمز");
            }
        } else {
            JOptionPane.showMessageDialog(null, "لا بد من ملء الخانات الثلاثة للمتابعة");
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new loginWindow().setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(newUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField namenv;
    private javax.swing.JPasswordField passwordnv1;
    private javax.swing.JPasswordField passwordnv2;
    // End of variables declaration//GEN-END:variables
}
