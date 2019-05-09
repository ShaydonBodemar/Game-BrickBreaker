import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Shaydon Bodemar
 */

public class BasicAnimation extends Application
{
    private int screenWidth, screenHeight;
    private int speed, x, y;
    Paddle p = new Paddle(175, 10, 50, 8, 25);
    Ball ball = new Ball(200, 200, 5, 1, .25);
    private String score;
    private int s = 0;

    private Canvas canvas;
    private GraphicsContext gc;
    private Timeline tl;

    public BasicAnimation()
    {
        screenWidth = 400;
        screenHeight = 400;

        x = 150;
        y = 150;
        speed = 5;
    }

    @Override 
    public void start(Stage stage) 
    {
        canvas = new Canvas(screenWidth, screenHeight);
        gc = canvas.getGraphicsContext2D();
        tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));

        tl.setCycleCount(Timeline.INDEFINITE);
        canvas.setFocusTraversable(true);

        // handle mouse and key events
        canvas.setOnKeyPressed(e ->
            {
                if(e.getCode() == KeyCode.LEFT)
                {
                    if (p.getV() > 0)
                    {
                        p.hitWall();
                    }
                    if (p.getX() > 0) 
                    {
                        p.move();
                    }
                }
                if(e.getCode() == KeyCode.RIGHT)
                {
                    if (p.getV() < 0)
                    {
                        p.hitWall();
                    }
                    if (p.getX() < 350) 
                    {
                        p.move();
                    }
                }
                if (e.getCode() == KeyCode.P)
                {
                    if(tl.getStatus() == Animation.Status.PAUSED)
                    {
                        tl.play();
                    }
                    else
                    {
                        tl.pause();
                    }
                }
            });
        stage.setTitle("Basic Animations");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc)
    {
        // color for background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, screenWidth, screenHeight);

        // color for objects
        gc.setFill(Color.WHITE);
        gc.fillOval(ball.getX(), ball.getY(), ball.getR(), ball.getR());

        gc.setFill(Color.WHITE);
        gc.fillText("" + s, 20, 20);

        if(s == 150)
        {
            gc.setFill(Color.WHITE);
            gc.fillText("You win!", 165, 200);
            tl.stop();
        }
        ball.move();

        if (ball.getX() <= p1.getX() + p1.getW() && ball.getY() > p1.getY() && ball.getY() < p1.getY() + p1.getH())
        {
            ball.hitSideWall();
            if (Math.random() > .75)
            {
                ball.addVel();
            }
        }
        else if (ball.getX() >= p2.getX() && ball.getY() > p2.getY() && ball.getY() < p2.getY() + p2.getH())
        {
            ball.hitSideWall();
            if (Math.random() > .5)
            {
                ball.addVel();
            }
        }
        else if (ball.getY() + (2 * ball.getR()) >= 400 || ball.getY() <= 0)
        {
            ball.hitTopBotWall();
        }
        else
        {
            if (ball.getX() + (2 * ball.getR()) < 0 )
            {
                s2++;
                
                if (s2 != 10)
                {
                    ball.reset();
                }
            }
            else if (ball.getX() > 400)
            {
                s1++;
                
                if (s1 != 10)
                {
                    ball.reset();
                }
            }
        }

        gc.fillRect(p1.getX(), p1.getY(), 5, 50);
        gc.fillRect(p2.getX(), p2.getY(), 5, 50);

    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}