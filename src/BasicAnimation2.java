/**
 * Write a description of class BasicAnimation here.
 * 
 * @author Andrew Kettle
 * @version (a version number or a date)
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.animation.Animation;

public class BasicAnimation2 extends Application
{
    private int screenWidth, screenHeight;
    private int speed, x, y;
    private int r;
    private int vx;
    private int vy;
    private int w;
    private int h;
    private int vel;
    private int lives;
    private int score;
    private Timeline tl;
    private Ball ball = new Ball(180, 180, 4, 2, 10);
    private Paddle paddle = new Paddle(150, 375, 40, 10, 30);
    private Bricks Brick = new Bricks(x, y, 35, 10); 

    public BasicAnimation2()
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
        Canvas canvas = new Canvas(screenWidth, screenHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        canvas.setFocusTraversable(true); 

        canvas.setOnKeyPressed(e ->
            {
                if(e.getCode() == KeyCode.LEFT) //Move left
                {
                    if(paddle.getX() > 0 && paddle.getX() + 40 < 400)
                    {
                        if (paddle.getV() > 0)
                        {
                            paddle.hitWall();
                        }
                        if (paddle.getX() > 0)
                        {
                            paddle.move();
                        }
                    }
                }
                if(e.getCode() == KeyCode.RIGHT) //Move right
                {
                    if(paddle.getX() > 0 && paddle.getX() + 40 < 400)
                    {
                        if (paddle.getV() < 0)
                        {
                            paddle.hitWall();
                        }
                        if (paddle.getX() > 0)
                        {
                            paddle.move();
                        }
                    }
                }
                if(e.getCode() == KeyCode.SPACE) // starts game
                {
                    if(tl.getStatus() == Animation.Status.PAUSED)
                    {
                        tl.play();
                    }
                    else
                    {
                        tl.stop();
                    }
                }
                if(e.getCode() == KeyCode.P) // pauses game
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

            } );
        stage.setTitle("Basic Animations");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc)
    {
        // color for background
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, screenWidth, screenHeight);

        gc.setFill(Color.BLACK); 
        gc.fillRect(paddle.getX(), paddle.getY(), paddle.getW(), paddle.getH()); //paddle
        gc.fillOval(ball.getX(), ball.getY(), ball.getR(), ball.getR()); //first ball

        for(int w = 0; w < 400; w+=35)
        {
            for(int h = 200; h < 400; h+=10)
            {
                if(w < 35) //add colors 
                {
                    gc.setFill(Color.RED); 
                    gc.fillRect(w, h, Brick.getW(), Brick.getH()); 
                }
                if(w < 70 && w > 35) // add color
                {
                    gc.setFill(Color.GREEN); 
                    gc.fillRect(w, h, Brick.getW(), Brick.getH());  
                }
                if(w < 105 && w > 70) //add color
                {
                    gc.setFill(Color.BLUE); 
                    gc.fillRect(w, h, Brick.getW(), Brick.getH()); 
                }
                if(w < 140 && w > 105) //add color
                {
                    gc.setFill(Color.YELLOW); 
                    gc.fillRect(w, h, Brick.getW(), Brick.getH()); 
                }
                if(w < 175 && w > 140) //add color
                {
                    gc.setFill(Color.ORANGE); 
                    gc.fillRect(w, h, Brick.getW(), Brick.getH()); 
                }
            }
        }

        if(ball.getX() > screenWidth - 10 || ball.getX() < 0)
        {
            ball.hitSideWall(); 
        }

        if(ball.getY() < 10) /// anything below paddle doesn't matter
        {
            lives--;
            if(lives == 0)
            {
                tl.stop();
                System.out.println("Sorry, you lost!");
            }
        }

        if(score == 150)
        {
            tl.stop();
            System.out.println("Congratulations! You won!");
        }

        if(ball.getX() < 0)
        {
            ball.hitSideWall();
        }
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}