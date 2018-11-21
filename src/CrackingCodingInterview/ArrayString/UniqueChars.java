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
public class UniqueChars 
{
    public static void main(String[] args) 
    {
        String s = "Shubham";
        System.out.println(isUique(s));
        IsUniqueChars i = new IsUniqueChars();
        System.out.println(i.isUniqueChars(s));
    }
    public static boolean isUique(String s) 
    {
        int a = 0;
        for (int i = 0; i < s.length(); i++) 
        {
            String temp = String.valueOf(s.charAt(i));
            for (int j = 0; j < s.length(); j++) 
            {
                if (i != j) {
                    String temp2 = String.valueOf(s.charAt(j));
                    if (temp.equals(temp2)) return false;
                }
            }
        }
        return true;
    }
}
// Altername
class IsUniqueChars {
    public boolean isUniqueChars(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
