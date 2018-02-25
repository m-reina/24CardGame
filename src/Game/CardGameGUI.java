/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* class: CardGameGUI
* File: CardGameGUI.java
* Description : Display game GUI and allow user to play as 
*                 many sets as they want and track their scores      
* Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
* Date : 02/27/2016
* @author Natasha Efendy
* @version 1.0.0
* History log:
* @see javax.swing.JFrame
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
*/ 
public class CardGameGUI extends javax.swing.JFrame
{

    //Global variables
    ArrayList<Player> players = new ArrayList<Player>();
    DeckOfCards myDeck = new DeckOfCards();
    private final int CARDS = 4;
    private final int POINT = 24;
    private final int MAX_SECONDS = 180;
    private int seconds = MAX_SECONDS;
    int score = 0;
    int currentPlayer = -1;
    private static final String OPERATORS = " +-*/%^!";
    private static final String FILE_NAME = "src/Data/players.txt";
    int[] currentCards = new int[CARDS];
    double[] operands = new double[CARDS];
    Timer timer =  new Timer();
    
     TimerTask task = new TimerTask() {
        @Override
        public void run() {
            seconds--;
            timerJTextField.setText(seconds + "");
            if (seconds == 0) {
                timer.cancel();
                timer.purge();
            }
        }
    };
    
    
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: creates the form, sets default button, and get 
     *                initial set of cards
     * Date: 01/27/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 

    public CardGameGUI() 
    {

        initComponents();
        
        //centers the form
        this.setLocationRelativeTo(null); 
        
        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/graphics/icon.png"));
                
        //fires submit button on default
        this.getRootPane().setDefaultButton(submitJButton);
        

 
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : startGame()
     * Description: Initialize game. Enables the submit button and start
     *              the timer.
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    private void startGame()
    {
        //shuffle initial cards
        shuffleCards();
        
        //enable the submit button
        submitJButton.setEnabled(true);
        
        //reset or start the timer
        resetTimer();
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : shuffleCards()
     * Description: get 4 cards from deck and display those cards
     * Date: 01/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    private void shuffleCards()
    {
       //obtain 4 cards from deck
       for(int i = 0 ; i< CARDS ; i++)
        currentCards[i] = myDeck.getCard();
       
        //put cards in respective slots
        firstJLabel.setIcon(new ImageIcon("src/Cards/" + currentCards[0]+".png"));
        secondJLabel.setIcon(new ImageIcon("src/Cards/" + currentCards[1]+".png"));
        thirdJLabel.setIcon(new ImageIcon("src/Cards/" + currentCards[2]+".png"));
        fourthJLabel.setIcon(new ImageIcon("src/Cards/" + currentCards[3]+".png"));
        
        //put back all the cards
        myDeck.resetDeck();
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : evaluateExpression()
     * Description: process operator and operands. Returns operator result
     * Date: 02/27/2016
     * Returns : int
     * @param String exp
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    public Double evaluateExpression(String exp) throws EmptyStackException,
               FullStackException
    {
        int  i = 0;
        GenericStack<Double> operandStack = new GenericStack<Double>();
        StringTokenizer tokens = new StringTokenizer(exp,OPERATORS,true);
        
        
        //scan tokens!
        while(tokens.hasMoreTokens())
        {
            String token = tokens.nextToken().trim();
            
            if(token.length() == 0)
                continue;
            else
                if(token.charAt(0) == '+' || token.charAt(0) == '-' ||
                    token.charAt(0) == '*' || token.charAt(0) == '/' ||
                    token.charAt(0) == '%' || token.charAt(0) =='^'
                     || token.charAt(0) =='!')
                {
                processAnOperator(token.charAt(0),operandStack);
            
                }
                else
                {
                    //it is in a operand, so push to the stack
                    operands[i] = new Double(token);
                    i++;
                    operandStack.push( new Double(token));
                }
                
  
        }
        if(compareArrays(operands,getCardRank()))
           return operandStack.pop();
        
        else
            JOptionPane.showMessageDialog(null, "Please only use the numbers "
                        + "provided by the cards.\nTo check rank equivalency "
                        + "guide please find the instructions "
                        + "in\nHelp > How to play","Invalid Numbers"
                        ,JOptionPane.WARNING_MESSAGE);
        return 0.0;
    }   
    
        
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getCardRank()
     * Description: returns an array that contains the current
     *                cards' rank
     * Returns : int[]
     * Date: 02/27/2016
     * @param none
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private double[] getCardRank()
    {
        double [] rank = new double[CARDS];
        
        for(int i = 0;i<CARDS;i++)
            rank[i] = myDeck.toNumber(currentCards[i]);
        
        return rank;
    }
    
        
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : compareArrays()
     * Description: compare two arrays
     * Returns : boolean
     * Date: 02/27/2016
     * @param int[] arr1, int[] arr2
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private boolean compareArrays(double[] arr1, double[] arr2)
    {
        boolean equal = true;
        selectionSort(arr1);
        selectionSort(arr2);
        
        for(int i = 0;i<CARDS;i++)
        {
            if(arr1[i]==arr2[i])
                equal = true;
            else
            {
                equal = false;
                break;
            }
        }
        
        return equal;
    }
    
     
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : selectionSort()
     * Description: sort an array
     * Returns : none
     * Date: 02/27/2016
     * @param int[] num
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */    
  private void selectionSort(double[] num)
    {
        int i, j, first;
        double temp; 
        for ( i = num.length - 1; i > 0; i -- ) 
        {
          first = 0;   
          for(j = 1; j <= i; j ++)  
          {
               if( num[ j ] < num[ first ] )         
                 first = j;
          }
          temp = num[ first ]; 
          num[ first ] = num[ i ];
          num[ i ] = temp; 
      }        
    }
  
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : processAnOperator()
     * Description: do mathematical calculation based on operators
     * Date: 02/27/2016
     * Returns : none
     * @param char op, GenericStack stack
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    public void processAnOperator(char op, GenericStack stack)throws 
                EmptyStackException,FullStackException
    {
        double op1 ,op2;
        if(op == '+')
        {
            op1 = (double)stack.pop();
            op2 = (double)stack.pop();
            
            stack.push(op1+op2);
        }
        else if ( op == '-')
        {
            op1 = (double)stack.pop();
            op2 = (double)stack.pop();
            
            stack.push(op2-op1);
        }
        else if (op == '*')
        {
            op1 = (double)stack.pop();
            op2 = (double)stack.pop();
            
            stack.push(op1*op2);
        }
         else if (op == '/')
        {
            op1 = (double)stack.pop();
            op2 = (double)stack.pop();
            
            stack.push(op2/op1);
        }
        else if (op == '^')
        {
            op1 = (double)stack.pop();
            op2 = (double)stack.pop();
            
            stack.push(Math.pow(op2, op1));
        }
        else if (op == '!')
        {
            op1 = (double)stack.pop();
            
            if(op1 <0 || op1-Math.floor(op1) != 0)
                JOptionPane.showMessageDialog(null, 
                        "Negative and decimal factorial is not supported",
                        "Invalid operation",JOptionPane.INFORMATION_MESSAGE);
            else
            {
            stack.push(factorial(op1));
            }
        }
        else
         {
            op1 = (double)stack.pop();
            op2 = (double)stack.pop();
            
            stack.push(op2%op1);
         }
    }   
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : swap()
     * Description: swap position of two cards
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */
         private void swap (int[] myArray ,int index, int n)
    {
        int temp = myArray[myArray.length - 1 - n];
        myArray[myArray.length - 1 - n] = myArray[index];
        myArray[index] = temp;
    }
         
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : checkExpression()
     * Description: evaluate expression and return the result
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */    
    private double checkExpression()
    {
        try
        {
            String expression = expressionJTextField.getText();
            String rpnExpression = new RPN().toRPN(expression);
            double result = evaluateExpression(rpnExpression);
            return result;

                
        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid "
                    + "expression with 4 numbers from 1-13,\nand the"
                    + " followinng operators :" 
                    + OPERATORS, "Invalid Expression",
                    JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : factorial()
     * Description: A recursive factorial method
     * Returns : int 
     * Date: 02/27/2016
     * @param int n
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private double factorial(double n)
    {
        double fact = 1.0;
        
        for(int i = 2;i <=n;i++)
            fact *= i;
        
        return fact;
	
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : resetTimer()
     * Description: reset current timer
     * Date: 02/27/2016
     * Returns : none
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    private void resetTimer()
    {
        task.cancel();
        task = new TimerTask() {
               @Override
                    public void run() {
                        seconds--;
                        timerJTextField.setText(seconds + "");
                        if (seconds == 0) {
                            timer.cancel();
                            timer.purge();
                            JOptionPane.showMessageDialog(null, "Time is Up!",
                                    "Out of time",
                                    JOptionPane.INFORMATION_MESSAGE);
                            shuffleCards();
                            resetTimer();
                         }
                    }
                };
    
             seconds = MAX_SECONDS;
             timerJTextField.setText(seconds+"");
             timer =  new Timer();
             timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : stopTimer()
     * Description: stops the current timer task
     * Date: 02/27/2016
     * Returns : none
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    private void stopTimer()
    {
                task.cancel();
        task = new TimerTask() {
               @Override
                    public void run() {
                        seconds--;
                        timerJTextField.setText(seconds + "");
                        if (seconds == 0) {
                            timer.cancel();
                            timer.purge();
                            JOptionPane.showMessageDialog(null, "Time is Up!",
                                    "Out of time",
                                    JOptionPane.INFORMATION_MESSAGE);
                            shuffleCards();
                            resetTimer();
                         }
                    }
                };
    }
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : saveScore()
     * Description: save player's score
     * Date: 02/27/2016
     * Returns : none
     * @param none
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    public void saveScore()
    {
        try
        {
        FileWriter fw = new FileWriter(FILE_NAME);
        
        for(int i =0;i<players.size();i++)
        {
            fw.write(players.get(i).getUsername()+
                            ","+players.get(i).getPassword()+
                            ","+players.get(i).getfirstName()+
                            ","+players.get(i).getlastName()+
                            ","+players.get(i).getAge()+
                             ","+players.get(i).getScore()
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardsJPanel = new javax.swing.JPanel();
        firstJLabel = new javax.swing.JLabel();
        secondJLabel = new javax.swing.JLabel();
        thirdJLabel = new javax.swing.JLabel();
        fourthJLabel = new javax.swing.JLabel();
        instructionJLabel = new javax.swing.JLabel();
        expressionJTextField = new javax.swing.JTextField();
        verifyJButton = new javax.swing.JButton();
        resultJLabel = new javax.swing.JLabel();
        totalJTextField = new javax.swing.JTextField();
        scoreJLabel = new javax.swing.JLabel();
        buttonsJPanel = new javax.swing.JPanel();
        submitJButton = new javax.swing.JButton();
        clearJButton = new javax.swing.JButton();
        shuffleJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        titleJLabel = new javax.swing.JLabel();
        timerJLabel = new javax.swing.JLabel();
        timerJTextField = new javax.swing.JTextField();
        currentPlayerJLabel = new javax.swing.JLabel();
        playerJLabel = new javax.swing.JLabel();
        saveJLabel = new javax.swing.JLabel();
        menuJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        seperator1JSeparator = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        gameJMenu = new javax.swing.JMenu();
        generateJMenuItem = new javax.swing.JMenuItem();
        validateJMenuItem = new javax.swing.JMenuItem();
        solutionJMenuItem = new javax.swing.JMenuItem();
        playerJMenu = new javax.swing.JMenu();
        signupJMenuItem = new javax.swing.JMenuItem();
        signinJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        infoJMenuItem = new javax.swing.JMenuItem();
        scoreJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();
        instructionsJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("24 Card Game");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(204, 204, 255));
        setResizable(false);

        cardsJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cards", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        cardsJPanel.setLayout(new java.awt.GridLayout(1, 4, 20, 10));

        firstJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cards/1.png"))); // NOI18N
        cardsJPanel.add(firstJLabel);

        secondJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cards/20.png"))); // NOI18N
        cardsJPanel.add(secondJLabel);

        thirdJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cards/42.png"))); // NOI18N
        cardsJPanel.add(thirdJLabel);

        fourthJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cards/28.png"))); // NOI18N
        cardsJPanel.add(fourthJLabel);

        instructionJLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        instructionJLabel.setForeground(new java.awt.Color(0, 0, 204));
        instructionJLabel.setText("Enter your expression :");

        expressionJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        expressionJTextField.setForeground(new java.awt.Color(0, 51, 204));
        expressionJTextField.setToolTipText("Enter a mathematical expression");

        verifyJButton.setBackground(new java.awt.Color(0, 0, 102));
        verifyJButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        verifyJButton.setForeground(new java.awt.Color(255, 255, 255));
        verifyJButton.setText("Verify");
        verifyJButton.setToolTipText("Validate expression");
        verifyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyJButtonActionPerformed(evt);
            }
        });

        resultJLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        resultJLabel.setForeground(new java.awt.Color(0, 0, 204));
        resultJLabel.setText("Score :");

        totalJTextField.setEditable(false);
        totalJTextField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        totalJTextField.setForeground(new java.awt.Color(0, 51, 153));
        totalJTextField.setText("0");

        scoreJLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        scoreJLabel.setForeground(new java.awt.Color(0, 0, 204));
        scoreJLabel.setText("0");

        buttonsJPanel.setLayout(new java.awt.GridLayout(2, 2, 20, 20));

        submitJButton.setBackground(new java.awt.Color(0, 0, 102));
        submitJButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        submitJButton.setForeground(new java.awt.Color(255, 255, 255));
        submitJButton.setText("Submit");
        submitJButton.setToolTipText("Submit expression");
        submitJButton.setEnabled(false);
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        buttonsJPanel.add(submitJButton);

        clearJButton.setBackground(new java.awt.Color(0, 0, 102));
        clearJButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        clearJButton.setForeground(new java.awt.Color(255, 255, 255));
        clearJButton.setText("Clear");
        clearJButton.setToolTipText("Clear Form");
        clearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJButtonActionPerformed(evt);
            }
        });
        buttonsJPanel.add(clearJButton);

        shuffleJButton.setBackground(new java.awt.Color(0, 0, 102));
        shuffleJButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        shuffleJButton.setForeground(new java.awt.Color(255, 255, 255));
        shuffleJButton.setText("Shuffle");
        shuffleJButton.setToolTipText("<html>\n\nGet a new question;<br> however, time will not be added\n</html>");
        shuffleJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleJButtonActionPerformed(evt);
            }
        });
        buttonsJPanel.add(shuffleJButton);

        exitJButton.setBackground(new java.awt.Color(0, 0, 102));
        exitJButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        exitJButton.setForeground(new java.awt.Color(255, 255, 255));
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Exit the game");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });
        buttonsJPanel.add(exitJButton);

        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/CardGameBanner.png"))); // NOI18N

        timerJLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        timerJLabel.setForeground(new java.awt.Color(0, 51, 153));
        timerJLabel.setText("Time Left : ");

        timerJTextField.setEditable(false);
        timerJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        timerJTextField.setForeground(new java.awt.Color(0, 51, 153));
        timerJTextField.setToolTipText("");

        currentPlayerJLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        currentPlayerJLabel.setForeground(new java.awt.Color(0, 0, 153));
        currentPlayerJLabel.setText("Current Player :");

        playerJLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        playerJLabel.setForeground(new java.awt.Color(0, 0, 153));
        playerJLabel.setText("No Player");

        saveJLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        saveJLabel.setForeground(new java.awt.Color(0, 0, 153));
        saveJLabel.setText("[This game supports auto save everytime a question is answered]");

        menuJMenuBar.setBackground(new java.awt.Color(255, 255, 255));

        fileJMenu.setForeground(new java.awt.Color(0, 51, 153));
        fileJMenu.setText("File");
        fileJMenu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        clearJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        clearJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        clearJMenuItem.setForeground(new java.awt.Color(0, 51, 153));
        clearJMenuItem.setText("Clear");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        printJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        printJMenuItem.setForeground(new java.awt.Color(0, 51, 153));
        printJMenuItem.setText("Print");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(seperator1JSeparator);

        quitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_MASK));
        quitJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        quitJMenuItem.setForeground(new java.awt.Color(0, 51, 153));
        quitJMenuItem.setText("Quit");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        menuJMenuBar.add(fileJMenu);

        gameJMenu.setForeground(new java.awt.Color(0, 51, 153));
        gameJMenu.setText("Edit");
        gameJMenu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        generateJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        generateJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        generateJMenuItem.setForeground(new java.awt.Color(0, 51, 153));
        generateJMenuItem.setText("New Puzzle");
        generateJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateJMenuItemActionPerformed(evt);
            }
        });
        gameJMenu.add(generateJMenuItem);

        validateJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        validateJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        validateJMenuItem.setForeground(new java.awt.Color(0, 51, 153));
        validateJMenuItem.setText("Check Answer");
        validateJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateJMenuItemActionPerformed(evt);
            }
        });
        gameJMenu.add(validateJMenuItem);

        solutionJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        solutionJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        solutionJMenuItem.setForeground(new java.awt.Color(0, 51, 153));
        solutionJMenuItem.setText("Get Solutions");
        solutionJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionJMenuItemActionPerformed(evt);
            }
        });
        gameJMenu.add(solutionJMenuItem);

        menuJMenuBar.add(gameJMenu);

        playerJMenu.setForeground(new java.awt.Color(0, 51, 153));
        playerJMenu.setText("Players");
        playerJMenu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        signupJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        signupJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        signupJMenuItem.setForeground(new java.awt.Color(0, 51, 204));
        signupJMenuItem.setText("Sign Up");
        signupJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupJMenuItemActionPerformed(evt);
            }
        });
        playerJMenu.add(signupJMenuItem);

        signinJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        signinJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        signinJMenuItem.setForeground(new java.awt.Color(0, 51, 204));
        signinJMenuItem.setText("Login");
        signinJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinJMenuItemActionPerformed(evt);
            }
        });
        playerJMenu.add(signinJMenuItem);

        editJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        editJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        editJMenuItem.setForeground(new java.awt.Color(0, 51, 204));
        editJMenuItem.setText("Edit  Personal Info");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        playerJMenu.add(editJMenuItem);

        infoJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        infoJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        infoJMenuItem.setForeground(new java.awt.Color(0, 51, 204));
        infoJMenuItem.setText("Player info");
        infoJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoJMenuItemActionPerformed(evt);
            }
        });
        playerJMenu.add(infoJMenuItem);

        scoreJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        scoreJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        scoreJMenuItem.setForeground(new java.awt.Color(0, 51, 204));
        scoreJMenuItem.setText("High Score");
        scoreJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreJMenuItemActionPerformed(evt);
            }
        });
        playerJMenu.add(scoreJMenuItem);

        menuJMenuBar.add(playerJMenu);

        helpJMenu.setForeground(new java.awt.Color(0, 51, 153));
        helpJMenu.setText("Help");
        helpJMenu.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        aboutJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        aboutJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        aboutJMenuItem.setForeground(new java.awt.Color(0, 51, 204));
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        instructionsJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        instructionsJMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        instructionsJMenuItem.setForeground(new java.awt.Color(0, 51, 204));
        instructionsJMenuItem.setText("How to Play");
        instructionsJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionsJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(instructionsJMenuItem);

        menuJMenuBar.add(helpJMenu);

        setJMenuBar(menuJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(timerJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timerJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(currentPlayerJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(playerJLabel))
                    .addComponent(cardsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveJLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(instructionJLabel)
                                .addGap(18, 18, 18)
                                .addComponent(expressionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(verifyJButton)
                                .addGap(34, 34, 34)
                                .addComponent(totalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resultJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scoreJLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timerJLabel)
                        .addComponent(timerJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(currentPlayerJLabel)
                        .addComponent(playerJLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(buttonsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(instructionJLabel)
                            .addComponent(expressionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifyJButton)
                            .addComponent(totalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scoreJLabel)
                            .addComponent(resultJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveJLabel)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        // exit form
        System.exit(0);
    }//GEN-LAST:event_exitJButtonActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        //reset the input fields
        clearJButtonActionPerformed(evt);
        
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void shuffleJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shuffleJButtonActionPerformed
        //get 4 random cards from deck
        shuffleCards();
    }//GEN-LAST:event_shuffleJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        if(checkExpression() == 24)
        {
            score++;
            players.get(currentPlayer).setScore(players.get(currentPlayer).getScore()+ 1);
            saveScore();
            scoreJLabel.setText(Integer.toString(score) + " (Correct!)");
            shuffleCards();
            resetTimer();
        }
        else
        {
            scoreJLabel.setText(Integer.toString(score) + " (Incorrect!)");
            shuffleCards();
            resetTimer();
        }    
                     
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void verifyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyJButtonActionPerformed
        totalJTextField.setText(Double.toString(checkExpression()));
    }//GEN-LAST:event_verifyJButtonActionPerformed

    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJButtonActionPerformed
        expressionJTextField.setText("");
        totalJTextField.setText("");
    }//GEN-LAST:event_clearJButtonActionPerformed

    private void generateJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateJMenuItemActionPerformed
        shuffleJButtonActionPerformed(evt);
    }//GEN-LAST:event_generateJMenuItemActionPerformed

    private void validateJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateJMenuItemActionPerformed
        verifyJButtonActionPerformed(evt);
    }//GEN-LAST:event_validateJMenuItemActionPerformed

    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
       exitJButtonActionPerformed(evt);
    }//GEN-LAST:event_quitJMenuItemActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
         PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void signinJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinJMenuItemActionPerformed
       LoginJDialogForm myLogin = new LoginJDialogForm();
       myLogin.setVisible(true);
       if(myLogin.isConfirmed())
       {
           players = myLogin.getPlayers();
           currentPlayer = myLogin.getCurrentUser();
           playerJLabel.setText(players.get(currentPlayer).getfirstName() + " (" + players.get(currentPlayer).getUsername()+")");
           stopTimer();
           startGame();
       }
       
    }//GEN-LAST:event_signinJMenuItemActionPerformed

    private void signupJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupJMenuItemActionPerformed
       SignUpJDialogForm mySignUp = new SignUpJDialogForm();
       mySignUp.setVisible(true);
    }//GEN-LAST:event_signupJMenuItemActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
      AboutGUI myAbout = new AboutGUI();
      myAbout.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    private void instructionsJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionsJMenuItemActionPerformed
      InstructionsGUI howToPlay = new InstructionsGUI();
      howToPlay.setVisible(true);
    }//GEN-LAST:event_instructionsJMenuItemActionPerformed

    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
     if(currentPlayer != -1)
     {
      EditJDialogForm myEdit = new EditJDialogForm(players,currentPlayer);
      myEdit.setVisible(true);
     }
     else
         JOptionPane.showMessageDialog(null,"Please login first to edit your"
                 + " information","Invalid Operation",
                 JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_editJMenuItemActionPerformed

    private void scoreJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreJMenuItemActionPerformed
        RankingGUI ranking = new RankingGUI();
        ranking.setVisible(true);
    }//GEN-LAST:event_scoreJMenuItemActionPerformed

    private void infoJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoJMenuItemActionPerformed
        PlayersJDialogForm playersData = new PlayersJDialogForm();
        playersData.setVisible(true);
    }//GEN-LAST:event_infoJMenuItemActionPerformed

    private void solutionJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionJMenuItemActionPerformed
        SolverGUI solver = new SolverGUI();
        solver.setVisible(true);
    }//GEN-LAST:event_solutionJMenuItemActionPerformed

    public static void main(String args[]) {


        //Show Splash screen first for 1.2 sec
        Splash mySplash = new Splash(2400);
        mySplash.showSplash();
        CardGameGUI myGUI = new CardGameGUI();
        
        myGUI.setVisible(true);
        myGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JPanel buttonsJPanel;
    private javax.swing.JPanel cardsJPanel;
    private javax.swing.JButton clearJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JLabel currentPlayerJLabel;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JButton exitJButton;
    private javax.swing.JTextField expressionJTextField;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JLabel firstJLabel;
    private javax.swing.JLabel fourthJLabel;
    private javax.swing.JMenu gameJMenu;
    private javax.swing.JMenuItem generateJMenuItem;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JMenuItem infoJMenuItem;
    private javax.swing.JLabel instructionJLabel;
    private javax.swing.JMenuItem instructionsJMenuItem;
    private javax.swing.JMenuBar menuJMenuBar;
    private javax.swing.JLabel playerJLabel;
    private javax.swing.JMenu playerJMenu;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JLabel saveJLabel;
    private javax.swing.JLabel scoreJLabel;
    private javax.swing.JMenuItem scoreJMenuItem;
    private javax.swing.JLabel secondJLabel;
    private javax.swing.JPopupMenu.Separator seperator1JSeparator;
    private javax.swing.JButton shuffleJButton;
    private javax.swing.JMenuItem signinJMenuItem;
    private javax.swing.JMenuItem signupJMenuItem;
    private javax.swing.JMenuItem solutionJMenuItem;
    private javax.swing.JButton submitJButton;
    private javax.swing.JLabel thirdJLabel;
    private javax.swing.JLabel timerJLabel;
    private javax.swing.JTextField timerJTextField;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTextField totalJTextField;
    private javax.swing.JMenuItem validateJMenuItem;
    private javax.swing.JButton verifyJButton;
    // End of variables declaration//GEN-END:variables
}
