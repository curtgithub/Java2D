/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dswing.examples;

import java.awt.Dimension;
import java2dswing.Java2DSwing;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author owner
 */
public class DrawEllipseSwing extends JComponent {
   
    public static void main(String args[]) {

      JFrame f = new JFrame("Ellipse Frame");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Dimension df = new Dimension(Java2DSwing.JFRAME_WIDTH,
              Java2DSwing.JFRAME_HEIGHT);
      f.setSize(df);

      Java2DSwing component = new Java2DSwing();
      f.add(component);
      f.setVisible(true);
   }
   
}
