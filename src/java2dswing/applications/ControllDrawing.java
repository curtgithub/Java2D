/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dswing.applications;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author owner
 */
public abstract class ControllDrawing extends JPanel implements MouseListener, MouseMotionListener {

   private ArrayList<Drawable> drawables;
   private JButton clear;
   private JButton undo;
   private JLabel mousePos;
   private JPanel drawPanel;
   private JPanel controlPanel;

   public void setDrawables(ArrayList<Drawable> drawables) {
      this.drawables = drawables;
   }

   public void setClear(JButton clear) {
      this.clear = clear;
   }

   public void setUndo(JButton undo) {
      this.undo = undo;
   }

   public void setMousePos(JLabel mousePos) {
      this.mousePos = mousePos;
   }

   public void setDrawPanel(JPanel drawPanel) {
      this.drawPanel = drawPanel;
   }

   public void setControlPanel(JPanel controlPanel) {
      this.controlPanel = controlPanel;
   }
   
   public ArrayList<Drawable> getDrawables() {
      return drawables;
   }

   public JButton getClear() {
      return clear;
   }

   public JButton getUndo() {
      return undo;
   }

   public JLabel getMousePos() {
      return mousePos;
   }

   public JPanel getDrawPanel() {
      return drawPanel;
   }

   public JPanel getControlPanel() {
      return controlPanel;
   }

}
