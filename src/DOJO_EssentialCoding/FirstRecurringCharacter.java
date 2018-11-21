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
public class FirstRecurringCharacter 
{
    public static void main(String[] args) 
    {
        String s1 = "ABCA"; // A
        String s2 = "BCABA"; // B
        String s3 = "ABC"; // null
        System.out.println(recurringChar(s3));
    }
    private static char recurringChar(String str)
    {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) 
        {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                return c;
            } else {
                map.put(c, i);
            }
        }
        return ' ';
    } 
}
