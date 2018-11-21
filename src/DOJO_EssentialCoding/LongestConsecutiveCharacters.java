/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class LongestConsecutiveCharacters 
{
    public static void main(String[] args) 
    {
        String str = "AABCDDBBBEA";
        Map<Character, Integer> map = getLongestChar(str);
        map.entrySet().forEach(e-> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
    private static Map<Character, Integer> getLongestChar(String str)
    {
        Map<Character, Integer> map = new HashMap<>();
        
        char current;
        int maxCount=0;
        char maxChar = str.charAt(0);
        char prevChar = str.charAt(0);
        int count=0;
        
        for (int i = 0; i < str.length(); i++) 
        {
            current = str.charAt(i);
            if (prevChar == str.charAt(i)) 
            {
                count++;
            }
            else
            {
                count = 1;
            }
            if (count > maxCount) 
            {
                maxCount = count;
                maxChar = current;
            }
            prevChar = current;
        }
        map.put(maxChar, maxCount);
        return map;
    }
}
