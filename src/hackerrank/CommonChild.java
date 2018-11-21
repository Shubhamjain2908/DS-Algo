/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author SHUBHAM
 */
public class CommonChild {

    public static Set<String> longestCommonSubstrings(String s, String t) 
    {
        int[][] table = new int[s.length()][t.length()];
        int longest = 0;
        Set<String> result = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) 
            {
                if (s.charAt(i) != t.charAt(j)) 
                {
                    continue;
                }

                table[i][j] = (i == 0 || j == 0) ? 1 : 1 + table[i - 1][j - 1];
                if (table[i][j] > longest) 
                {
                    longest = table[i][j];
                    result.clear();
                }
                if (table[i][j] == longest) 
                {
                    result.add(s.substring(i - longest + 1, i + 1));
                }
            }
        }
        return result;
    }
    
    public static void main (String[] args) 
    {
        String str1 = "SHINCHAN";
        String str2 = "NOHARAAA";
        //Set<String> s = longestCommonSubstrings(str1, str2);
        //s.forEach(t -> System.out.println(t));
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            l.add(i);
        }
        List<Integer> l2 = l.stream().filter(t -> t<=10).collect(Collectors.toList());
        l2.forEach(t -> System.out.println(t));
    }
}
