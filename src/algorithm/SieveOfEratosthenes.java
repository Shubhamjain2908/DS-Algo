/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        SieveOfEratosthenes soe = new SieveOfEratosthenes();
        ArrayList<Integer> al = soe.getPrime(200);
        al.forEach(action -> System.out.println(action));
    }
    public ArrayList<Integer> getPrime(int num){
        Map<Integer, String> map = new HashMap<>();
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            map.put(i, "true");
        }
        map.replace(0, "false");
        map.replace(1, "false");
        for (int i = 2; i < Math.sqrt(num); i++) {
            for (int j = 2; j * i <= num; j++) {
               map.replace(i*j, "false");
            }
        }
        for (int i = 0; i < map.size(); i++) {
            if ("true".equals(map.get(i))) {
                primes.add(i);
            }
        }
        return primes;
    }
}
