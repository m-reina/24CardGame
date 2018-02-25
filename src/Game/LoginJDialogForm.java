
package Game;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * class: LoginJDialogForm
     * File: LoginJDialogForm.java
     * Description : display login form
     *                 
     * Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
     * Date : 02/27/2016
     * @author Natasha Efendy
     * @version 1.0.0
     * History log:
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 

public class LoginJDialogForm extends javax.swing.JDialog {
String fileName = "src/Data/players.txt";
private int index = 0;
ArrayList<Player> players = new ArrayList <Player>();
private boolean confirm = true;

   /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: creates the form, sets default button, icon
     * Centers the form
     * Date: 02/15/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */ 
    public LoginJDialogForm() {

        initComponents();

        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/Graphics/icon.png"));
        
        //centers the form
         this.setLocationRelativeTo(null);
         
         getData(fileName);
         
        //fires login JButton on default
        this.getRootPane().setDefaultButton(loginJButton);
        
        setModal(true);
    }

  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getData()
     * Description: get data into array countries
     * Date: 02/15/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
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
            
            //always sort countries based on its population
            insertionSort(players);
            
            //close the input stream
            input.close();

        } catch (IOException exp) {
              
        }

    }
     
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : insertionSort()
     * Description: alphabetize the array in ascending order
     * Date: 02/15/2016
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginJButton = new javax.swing.JButton();
        loginJPanel = new javax.swing.JPanel();
        userJLabel = new javax.swing.JLabel();
        userJTextField = new javax.swing.JTextField();
        passwordJLabel = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        titleJLabel = new javax.swing.JLabel();
        cancelJButton = new javax.swing.JButton();

        setTitle("User Login");

        loginJButton.setBackground(new java.awt.Color(0, 0, 153));
        loginJButton.setForeground(new java.awt.Color(255, 255, 255));
        loginJButton.setText("Login");
        loginJButton.setToolTipText("Access account");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        loginJPanel.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        userJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        userJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userJLabel.setText("Username : ");
        loginJPanel.add(userJLabel);

        userJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        loginJPanel.add(userJTextField);

        passwordJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwordJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordJLabel.setText("Password : ");
        loginJPanel.add(passwordJLabel);

        passwordJPasswordField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        loginJPanel.add(passwordJPasswordField);

        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/login.png"))); // NOI18N

        cancelJButton.setBackground(new java.awt.Color(0, 0, 153));
        cancelJButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelJButton.setText("Cancel");
        cancelJButton.setToolTipText("Cancel login");
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
                .addComponent(titleJLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(cancelJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        //check if login invalid
        
        String username = userJTextField.getText();

        
        if((username != null) && (username.length() > 0))
        {
            //Sort the username
            String[] userList = new String[players.size()];
            for(int i = 0;i<players.size();i++)
            {
                userList[i] = players.get(i).getUsername();
            }

    
            index = binarySearch(userList, username);
            
            if(index != -1)
            {
                char[] pass = passwordJPasswordField.getPassword();
                String password = new String(pass);
                
                if( players.get(index).getPassword().compareTo(password) == 0)
                {
                   this.dispose();
                   confirm = true;
                } 
                else
                    JOptionPane.showMessageDialog(null,"Incorrect password", "Password mismatch",JOptionPane.WARNING_MESSAGE);
            }         
            else
                JOptionPane.showMessageDialog(null, "Incorrect username","Unregistered User",JOptionPane.WARNING_MESSAGE);

        }
        else
            JOptionPane.showMessageDialog(null,"Please fill in all fields to login","Insufficient Login Data",JOptionPane.WARNING_MESSAGE);
   
        

    }//GEN-LAST:event_loginJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        confirm = false;
        this.dispose();
    }//GEN-LAST:event_cancelJButtonActionPerformed

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getCurrentUser()
     * Description: get the current user info
     * Date: 02/15/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public int getCurrentUser()
    {
        return index;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getPlayers()
     * Description: get the players
     * Date: 02/15/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : isConfirmed()
     * Description: check whether there is an existing player or not
     * Date: 02/15/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public boolean isConfirmed()
    {
        return confirm;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : binarySearch()
     * Description: search a player
     * Date: 02/15/2016
     * Returns : none
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
       public int binarySearch(String[] myPlayer, String key)
        {
            int low = 0;
            int high = myPlayer.length-1;
            
            
            while(low <= high)
            {
              int middle = (low+high)/2;
              //if(key.compareToIgnoreCase(myArray[middle]) == 0)
              if(myPlayer[middle].toLowerCase().contains(key.toLowerCase()))
              {
                  return middle;
              }
              else if(key.compareToIgnoreCase(myPlayer[middle]) < 0)
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
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJButton;
    private javax.swing.JButton loginJButton;
    private javax.swing.JPanel loginJPanel;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel userJLabel;
    private javax.swing.JTextField userJTextField;
    // End of variables declaration//GEN-END:variables
}
