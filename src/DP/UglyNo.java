/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author SHUBHAM
 *  Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
    Given a number n, the task is to find n’th Ugly number.
 */
public class UglyNo 
{
    public static void main(String[] args) 
    {
        int n = 10;
        System.out.println("Count "+getUgly(n));
    }
    
    // O(n) && S(1)
    private static int getUgly(int n)
    {
        int i=1;
        int count = 1;
        System.out.print("1 ");
        while(n > count)
        {
            i++;
            if (isUgly(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("");
        return count;
    }
    private static boolean isUgly(int n)
    {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);
        return n==1;
    }
    private static int maxDivide(int a, int b){
        while(a%b == 0)
            a = a/b;
        return a;
    }   
}
