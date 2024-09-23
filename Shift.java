/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import javax.swing.JOptionPane;

/**
 *
 * @author dytli
 */
public class Shift {
    public static void main(String args[]) {
        JOptionPane.showMessageDialog(null, "REAL SHIFT | V0.1");
        
        String input = "";
        int stage = 0;
        while(true) {
            if (stage == 0) {
                input = JOptionPane.showInputDialog("Give me a string");
                if (input == null) {
                    break;
                }
                
                if (input.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Please give me a string with at least 1 character.");
                    continue;
                }
                
                stage = 1;
            } else if (stage == 1) {
                String shiftAmount = JOptionPane.showInputDialog("How much would you like to shift \""+input+"\"?");
                
                if (shiftAmount == null) {
                    stage = 0;
                    continue;
                }
                
                try {
                    int shiftAmountInt = Integer.parseInt(shiftAmount);
                    JOptionPane.showMessageDialog(null, 
                            "Original: "+input+"\nNew:    "+ShiftString(input, shiftAmountInt)+"\nShift amount: "+shiftAmountInt);
                    stage = 0;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, shiftAmount+" is not a valid integer. Try again.");
                }
            }
            
        }
        JOptionPane.showMessageDialog(null, "Goodbye");
    }
    
    public static String ShiftString(String s, int amount) {
        int sLen = s.length();
        char[] out = new char[sLen]; 
        
        int index = 0;
        for(char c: s.toCharArray()) {
            out[(index + amount) % sLen] = c;
            index++;
        }
        
        return new String(out);
    }
}
