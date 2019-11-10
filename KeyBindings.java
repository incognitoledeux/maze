import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyBindings extends JFrame {
    private int x = 25;
    private int y = 25;

    private DrawPanel drawPanel = new DrawPanel();

    private KeyBindings(){
        Action rightAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                x +=2;
                drawPanel.repaint();
            }
        };
        Action leftAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                x -=2;
                drawPanel.repaint();
            }
        };
        Action upAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                y -=2;
                drawPanel.repaint();
            }
        };
        Action downAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                y +=2;
                drawPanel.repaint();
            }
        };


        InputMap inputMap = drawPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = drawPanel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        actionMap.put("rightAction", rightAction);
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        actionMap.put("leftAction", leftAction);
        inputMap.put(KeyStroke.getKeyStroke("UP"), "upAction");
        actionMap.put("upAction", upAction);
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        actionMap.put("downAction", downAction);

        add(drawPanel);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class DrawPanel extends JPanel {
       private static final int RECT_X = 25;


        private void map1(Graphics g) {
            boolean x = true;
            g.fillRect(0, 0, RECT_X, 600);
            if (x) {
                g.fillRect(225, 225, 25, 50);
            }
            g.fillRect(RECT_X + 25, 0, RECT_X, 250);
            g.fillRect(0, 275, 175, 175);
            g.fillRect(0, 475, 175, 200);
            g.fillRect(0, 550, 250, 200);

            g.fillRect(75, 0, 175, 250);
            g.fillRect(200, 275, 50, 400);

        }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            map1(g);
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 15, 15);
            repaint();
        }

        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                new KeyBindings();
            }
        });
    }
}