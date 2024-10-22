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
public class DataTest {
    public static void main(String args[]) {
        Data myData = new Data();
        int input = -1;
        while (true) {
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog("Choose an option\n\n0: Quit\n1: Input numbers\n2: Display numbers\n3: Search numbers\n4: Delete numbers"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Your input was not a number. Try again.");
                continue;
            }
            
            if (input == 0) {
                JOptionPane.showMessageDialog(null, "Exiting.");
                break;
            } else if (input == 1) {
                String numberInput;
                while (true) {
                    numberInput = JOptionPane.showInputDialog("Enter a number you wish to insert. (Press cancel to stop)");
                    if (numberInput == null) {
                        // exit number input loop if user presses cancel (which sets input to null)
                        break;
                    }
                    try {
                        int n = Integer.parseInt(numberInput) ;
                        myData.addNumber(n);
                        JOptionPane.showMessageDialog(null, "Inserted "+n);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "That is not a number. Try again.");
                    }
                }
            } else if (input == 2) {
                JOptionPane.showMessageDialog(null, myData.getNumbers());
            } else if (input == 3) {
                String numberInput;
                while (true) {
                    numberInput = JOptionPane.showInputDialog("Enter a number you wish to find. (Press cancel to stop)");
                    if (numberInput == null) {
                        // exit number input loop if user presses cancel (which sets input to null)
                        break;
                    }
                    try {
                        int n = Integer.parseInt(numberInput) ;
                        int searchResult = myData.indexOf(n);
                        if (searchResult == -1) {
                            JOptionPane.showMessageDialog(null, "No occurance of "+n+" found.");
                            continue;
                        }
                        JOptionPane.showMessageDialog(null, "Found "+n+" at index "+searchResult);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "That is not a number. Try again.");
                    }
                }
            } else if (input == 4) {
                myData.deleteNumbers();
                JOptionPane.showMessageDialog(null, "Number list has been reset.");
            } else {
                JOptionPane.showMessageDialog(null, "That is not a valid choice. Please choose from list of choices");
            }
        }
    }
}
