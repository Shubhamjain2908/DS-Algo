/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 *
 * @author SHUBHAM
 */
public class HackerEarth_FreedoArray {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in)))
        { 
            int size = Integer.valueOf(bufferedReader.readLine());
            String[] numbers = bufferedReader.readLine().split(" ");
            int[] arr = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
            int sumArr = Arrays.stream(arr).sum();
            int x = Math.abs(sumArr/size);
            if (x*size <= sumArr) {
                x += 1;
            }
            System.out.println(x);
        }
        catch(Exception e){}
    }
}
