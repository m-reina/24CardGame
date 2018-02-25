/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* class: RankingGUI
* File: Ranking.java
* Description : Displays top 3 players    
* Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
* Date : 02/27/2016
* @author Davian Lukman
* @version 1.0.0
* History log:
* @see javax.swing.JFrame
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
*/
public class RankingGUI extends javax.swing.JFrame {

    String myFile = "src/data/players.txt";
    ArrayList<Player> players = new ArrayList<Player>();
    final int HIGH_SCORE = 3;
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: creates the form, sets default button, and get 
     *              ranking
     * Date: 02/27/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    public RankingGUI() {
        initComponents();
        
        
        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/Graphics/icon.png"));
        
        //centers the form
        this.setLocationRelativeTo(null);
        
        //get the high score
        getHighScore();
        
        //display high score on text area
        displayHighScore();
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getHighScore()
     * Description: get players data
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    private void getHighScore()
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
            
            //sort players based on scores
            selectionSort(players);

            //close the input stream
            input.close();

        } catch (IOException exp) {
              
        }
    }
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : displayHighScore()
     * Description: performs selection sort on an ArrayList
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
     public void selectionSort(ArrayList<Player> list)
    {
       for ( int i =0 ; i < list.size() ; i++)
       {
           int max = findMaximum(list, i );
           swap(list, i , max);
       }
    }
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : findMaximum()
     * Description: find maximum value of an arraylist
     * Date: 02/27/2016
     * Returns : none
     * @param ArrayList<Player> list, int i
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public int findMaximum (ArrayList<Player> list, int i)
    {
        int j, max = i;
        for (j = i +1; j< list.size() ; j++)
        {
            if(list.get(j).getScore() > list.get(max).getScore())
            {
                max = j;
            }
        }
        return max;
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : swap()
     * Description: swap contains of 2 arrays
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public void swap (ArrayList<Player> list ,int i, int j)
    {
        Player temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : displayHighScore()
     * Description: displays top 3 players to the JTextArea
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    private void displayHighScore()
    {
        
        for(int i = 0;i<HIGH_SCORE && i<players.size();i++)
        {

            rankingJTextArea.append((i+1)+". " + players.get(i).getfirstName()+ 
                                   "(" + players.get(i).getUsername() + ")" + 
                                    "--" + players.get(i).getScore() + "pts" 
                                    + "\n" + "\n");
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        exitJButton = new javax.swing.JButton();
        scrollJScrollPane = new javax.swing.JScrollPane();
        rankingJTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("24 Card Game Leader Board");

        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/ranking.png"))); // NOI18N

        exitJButton.setBackground(new java.awt.Color(0, 0, 153));
        exitJButton.setForeground(new java.awt.Color(255, 255, 255));
        exitJButton.setText("Close");
        exitJButton.setToolTipText("Access account");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });

        rankingJTextArea.setEditable(false);
        rankingJTextArea.setColumns(20);
        rankingJTextArea.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        rankingJTextArea.setForeground(new java.awt.Color(0, 0, 153));
        rankingJTextArea.setLineWrap(true);
        rankingJTextArea.setRows(5);
        scrollJScrollPane.setViewportView(rankingJTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleJLabel)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(102, Short.MAX_VALUE)
                    .addComponent(scrollJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(98, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(exitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(96, Short.MAX_VALUE)
                    .addComponent(scrollJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(76, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitJButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RankingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RankingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RankingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RankingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RankingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitJButton;
    private javax.swing.JTextArea rankingJTextArea;
    private javax.swing.JScrollPane scrollJScrollPane;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
