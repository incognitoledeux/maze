import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class DrawRect extends JPanel {
    private static final int RECT_X = 25;
    private static final int RECT_Y = 40;
    private static final int RECT_WIDTH = 100;
    private static final int RECT_HEIGHT = 400;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        map1(g);

    }

    private void map1(Graphics g){
        boolean x = true;
        g.fillRect(0, 0, RECT_X, 600);
        if(x){
            g.fillRect(225, 225, 25,50);
        }
        g.fillRect(RECT_X+25 ,0,RECT_X,250);
        g.fillRect(0,275,175, 175);
        g.fillRect(0,475,175, 200);
        g.fillRect(0,550,250, 200);

        g.fillRect(75,0,175, 250);
        g.fillRect(200 ,275,50,400);
    }

    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(800, 600);
    }

    // create the GUI explicitly on the Swing event thread
    private static void createAndShowGui() {
        DrawRect mainPanel = new DrawRect();

        JFrame frame = new JFrame("DrawRect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}