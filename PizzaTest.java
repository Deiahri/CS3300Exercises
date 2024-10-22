/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author dytli
 */
public class PizzaTest {
    public static void main(String args[]) {
        int numPizzas = 0; // stores number of pizzas desired by user
        while (numPizzas <= 0) {
            // do try catch, as it is possible for user to input non-number
            try {
                numPizzas = Integer.parseInt(JOptionPane.showInputDialog("How many pizzas do you want?"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "That is not a valid number, please try again.");
                continue;
            }
            
            // getting out here means input was a number. Now check if number is valid
            if (numPizzas <= 0) {
                JOptionPane.showMessageDialog(null, "You must enter a non-negative number of pizzas.");
            }
        }
        
        int pizzaIndex = 0;
        
        // do for every pizza
        while (pizzaIndex < numPizzas) {
            // collect size --------------------------------
            String size = null;
            while (size == null) {
                size = JOptionPane.showInputDialog("Pizza "+(pizzaIndex+1)+". What size would you like this pizza?\n(small, medium, or large)");
                if (size == null) {
                    JOptionPane.showMessageDialog(null, "You input is null. Try again.");
                    continue;
                }
                
                // set to lower case, and trim off surrounding spaces
                size = size.toLowerCase().trim();
                
                // check if size is valid
                if (!size.equals("small") && !size.equals("medium") && !size.equals("large")) {
                    JOptionPane.showMessageDialog(null, size+" is not a valid pizza size.");
                    size = null;
                }
            }
            // ---------------------------------------------
            
            // collect num cheese toppings -----------------
            int cheeseToppings = -1;
            while (cheeseToppings == -1) {
                try {
                    cheeseToppings = Integer.parseInt(JOptionPane.showInputDialog("How much cheese toppings?"));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "That is not a number. Try again.");
                    continue;
                }
                
                if (cheeseToppings < 0) {
                    JOptionPane.showMessageDialog(null, "Number of cheese toppings cannot be negative. Try again.");
                    cheeseToppings = -1;
                }
            }
            // ---------------------------------------------
            
            
            // collect num ham toppings -----------------
            int hamToppings = -1;
            while (hamToppings == -1) {
                try {
                    hamToppings = Integer.parseInt(JOptionPane.showInputDialog("How much ham toppings?"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "That is not a number. Try again.");
                    continue;
                }
                
                if (hamToppings < 0) {
                    JOptionPane.showMessageDialog(null, "Number of ham toppings cannot be negative. Try again.");
                    cheeseToppings = -1;
                }
            }
            // ---------------------------------------------
            
            
            // collect num ham toppings -----------------
            int pepperoniToppings = -1;
            while (pepperoniToppings == -1) {
                try {
                    pepperoniToppings = Integer.parseInt(JOptionPane.showInputDialog("How much pepperoni toppings?"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "That is not a number. Try again.");
                    continue;
                }
                
                if (pepperoniToppings < 0) {
                    JOptionPane.showMessageDialog(null, "Number of pepperoni toppings cannot be negative. Try again.");
                    cheeseToppings = -1;
                }
            }
            // ---------------------------------------------
            
            
            // create the pizzas
            Pizza newPizza = new Pizza(size, cheeseToppings, hamToppings, pepperoniToppings);
            
            // print out its description
            JOptionPane.showMessageDialog(null, newPizza.getDescription());
            
            // move on to next pizza if possible
            pizzaIndex++;
        }
        
        JOptionPane.showMessageDialog(null, "Mama Mia");
    }
}
