
package Game;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;


 /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* class: SolverGUI
* File: SolverGUI.java
* Description : Give users answers for the 4 numbers they input   
* Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
* Date : 03/08/2016
* @author Natasha Efendy
* @version 1.0.0
* History log:
* @see javax.swing.JFrame
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
*/ 
public class SolverGUI extends javax.swing.JFrame {
int counter = 0;
int n = 0;
final int PERMUTATION = 24;
final int COMBINATION = 840;
int[][] numbers = new int[PERMUTATION][4];
char[] operators = new char[] {'+','-','*','/','%','^'};
char[][] combinations = new char[COMBINATION][3];

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: creates the form, sets default button
     * Date: 03/08/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    public SolverGUI() {
        initComponents();
        
         //centers the form
        this.setLocationRelativeTo(null); 
        
        //put icon image for the form
        this.setIconImage(Toolkit.getDefaultToolkit()
        .getImage("src/graphics/icon.png"));
                
        //fires submit button on default
        this.getRootPane().setDefaultButton(solveJButton);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructionsJLabel = new javax.swing.JLabel();
        num2JTextField = new javax.swing.JTextField();
        num3JTextField = new javax.swing.JTextField();
        num1JTextField = new javax.swing.JTextField();
        num4JTextField = new javax.swing.JTextField();
        solutionsJScrollPane = new javax.swing.JScrollPane();
        solutionsJTextArea = new javax.swing.JTextArea();
        solveJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("24 Game Solver");
        setAutoRequestFocus(false);
        setResizable(false);

        instructionsJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        instructionsJLabel.setForeground(new java.awt.Color(0, 0, 102));
        instructionsJLabel.setText("Enter the 4 numbers to solve");

        num2JTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        num3JTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        num1JTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        num4JTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        solutionsJTextArea.setColumns(20);
        solutionsJTextArea.setRows(5);
        solutionsJScrollPane.setViewportView(solutionsJTextArea);

        solveJButton.setBackground(new java.awt.Color(0, 0, 102));
        solveJButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        solveJButton.setForeground(new java.awt.Color(255, 255, 255));
        solveJButton.setText("Solve");
        solveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("*note : the division here is double division");

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(instructionsJLabel)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(solutionsJScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(num1JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(num2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(num3JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(num4JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(solveJButton)
                .addGap(51, 51, 51)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instructionsJLabel)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num3JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num1JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num4JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(solutionsJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(solveJButton)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : reset()
     * Description: reset arrays, counters, and JTextArea
     * Date: 01/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    private void reset()
    {
        int[][] arrays = new int[PERMUTATION][4];
        char[] operators = new char[] {'+','-','*','/','^','%'};
        char[][] combinations = new char[COMBINATION][3];
        counter  = 0;
        n=0;
        solutionsJTextArea.setText("");
    }
    
    private void solveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveJButtonActionPerformed
        try
        {
        reset();
        GenericStack<Integer> operandStack = new GenericStack<Integer>();
        
        int num1 = Integer.parseInt(num1JTextField.getText());
        int num2 = Integer.parseInt(num2JTextField.getText());
        int num3 = Integer.parseInt(num3JTextField.getText());
        int num4 = Integer.parseInt(num4JTextField.getText());
        
        if((num1 < 0 || num1 >13) || (num2 < 0 || num2 >13) || 
                (num3 < 0 || num3 >13) || (num4 < 0 || num4 >13))
            JOptionPane.showMessageDialog(null, "Please enter a number between 1"
                    + " to 13","Invalid number bounds",
                    JOptionPane.WARNING_MESSAGE);
        else
        {
        int[] myArray = new int[4];
        myArray[0] = num1;
        myArray[1] = num2;
        myArray[2] = num3;
        myArray[3] = num4;
        
        //get all possible permutations
        //and combinations for both operand and operators
        permute(myArray,0);
        operatorCombinations(3,operators,"");
        
        for(int i = 0;i<PERMUTATION;i++)
        {
            for(int j = 0;j<COMBINATION;j++)
            {
                String rpnExpression = Integer.toString(numbers[i][0]) + " " +
                Integer.toString(numbers[i][1])+" "+ combinations[j][0] + " "
                + Integer.toString(numbers[i][2]) + " " + combinations[j][1] + " " + 
                Integer.toString(numbers[i][3]) + " " + combinations[j][2];
                
                
                RPN expression = new RPN();
                String trimmedRPN = rpnExpression.replaceAll("\\s+","");
                
                try
                {
                    double result = evaluateExpression(rpnExpression);
                    if(result == 24)
                    {
                        solutionsJTextArea.append(expression.toInfix(rpnExpression));
                        solutionsJTextArea.append("\n");
                    }
                }
                catch(Exception exp)
                {
                    System.out.println("error");
                }
                
            }
        }
        
        if(solutionsJTextArea.getText().isEmpty())
            solutionsJTextArea.append("No solutions!");
        }
        }
        catch(NumberFormatException numex)
        {
            JOptionPane.showMessageDialog(null,"Please enter numeric values"
                    ,"Invalid Input",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_solveJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : permute()
     * Description: get card permutations
     * Date: 03/08/2016
     * Returns : none
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    private void permute(int[] arr, int start)
    {
        int size = arr.length;
        if (size == start + 1) 
        {
            for(int i = 0;i<size;i++)
              numbers[counter][i]=arr[i];
              counter++;
        }
        else 
        {
            for (int i = start; i < size; i++)
            {

                swap(arr,start,i);
                permute(arr, start + 1);
                swap(arr,start,i);
            }
        }
        
    }
    
      /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : swap()
     * Description: swap 2 elements in an array
     * Date: 02/27/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    private void swap(int[] arr,int start,int i)
    {
            int temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : operatorCombinations()
     * Description: get possible operators combination
     * Date: 03/08/2016
     * Returns : none
     * @param None
     * @author Davian Lukman
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
     private void operatorCombinations(int maxLength, char[] alphabet, String combi) {
         

        if(combi.length() == maxLength) 
        {
            char[] temp = combi.toCharArray();
            for(int i = 0;i<3;i++)
            {
                combinations[n][i] = temp[i];
            }
            n++;

        }
        else {
            for(int i = 0; i < alphabet.length; i++) {
                String oldCombi = combi;
                combi += alphabet[i];
                operatorCombinations(maxLength,alphabet,combi);
                combi = oldCombi;
            }
        }
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
     
        GenericStack<Double> operandStack = new GenericStack<Double>();
        StringTokenizer tokens = new StringTokenizer(exp," +-*/%^!",true);
        
        
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
                    operandStack.push( new Double(token));
                }
                
  
        }
      
        return operandStack.pop();
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
            
            stack.push(factorial(op1));
        }
        else
         {
            op1 = (double)stack.pop();
            op2 = (double)stack.pop();
            
            stack.push(op2%op1);
         }
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel instructionsJLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField num1JTextField;
    private javax.swing.JTextField num2JTextField;
    private javax.swing.JTextField num3JTextField;
    private javax.swing.JTextField num4JTextField;
    private javax.swing.JScrollPane solutionsJScrollPane;
    private javax.swing.JTextArea solutionsJTextArea;
    private javax.swing.JButton solveJButton;
    // End of variables declaration//GEN-END:variables
}
