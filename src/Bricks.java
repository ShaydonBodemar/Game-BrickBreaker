/**
 * Write a description of class Ball here.
 * 
 * @author Andrew Kettle
 * @version (a version number or a date)
 */
public class Bricks
{
    private int x, y, w, h, vel;
    
    public Bricks(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    
    /**
     * Returns x-coordinate.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Returns y-coordinate.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Returns width of this paddle.
     */
    public int getW()
    {
        return w;
    }
    
    /**
     * Returns height of this paddle.
     */
    public int getH()
    {
        return h;
    }
}