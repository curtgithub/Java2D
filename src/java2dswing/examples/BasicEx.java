/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dswing.examples;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author owner
 */

/*
  * See:
  * https://zetcode.com/gfx/java2d/introduction/
 */
public class BasicEx extends JFrame {

    public BasicEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Simple Java 2D example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                BasicEx ex = new BasicEx();
                ex.setVisible(true);
            }
        });
    }
}