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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author owner
 */
public class MastTwoTargetSignals {

   private JFrame frame;
   private JPanel aspectPanel;
   private JPanel signalPanel;
   private JSplitPane splitPane;

   public MastTwoTargetSignals(JFrame frame, JPanel aspectPanel, JPanel signalPanel) {
      this.frame = frame;
      this.aspectPanel = aspectPanel;
      this.signalPanel = signalPanel;
      splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
              aspectPanel, signalPanel);
      splitPane.setSize(500, 1000);
      this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.frame.setSize(500, 1000);
      this.frame.setLocationRelativeTo(null);
      this.frame.add(splitPane);
      this.frame.setVisible(true);

   }

   public static class RunSignalFrame extends JFrame {

      public RunSignalFrame(String title) throws HeadlessException {
         super(title);
         init();

      }

      private void init() {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

   }

   public static class SignalPanel extends JPanel {

      private Rectangle2D mast;
      private Ellipse2D upperTarget;
      private Ellipse2D upperLens;
      private Ellipse2D lowerTarget;
      private Ellipse2D lowerLens;

      public SignalPanel() {
         init();
         //
         // Draw 2 Target Signals
         //
         mast = new Rectangle2D.Double(240, 90, 20, 500);
         upperTarget = new Ellipse2D.Double(214, 64, 73, 73);
         upperLens = new Ellipse2D.Double(240, 90, 20, 20);
         lowerTarget = new Ellipse2D.Double(214, 160, 73, 73);
         lowerLens = new Ellipse2D.Double(240, 186, 20, 20);

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
         // Draw and fill the upperTarget
         //
         g2d.setColor(Color.WHITE);
         g2d.draw(upperTarget);
         g2d.setColor(Color.BLACK);
         g2d.fill(upperTarget);
         //
         // Draw and fill the upperLens
         //
         g2d.setColor(Color.WHITE);
         g2d.draw(upperLens);
         g2d.setColor(Color.GREEN.brighter());
         //g2d.setColor(Color.GRAY.darker());
         g2d.fill(upperLens);
         //
         // Draw and fill the lowerTarget
         //
         g2d.setColor(Color.WHITE);
         g2d.draw(lowerTarget);
         g2d.setColor(Color.BLACK);
         g2d.fill(lowerTarget);
         //
         // Draw and fill the lowerLens
         //
         g2d.setColor(Color.WHITE);
         g2d.draw(lowerLens);
         g2d.setColor(Color.RED.brighter());
         //g2d.setColor(Color.GRAY.darker());
         g2d.fill(lowerLens);
      }

      private void init() {
         setSize(250, 1000);

      }
   }

   public static class AspectPanel extends JPanel {

      private JList<String> signalRuleNames;

      public AspectPanel() {
         init();

      }

      private void init() {
         setSize(250, 1000);
         DefaultListModel<String> listModel = new DefaultListModel<>();
         //
         // SEE: https://signals.jovet.net/rules/NORAC%20Signal%20Rules.pdf
         //
         listModel.addElement("CLEAR");
         listModel.addElement("CAB SPEED");
         listModel.addElement("APPROACH LIMITED");
         listModel.addElement("LIMITED CLEAR");
         listModel.addElement("APPROACH MEDIUM");
         listModel.addElement("ADVANCE APPROACH");
         listModel.addElement("MEDIUM CLEAR");
         listModel.addElement("APPROACH SLOW ");
         listModel.addElement("APPROACH");
         listModel.addElement("RESTRICTING");
         listModel.addElement("STOP SIGNAL");
//create the list
         signalRuleNames = new JList<>(listModel);
         add(signalRuleNames);

      }
   }

   public static void main(String[] args) {

      RunSignalFrame runSignalFrame = new RunSignalFrame("2 Target Signals");
      AspectPanel aspectPanel = new AspectPanel();
      SignalPanel signalPanel = new SignalPanel();
      MastTwoTargetSignals runSignal = new MastTwoTargetSignals(runSignalFrame, aspectPanel, signalPanel);

   }

}
