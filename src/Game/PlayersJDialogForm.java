
package Game;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* class: PlayersJDialogForm
* File: PlayersJDialogForm.java
* Description : Display player's information     
* Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
* Date : 02/27/2016
* @author Natasha Efendy
* @version 1.0.0
* History log:
* @see javax.swing.JFrame
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
*/ 
public class PlayersJDialogForm extends javax.swing.JDialog {
   ArrayList<Player> players =  new ArrayList<Player>();
   String fileName  = "src/Data/players.txt";
   int index = -1;
   private final String ADMIN_1 = "nefendy";
   private final String ADMIN_2 = "nculevski";

    public PlayersJDialogForm() {
 
        initComponents();
   
        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/Graphics/icon.png"));
        
        //get player data
        getData(fileName);
        
        //set the countries on the JList
        setList(players);
        
         //centers the form
         this.setLocationRelativeTo(null);
        
        //fires enter button on default
         this.getRootPane().setDefaultButton(searchJButton);
         
         setModal(true);
    }

      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : setList()
     * Description: set player's List
     * Date: 02/27/2016
     * Returns : none
     * @param ArrayList<Player> players
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    public void setList(ArrayList<Player> players)
    {
        String[] playerNames = new String[players.size()];
        
        for(int i =0;i<players.size();i++)
        {
            playerNames[i] = players.get(i).getUsername();
        }
        
        playersJList.setListData(playerNames);
    }

    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getData()
     * Description: get player data
     * Date: 02/27/2016
     * Returns : none
     * @param String myFile
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

        playersJPanel = new javax.swing.JPanel();
        playersJScrollPane = new javax.swing.JScrollPane();
        playersJList = new javax.swing.JList<>();
        deleteJButton = new javax.swing.JButton();
        infoJPanel = new javax.swing.JPanel();
        firstJLabel = new javax.swing.JLabel();
        firstJTextField = new javax.swing.JTextField();
        lastJLabel = new javax.swing.JLabel();
        lastJTextField = new javax.swing.JTextField();
        ageJLabel = new javax.swing.JLabel();
        ageJTextField = new javax.swing.JTextField();
        scoreJLabel = new javax.swing.JLabel();
        scoreJTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        searchJLabel = new javax.swing.JLabel();
        searchJTextField = new javax.swing.JTextField();
        searchJButton = new javax.swing.JButton();
        closeJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Players Database");

        playersJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Players", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 18))); // NOI18N

        playersJList.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        playersJList.setSelectionBackground(new java.awt.Color(0, 0, 102));
        playersJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playersJListValueChanged(evt);
            }
        });
        playersJScrollPane.setViewportView(playersJList);

        deleteJButton.setBackground(new java.awt.Color(0, 0, 102));
        deleteJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        deleteJButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteJButton.setText("Delete");
        deleteJButton.setToolTipText("Deleting a player will close the form");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout playersJPanelLayout = new javax.swing.GroupLayout(playersJPanel);
        playersJPanel.setLayout(playersJPanelLayout);
        playersJPanelLayout.setHorizontalGroup(
            playersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playersJPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(playersJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playersJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        playersJPanelLayout.setVerticalGroup(
            playersJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playersJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playersJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Player Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14))); // NOI18N
        infoJPanel.setLayout(new java.awt.GridLayout(4, 2, 10, 10));

        firstJLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        firstJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        firstJLabel.setText("First Name :");
        firstJLabel.setToolTipText("");
        infoJPanel.add(firstJLabel);

        firstJTextField.setEditable(false);
        firstJTextField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        infoJPanel.add(firstJTextField);

        lastJLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lastJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastJLabel.setText("Last Name : ");
        lastJLabel.setToolTipText("");
        infoJPanel.add(lastJLabel);

        lastJTextField.setEditable(false);
        lastJTextField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        infoJPanel.add(lastJTextField);

        ageJLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        ageJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ageJLabel.setText("Age :");
        ageJLabel.setToolTipText("");
        infoJPanel.add(ageJLabel);

        ageJTextField.setEditable(false);
        ageJTextField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        infoJPanel.add(ageJTextField);

        scoreJLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        scoreJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        scoreJLabel.setText("Best Score : ");
        scoreJLabel.setToolTipText("");
        infoJPanel.add(scoreJLabel);

        scoreJTextField.setEditable(false);
        scoreJTextField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        infoJPanel.add(scoreJTextField);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14))); // NOI18N

        searchJLabel.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        searchJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchJLabel.setText("<html>Enter the username of <br>a player to search<html>");

        searchJTextField.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        searchJButton.setBackground(new java.awt.Color(0, 0, 102));
        searchJButton.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        searchJButton.setForeground(new java.awt.Color(255, 255, 255));
        searchJButton.setText("Search");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(searchJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(searchJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(searchJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchJButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        closeJButton.setBackground(new java.awt.Color(0, 0, 102));
        closeJButton.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        closeJButton.setForeground(new java.awt.Color(255, 255, 255));
        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/players.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playersJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(infoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(playersJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
       this.dispose();
    }//GEN-LAST:event_closeJButtonActionPerformed

    private void playersJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playersJListValueChanged
        int index = playersJList.getSelectedIndex();
        
        if(index != -1)
        {
            firstJTextField.setText(players.get(index).getfirstName());
            lastJTextField.setText(players.get(index).getlastName());
            ageJTextField.setText(Integer.toString(players.get(index).getAge()));
            scoreJTextField.setText(Integer.toString(players.get(index).getScore()));
        }
    }//GEN-LAST:event_playersJListValueChanged

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed
       String key = searchJTextField.getText();
       searchPlayers(key);
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        LoginJDialogForm myLogin = new LoginJDialogForm();
        myLogin.setVisible(true);
        int index = myLogin.getCurrentUser();
        
        if(players.get(index).getUsername().compareTo(ADMIN_1) == 0  || players.get(index).getUsername().compareTo(ADMIN_2) ==0 )
        {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this player?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION)
            {
                index = playersJList.getSelectedIndex();
                removePlayer(index);
                this.dispose();
            }
            else if (response == JOptionPane.CLOSED_OPTION);
            else if(response == JOptionPane.NO_OPTION);
        }
        else
        JOptionPane.showMessageDialog(null, "Only administrators can delete players","Insufficient Permission",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_deleteJButtonActionPerformed
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : searchPlayers()
     * Description: search for players
     * Date: 02/27/2016
     * Returns : none
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    public void searchPlayers (String keyPlayer)
    {
        if((keyPlayer != null) && (keyPlayer.length() > 0))
        {

            String[] usernames = new String[players.size()];
            for(int i = 0;i<players.size();i++)
            {
                usernames[i] = players.get(i).getUsername();
            }
            
            //call binary search
            int index = binarySearch(usernames, keyPlayer);
            if(index == -1)
            {
                //not found
                JOptionPane.showMessageDialog(null,
                                             keyPlayer + " Not found" ,
                                             "Search Result",
                                             JOptionPane.INFORMATION_MESSAGE
                                             );
            }
            
            else
            {
                playersJList.setSelectedIndex(index);
            }
        }
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : binarySearch()
     * Description: search for players
     * Date: 02/27/2016
     * Returns : none
     * @param none
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
     * Method : removePlayer()
     * Description: remove a player from the database
     * Date: 02/27/2016
     * Returns : none
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    public void removePlayer(int num)
    {
        String currentLine="";
        String totalString="";
        String score = Double.toString(players.get(num).getScore());
        score = score.replaceAll("\\.0*$", ""); //remove trailing decimals
        
  
        //set the employee line that is going to be removed
        String deletedLine = players.get(num).getUsername()+
                            ","+players.get(num).getPassword()+
                            ","+players.get(num).getfirstName()+
                            ","+players.get(num).getlastName() +
                            ","+players.get(num).getAge() +
                            ","+score
                            ;
                            
        
        
         try
        {
            
        FileReader freader = new FileReader (fileName);
        BufferedReader input = new BufferedReader (freader);

        
       for(int i = 0;i<players.size();i++)
        {
            String playerScore = Integer.toString(players.get(i).getScore());
            playerScore = playerScore.replaceAll("\\.0*$", ""); //remove trailing decimals
            totalString += players.get(i).getUsername()+
                            ","+players.get(i).getPassword()+
                            ","+players.get(i).getfirstName()+
                            ","+players.get(i).getlastName() +
                            ","+players.get(i).getAge() +
                            ","+playerScore+ "\n"
                            ;

        }
        
        //remove white spaces, tabs, and other unwated characters
        totalString = totalString.replaceAll(deletedLine, "");
        totalString = totalString.replaceAll("(?m)^[ \t]*\r?\n", "");
        totalString = totalString.trim();
        
        //overwrite the data file
        FileWriter fw = new FileWriter(fileName,false);
        fw.write(totalString);
        fw.close();
        
        //reset the variables and form
        

       
        }
       catch(IOException exp)
       {
       exp.printStackTrace();
       }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JTextField ageJTextField;
    private javax.swing.JButton closeJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JLabel firstJLabel;
    private javax.swing.JTextField firstJTextField;
    private javax.swing.JPanel infoJPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lastJLabel;
    private javax.swing.JTextField lastJTextField;
    private javax.swing.JList<String> playersJList;
    private javax.swing.JPanel playersJPanel;
    private javax.swing.JScrollPane playersJScrollPane;
    private javax.swing.JLabel scoreJLabel;
    private javax.swing.JTextField scoreJTextField;
    private javax.swing.JButton searchJButton;
    private javax.swing.JLabel searchJLabel;
    private javax.swing.JTextField searchJTextField;
    // End of variables declaration//GEN-END:variables
}
