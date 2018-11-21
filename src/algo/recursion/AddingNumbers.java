/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.recursion;

/**
 *
 * @author SHUBHAM
 */
public class AddingNumbers {
    public static void main(String[] args) {
        System.out.println(add(10));
    }
    public static int add(int n) {
        if (n == 1) return 1;
        return n + add(n-1);
    }
}
