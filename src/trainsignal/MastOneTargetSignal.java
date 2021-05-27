/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainsignal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author owner
 */
public class MastOneTargetSignal {

   private JFrame frame;
   private JPanel panel;

   public MastOneTargetSignal(JFrame frame, JPanel panel) {
      this.frame = frame;
      this.panel = panel;
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500, 1000);
      frame.setLocationRelativeTo(null);
      frame.add(panel);
      frame.setVisible(true);

   }

   public static class SignalFrame extends JFrame {

      public SignalFrame(String title) throws HeadlessException {
         super(title);
         init();

      }

      private void init() {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

   }

   public static class SignalPanel extends JPanel {

      private Rectangle2D mast;
      private Ellipse2D target;
      private Ellipse2D lens;

      public SignalPanel() {
         init();
         //
         // Draw Target Signal
         //
         mast = new Rectangle2D.Double(240, 90, 20, 500);
         target = new Ellipse2D.Double(214, 64, 73, 73);
         lens = new Ellipse2D.Double(240, 90, 20, 20);
      }

      @Override
      public void paintComponent(Graphics g) {

         Graphics2D g2d = (Graphics2D) g.create();
         //
         // Clear the frame
         //
         g2d.clearRect(0, 0, 50, 50);
         //
         //  TODO: Read about rendering hints
         //
         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);

         g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                 RenderingHints.VALUE_RENDER_QUALITY);
         //
         // Translate the circle to the the frame's center
         //
         // g2d.translate(fd.getWidth() / 2, fd.getHeight() / 2);
         //
         // Draw and fill the mast
         //
         g2d.setColor(Color.WHITE);
         g2d.draw(mast);
         g2d.setColor(Color.GRAY.brighter());
         g2d.fill(mast);
//
         // Draw and fill the target
         //
         g2d.setColor(Color.WHITE);
         g2d.draw(target);
         g2d.setColor(Color.BLACK);
         g2d.fill(target);
         //
         // Draw and fill the targe
         //
         g2d.setColor(Color.WHITE);
         g2d.draw(lens);
         g2d.setColor(Color.GREEN.brighter());
         //g2d.setColor(Color.GRAY.darker());
         g2d.fill(lens);
      }

      private void init() {
         setSize(500, 1000);

      }
   }

   public static void main(String[] args) {
      SignalFrame sf = new SignalFrame("Target Signal");
      SignalPanel sp = new SignalPanel();
      MastOneTargetSignal ts = new MastOneTargetSignal(sf, sp);

   }

}
