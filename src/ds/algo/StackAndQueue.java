/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author SHUBHAM
 */
public class StackAndQueue {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        String[] stackElem = br.readLine().split(" ");
        ArrayList<Integer> st = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            //st.push(Integer.valueOf(stackElem[i]));
            st.add(Integer.valueOf(stackElem[i]));
        }
        Collections.sort(st);
        //Collections.reverse(st);
        int sum = 0;
        for (int i = K; i < st.size(); i++) {
            sum += st.get(i);
        }
        System.out.println(sum);
    }
}
