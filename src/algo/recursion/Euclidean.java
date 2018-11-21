/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.recursion;

/**
 *
 * @author SHUBHAM
 * If we subtract smaller number from larger (we reduce larger number), GCD doesn’t change. So if we keep subtracting repeatedly the larger of two, we end up with GCD.
 * Now instead of subtraction, if we divide smaller number, the algorithm stops when we find remainder 0.
 */
public class Euclidean {
    public static void main(String[] args) {
        System.out.println(eu(10, 15));
    }
    public static int eu(int n1, int n2) {
        if(n2 == 0) return n1;
        return eu(n2, n1%n2);
    }
}
