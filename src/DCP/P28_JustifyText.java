/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHUBHAM
 * Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.
 * For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:
    ["the  quick brown", # 1 extra space on the left
    "fox  jumps  over", # 2 extra spaces distributed evenly
    "the   lazy   dog"] # 4 extra spaces distributed evenly
 */
public class P28_JustifyText 
{
    public static void main(String[] args) 
    {
        String[] arr = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        int k = 16;
        printJustifyText(arr, k);
    }
    public static void printJustifyText(String[] arr, int k) 
    {
        List<Integer> list = new ArrayList<>();
        for (String arr1 : arr) {
            list.add(arr1.length());
        }
        for (int i = 0; i < list.size()-1; i++) 
        {
            
        }
    }
}
