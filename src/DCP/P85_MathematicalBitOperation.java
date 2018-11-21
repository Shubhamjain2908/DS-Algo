/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

/**
 * Facebook
 * @author SHUBHAM
 * Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0.
 */
public class P85_MathematicalBitOperation 
{
    public static void main(String[] args) 
    {
        int x = 12;
        int y = 78;
        int b = 1;
//        System.out.println(getB(x, y, b));
b();
    }
    private static int getB(int x, int y, int b)
    {
        return b&x | b^y;
    }
    private static void b()
    {
        int a = 23; 
        int b = 21;
        int c = 0;
  
        // bitwise and 
        // 0101 & 0111=0101 = 5 
        System.out.println("a&b = " + (a & b)); 
  
        // bitwise or 
        // 0101 | 0111=0111 = 7 
        System.out.println("a|b = " + (a | b)); 
  
        // bitwise xor 
        // 0101 ^ 0111=0010 = 2 
        System.out.println("a^b = " + (a ^ b)); 
  
        // bitwise and 
        // ~0101=1010 
        // will give 2's complement of 1010 = -6 
        System.out.println("~a = " + ~a); 
  
        // can also be combined with 
        // assignment operator to provide shorthand 
        // assignment 
        // a=a&b 
        a &= b; 
        System.out.println("a= " + a); 
    }
}
