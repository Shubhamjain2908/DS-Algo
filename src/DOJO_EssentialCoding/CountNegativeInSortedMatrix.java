/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

/**
 *
 * @author SHUBHAM
 */
public class CountNegativeInSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{-3,-2,-1,1} ,{-2,2,3,4}, {4,5,7,8}};
        //System.out.println(countNegative(mat));
        System.out.println(func(mat, 4, 3));
    }
    
    // Optimal solution O(m+n)
    private static int func(int[][] arr, int row, int col)
    {
        int count = 0;
        int i=0, j = col-1;
        while(j>=0 && i<row){
            if (arr[i][j] < 0) {
                count += (j+1);
                i += 1;
            } else{
                j -= 1;
            }
        }
        return count;
    }
    
    // Brute force
    private static int countNegative(int[][] arr) 
    {
        int count = 0;
        for (int[] x : arr)
        {
           for (int y : x)
           {
                //System.out.print(y + " ");
                if (y<0) {
                   count++;
               }
           }
           //System.out.println();
        }
        return count;
    }
}
