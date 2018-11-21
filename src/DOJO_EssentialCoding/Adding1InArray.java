/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.ArrayList;
import java.util.List;

/**
 * {1,3,2,4} -> {1,3,2,5}
 * @author SHUBHAM
 */
public class Adding1InArray 
{
    public static void main(String[] args) 
    {
        int[] arr = {9,9};
        int[] newArr = addOne(arr);
        for(int a: newArr) System.out.println(a);
    }
    public static int[] addOne(int[] arr)
    {
        if (arr[arr.length-1] < 9) {
            arr[arr.length-1] = arr[arr.length-1] + 1;
            return arr;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) 
        {
            sb.append(arr[i]);
        }
        String s = String.valueOf(Integer.valueOf(sb.toString()) + 1);
        System.out.println(s);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) 
        {
            list.add(Integer.valueOf(String.valueOf(s.charAt(i))));
        }
        int[] newArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) 
        {
            newArr[i] = list.get(i);
        }
        return newArr;
    }
}
