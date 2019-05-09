/*
 * Shaydon Bodemar
 */
public class Brick
{
    private int x, y, w, h;
    
    public Brick(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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
     * Returns width of this brick.
     */
    public double getW()
    {
        return w;
    }

    /**
     * Returns height of this brick.
     */
    public double getH()
    {
        return h;
    }

}