/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author SHUBHAM
 */
import java.util.*;

public class HashTablesIceCreamParlor {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        // Complete this function
        if (cost == null || cost.length < 1) {
            System.out.println(-1 + " " + -1);
            return;
        }

        // core logic
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] < money) {
                if (hashMap.containsKey(money - cost[i])) {
                    int index = hashMap.get(money - cost[i]);
                    System.out.println((index + 1) + " " + (i + 1));
                    return;
                }

                if (!hashMap.containsKey(cost[i])) {
                    hashMap.put(cost[i], i);
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        int[] cost = {1, 4, 5, 3, 2};
        int[] cost2 = {2,2,4,3};
        int[] cost3 = {1, 2, 3, 5, 6};
        int[] cost4 = {4, 3, 2, 5, 7};
        int[] cost5 = {7, 2, 5, 4, 11};
        int money = 4;
        int money2 = 4;
        int money3 = 5;
        int money4 = 8;
        int money5 = 12;
        whatFlavors(cost5, money5);
    }

}
