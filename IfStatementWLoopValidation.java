/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;


// import JOPTIONPANEEEEEE AHHHHHHHHHHH
import javax.swing.JOptionPane;


public class IfStatementWLoopValidation {
    public static void main(String args[]) {
        // NOTE: Choose which one you wish to run.
        
        // has no loop validation
        // noLoopValidation();
        
        // has loop validation
         loopValidation();
    }
    
    public static void noLoopValidation() {
        // initializes two doubles with no values.
        double num1 = 0, num2 = 0;
        
        
        // put input getting statement in try-catch because it is possible
        // the value given will be invalid and cannot be converted into a number
        try {
            // take in first number, and try to convert it to a double at the same time
            num1 = Double.parseDouble(JOptionPane.showInputDialog("Give me number"));
        } 
        // we expect to catch a number format exception from converting invalid
        // input into a number
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Your number is invalid.");
            
            // forces program to stop | 0 = exit code (I don't know what 0 means though)
            System.exit(0);
        }
        
        
        // do the same thing as the first one
        try {
            num2 = Double.parseDouble(JOptionPane.showInputDialog("Give me number 2nd number"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Your number is invalid.");
            System.exit(0);
        }
        
        if (num1 > num2) {
            JOptionPane.showMessageDialog(null, num1+">"+num2);
        } else if (num1 < num2) {
            JOptionPane.showMessageDialog(null, num1+"<"+num2);
        } else {
            JOptionPane.showMessageDialog(null, num1+"="+num2);
        }
        
        // note: the numbers show up with a decimal because they are doubles.
        // if they were integers, they would not show up with a decimal.
    }
    
    
    // same thing as the first one, except it loops instead of exiting when the number is incorrect.
    public static void loopValidation() {
        
        // initializes two doubles with no values.
        double num1 = 0, num2 = 0;
        boolean valid1 = false, valid2 = false;
        
        // put input getting statement in try-catch because it is possible
        // the value given will be invalid and cannot be converted into a number
        while (!valid1) {
            try {
                // take in first number, and try to convert it to a double at the same time
                num1 = Double.parseDouble(JOptionPane.showInputDialog("Give me number"));
               
                // if successfully converts input to number, it will set valid1 to true
                // this results in the loop exiting.
                valid1 = true;
            } 
            // we expect to catch a number format exception from converting invalid
            // input into a number
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Your number is invalid.");
            }
        }
        
        while (!valid2) {
            // do the same thing as the first one
            try {
                num2 = Double.parseDouble(JOptionPane.showInputDialog("Give me number 2nd number"));
                valid2 = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Your number is invalid.");
            }
        }
        
        if (num1 > num2) {
            JOptionPane.showMessageDialog(null, num1+">"+num2);
        } else if (num1 < num2) {
            JOptionPane.showMessageDialog(null, num1+"<"+num2);
        } else {
            JOptionPane.showMessageDialog(null, num1+"="+num2);
        }
        
        // note: the numbers show up with a decimal because they are doubles.
        // if they were integers, they would not show up with a decimal.
    }
}
