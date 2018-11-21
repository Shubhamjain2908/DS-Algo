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
public class HouseBuilding {
    public static void main(String[] args) {
        buildLayout(20);
    }
    public static void buildLayout(int height) {
        if (height == 0) return;
        System.out.println(height);
        buildLayout(height - 1);
        
    }
}
