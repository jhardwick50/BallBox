/*
 * Author: Jason Hardwick
    CIS 314
    Module 4
 */
package bouncyballs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Jason
 */
public class BallBox extends JPanel implements MouseListener{
    private Random rng = new Random();
    private ArrayList<Ball> balls = new ArrayList<>();
    
    public BallBox(){
        this.addMouseListener(this);
        //creating thread when balls are created
        Thread boxThread = new Thread(){
            @Override
            public void run() {
                while (true){
                    updateCoordinates(balls);
                    repaint();
                    
                    try{
                        Thread.sleep(1000/30);
                    }catch (InterruptedException e){}
                }
            }
            
        };
        boxThread.start();
    }
    //updates ball coordinates when collisions occur.
    public void updateCoordinates(List<Ball> balls){
        for(Ball ball : balls) {
            double x = ball.getX();
            double y = ball.getY();
           
            double newX = x + ball.getDirectionX();
            double newY = y + ball.getDirectionY();

            if (newX < 5 || newX > 495) {
                //System.out.print("Ball " + ball.getId() + ": X went off screen at " + newX);       
                newX = (int) (x - ball.getDirectionX());
                ball.setDirectionX(-1 * ball.getDirectionX());
               // System.out.println(" -- X direction is flipped to " + ball.getDirectionX());
            }
            
            if (newY < 5 || newY > 495) {
                //System.out.print("Ball " + ball.getId() + ": Y went off screen at " + newY);  
                newY = (int) (y - ball.getDirectionY());
                ball.setDirectionY(-1 * ball.getDirectionY());
                //System.out.println(" -- Y direction is flipped to " + ball.getDirectionY());
            }
            //System.out.println("After x,y: " + newX + "," + newY);
            
            ball.setX((int) newX);
            ball.setY((int) newY);
            
            
            
        }
    }
    //draws balls on screen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.setColor(Color.blue);
        
        
        for( int i = 0;i < balls.size();++i){
            
            Ball current = balls.get(i);
            //System.out.println("drawing ball at "+current.getX() + "," +current.getY());
            g.fillOval((int) current.getX(), (int) current.getY(), 10, 10);
        }
    }
    
    //creates new ball when mouse is clicked
    @Override
    public void mouseClicked(MouseEvent e) {
        if(balls.size() >= 25){
            return;
        }
        //System.out.println("new ball created from mouse click");
        int x = rng.nextInt(500);
        int y = rng.nextInt(500);
        double angle = Math.random() * 2.0 * Math.PI;
        
        Ball ball = new Ball(balls.size() + 1, x, y, angle, 2);
       // System.out.println("Ball " + ball.getId() + ": generated at " + x + "," + y + " with angle " + angle);
        balls.add(ball);
        
        
        
        
       // this.repaint();//TODO: repainting should happen from thread not manually on click.(or both?)
    }   
        
        
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
