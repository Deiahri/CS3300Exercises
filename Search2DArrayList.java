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
public class Search2DArrayList {
    public static void main(String args[]) {
        int[][] matrix = { { 1,1,3,1,5 },{ 1,1,3,1,5 },{ 1,1,3,1,5 },{ 1,1,3,1,5 },{ 1,1,3,1,5 } };
        int[][] matrix2 = { { 1,2,3,4,5,6,7,8,9,10 },{ -2,-1,2,1},{ },{ 2,2,2 }};
        
        
        ArrayList<ArrayList<Integer>> Data1 = ConvertMatrixToMatrixList(matrix);
        ArrayList<ArrayList<Integer>> Data2 = ConvertMatrixToMatrixList(matrix2);
        
        // // output array lists
        // System.out.println(Data1);
        // System.out.println(Data2);
        
        // use function to get even coordinates in ArrayList<String>
        ArrayList<String> Data1EvenCoords = SearchEven(Data1);
        ArrayList<String> Data2EvenCoords = SearchEven(Data2);
        
        // use function to handle outputting coordinates
        System.out.println("Data1 Results:");
        Display_Locations(Data1EvenCoords);
        
        System.out.println("\nData2 Results:");
        Display_Locations(Data2EvenCoords);
    }
    
    
    public static void Display_Locations(ArrayList<String> locations) {
        // if first index of locations contains -1 (which usually only happens if no even coords were found)
        // outputs special message
        if (locations.get(0).equals("-1")) {
            System.out.println("This vector did not have any even numbers.");
            
            // exits function
            return;
        }
        
        // outputs each coord on a separate line
        for(String coord:locations) {
            System.out.println(coord);
        }
    }
    
    // searches a 2D array list and stores the coordinates of every even number
    // in the returned array list
    public static ArrayList<String> SearchEven(ArrayList<ArrayList<Integer>> nums) {
        ArrayList<String> coords = new ArrayList<String>();
        
        // searches every row in nums
        for (int i = 0; i < nums.size(); i++) {
            // searches every item in row
            for(int j = 0; j < nums.get(i).size(); j++) {
                // adds coordinates (row) (col) as string to coord array list
                if (nums.get(i).get(j) % 2 == 0) {
                    coords.add(i+" "+j);
                }
            }
        }
        
        // add -1 to coords if coords is empty
        if (coords.isEmpty()) {
            coords.add("-1");
        }
        return coords;
    }
    
    
    // takes in a matrix and converts it to a matrix array list.
    // essentially int[][] --> ArrayList<ArrayList<Integer>>
    // this is done twice, so I created a function to run it twice.
    public static ArrayList<ArrayList<Integer>> ConvertMatrixToMatrixList(int[][] dataArray) {
        ArrayList<ArrayList<Integer>> dataArrayList = new ArrayList<ArrayList<Integer>>();
        
        // copy each number from the data array to the array list
        for(int i = 0; i < dataArray.length; i++) {
            // create array list row
            ArrayList<Integer> row = new ArrayList<Integer>();
            
            for(int j = 0; j < dataArray[i].length; j++) {
                // copy each value in the array row to the arrayList row
                row.add(dataArray[i][j]);
            }
            
            // push array list row to arrayList matrix
            dataArrayList.add(row);
        }
        return dataArrayList;
    }
}
