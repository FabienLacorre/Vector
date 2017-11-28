import java.awt.Color;
import javax.swing.JFrame;
import java.util.List;
import javax.swing.JPanel;

public class Window extends JFrame{
    private Panel pan = new Panel();

    public Window(String name, int w, int h)
    {
        pan.setBackground(Color.BLACK);
        pan.initColTab();
        this.setTitle(name);
        this.setSize(w, h);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(pan);
        this.setVisible(true);
        pan.initAllBalls(70);
        this.go();
    }

    private void go() {
        while (true) {
            List<Ball> list = pan.getAllBalls();

            for (Ball elem : list){
                if (elem.getX() >= pan.getWidth() - elem.getSize() || elem.getX() <= 0){
                    elem.setDirectionX(elem.getDirectionX() * -1);
                }
                if (elem.getY() >= pan.getHeight() - elem.getSize() || elem.getY() <= 0){
                    elem.setDirectionY(elem.getDirectionY() * -1);
                }
                elem.setX(elem.getX() + (elem.getDirectionX() * elem.getVelocity()));
                elem.setY(elem.getY() + (elem.getDirectionY() * elem.getVelocity()));
            }

            pan.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
