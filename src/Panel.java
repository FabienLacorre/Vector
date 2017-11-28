import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.rmi.MarshalException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Panel extends JPanel implements MouseListener {

    private List<Ball> allBalls = new ArrayList<Ball>();
    private List<Color> colList = new ArrayList<Color>();
    private Color[] tabCol;

    public Panel(){
        this.addMouseListener(this);
    }

    private void initBall(int x, int y, int size, int velocity, Color col){
        allBalls.add(new Ball(x, y, size, velocity, col));
    }

    public void initColTab(){
        tabCol = new Color[256];
        for (int i = 0; i < 255; i++){
            tabCol[i] = new Color(51, 204,  204, i);
        }
    }

    public void initAllBalls(int nbBall)
    {
        Random r = new Random();
        for (int i = 0; i < nbBall; i++)
        {
            int x = 50 + r.nextInt((this.getWidth() - 50)- 50);
            int y = 50 + r.nextInt((this.getHeight() - 50) - 50);
            int vel = 1 + r.nextInt(2 - 1);
            initBall(x, y, 3, vel, tabCol[250]);
        }
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (Ball primal : allBalls){
            for (Ball elem : allBalls){
                double d = Math.sqrt(Math.pow((double)elem.getX() - (double)primal.getX(), 2) + Math.pow((double)elem.getY() - (double)primal.getY(), 2));
                if (d < 150)
                {
                    int alpha = 150 - (int)d;
                    g.setColor(tabCol[alpha]);
                    g.drawLine(primal.getX() + (primal.getSize() / 2), primal.getY() + (primal.getSize() / 2),
                            elem.getX() + (elem.getSize() / 2), elem.getY() + (elem.getSize() / 2));
                }
            }
        }
        for (Ball elem : allBalls){
            g.setColor(elem.getColor());
            g.fillOval(elem.getX(), elem.getY(),elem.getSize(), elem.getSize());
        }

    }

    public List<Ball> getAllBalls(){
        return (this.allBalls);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
