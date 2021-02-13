/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2dswing.applications;

import java2dswing.applications.ControllDrawing;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java2dswing.applications.Drawable;

/**
 *
 * @author owner
 */
public abstract class DrawPanel extends ControllDrawing {
   
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
         getDrawables().forEach((d) -> {
            d.paint(this, g2d);
         });
			g2d.dispose();
		}

		public void addDrawable(Drawable drawable) {
			getDrawables().add(drawable);
			repaint();
		}
	}
