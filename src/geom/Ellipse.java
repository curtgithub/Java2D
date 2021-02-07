/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geom;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owner
 */
public class Ellipse {

   private double semiMajorAxis = Double.MIN_NORMAL;
   private double semiMinorAxis = Double.MIN_NORMAL;

   private void checkForPositiveValues() throws Exception {
      if (this.semiMajorAxis < Double.MIN_NORMAL || this.semiMinorAxis < Double.MIN_NORMAL) {
         throw new Exception("Ellipse must have a greater than 0 semi-major and minor values.");
      }
   }

   public Ellipse() {
   }

   public Ellipse(double semiMajorAxis, double semiMinorAxis) throws Exception {
      this.semiMajorAxis = semiMajorAxis;
      this.semiMinorAxis = semiMinorAxis;
      checkForPositiveValues();
   }

   public double getSemiMajorAxis() {
      return semiMajorAxis;
   }

   public void setSemiMajorAxis(double semiMajorAxis) throws Exception {
      this.semiMajorAxis = semiMajorAxis;
      this.checkForPositiveValues();
   }

   public double getSemiMinorAxis() {
      return semiMinorAxis;
   }

   public void setSemiMinorAxis(double semiMinorAxis) throws Exception {
      this.semiMinorAxis = semiMinorAxis;
      this.checkForPositiveValues();
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 43 * hash + (int) (Double.doubleToLongBits(this.semiMajorAxis) ^ (Double.doubleToLongBits(this.semiMajorAxis) >>> 32));
      hash = 43 * hash + (int) (Double.doubleToLongBits(this.semiMinorAxis) ^ (Double.doubleToLongBits(this.semiMinorAxis) >>> 32));
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Ellipse other = (Ellipse) obj;
      if (Double.doubleToLongBits(this.semiMajorAxis) != Double.doubleToLongBits(other.semiMajorAxis)) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "Ellipse{" + "semiMajorAxis=" + semiMajorAxis + ", semiMinorAxis=" + semiMinorAxis + '}';
   }

   public void setWidthHeight(double width, double height) throws Exception {
      this.setSemiMajorAxis(width / 2.0d);
      this.setSemiMinorAxis(height / 2.0d);
   }

   public void setWidth(double width) throws Exception {
      this.setSemiMajorAxis(width / 2.0d);
   }

   public double getWidth() {
      return this.getSemiMajorAxis() / 2.0d;
   }

   public void setHeight(double height) throws Exception {
      this.setSemiMinorAxis(height / 2.0d);
   }

   public double getHeight() {
      return this.getSemiMinorAxis() / 2.0d;
   }

   //
   // TODO: Setters and getters for foci and eccentricty.
  //
   public double calcArea() {
      double area;
      area = Math.PI * this.getSemiMajorAxis() * this.getSemiMinorAxis();
      return area;
   }

   //
   // TODO: Calculate circumference. 
   //
   public static void main(String[] args) {
      System.out.println("Ellipse.main running...\n");

      try {
         Ellipse e = new Ellipse(4.0d, -2.0d);
         System.out.println("4x2 ellipse has an area = " + e.calcArea() + "\n");
      } catch (Exception ex) {
         Logger.getLogger(Ellipse.class.getName()).log(Level.SEVERE, 
                 "An Ellipse must have a positive semi-major and minor axis!", ex);
      }

      try {
         Ellipse e = new Ellipse(4.0d, 2.0d);
         System.out.println("4x2 ellipse has an area = " + e.calcArea() + "\n");
      } catch (Exception ex) {
         Logger.getLogger(Ellipse.class.getName()).log(Level.SEVERE, null, ex);
      }

      System.out.println("Ellipse.main exiting...\n");
   }
}
