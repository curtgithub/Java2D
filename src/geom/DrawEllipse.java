/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 *
 * @author owner
 */
public class DrawEllipse extends JApplet {
   
   final static int JRAME_WIDTH = 1024;
   final static int JRAME_HEIGHT = 1024;   
   final static Dimension JFRAME_DIMENSION = new Dimension(JRAME_WIDTH, JRAME_HEIGHT);

   final static float STROKE_WIDTH = 2.0f;
   final static BasicStroke STROKE = new BasicStroke(STROKE_WIDTH);

   @Override
   public void init() {
      //Initialize drawing colors
      setBackground(Color.WHITE);
      setForeground(Color.BLACK);
   }

   @Override
   public void paint(Graphics g) {
      //
      // ?Setup Rendering Hints?
      //
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      Dimension d = getSize();
      int gridWidth = d.width;
      int gridHeight = d.height;
      
      int rectWidth = gridWidth / 2;
      int rectHeight = gridHeight / 2;
      
      double x = gridWidth / 2;
      double y = gridHeight / 2;

      //
      // IMPORTANT: Create/Draw The Ellipse
      //
      g2.setStroke(STROKE);
      g2.draw(new Ellipse2D.Double(x, y, rectWidth, rectHeight));
      //g2.drawString("Ellipse2D", x, stringY);
      //x += gridWidth;

   }

   public static void main(String[] args) {
      JFrame f = new JFrame("DrawEllipse");
      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      JApplet applet = new DrawEllipse();
      f.getContentPane().add("Center", applet);
      applet.init();
      f.pack();
      //
      // IMPORTANT: Set the JFrame Dimension i.e. Size
      //
      applet.init();
      f.pack();
      f.setSize(new Dimension(JRAME_WIDTH, JRAME_HEIGHT));
      f.setVisible(true);
   }
}
