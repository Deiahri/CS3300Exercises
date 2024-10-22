/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;



// REMEMBER TO IMPORT ARRAYLIST!!!
import java.util.ArrayList;

/**
 *
 * @author dytli
 */
public class EvenOddArrayList {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> nums = generateNumbers();
        ArrayList<ArrayList<Integer>> separated = separateEvenOdd(nums);
        System.out.println(separated);
        
        // you can iterate through the array list and print out each number instead
        
        System.out.println("\n--------Even--------");
        for(int num:separated.get(0)) {
            System.out.print(num+", ");
        }
        
        System.out.println("\n--------Odd--------");
        for(int num:separated.get(1)) {
            System.out.print(num+", ");
        }
    }
    
    public static ArrayList<ArrayList<Integer>> separateEvenOdd(ArrayList<ArrayList<Integer>> nums) {
        // this array list will contain two array lists. One that contains only even numbers, and the other that contains only odd
        ArrayList<ArrayList<Integer>> evenOdd = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                // accesses current number in current row, column
                int currentNumber = nums.get(i).get(j);
                
                // determines if number is even or odd, then adds it to its respective arrayList
                if (currentNumber % 2 == 0) {
                    even.add(currentNumber);
                } else {
                    odd.add(currentNumber);
                }
            }
        }
        
        // adds both array lists to the arrayList of arrayLists (mb, this is redundant, I know).
        evenOdd.add(even);
        evenOdd.add(odd);
        return evenOdd;
    }
    
    /*
        ArrayList<Type> = arraylist containing items of type "Type"
        ArrayList<Integer> = arraylist of integers.
        ArrayList<ArrayList<Integer>> is an array list that contains array lists that contain integers.
        Essentially a 2D ArrayList
    */
    public static ArrayList<ArrayList<Integer>> generateNumbers() {
        ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
        int width = 5;
        int height = 5;
        
        for (int i = 0; i < height; i++) {
            // create a row
            ArrayList<Integer> row = new ArrayList<Integer>();
            
            for(int j = 0; j < width; j++) {
                // access each item in current row
                // generate a random number between 0 and 99.999999
                // floor that number (essentially 0-99)
                // insert the number into the current row
                row.add((int)Math.floor(Math.random()*100));
            }
            // add new row to our matrix
            nums.add(row);
        }
        return nums;
    }
}
