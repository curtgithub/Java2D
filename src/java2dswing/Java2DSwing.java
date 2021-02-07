/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dswing;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author owner
 */
public class Java2DSwing extends JComponent {

   public static final int JFRAME_WIDTH = 1024;
   public static final int JFRAME_HEIGHT = 1024;

   protected void paintComponent(Graphics g) {

      System.out.println("Width:" + getWidth() + ", Height:" + getHeight());

   }

   public static void main(String args[]) {

      JFrame f = new JFrame("Some frame");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Dimension df = new Dimension(Java2DSwing.JFRAME_WIDTH,
              Java2DSwing.JFRAME_HEIGHT);
      f.setSize(df);

      Java2DSwing component = new Java2DSwing();
      f.add(component);
      f.setVisible(true);
   }
}
