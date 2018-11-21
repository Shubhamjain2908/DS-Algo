/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.util.Scanner;

/**
 *
 * @author SHUBHAM
 */
public class Maze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = "";
        for (int i = 1; i < N; i++) {
            str += fib(i) + "," + nthPrime(i) + ",";
            
        }
        String[] s = str.split(",");
        System.out.println(s[s.length - 1]);
    }
    private static boolean isPrime(int n) {
        for(int i = 2; i < n; ++i) {
            if (n % i == 0) {
                // We are naive, but not stupid, if
                // the number has a divisor other
                // than 1 or itself, we return immediately.
                return false;
            }
        }
        return true;
    }
    public static int nthPrime(int n) {
        int candidate, count;
        for(candidate = 2, count = 0; count < n; ++candidate) {
            if (isPrime(candidate)) {
                ++count;
            }
        }
        // The candidate has been incremented once after the count reached n
        return candidate-1;
    }
    public static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    
}
