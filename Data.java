/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author dytli
 */
public class Data {
    private ArrayList<Integer> numbers;
    public Data() {
        this.numbers = new ArrayList<Integer>();
    }
    
    public void addNumber(int num) {
        numbers.add(num);
    }
    
    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }
    
    public int indexOf(int num) {
        return numbers.indexOf(num);
    }
    
    public void deleteNumbers() {
        this.numbers.clear();
    }
}
