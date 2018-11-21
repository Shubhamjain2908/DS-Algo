/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingCodingInterview.ArrayString;

/**
 *
 * @author SHUBHAM
 */
// Assume you have a method isSubstring which checks if one word is a isSubstring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
// one call to isSubstring(e.g., "waterbottle" is a rotation of "erbottlewat").
public class IsRotationString 
{
    public static void main(String[] args) 
    {
        String s1 = "waterbottle";
        String s2 = "elttobretaw";
        System.out.println(isRotate(s1, s2));
    }
    private static boolean isRotate(String s1,String s2) 
    {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(s1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
/**
  public class IsRotation {
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		//check that s1 and s2 are equal length and not empty 
		if(len == s2.length() && len > 0) {
			// concatenate s1 and s1 within new buffer 
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}

		return false;
	}
}
 */