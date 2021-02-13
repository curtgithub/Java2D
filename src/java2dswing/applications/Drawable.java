/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dswing.applications;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 *
 * @author owner
 */
public interface Drawable {

   public void paint(JComponent parent, Graphics2D g2d);

   public void setLocation(Point location);

   public void setSize(Dimension size);

   // TODO public DrawingApplication.State getState();

   public Rectangle getBounds();
}
