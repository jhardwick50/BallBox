/*
 *  Author: Jason Hardwick
    CIS 314
    Module 4
 */
package bouncyballs;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BouncyBalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BallBox box = new BallBox();
        
        
        frame.add(box);
        
        //box.setSize(500,500);
                box.setBackground(Color.white);
        
        frame.setSize(550, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        
    }

   
    
}
