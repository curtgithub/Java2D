/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dawt.examples;

import geom.Ellipse;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 *
 * @author owner
 */
public class DrawEllipse extends JApplet {

   final static int JRAME_WIDTH = 1024;
   final static int JRAME_HEIGHT = 1024;

   final static float STROKE_WIDTH = 2.0f;

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
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);

      Dimension d = getSize();
      
      g2.setBackground(Color.WHITE);
      Ellipse ellipse = new Ellipse();
      try {
         ellipse.setWidth(d.width);
         ellipse.setHeight(d.height/2);
      } catch (Exception ex) {
         Logger.getLogger(DrawEllipse.class.getName()).log(Level.SEVERE,
                 "Ellipse must have a greater than 0 semi-major and minor values.", ex);
      }
      g2.draw(new Ellipse2D.Double(0, 0,
              ellipse.getWidth(),
              ellipse.getHeight()));
     
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
