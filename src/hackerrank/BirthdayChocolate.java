/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class BirthdayChocolate {
    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            s.add(i);
        }
        System.out.println(birthday(s,5,2));
    }
    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        
        for(int i=0;i<Math.ceil((double)s.size()/m);i++){
            List<Integer> l = s.subList(i,i+m);
            int listSum = l.stream().mapToInt(Integer::intValue).sum();
            if(listSum == d){
                count++;
            }
        }
        return count;
    }
}
