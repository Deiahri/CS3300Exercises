/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;


// // not needed in this case, but this is how you would import it if it
// // wasn't in the same package
//import practice.Odometer;


/**
 *
 * @author dytli
 */
public class OdometerTest {
    public static void main(String args[]) {
        Odometer fuelEfficient = new Odometer();
        Odometer gasGuzzler = new Odometer();
        
        fuelEfficient.setMpg(50);
        gasGuzzler.setMpg(10);
        
        System.out.println("For your fuel efficient car:");
        fuelEfficient.addMileage(100);
        System.out.println("After 100 miles, "+fuelEfficient.getGallonsConsumed()+" gallons used.");
        fuelEfficient.addMileage(50);
        System.out.println("After another 50 miles, "+fuelEfficient.getGallonsConsumed()+" gallons used.");
        
        
        System.out.println("\n\nFor your gas guzzler car:");
        gasGuzzler.addMileage(100);
        System.out.println("After 100 miles, "+gasGuzzler.getGallonsConsumed()+" gallons used.");
        gasGuzzler.addMileage(50);
        System.out.println("After another 50 miles, "+gasGuzzler.getGallonsConsumed()+" gallons used.");
        
    }
}
