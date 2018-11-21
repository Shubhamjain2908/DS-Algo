/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author SHUBHAM
 */
class HackerEarth_CommonFactors {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in)))
        { 
            String[] numbers = bufferedReader.readLine().split(" ");
            if (numbers.length == 2) {
                System.out.println(commDiv(Long.valueOf(numbers[0]),Long.valueOf(numbers[1])));
            } else{
                System.out.println("Only Two numbers are allowed");
            }
            
        }
        catch(Exception e){}
    }
    public static Long gcd(Long a, Long b)
    {
        if (a == 0) 
            return b;
         
        return gcd(b%a,a);
    }
    // method to calculate all common divisors
    // of two given numbers
    // a, b --> input integer numbers
    public static int commDiv(Long a,Long b)
    {
        // find gcd of a,b
        Long n = gcd(a, b);
      
        // Count divisors of n.
        int result = 0;
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            // if 'i' is factor of n
            if (n%i==0)
            {
                // check if divisors are equal
                if (n/i == i)
                    result += 1;
                else
                    result += 2;
            }
        }
        return result;
    }
}
