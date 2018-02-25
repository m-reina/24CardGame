
package Game;

import java.awt.Toolkit;

 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* class: AboutGUI
* File: AboutGUI.java
* Description : Display the about information     
* Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
* Date : 03/05/2016
* @author Natasha Efendy
* @version 1.0.0
* History log:
* @see javax.swing.JFrame
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
*/ 
public class AboutGUI extends javax.swing.JFrame {

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: creates the form, sets default button, and get 
     *                initial set of cards
     * Date: 03/05/2016
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    public AboutGUI() {
        initComponents();
        
        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/Graphics/icon.png"));
        
        //centers the form
         this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();
        detailJPanel = new javax.swing.JPanel();
        emailJLabel = new javax.swing.JLabel();
        productverJLabel = new javax.swing.JLabel();
        copyrightJLabel = new javax.swing.JLabel();
        aboutJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("About 24 Card Game");

        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/about.png"))); // NOI18N

        closeJButton.setBackground(new java.awt.Color(0, 0, 153));
        closeJButton.setForeground(new java.awt.Color(255, 255, 255));
        closeJButton.setText("Close");
        closeJButton.setToolTipText("Access account");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        detailJPanel.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        emailJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        emailJLabel.setText("<html>Contact : N.EFENDY3364@edmail.edcc.edu<br> Natasha Efendy</html>");
        detailJPanel.add(emailJLabel);

        productverJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        productverJLabel.setText("Product version : 1.1");
        detailJPanel.add(productverJLabel);

        copyrightJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        copyrightJLabel.setText("Copyright : Free");
        detailJPanel.add(copyrightJLabel);

        aboutJLabel.setText("<html>\nA program that lets user play the 24 card game. Features includes :<br>\n1. 24 Card Game (timed version)<br>\n2. User data management<br>\n3. Leader Board<br>\n<br>\nIn order to play and get score recorder, player must login<br>\nInstructions on how to play the game can be found on Help > How to Play\n</html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleJLabel)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(detailJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(aboutJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detailJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeJButtonActionPerformed


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
            java.util.logging.Logger.getLogger(AboutGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutJLabel;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel;
    private javax.swing.JPanel detailJPanel;
    private javax.swing.JLabel emailJLabel;
    private javax.swing.JLabel productverJLabel;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
