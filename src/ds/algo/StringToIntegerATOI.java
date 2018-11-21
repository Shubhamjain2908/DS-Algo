/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class StringToIntegerATOI 
{
    public static void main(String[] args) 
    {
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "20000000000000000000";
        String s7 = "";
        String s8 = "+";
        String s9 = "-";
        String s10 = "+-21";
        String s11 = "-abc";
        String s12 = "-+++123";
        String s13 = "3.172818";
        List<String> l = new ArrayList<>();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);
        l.add(s6);
        l.add(s7);
        l.add(s8);
        l.add(s9);
        l.add(s10);
        l.add(s11);
        l.add(s12);
        l.add(s13);
        l.forEach(t -> System.out.println(myAtoi(t.toCharArray())));
    }
    
    
    
    private static int myAtoi(String str) {
        str = str.trim().replaceAll("\\s+", "");
        if (str == null || str.isEmpty() || str.length() == 0 || (str.length() == 1 && str.charAt(0) == '-')) {
            return 0;
        }
        char first = str.charAt(0);
        if (first == '-' || first == '+'|| Character.isDigit(first)) {
            boolean containSign = false;
            if (first == '-') {
                str = str.substring(1);
                containSign = true;
            }
            if (first == '+') {
                str = str.substring(1);
            }
            if(str == null || str.isEmpty()) return 0;
            String no = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isDigit(c)) {
                    no += c;
                }
                if (Character.isLetter(c)) {
                    if(no.length() < 1) {
                        return 0;
                    }
                    break;
                }
                if (c == '.') {
                    if(no.length() < 1) {
                        return 0;
                    }
                    break;
                }
            }
            no = containSign ? "-"+no:no;
            double n = Double.valueOf(no);
            if (n > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (n<Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            return Integer.valueOf(no);
            
        }
       return 0;    
   }
    private static int myAtoi(char[] str) 
    { 
        int sign = 1, base = 0, i = 0; 
        // if whitespaces then ignore. 
        while (str[i] == ' ') 
        { 
            i++; 
        } 
        // sign of number 
        if (str[i] == '-' || str[i] == '+') { 
            sign = 1 - 2 * (str[i++] == '-' ? 1 : 0); 
        }
        // checking for valid input 
        
        while (str[i] >= '0' && str[i] <= '9') 
        { 
            //handling overflow test case 
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str[i] - '0' > 7)) { 
                if (sign == 1) return Integer.MAX_VALUE; 
                return Integer.MIN_VALUE; 
            } 
            base = 10 * base + (str[i++] - '0'); 
            if (i>=str.length) {
                break;
            }
        } 
        return base * sign; 
    } 
}
