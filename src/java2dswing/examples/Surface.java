/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java2dswing.examples;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author owner
 */
 /*
  * See:
  * https://zetcode.com/gfx/java2d/introduction/
 */
public class Surface extends JPanel {

   //
   // TODO: Use Surface to override doDrawig
   //
   private void doDrawing(Graphics g) {

      Graphics2D g2d = (Graphics2D) g;
      g2d.drawString("Java 2D", 50, 50);
      //
      // TODO: Use Surface to override doDrawig
      //
   }

   @Override
   public void paintComponent(Graphics g) {

      super.paintComponent(g);
      doDrawing(g);
   }

}
