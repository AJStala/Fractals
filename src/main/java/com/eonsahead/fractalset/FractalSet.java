package com.eonsahead.fractalset;

import java.awt.Container;
import javax.swing.JFrame;

public class FractalSet extends JFrame {

    private static final int FRACTAL_WIDTH = 512;
    private static final int FRACTAL_HEIGHT = 512;
    private static final String FRACTAL_TITLE = "Fractal";

    public FractalSet() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRACTAL_WIDTH, FRACTAL_HEIGHT);
        this.setTitle(FRACTAL_TITLE);

        Container pane = this.getContentPane();

        FractalSetPanel panel = new FractalSetPanel();
        pane.add(panel);
        this.setVisible(true);
    } // FractalSet()

    public static void main(String[] args) {
        FractalSet fractalSet = new FractalSet();
    } // main( String [] )

} // FractalSet
