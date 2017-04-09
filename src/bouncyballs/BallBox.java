/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private Random rng = new Random(500);
    private ArrayList<Ball> balls = new ArrayList<>();
    
    public BallBox(){
        this.addMouseListener(this);
        
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
    
    public void updateCoordinates(List<Ball> balls){
        for(Ball ball : balls) {
            int x = ball.getX();
            int y = ball.getY();


            
            int newX = x + (int)(5 * Math.cos(ball.getAngle()));
            int newY = y + (int)(5 * Math.sin(ball.getAngle()));
            
            ball.setX(newX);
            ball.setY(newY);
            
            
        }
    }
    
    public int angleX(int direction) {
        if (direction <= 90) {
            return 90 - direction;
        } else if (direction > 90 && direction <= 180) {
            return 90 - direction;
        } else if (direction > 180 && direction <= 270) {
            return direction - 270;
        } else {
            return direction - 270;
        }
    }
    
    public int angleY(int direction) {
                if (direction <= 90) {
            return 90 - direction;
        } else if (direction > 90 && direction <= 180) {
            return 90 - direction;
        } else if (direction > 180 && direction <= 270) {
            return direction - 270;
        } else {
            return direction - 270;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.blue);
        
        
        for( int i = 0;i < balls.size();++i){
            
            Ball current = balls.get(i);
            //System.out.println("drawing ball at "+current.getX() + "," +current.getY());
            g.fillOval(current.getX(), current.getY(), 10, 10);
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(balls.size() >= 25){
            return;
        }
        //System.out.println("new ball created from mouse click");
        int x = rng.nextInt(500);
        int y = rng.nextInt(500);
        int angle = (int)(Math.random() * 2.0 * Math.PI);
        Ball ball = new Ball(x, y, angle);
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
