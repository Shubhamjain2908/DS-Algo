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
public class PalindromeString {
    public static void main(String[] args) {
        PalindromeString palin = new PalindromeString();
        System.out.println(palin.isPallin("Shubhamjain"));
    }
    public boolean isPallin(String p) 
    {
        String x = p.replaceAll("\\s+","");
        String y ="";
        String[] a = x.split("");
        int j =0;
        for (int i = a.length -1 ; i >= 0; i--) {
            y += a[i];
            j++;
        }
        return y.equals(x);
    }
}
