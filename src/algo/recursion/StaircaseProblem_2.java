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
public class StaircaseProblem_2 {
    
    final static int[] arr = {1,3,5};
    
    public static void main(String[] args) {
        //System.out.println(noOfWays(4));
        System.out.println(noOfWaysBottomUp(40));
    }
    // Bad Algorithm
    public static int noOfWays(int n) 
    {
        
        if (n==0) return 1;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            if(n-i>=0)
            {
                total += noOfWays(n-i);
            }
        }
        return total;
    }
    // DP
    public static int noOfWaysBottomUp(int n) 
    {
        if(n==0) return 1;
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) 
        {
            int total = 0;
            for (int j = 0; j < arr.length; j++) 
            {
                if (i - j >=0) {
                    total += nums[i-j];
                }
            }
            nums[i] = total;
        }
        return nums[n];
    }
}
