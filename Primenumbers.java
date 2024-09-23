/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.util.Scanner;

/**
 *
 * @author dytli
 */
public class Primenumbers {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        
        String in;
        while (true) {
            System.out.print("Print prime numbers till (type quit to exit.): ");
            in = scan.nextLine();
            if (in.trim().toLowerCase().equals("quit")) {
                break;
            }
            try {
                int ceil = Integer.parseInt(in);
                printPrime(1, ceil);
            } catch (Exception e) {
                System.out.println("\n\nThat is not a valid integer");
            }
        }
        System.out.println("\n\nGoodbye");
    }
    
    public static void printPrime(int floor, int ceil) {
        if (floor < 1) {
            return;
        }
        
        for(int i = floor; i <= ceil; i++) {
            boolean prime = true;
            for(int k = 2; k < i; k++) {
                if (i % k == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.print(i+", ");
            }
        }
        System.out.println();
    }
}
