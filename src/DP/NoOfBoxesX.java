/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author SHUBHAM
 */
public class NoOfBoxesX {
    public static void main(String[] args) {
        int[][] mat = {
                    {0,1,1,1,1},
                    {1,1,0,1,0},
                    {1,0,1,1,1},
                    {1,1,1,0,1},
                    {0,1,1,1,1}};
        System.out.println(countBox(mat));
    }
    private static int countBox(int[][] mat)
    {
        int n = mat.length;
        int total = (n * (n+1) * (2*n+1))/6;
        int[][] box = new int[n][n];
        int[][] reduction = new int[n][n];
        
        if (mat[0][0] == 0) {
            box[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (mat[0][i] == 0) {
                box[0][i] += box[0][i-1] + 1;
            } else {
                box[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (mat[i][0] == 0) {
                box[i][0] += box[i-1][0] + 1;
            } else {
                box[i][0] = 1;
            }
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                box[i][j] = box[i-1][j] + box[i][j-1] - box[i-1][j-1] + reducedBox(mat, i, j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println(" ");
        }
        
        return total - box[n-1][n-1];
    }
    
    private static int reducedBox(int[][] mat, int i, int j)
    {
        int noOfBox = Math.min(i, j) + 1;
        if (mat[i][j] == 0) {
            return noOfBox;
        }
        int count = 0;
        for (int k = 0; k < noOfBox; k++) {
            for (int l = i - k; l < i; l++) {
                for (int m = j - k ; m < j; m++) {
                    if (mat[l][m] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
