/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class MaxSubsquaresWithSideX 
{
    public static void main(String[] args) 
    {
        int[][] mat = {
            {0,0,0,0,1},
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,1,1,1,1},
            {0,0,1,1,1}
        };
        System.out.println(maxSquare(mat));
    }
    private static int maxSquare(int[][] mat)
    {
        int V = mat.length;
        int max = 1;
        List<int[]>[][] adjListArray = new ArrayList[V][V];
        for (int i = 0; i < V; i++) 
        {
            for (int j = 0; j < V; j++) 
            {
                adjListArray[i][j] = new ArrayList<>();
            }
        }
        
        for (int i = 0; i < V; i++) 
        {
            for (int j = 0; j < V; j++) 
            {
                List<int[]> l = new ArrayList<>();
                int[] c = new int[2];
                if (mat[i][j] == 1) 
                {
                    c[0] = 1;
                    c[1] = 1;
                    if (i>0) 
                    {
                        c[0] += adjListArray[i-1][j].get(0)[0];
                    }
                    if (j>0) 
                    {
                        c[1] += adjListArray[i][j-1].get(0)[1];
                    }
                }
                else 
                {
                    c[0] = 0;
                    c[1] = 0;
                }
                l.add(c);
                adjListArray[i][j] = l;  
                System.out.print(Arrays.toString(adjListArray[i][j].get(0)) + " ");
            }
            System.out.println("");
        }
        for (int i = V-1; i >= 0; i--) 
        {
            for (int j = V-1; j >= 0; j--) 
            {
                int x = adjListArray[i][j].get(0)[0];
                int y = adjListArray[i][j].get(0)[1];
                if (y==0 || y==1 || x==1) {
                    continue;
                }
                int min = Math.min(x, y);
                System.out.println("min " + min );
                int k=0;
                for(k=min; k > 1; k--){
                    if(adjListArray[i][j-k+1].get(0)[1] >= k && adjListArray[i-k+1][j].get(0)[0] >= k){
                        break;
                    }
                }
                if (k >= max) {
                    max = k;
                    
                }
            }
        }
        return max;
    }
}
