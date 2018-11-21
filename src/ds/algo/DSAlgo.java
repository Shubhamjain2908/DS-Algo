/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;
import java.util.*;
/**
 *
 * @author SHUBHAM
 */
public class DSAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            al.add(i);
        }
        List<Integer> al2 = al.subList(0, 2);
        al.forEach(t -> System.out.println(t));
        al2.forEach(t -> System.out.println("al2 - "+t));
    }
    
}
