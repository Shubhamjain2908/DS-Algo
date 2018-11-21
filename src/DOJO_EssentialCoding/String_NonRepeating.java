/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author SHUBHAM
 */
public class String_NonRepeating 
{
    public static void main(String[] args)     
    {
        String test = "aaacbb";
        System.out.println(nonRepeatedText(test));
    }

    private static String nonRepeatedText(String test) 
    {
        Map<String, Integer> map = getMap(test);
        Optional<Map.Entry<String, Integer>> result = map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst();
        if (!result.isPresent()) {
            return null;
        }
        return result.get().getKey();
    }
    private static Map<String, Integer> getMap(String test){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < test.length(); i++) {
            String s = String.valueOf(test.charAt(i));
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else{
                map.put(s, 1);
            }
        }
        return map;
    }
}
