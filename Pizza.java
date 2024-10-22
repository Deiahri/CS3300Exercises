/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

/**
 *
 * @author dytli
 */
public class Pizza {
    private String size;
    private int cheeseToppings;
    private int hamToppings;
    private int pepperoniToppings;
    public Pizza(String size, int cheeseToppings, int hamToppings, int pepperoniToppings) {
        // size in this scope refers to the parameter size, not the instance variable size.
        // using this.size accesses the instance variable
        // therefore this.size (instance variable) = size (parameter);
        this.size = size;
        this.cheeseToppings = cheeseToppings;
        this.hamToppings = hamToppings;
        this.pepperoniToppings = pepperoniToppings;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public void setCheeseToppings(int cheeseToppings) {
        this.cheeseToppings = cheeseToppings;
    }
    
    public void setHamToppings(int hamToppings) {
        this.hamToppings = hamToppings;
    }
    
    public void pepperoniToppings(int pepperoniToppings) {
        this.pepperoniToppings = pepperoniToppings;
    }
    
    public String getSize() {
        return this.size;
    }
    
    public int getCheeseToppings() {
        return this.cheeseToppings;
    }
    
    public int getHamToppings() {
        return this.hamToppings;
    }
    
    public int getPepperoniToppings() {
        return this.pepperoniToppings;
    }
    
    public double calcCost() {
        int total = 0;
        
        // this can be done with if statements too.
        switch (this.size) {
            case "small":
                total += 10;
                break;
            case "medium":
                total += 12;
                break;
            case "large":
                total += 14;
                break;
            default:
                System.out.println("Unrecognized pizza size "+this.size);
                return -1;
        }
        
        // $2 per topping
        total += 2*(this.cheeseToppings + this.hamToppings + this.pepperoniToppings);
        return total;
    }
    
    public String getDescription() {
        return "Size: "+this.size+", Cheese Toppings: "+this.cheeseToppings+", Ham Toppings: "+this.hamToppings+", Pepperoni Toppings: "+this.pepperoniToppings+". Cost: $"+this.calcCost();
    }
}
