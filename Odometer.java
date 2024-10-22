/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

/**
 *
 * @author dytli
 */
public class Odometer {
    private double mileage = 0;
    private double mpg = 0;
    private double gallonsConsumed = 0;
    
    // this is the constructor of Odometer.
    // when you do Odometer o = new Odometer(1, 5, 2);
    // 1, 5, and 2, are sent here.
    
    // in this case, there are no parameters required to initialize an Odometer object.
    public Odometer() {
    }
    
    public void resetOdometer() {
        this.gallonsConsumed = 0;
        this.mileage = 0;
    }
    
    public void setMpg(double newMpg) {
        this.mpg = newMpg;
    }
    
    public void addMileage(double m) {
        this.mileage += m;
        
        double gallonsRequired = m/this.mpg;
        this.gallonsConsumed += gallonsRequired;
    }
    
    public double getMileage() {
        return this.mileage;
    }
    
    public double getGallonsConsumed() {
        return this.gallonsConsumed;
    }
}
