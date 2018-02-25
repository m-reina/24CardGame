/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * class: EditJDialog
     * File: EditJDialog.java
     * Description : create a form to edit player info
     *                 
     * Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
     * Date : 02/27/2016
     * @author Davian Lukman
     * @version 1.0.0
     * History log:
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 

public class EditJDialogForm extends javax.swing.JDialog {
ArrayList<Player> players = new ArrayList<Player>();
int currentUser = 0;
final String fileName = "src/Data/players.txt";


      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: creates the form, sets default button, icon
     * Centers the form
     * Date: 02/27/2016
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */ 
    public EditJDialogForm(ArrayList<Player> players, int index) {
        
        initComponents();
        
        this.players = players;
        currentUser = index;
        
        //centers the form
        this.setLocationRelativeTo(null);
        
        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/Graphics/icon.png"));
        
        setModal(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        lastNameJLabel = new javax.swing.JLabel();
        lastnameJTextField = new javax.swing.JTextField();
        ageJLabel = new javax.swing.JLabel();
        ageJTextField = new javax.swing.JTextField();
        passwordJLabel = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        passwordConfirmJLabel = new javax.swing.JLabel();
        passwordConfirmJPasswordField = new javax.swing.JPasswordField();
        cancelJButton = new javax.swing.JButton();
        signupJButton = new javax.swing.JButton();
        titleJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit a User");

        editJPanel.setLayout(new java.awt.GridLayout(5, 2, 10, 10));

        nameJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameJLabel.setText("First Name : ");
        editJPanel.add(nameJLabel);

        nameJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJPanel.add(nameJTextField);

        lastNameJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lastNameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastNameJLabel.setText("Last Name : ");
        editJPanel.add(lastNameJLabel);

        lastnameJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJPanel.add(lastnameJTextField);

        ageJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ageJLabel.setText("Age : ");
        editJPanel.add(ageJLabel);

        ageJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJPanel.add(ageJTextField);

        passwordJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordJLabel.setText("Password : ");
        editJPanel.add(passwordJLabel);

        passwordJPasswordField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJPanel.add(passwordJPasswordField);

        passwordConfirmJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordConfirmJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordConfirmJLabel.setText("Re-type Password :  ");
        editJPanel.add(passwordConfirmJLabel);

        passwordConfirmJPasswordField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editJPanel.add(passwordConfirmJPasswordField);

        cancelJButton.setBackground(new java.awt.Color(0, 0, 153));
        cancelJButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        signupJButton.setBackground(new java.awt.Color(0, 0, 153));
        signupJButton.setForeground(new java.awt.Color(255, 255, 255));
        signupJButton.setText("Edit");
        signupJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupJButtonActionPerformed(evt);
            }
        });

        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/edit.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(signupJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(cancelJButton))
            .addComponent(titleJLabel)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(editJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJLabel)
                .addGap(41, 41, 41)
                .addComponent(editJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupJButton)
                    .addComponent(cancelJButton))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupJButtonActionPerformed
    try
    {
    String first = nameJTextField.getText();
    String last  = lastnameJTextField.getText();
    int age  =  Integer.parseInt(ageJTextField.getText());
    char[] password = passwordJPasswordField.getPassword();
    char[] confirmation = passwordConfirmJPasswordField.getPassword();
    String myPassword = new String(password);
    String myConfirmation = new String(confirmation);
    
    
    
    if(myPassword.equals(myConfirmation))
    {
    
        if(myPassword.length() < 5)
        {
            JOptionPane.showMessageDialog(null, "Password must be at least 5 characters long","Invalid password format",JOptionPane.WARNING_MESSAGE);
        }
        if(age <0)
        {
            JOptionPane.showMessageDialog(null, "Age must be greater than 0","Invalid age",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            
            players.get(currentUser).setfirstName(first);
            players.get(currentUser).setlastName(last);
            players.get(currentUser).setAge(age);
            players.get(currentUser).setPassword(myPassword);
            overwriteData();
            this.dispose();
        }
   }
   else
        JOptionPane.showMessageDialog(null, "The password did not match","Password mismatch",JOptionPane.WARNING_MESSAGE);
   }
   
    catch(NumberFormatException e)
        {
           
            JOptionPane.showMessageDialog(null, "Please enter age in integer",
                    "Incorret Input",
                JOptionPane.ERROR_MESSAGE);
        }
    
    
    
  
    }//GEN-LAST:event_signupJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed
    
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : overwriteData()
     * Description: overwrite data with the newest version
     * Returns : none 
     * Date: 02/27/2016
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private void overwriteData()
    {
        try
        {
        FileWriter fw = new FileWriter(fileName);
        
        for(int i =0;i<players.size();i++)
        {
            String playerScore = Integer.toString(players.get(i).getScore());
            playerScore = playerScore.replaceAll("\\.0*$", ""); //remove trailing decimals
                fw.write( players.get(i).getUsername()+
                            ","+players.get(i).getPassword()+
                            ","+players.get(i).getfirstName()+
                            ","+players.get(i).getlastName() +
                            ","+players.get(i).getAge() +
                            ","+playerScore
                           );
            if( i != players.size()-1)
                fw.write("\n");
        }
        
        fw.close();
        }
        catch(IOException exp)
        {
        exp.printStackTrace();
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JTextField ageJTextField;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JPanel editJPanel;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JTextField lastnameJTextField;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel passwordConfirmJLabel;
    private javax.swing.JPasswordField passwordConfirmJPasswordField;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JButton signupJButton;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
