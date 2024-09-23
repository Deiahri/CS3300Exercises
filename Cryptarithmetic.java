/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author dytli
 */
public class Cryptarithmetic {
    public static void main(String args[]) {
//        System.out.println(processEquation("VERY + FUNNY = LMAO"));
//        System.exit(0);
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        String equation;
        ArrayList<String> processedEquation;
        while(true) {
            equation = JOptionPane.showInputDialog("Enter an Equation\n\nEx: VERY + FUNNY = LMAO");
            if (equation == null) {
                JOptionPane.showMessageDialog(null, "Exiting.");
                System.exit(0);
            }
            processedEquation = processEquation(equation);
            if (processedEquation == null) {
                JOptionPane.showMessageDialog(null, equation+" is not a valid equation");
                continue;
            }
            break;
        }
        
        equation = equation.toUpperCase();
        
        for(char c:equation.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                continue;
            }
            letters.put(c, 0);
        }
        
        if (letters.size() > 9) {
            JOptionPane.showMessageDialog(null, "Number of unique characters exceeds 9. Unsolvable.");
            System.exit(0);
        }
        
        System.out.println(letters);
        int count = 0;
        Object[] letterKeys = letters.keySet().toArray();
        boolean success = false;
        while(!exaustedOptions(letters)) {
            char[] vals = (""+count).toCharArray();
            
            for(char key:letters.keySet()) {
                letters.put(key, 0);
            }
            for(int i = 0; i < letters.size() && i < vals.length; i++) {
                letters.put((Character)letterKeys[i], Integer.parseInt(""+vals[vals.length - i - 1]));
            }
            
            if (valuesSatisfyEquation(letters, processedEquation)) {
                success = true;
                break;
            }
            
            count++;
        }
        
        if (!success) {
            JOptionPane.showMessageDialog(null, "No such combination of values makes this equation true");
        } else {
            JOptionPane.showMessageDialog(null, "Solvable. The values are: "+letters);
        }
    }
    
    public static boolean valuesSatisfyEquation(HashMap<Character, Integer> values, ArrayList<String> equation) {
        int sum = 0;
        
        HashSet<Integer> valueSet = new HashSet<Integer>();
        for(int value:values.values()) {
            if (valueSet.contains(value)) {
                return false;
            }
            valueSet.add(value);
        }
        
        String eq = "";
        for(String chunk:equation) {
            String convertedChunk = ""+chunk.charAt(0);
            for(int index = 1; index < chunk.length(); index++) {
                convertedChunk += values.get(chunk.charAt(index));
            }
            sum += Integer.valueOf(convertedChunk);
            eq += convertedChunk += " ";
        }
//        System.out.println(eq);
        return sum == 0;
    }
    
    public static boolean exaustedOptions(HashMap<Character, Integer> options) {
        for(int i:options.values()) {
            if(i != 9){
                return false;
            }
        }
        return true;
    }
    
    public static ArrayList<String> processEquation(String equation) {
        int stage = 0;
        boolean valid = true;
        equation = equation.strip().toUpperCase();
        
        // all parts of the equation will be deposited here.
        // -ABC + CDE = ACE - BCD --> {-ABC, CDE, -ACE, BCD}
        ArrayList<String> processedEquation = new ArrayList<String>();
        String currentChunk = "";
        boolean RHS = false;
        boolean positive = true;
        for(char c:equation.toCharArray()) {
            if (stage == -1) {
                return null;
            }
            // expect first character
            else if (stage == 0) {
                if(Character.isAlphabetic(c)) {
                    positive = !RHS;
                    currentChunk += c;
                    stage = 1;
                } else if (c == '+' || c == '-') {
                    if (RHS) {
                        // invert sign if right hand side
                        positive = !(c == '+');
                    } else {
                        positive = (c == '+');
                    }
                    stage = 2;
                } else if (Character.isWhitespace(c)) {
                    // ignore white space
                } else {
                    valid = false;
                    break;
                }
            } 
            // expect more characters in chunk
            else if (stage == 1) {
                if(Character.isAlphabetic(c)) {
                    currentChunk += c;
                } else if (c == '+' || c == '-') {
                    // encountered add or subtract operator
                    // expecting new chunk after operator.
                    
                    stage = 2;
                    
                    // add current chunk
                    processedEquation.add((positive?"+":"-")+currentChunk.strip());
                    
                    // prepare for next chunk
                    currentChunk = "";
                    
                    if (RHS) {
                        // invert sign if right hand side
                        positive = !(c == '+');
                    } else {
                        positive = (c == '+');
                    }
                } else if (c == '=') {
                    // if already on the RHS, then problem
                    if (RHS) {
                        break;
                    }
                    // moving to right hand side
                    RHS = true;
                    // add current chunk
                    processedEquation.add((positive?"+":"-")+currentChunk.strip());
                    
                    // prepare for next chunk
                    currentChunk = "";
                    
                    stage = 0;
                } else if (Character.isWhitespace(c)) {
                    // ignore white space
                } else {
                    valid = false;
                    break;
                }
            } 
            // expect new character chunk after + or - operator
            else if (stage == 2) {
                if(Character.isAlphabetic(c)) {
                    currentChunk += c;
                    stage = 1;
                } else if (Character.isWhitespace(c)) {
                    continue;
                } else {
                    valid = false;
                    break;
                }
            } 
            // rightHandSide chunk processing. Expecting first character
            else {
                valid = false;
                break;
            }
        }
        if (stage != 1 && RHS) {
            System.out.println(stage + " "+ RHS);
            return null;
        }
        
        // add current chunk
        processedEquation.add((positive?"+":"-")+currentChunk.strip());
        
        System.out.println(processedEquation);
        
        return processedEquation;
    }
}
