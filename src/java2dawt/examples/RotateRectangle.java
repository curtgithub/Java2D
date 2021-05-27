/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dawt.examples;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author owner
 */
public class RotateRectangle extends JPanel implements ActionListener {

   private static final double RR_WIDTH = 200;
   private static final double RR_HEIGHT = 150;
   private static final double RR_FRAME_SCALE = 5;

   private JFrame frame;
   private Rectangle rect;
   private double angle;
   private Color drawColor;
   private Color fillColor;
   private Timer timer;

   public RotateRectangle(JFrame frame) {
      this.frame = frame;

      rect = new Rectangle();
      Dimension fd = this.frame.getSize();
      rect.setRect(fd.getWidth() / 2 - RR_WIDTH / 2,
              fd.getHeight() / 2 - RR_HEIGHT / 2,
              RR_WIDTH, RR_HEIGHT);
      
      angle = 0;

      drawColor = Color.BLUE;
      fillColor = Color.RED;
      
      timer = new Timer(10, this);
      timer.start();

   }

   @Override
   public void actionPerformed(ActionEvent e) {

      angle += 0.01;

      repaint();

   }

   @Override
   public void paintComponent(Graphics g) {

      Graphics2D g2d = (Graphics2D) g.create();
      //
      // Clear the frame
      //
      Dimension fd = this.frame.getSize();
      g2d.clearRect(0, 0,
              (int) Math.round(fd.getWidth()), (int) Math.round(fd.getHeight()));
      //
      //  TODO: Read about rendering hints
      //
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
              RenderingHints.VALUE_ANTIALIAS_ON);

      g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
              RenderingHints.VALUE_RENDER_QUALITY);
      //
      // Set the rectange's center to the Frame's 0,0
      //
      Dimension rd = this.rect.getSize();
      rect.setRect(-rd.getWidth() / 2,
              -rd.getHeight() / 2,
              rd.getWidth(), rd.getHeight());
      //
      // Translate the rectangle to the the frame's center
      //
      g2d.translate(fd.getWidth() / 2, fd.getHeight() / 2);
      //
      // Rotate the frame? or rectangle?
      //
      g2d.rotate(angle);
      //
      // Draw and fill the rectangle
      //
      g2d.setColor(drawColor);
      g2d.draw(rect);
      g2d.setColor(fillColor);
      g2d.fill(rect);
      //
      // Delete the Graphics2D copy
      //
      g2d.dispose();
   }

   public static void main(String[] args) {

      JFrame frame = new JFrame("Rotating Rectangle.");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize((int) Math.round(RR_WIDTH * RR_FRAME_SCALE),
              (int) Math.round(RR_HEIGHT * RR_FRAME_SCALE));
      frame.setLocationRelativeTo(null);
      RotateRectangle rect = new RotateRectangle(frame);
      frame.add(rect);
      frame.setVisible(true);

   }

}
