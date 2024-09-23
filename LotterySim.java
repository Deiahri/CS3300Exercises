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
public class LotterySim {
    public static void main(String args[]) {
        int[] nums = new int[3];   
        int currentReadIndex = 0;
        while (currentReadIndex < nums.length) {
            try {    
                nums[currentReadIndex] = Integer.parseInt(JOptionPane.showInputDialog("Give me lottery #"+(currentReadIndex+1)));
                if (nums[currentReadIndex] < 0 || nums[currentReadIndex] >= 100) {
                    JOptionPane.showMessageDialog(null, "That number is not between 0 and 100 (not including 100)");
                    continue;
                }
                currentReadIndex++;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "That's not a valid Integer. Try again.");
            }
        }
        
        
        int attempts = 0;
        boolean matches = false;
        while (!matches) {
            attempts++;
            if (nums[0] != generateRandomInt(0, 100)) {
                continue;
            } else if (nums[1] != generateRandomInt(0, 100)) {
                continue;
            } else if (nums[2] != generateRandomInt(0, 100)) {
                continue;
            }
            break;
        }
        JOptionPane.showMessageDialog(null, "It took "+attempts+" attempts to "
                + "generate the given lottery numbers "
                + "("+nums[0]+", "+nums[1]+", "+nums[2]+").");
    }
    
    public static int generateRandomInt(int start, int end) {
        return (int)Math.floor(start+Math.random()*(end-start));
    }
}
