/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author SHUBHAM
 */
public class Fibonacci {
    // 1,1,2,3,4,5,13,21,34...
    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        // System.out.println(fb.fibbo(3));
        System.out.println(fb.fibboR(12));
    }
    // Using Loop (O(n))
    public int fibbo(int position)
    {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 0; i < position - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    
    //Using recurssion (O(2^n))
    public int fibboR(int position) 
    {
        if (position < 3) 
        {
            return 1;
        }
        else 
        {
            return fibboR(position - 1) + fibboR(position - 2);
        }
    }
}
