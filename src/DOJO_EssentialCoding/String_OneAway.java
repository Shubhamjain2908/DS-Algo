/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

/**
 * If 2 strings are one edit away - True
 * @author SHUBHAM
 */
public class String_OneAway 
{
    public static void main(String[] args) 
    {
        String s1 = "abcde";
        String s2 = "abfde";
        System.out.println(is_One_Away(s1, s2));
    }
    
    //----------------------------------//
    // DOJO
    public static Boolean is_One_Away(String s1, String s2) {
        if (s1.length() - s2.length() >= 2 || s2.length() - s1.length() >= 2) {
            return false;
        } else if (s1.length() == s2.length()) {
            return isOneAwaySameLength(s1, s2);
        } else if (s1.length() > s2.length()) {
            return isOneAwayDiffLengths(s1, s2);
        } else {
            return isOneAwayDiffLengths(s2, s1);
        }
    }

    public static Boolean isOneAwaySameLength(String s1, String s2) {
        int countDiff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                countDiff += 1;
                if (countDiff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Assumption: s1.length() == s2.length() + 1
    public static Boolean isOneAwayDiffLengths(String s1, String s2) {
        int i = 0;
        int countDiff = 0;
        while (i < s2.length()) {
            if (s1.charAt(i + countDiff) == s2.charAt(i)) {
                i += 1;
            } else {
                countDiff += 1;
            }
            if (countDiff > 1) {
                return false;
            }
        }
        return true;
    }
    //----------------------------------//
    
    // Allowed operations -> Change, Delete, add
    private static boolean isOneAway(String s1, String s2)
    {
        if (Math.abs(s1.length() - s2.length()) >= 2)
        {
            return false;
        }
        if (s1.length() == s2.length()) 
        {
            int diffChar = 0;
            for (int i = 0; i < s1.length(); i++) 
            {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffChar++;
                }
            }
            return diffChar < 2;
        }
        if (Math.abs(s1.length() - s2.length()) == 1)
        {
            int i=0;
            int countDiff = 0;
            while(i<s2.length()){
                if (s1.charAt( + countDiff) == s2.charAt(i)) {
                    i += 1;
                }
                else{
                    countDiff += 1;
                    return countDiff < 2;
                }
            }
        }
        return true;
    }
}
