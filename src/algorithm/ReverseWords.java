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
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reversedString("My name is Shubham Jain"));
    }
    public String reversedString(String str) 
    {
        String[] a = str.split(" ");
        String aa = "";
        for (String a1 : a) {
            String reverseString = "";
            for (int j = a1.length() - 1; j >=0; j--) {
                reverseString += a1.charAt(j);
            }
            aa += reverseString + " ";
        }
        return aa;
    }
}
