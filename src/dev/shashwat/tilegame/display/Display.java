package dev.shashwat.tilegame.display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    private String TITLE;
    private int HEIGHT;
    private int WIDTH;

    public Display(String TITLE, int WIDTH, int HEIGHT) {
        this.TITLE = TITLE;
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(TITLE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas  = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setFocusable(true);
        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}
