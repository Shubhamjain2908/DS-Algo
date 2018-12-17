/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Facebook
 * @author SHUBHAM
 * Given a string and a set of delimiters, reverse the words in the string while maintaining the relative order of the delimiters. For example, given "hello/world:here", return "here/world:hello"
    Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"
 */
public class P114_ReverseWordsStringInDelimeter 
{
    public static void main(String[] args) 
    {
        String str1 = "hello/world:here";
        String[] del1 = {"/", ":"};
        System.out.println(reverse(str1, del1));
        
        String str2 = "hello//world:here";
        String[] del2 = {"//", ":"};
        System.out.println(reverse(str2, del2));
    }
    private static String reverse(String sw, String[] del)
    {
        int j = 0;
        for (String del1 : del)
            sw = sw.replace(del1, " ");
        String rev = "";
        String s[] = sw.split(" ");
        for (int i = s.length-1; i >= 0; i--) 
        {
            rev += s[i] + " ";
        }
        for (String del1 : del)
            rev = rev.replaceFirst(" ", del1);
        return rev;
    }
}
