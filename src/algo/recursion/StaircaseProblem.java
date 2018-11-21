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
public class StaircaseProblem {
    public static void main(String[] args) {
        
        System.out.println(noOfWaysBottomUp(4000));
        //System.out.println(noOfWays(400));
    }
    // Bad Algorithm
    public static int noOfWays(int stair) {
        if(stair==0 || stair==1) return 1;
        return noOfWays(stair-1) + noOfWays(stair-2);
    }
    public static int noOfWaysBottomUp(int stair) {
        if (stair == 0|| stair ==1) return 1;
        int[] nums = new int[stair+1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= stair; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[stair];
    }
}
