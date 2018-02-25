package Game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * class: CountUpProgressBar
     * File: CountUpProgressBar.java
     * Description : Load the splash screen until 100%
     *                 
     * Environment: PC, windows 10, jdk 1.8, Netbeans 8.0
     * Date : 01/15/2016
     * @author Natasha Efendy
     * @version 1.0.0
     * History log:
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 

    class CountUpProgressBar extends JPanel {

    private JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
    private JLabel label = new JLabel("", JLabel.CENTER);
    private Timer timer = new Timer(100, new ActionListener() {

        private int counter = 0;

        @Override
        public void actionPerformed(ActionEvent ae) {
            label.setText(String.valueOf(counter));
            bar.setValue(counter+=5);
            if (counter >= 105) {
                timer.stop();
            }
        }
    });

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor: default constructor
     * Description: create loading bar
     * Centers the form
     * Date: 02/15/2016
     * @param None
     * @author Natasha Efendy
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
     */ 

    
   CountUpProgressBar() {
        super.setLayout(new GridLayout(0, 1));
        bar.setValue(0);
        timer.start();
        this.add(bar);
        this.add(label);
        //JOptionPane.showMessageDialog(null, this);
    }
    }
