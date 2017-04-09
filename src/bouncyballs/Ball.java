/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncyballs;

/**
 *
 * @author Jason
 */
class Ball {
    private int id;
    private double x;
    private double y;
    private double angle;
    private double velocity;
    private double directionX;
    private double directionY;
    
    public Ball(int id, int x,int y, double angle, double velocity){
        this.id = id;
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.velocity = velocity;
        this.directionX = velocity * Math.cos(angle);
        this.directionY = velocity * Math.sin(angle);
    }

    public int getId() {
        return id;
    }

    
    public double getDirectionX() {
        return directionX;
    }

    public double getDirectionY() {
        return directionY;
    }

    public void setDirectionX(double directionX) {
        this.directionX = directionX;
    }

    public void setDirectionY(double directionY) {
        this.directionY = directionY;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
