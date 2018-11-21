/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author SHUBHAM
 */
public class TCSCodu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        try(BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in))){ 
            String[] words = bufferedReader.readLine().split(" ");
                
                ArrayList<String> list = new ArrayList<>(Arrays.asList(words));
                if(words.length == N) 
                {
                    System.out.println(calculateMod(list));
                } else {
                    System.out.println("Please enter " + N + " digits");
                }
            }
            catch(IOException exception){
                System.out.println(exception);
            }
        sc.close();
    }
    public static long calculateMod(ArrayList<String> list) {
        final long[] s = {0};
        list.forEach( t -> {
            String str = Long.toString((long) Math.pow(2, Long.valueOf(t)));
            if (str.length() > 2) {
                s[0] += Integer.valueOf(str.substring(str.length() - 2));
            } else {
                s[0] += Integer.valueOf(str);
            }
        });
        return s[0]%100;
    }
}
