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
public class SecondHighest 
{
    public static void main(String[] args) 
    {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(secondHighest(arr));
    }
    private static int secondHighest(int[] arr) 
    {
        int f = 0;
        int s = 0;
        
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] > f) {
                s = f;
                f = arr[i];
            } else if(arr[i] > s){
                s = arr[i];
            }
        }
        
        return s;
    }
}
