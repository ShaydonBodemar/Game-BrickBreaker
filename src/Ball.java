/**
 * Shaydon Bodemar
 */
public class Ball
{
    private double x, y, vx, vy;
    private int r;
    
    public Ball(double x, double y, int r, double vx, double vy)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }
    
    /**
     * Changes the x and y coordinates for movement.
     */
    public void move()
    {
        x += vx;
        y += vy;
    }
    
    /**
     * Reverse direction when hitting wall.
     */
    public void hitSideWall()
    {
        vx = -vx;
    }
    
    /**
     * Reverse direction when hitting wall.
     */
    public void hitTopBotWall()
    {
        vy = -vy;
    }
    
    /**
     * Returns x-coordinate.
     */
    public double getX()
    {
        return x;
    }
    
    /**
     * Returns y-coordinate.
     */
    public double getY()
    {
        return y;
    }
    
    /**
     * Returns radius.
     */
    public double getR()
    {
        return r;
    }
    
    /**
     * Increases velocity by factor of 1.5.
     */
    public void reset()
    {
        x = 200 * Math.random() + 100;
        y = 150 * Math.random() + 150;
        vx *= -.5;
        vy *= -.5;
        
    }
    
    /**
     * Increases velocity by factor of 1.5.
     */
    public void addVel()
    {
        vx *= 1.2;
        vy *= 1.2;
    }
}