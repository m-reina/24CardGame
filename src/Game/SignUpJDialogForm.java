
package Game;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* class: SignUpJDialogForm
* File: SignUpJDialogForm.java
* Description : Allows user to enter their information and
*               get a login ID
* Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
* Date : 02/27/2016
* @author Natasha Efendy
* @version 1.0.0
* History log:
* @see javax.swing.JFrame
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
*/ 
public class SignUpJDialogForm extends javax.swing.JDialog {
    String  fileName = "src/Data/players.txt";
    ArrayList<Player> players = new ArrayList<Player>();
    
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: creates the form, sets default button
     * Date: 02/27/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 

    public SignUpJDialogForm() {
        initComponents();
        
        getData(fileName);
        
        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/Graphics/icon.png"));
        
        //centers the form
         this.setLocationRelativeTo(null);
         
         
         //fires sign up button on default
        this.getRootPane().setDefaultButton(signupJButton);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        lastNameJLabel = new javax.swing.JLabel();
        lastnameJTextField = new javax.swing.JTextField();
        ageJLabel = new javax.swing.JLabel();
        ageJTextField = new javax.swing.JTextField();
        userJLabel = new javax.swing.JLabel();
        userJTextField = new javax.swing.JTextField();
        passwordJLabel = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        passwordConfirmJLabel = new javax.swing.JLabel();
        passwordConfirmJPasswordField = new javax.swing.JPasswordField();
        signupJButton = new javax.swing.JButton();
        titleJLabel = new javax.swing.JLabel();
        cancelJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Sign Up");

        fieldJPanel.setLayout(new java.awt.GridLayout(6, 2, 10, 10));

        nameJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nameJLabel.setText("First Name : ");
        fieldJPanel.add(nameJLabel);

        nameJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldJPanel.add(nameJTextField);

        lastNameJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lastNameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastNameJLabel.setText("Last Name : ");
        fieldJPanel.add(lastNameJLabel);

        lastnameJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldJPanel.add(lastnameJTextField);

        ageJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        ageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ageJLabel.setText("Age : ");
        fieldJPanel.add(ageJLabel);

        ageJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldJPanel.add(ageJTextField);

        userJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        userJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userJLabel.setText("Username : ");
        fieldJPanel.add(userJLabel);

        userJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldJPanel.add(userJTextField);

        passwordJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordJLabel.setText("Password : ");
        fieldJPanel.add(passwordJLabel);

        passwordJPasswordField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldJPanel.add(passwordJPasswordField);

        passwordConfirmJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordConfirmJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordConfirmJLabel.setText("Re-type Password :  ");
        fieldJPanel.add(passwordConfirmJLabel);

        passwordConfirmJPasswordField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        fieldJPanel.add(passwordConfirmJPasswordField);

        signupJButton.setBackground(new java.awt.Color(0, 0, 153));
        signupJButton.setForeground(new java.awt.Color(255, 255, 255));
        signupJButton.setText("Sign up");
        signupJButton.setToolTipText("Create new player");
        signupJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupJButtonActionPerformed(evt);
            }
        });

        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/signup.png"))); // NOI18N

        cancelJButton.setBackground(new java.awt.Color(0, 0, 153));
        cancelJButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelJButton.setText("Cancel");
        cancelJButton.setToolTipText("Cancel player creation");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleJLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(fieldJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(signupJButton)
                .addGap(40, 40, 40)
                .addComponent(cancelJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJLabel)
                .addGap(18, 18, 18)
                .addComponent(fieldJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupJButton)
                    .addComponent(cancelJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupJButtonActionPerformed
        try
        {
            String user = userJTextField.getText();
            char[] password = passwordJPasswordField.getPassword();
            char[] confirmation = passwordConfirmJPasswordField.getPassword();
            String myPassword = new String(password);
            String myConfirmation = new String(confirmation);
            String name = nameJTextField.getText();
            String last = lastnameJTextField.getText();
            int age = Integer.parseInt(ageJTextField.getText());

            String[] usernames = new String[players.size()];
            
            if(!players.isEmpty())
            {
            for(int i = 0; i < players.size();i++)
            {
                usernames[i] = players.get(i).getUsername();
            }

            int index = binarySearch(usernames,user);

            if(index == -1)
            {
                if(myPassword.equals(myConfirmation))
                {
                    if(myPassword.length() < 5 || age<0)
                    {
                        if(myPassword.length() < 5)
                        {
                            JOptionPane.showMessageDialog(null, "Password must be at least 5 characters long","Invalid password format",JOptionPane.WARNING_MESSAGE);
                        }

                        if(age <0)
                        {
                            JOptionPane.showMessageDialog(null, "Age must be greater than 0","Invalid age",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else
                    {
                        FileWriter fwriter = new FileWriter(fileName,true);
                        PrintWriter outputFile = new PrintWriter(fwriter);

                        outputFile.printf("\n"+user + "," +
                            myPassword + "," + name
                            + "," + last + "," +age  +"," + 0
                        );

                        outputFile.close();

                        JOptionPane.showMessageDialog(null, "Login data successfully created","Sign up success",JOptionPane.PLAIN_MESSAGE);

                        this.dispose();
                    }
                }
                else
                JOptionPane.showMessageDialog(null, "The password did not match","Password mismatch",JOptionPane.WARNING_MESSAGE);
            }
            else
            JOptionPane.showMessageDialog(null, "Username is already taken","Invalid username",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                FileWriter fwriter = new FileWriter(fileName,true);
                        PrintWriter outputFile = new PrintWriter(fwriter);

                        outputFile.printf(user + "," +
                            myPassword + "," + name
                            + "," + last + "," +age  +"," + 0
                        );

                        outputFile.close();

                        JOptionPane.showMessageDialog(null, "Login data successfully created","Sign up success",JOptionPane.PLAIN_MESSAGE);

                        this.dispose();
            }
                
        }
        catch(IOException exp)
        {
            exp.printStackTrace();
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

 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : binarySearch()
     * Description: search the player
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
         public int binarySearch(String[] myArray, String key)
        {
            int low = 0;
            int high = myArray.length-1;
            
            
            while(low <= high)
            {
              int middle = (low+high)/2;
              //if(key.compareToIgnoreCase(myArray[middle]) == 0)
              if(myArray[middle].toLowerCase().contains(key.toLowerCase()))
              {
                  return middle;
              }
              else if(key.compareToIgnoreCase(myArray[middle]) < 0)
              {
                  high = middle - 1; 
              }
              else 
              {
                  low = middle + 1;
              }
                  
            }
            return -1;
        }
         
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getData()
     * Description: get the data of new player and put into array
     * Date: 02/15/2016
     * Returns : none
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public void getData(String myFile)
    {

        try {

            FileReader freader = new FileReader(myFile);
            BufferedReader input = new BufferedReader(freader);
            String line = input.readLine();
            
            //seperate information by ","
            while (line != null) {
                Player aPlayer = new Player();
                StringTokenizer userToken = new StringTokenizer(line, ",");

                while (userToken.hasMoreElements()) {
                    aPlayer.setUsername(userToken.nextToken());
                    aPlayer.setPassword(userToken.nextToken());
                    aPlayer.setfirstName(userToken.nextToken());
                    aPlayer.setlastName(userToken.nextToken());
                    aPlayer.setAge(Integer.parseInt(userToken.nextToken()));
                    aPlayer.setScore(Integer.parseInt(userToken.nextToken()));
                }
   
                players.add(aPlayer);
                
                //read next line!
                line = input.readLine();
                
            }
            
            //always sort countries based on its score
            insertionSort(players);
            
            //close the input stream
            input.close();

        } catch (IOException exp) {
              
        }

    }
           
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : insertionSort()
     * Description: organize the array
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public void insertionSort(ArrayList<Player> list)
    {
        int i,j = 0;
        for( i = 0;i<list.size();i++)
        {
            Player temp = list.get(i);
            j = i - 1;
            while(j>=0 && list.get(j).getUsername().compareToIgnoreCase(temp.getUsername()) > 0)
            {
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,temp);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JTextField ageJTextField;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JPanel fieldJPanel;
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
    private javax.swing.JLabel userJLabel;
    private javax.swing.JTextField userJTextField;
    // End of variables declaration//GEN-END:variables
}
