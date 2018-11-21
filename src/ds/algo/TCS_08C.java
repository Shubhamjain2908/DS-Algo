/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

/**
 *
 * @author SHUBHAM
 */
import java.util.Scanner;

class TCS_08C
{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int arr[][] = new int[3][4];
    
    for(int i=0;i<3;i++){
    	for(int j=0;j<4;j++){
        	arr[i][j] = sc.nextInt();
        }
    }
    printArr(zero(arr));
  }
  
  public static int[][] zero(int[][] m){
  	int rows = m.length;
    int columns = m[0].length;
    int[][] tempArray = new int[rows][columns];
    
    for(int i=0;i<rows;i++)
    {
      for(int j=0;j<columns;j++)
      {
        tempArray[i][j] = m[i][j];
        if(m[i][j] == 0)
        {
          for(int l=0;l<rows;l++)
          {
            tempArray[l][j] = 0;
          }
          
          for(int l=0;l<columns;l++)
          {
            tempArray[i][l] = 0;
          }
        }
      }
    }
    return tempArray;
  }
  
  public static void printArr(int[][] arr){
  	for(int[] x: arr){
    	for(int y:x){
        	System.out.print(y+" ");
        }
      	System.out.println();
    }
  }
}