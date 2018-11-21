/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author SHUBHAM
 */
import java.util.*;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<String, Integer> map1 = new HashMap<>(); 
        Map<String, Integer> map2 = new HashMap<>(); 
        for(int i=0;i<a.length();i++){
            if(map1.containsKey(String.valueOf(a.charAt(i))))
            {
               map1.put(String.valueOf(a.charAt(i)), map1.get(String.valueOf(a.charAt(i))) + 1);  
            }
            map1.putIfAbsent(String.valueOf(a.charAt(i)), 1);
        }
        
        for(int i=0;i<b.length();i++){
            if(map2.containsKey(String.valueOf(b.charAt(i)))){
              map2.put(String.valueOf(b.charAt(i)), map2.get(String.valueOf(b.charAt(i))) + 1);  
            } 
            map2.putIfAbsent(String.valueOf(b.charAt(i)), 1);
        }
        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            if (map1.containsKey(String.valueOf(b.charAt(i))) && map1.get(String.valueOf(b.charAt(i)))>0) {
                map1.put(String.valueOf(b.charAt(i)), map1.get(String.valueOf(b.charAt(i))) - 1);  
            } else {
                count++;
            }
        }
        for (int i = 0; i < a.length(); i++) {
            if (map2.containsKey(String.valueOf(a.charAt(i))) && map2.get(String.valueOf(a.charAt(i)))>0) {
                map2.put(String.valueOf(a.charAt(i)), map2.get(String.valueOf(a.charAt(i))) - 1);  
            } else {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        
        String a = "cde";

        String b = "abc";

        int res = makeAnagram(a, b);
        
        System.out.println(res);
    }
}
