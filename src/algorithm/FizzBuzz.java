/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.Scanner;

/**
 *
 * @author SHUBHAM
 */
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number");
        int n =sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if(i%3==0)
            {
                if (i%5==0) {
                    System.out.println("FizzBuzz");
                }
                System.out.println("Fizz");
            }
            else if(i%5==0) 
            {
                System.out.println("Buzz");
            }
            else 
            {
                System.out.println(i);
            }
        }
    }
}
