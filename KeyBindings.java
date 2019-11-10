import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class KeyBindings extends JFrame {
    private int x = 27;
    private int y = 27;
    private boolean gate = false;
    private DrawPanel drawPanel = new DrawPanel();

    private KeyBindings(){
        Action rightAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                x +=4;
                drawPanel.repaint();
            }
        };
        Action leftAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                x -=4;
                drawPanel.repaint();
            }
        };
        Action upAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                y -=4;
                drawPanel.repaint();
            }
        };
        Action downAction = new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                y +=4;
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


            g.fillRect(0, 0, 25, 600);


            g.fillRect(225, 250, 25, 25);

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
            g.setColor(Color.ORANGE);
            g.fillRect(25,450,25,25);
            g.fillRect(175,525,25,25);
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 15, 15);

            repaint();



            //randomized key

            double choose = Math.random();


            if(choose%2 == 0) {
                if (x > 25 && x < 50 && y > 450 && y < 475) {

                    gate = true;

                }
            }else {
                if (x > 175 && x < 200 && y < 550 && y > 525) {

                    gate = true;


                }
            }


            Rectangle r1 = new Rectangle(x,y,25,25);
            Rectangle r2 = new Rectangle(0, 0, 25, 600);
            Rectangle r3 = new Rectangle(235, 250, 25, 25);
            Rectangle r4 = new Rectangle(60, 0, 25, 250);
            Rectangle r5 = new Rectangle(0, 285, 175, 155);
            Rectangle r6 = new Rectangle(0, 465, 175, 200);
            Rectangle r7 = new Rectangle(0, 565, 250, 200);
            Rectangle r8 = new Rectangle(65, 0, 175, 240);
            if(gate == true){
                g.clearRect(225, 250, 25, 25);
                r3.setLocation(0,0);
            }
            if(r1.intersects(r2)) {
                x=25;
                y=25;
            }
            if(r1.intersects(r3))
            {
                x=25;
                y=25;
            }
            if(r1.intersects(r4))
            {
                x=25;
                y=25;
            }
            if(r1.intersects(r5))
            {
                x=25;
                y=25;
            }
            if(r1.intersects(r6))
            {
                x=25;
                y=25;
            }
            if(r1.intersects(r7))
            {
                x=25;
                y=25;
            }
            if(r1.intersects(r8))
            {
                x=25;
                y=25;
            }
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