package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
  
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * class:Splash
     * File: Splash.java
     * Description : Display flag for each country, longest river,
     * capital, population. Allow edit, delete, or add. 
     * Also quiz for education
     *                 
     * Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
     * Date : 02/19/2016
     * @author Natasha Efendy
     * @version 1.0.0
     * History log:
     * @see javax.swing.JFrame
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 

public class Splash extends JWindow
{

    private int duration;
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: set the duration of splash screen
     * Date: 02/19/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
     */ 

    public Splash(int dur)
    {
        duration = dur;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method : showSplash()
     * Description: A simple little method to show a title screen in the center
     * of the screen for the amount of time given in the constructor
     * Date: 02/19/2016
     * Returns : none
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */
    public void showSplash()
    {

        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.lightGray);
        
        CountUpProgressBar myBar = new CountUpProgressBar();
        
        // Set the window's bounds, centering the window
        int width = 300;
        int height = 150;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);
        
        
       
        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon("src/Graphics/icon.png"));
        JLabel copyrt = new JLabel
        ("24 Card Game", JLabel.CENTER);
        
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        content.add(myBar,BorderLayout.NORTH);
        Color border = new Color(50, 20, 20,  55);
        content.setBorder(BorderFactory.createLineBorder(border, 10));

        // Display it
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try 
        {
            Thread.sleep(duration);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setVisible(false);
        
        

    }
}