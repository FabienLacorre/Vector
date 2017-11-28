import java.awt.Color;
import java.util.Random;

public class Ball {

    private int x;
    private int y;
    private int size;
    private int velocity;
    private Color col;
    private int directionX;
    private int directionY;
    Random r = new Random();

    public Ball(int x, int y, int size, int velocity, Color col) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.col = col;
        this.velocity = velocity;
        this.directionX = 0;
        this.directionY = 0;
        this.directionX = r.nextInt(2);
            if (this.directionX == 0)
                this.directionX = -1;
        this.directionY = r.nextInt(2);
            if (this.directionY == 0)
                this.directionY = -1;

    }

    public int getDirectionX(){
        return this.directionX;
    }

    public void setDirectionX(int direction){
        this.directionX = direction;
    }

    public int getDirectionY(){
        return (this.directionY);
    }

    public void setDirectionY(int directionY){
        this.directionY = directionY;
    }

    public int getX() {
        return (this.x);
    }

    public int getY() {
        return (this.y);
    }

    public int getSize(){
        return (this.size);
    }

    public Color getColor(){
        return (this.col);
    }

    public int getVelocity(){
        return (this.velocity);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void setCol(Color col){
        this.col = col;
    }

    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
}
