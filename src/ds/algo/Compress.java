/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

/**
 *
 * @author SHUBHAM
 */
public class Compress {

    public static void main(String[] args) {

        String str = "Shhhubham jain";

        System.out.println("str: " + str);
        System.out.println("compressed: " + compresString(str));
    }

    /* Implement a method to perform basic string compression using the counts 
     * of repeated characters. For example, the string aabcccccaaa would 
     * become a2b1c5a3. If the "compressed" string would not become smaller
     * than the original string, your method should return the original string.
     */
    public static String compress1(String str) {
        if (str.length() < 1) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        String newStr;

        char previous = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == previous) {
                count++;
            } else {
                result.append(previous);
                result.append(count);
                previous = current;
                count = 1;
            }
        }

        result.append(previous);
        result.append(count);
        newStr = result.toString();
        return str.length() <= newStr.length() ? str : newStr;
    }

    public static String compress2(String str) {
        int newLength = countCompression(str);

        if (str.length() <= newLength) {
            return str;
        }

        char[] result = new char[newLength];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == last) {
                count++;
            } else {
                index = setChar(result, last, index, count);
                last = current;
                count = 1;
            }
        }

        setChar(result, last, index, count);
        return new String(result);
    }

    public static int setChar(char[] str, char c, int index, int count) {
        str[index] = c;
        index++;
        char[] number = String.valueOf(count).toCharArray();

        for (char d : number) {
            str[index] = d;
            index++;
        }

        return index;
    }

    public static int countCompression(String str) {
        if (str.length() < 1) {
            return 0;
        }

        int total = 0;
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == last) {
                count++;
            } else {
                total += 1 + String.valueOf(count).length();
                last = current;
                count = 1;
            }
        }

        total += 1 + String.valueOf(count).length();
        return total;
    }

    public static String compresString(String text) {
        int length = text.length();
        /*
	*  Compression makes sense at length of larger than or equal to 3.
	*  For instance: "aaa" -> "a3"
         */
        if (length > 2) {
            String compressedText = "";
            char lastChar = text.charAt(0);
            int charCount = 1;
            for (int i = 1; i < length; i++) {
                if (text.charAt(i) == lastChar) {
                    charCount++;
                } else {
                    compressedText += Character.toString(lastChar) + Integer.toString(charCount);
                    lastChar = text.charAt(i);
                    charCount = 1;
                }
            }
            compressedText += Character.toString(lastChar) + Integer.toString(charCount);
            if (compressedText.length() < length) {
                return compressedText;
            }
        }
        return text;
    }
}
