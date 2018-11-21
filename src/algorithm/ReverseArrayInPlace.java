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
public class ReverseArrayInPlace {
    public static void main(String[] args) {
        ReverseArrayInPlace rev = new ReverseArrayInPlace();
        Object[] ar = {12, 34, 43, 2, 22, 111};
        Object[] ar2 = rev.a(ar);
        for (Object ar21 : ar2) {
            System.out.println(ar21);
        }
    }
    public Object[] a(Object[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            Object temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}
