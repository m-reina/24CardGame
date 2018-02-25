
package Game;
import java.util.StringTokenizer;

/**
 * Class RPN
 File Name : RPN.java
 Description : A class that contains methods to toInfix 
                 a mathematical expression to a RPN (Reverse
                 Polish Notation) expression
 Date : 02/27/2016
 * @author Natasha Efendy
 */
public class RPN
{
    
        private GenericStack operatorStack = new GenericStack(); 
        private final String OPERATORS = "()+-/*%^!";
        private final int PRIORITY_1 = 4;
        private final int PRIORITY_2 = 3;
        private final int PRIORITY_3 = 2;
        private final int PRIORITY_4 = 1;
        
        
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     Method : toRPN()
     Description: toInfix mathematical expression to RPN expression
     Returns : String rpnExpression
     Date: 02/27/2016   
     * @param String expression
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
        public String toRPN(String expression) throws FullStackException, EmptyStackException 
        {
            expression="(" + expression + ")";   

            String rpnExpression = "";


            StringTokenizer tokens = new StringTokenizer
                                   (expression, OPERATORS, true); 
            
            while(tokens.hasMoreTokens())
            {
                String token = tokens.nextToken().trim();

                if (token.length() != 0)
                {
                        if (isNumeric(token))
                        {
                            //put numbers to rpn expression
                             rpnExpression += token + " ";

                         }
                        else if (token.equals("("))
                            operatorStack.push(token.charAt(0));

                        else if (token.equals(")")) 
                        {
                            while ((char)operatorStack.peek() != '(')
                            {
                                rpnExpression += (char)operatorStack.peek()
                                        + " ";
                                operatorStack.pop();
                            }

                            operatorStack.pop();
                        } 
                        else 
                        {
                            //decide the order of operation
                            while (getPriority((char)operatorStack.peek()) 
                                    >= getPriority(token.charAt(0)) )
                            {
                                //put the operators in the rpn expression
                                rpnExpression += (char)operatorStack.peek()
                                        + " ";
                                operatorStack.pop();
                            }
                            operatorStack.push(token.charAt(0));
                        }
            }
        }
      
        return rpnExpression;

    }
    
       
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : isNumeric()
     * Description: check whether the current string is a number
     * Returns : boolean
     * Date: 02/27/2016
     * @param String str
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 
    private boolean isNumeric(String str)  
    {  
        try  
        {  
            //try parsing to integer
            //if it fails then it is non numeric
            Integer.parseInt(str);  
        }  
        catch(NumberFormatException exp)  
        {  
            return false;  
        }  
        return true;  
    }
    
      
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : getPriority()
     * Description: returns an integer which indicated the
     *               presidence of operators
     * Returns : int
     * Date: 02/27/2016
     * @param char operator
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */   
    private int getPriority(char operator) 
    {
        if(operator == '!')
            return PRIORITY_1; //higher priority
        if(operator =='^')
           return PRIORITY_2; 
        if (operator == '/' || operator == '*' || operator =='%')
            return PRIORITY_3; 
        if (operator == '+' || operator == '-')
            return PRIORITY_4; //lower priority
        return 0;
    }
    
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : toInfix()
     * Description: convert an rpn expression (postfix) to infix
     *              notation.
     * Date: 03/07/2016
     * Returns : none
     * @param String rpn
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
    public String toInfix(String rpn){
    GenericStack<String> myStack = new GenericStack<String>();
    boolean skip = false;
    
     for(int i = 0; i < rpn.length(); i++)
     {
        char c = rpn.charAt(i);
        char c2 = ' ';
        
        if(skip)
        {
            skip=false;
            continue;
        }
        
        if(i!=(rpn.length()-1))
            c2 = rpn.charAt(i+1);
        
        if(c == ' ')
            continue;
        
        if(isOperator(c))
        {
            String b = myStack.pop();
            String a = myStack.pop();
            myStack.push("("+a+c+b+")");

        }
        else
        {
            if(!isOperator(c2) && c!= ' ')
            {
                myStack.push(""+Character.toString(c)+Character.toString(c2));
                skip = true;
            }
            else
                myStack.push(""+c);
        }

    }
   
  return myStack.pop();
 }
 
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : isOperator()
     * Description: check whether character is an operator
     * Date: 03/07/2016
     * Returns : boolean
     * @param char operator
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */   
  private boolean isOperator(char operator)
  {
    if(operator == '+' || operator == '-' || operator == '*' 
            || operator =='/'  || operator == '!'
            || operator == '^' || operator == '%')
        return true;
    return false;
  }

}
