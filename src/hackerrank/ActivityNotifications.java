/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Arrays;
/**
 *
 * @author SHUBHAM
 */

public class ActivityNotifications {


    static int activityNotifications(int[] expenditure, int d) 
    {
        return calculateNotifications(expenditure, d, 0);
    }
    
    static int calculateNotifications(int[] expenditure, int d, int warning)
    {
        if (expenditure.length <= d + 1) {
            return warning;
        }
        int[] e1 = Arrays.copyOfRange(expenditure, 0, d);
        int[] e2 = Arrays.copyOfRange(expenditure, 1, expenditure.length);
        
        if (expenditure[d] >= 2*median(e1)) {
            
            warning++;
        }
        
        return calculateNotifications(e2, d, warning);
    }
    
    static double median(int[] arr)
    {
        Arrays.sort(arr);
        if(arr.length %2 !=0) return arr[arr.length/2];
        return (double)(arr[arr.length/2 - 1] + arr[arr.length/2])/2;
    }

    public static void main(String[] args) {
        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int d=5;
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
    }
}
