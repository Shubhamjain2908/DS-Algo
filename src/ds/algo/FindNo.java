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
public class FindNo {
    public static void main(String[] args) {
          List<Integer> l = new ArrayList<>();
          l.add(1);
          l.add(2);
          l.add(3);
          l.add(4);
          l.add(5);
          System.out.println(f(l, 8));
    }
    public static String f(List<Integer> l, int k)
    {
        if(l.stream().anyMatch(o -> o.equals(k)))
        {
            return "YES";
        }
        return "NO";
    }
}
