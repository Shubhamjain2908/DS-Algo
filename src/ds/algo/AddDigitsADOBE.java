/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

/**
 *
 * @author SHUBHAM
 */
public class AddDigitsADOBE {
    public static void main(String[] args) {
        System.out.println(add(18));
    }
    public static int add(int n)
    {
        String no = Integer.toString(n);
        int y = 0;
        for (int i = 0; i < no.length(); i++) {
            y += no.charAt(i) - '0';
        }
        if (y<=9) {
            return y;
        } 
        return add(y);
    } 
}
