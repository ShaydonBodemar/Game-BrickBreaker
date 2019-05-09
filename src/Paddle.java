/**
 * Shaydon Bodemar
 */
public class Paddle
{
    private int x, y, w, h, vel;

    public Paddle(int x, int y, int w, int h, int vel)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.vel = vel;
    }

    /**
     * Changes y-coordinate for movement.
     */
    public void move()
    {
        x += vel;
    }

    /**
     * Changes direction of movement when wall is hit.
     */
    public void hitWall()
    {
        vel = -vel;
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
     * Returns width of this paddle.
     */
    public double getW()
    {
        return w;
    }

    /**
     * Returns height of this paddle.
     */
    public double getH()
    {
        return h;
    }

    /**
     * Returns height of this paddle.
     */
    public double getV()
    {
        return vel;
    }
}