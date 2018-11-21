/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.util.*;

/**
 *
 * @author SHUBHAM
 */
public class PoS {
    public static void main(String[] args) {
        String test = "awhfy";
        List<String> s = permutate( test.toCharArray() , 0 , new ArrayList<>());
        System.out.println(s.get(s.indexOf(test) + 1));
    }
    public static List<String> permutate( char[] str, int index, List<String> set )
    {
        int i = 0;
        if( index == str.length )
        { 
            String st = ""; 
            for (int j = 0; j < str.length; j++) {
                st += str[j];
            }
            set.add(st);
        }
        char temp ;
        for( i = index; i < str.length; i++ )
        {
            temp = str[index];
            str[index] = str[i];
            str[i] = temp;
            
            permutate( str, index + 1, set );
            
            temp = str[index];
            str[index] = str[i];
            str[i] = temp;
        }
        Collections.sort(set);
        return set;
    }
    
}
