/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *Errrrrrrrrrrrrrrrrrrrr
 * @author SHUBHAM
 */
import java.util.*;

public class SherlockAndTheValidString {

    static String isValid(String a) 
    {
        Map<String, Integer> map1 = new HashMap<>(); 
        
        for(int i=0;i<a.length();i++)
        {
            if(map1.containsKey(String.valueOf(a.charAt(i))))
            {
               map1.put(String.valueOf(a.charAt(i)), map1.get(String.valueOf(a.charAt(i))) + 1);  
            }
            map1.putIfAbsent(String.valueOf(a.charAt(i)), 1);
        }
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map2 = new HashMap<>(); 
        map1.entrySet().forEach(e -> set.add(e.getValue()));
        
        if (set.size() > 1) 
        {
            if (set.size() <= 2) 
            {
                List<Integer> l = new ArrayList<>();
                l.addAll(set);
                return Math.abs(l.get(0) - l.get(1)) == 1 ? "YES" : "NO";
            }
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args){

        System.out.println(isValid("aabc"));

    }
}
