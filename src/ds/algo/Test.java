/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Random;
import java.util.Set;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

/**
 *
 * @author SHUBHAM
 */
public class Test {
    public static void main(String[] args) 
    {
//        googleGuava();
//        orgApache();
//        System.out.println(hash(12));   
        getSeason();
    }
    private static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    private static void googleGuava()
    {
        // create multimap to store key and values
        Multimap<String, String> multiMap = ArrayListMultimap.create();
        // put values into map for A
        multiMap.put("A", "Apple");
        multiMap.put("A", "Aeroplane");
        // put values into map for B
        multiMap.put("B", "Bat");
        multiMap.put("B", "Banana");
        // put values into map for C
        multiMap.put("C", "Cat");
        multiMap.put("C", "Car");
        // retrieve and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        // get all the set of keys
        Set<String> keys = multiMap.keySet();
        // iterate through the key set and display key and values
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + multiMap.get(key) + "n");
        }
    }
    private static void orgApache()
    {
        // create multimap to store key and values
        MultiMap multiMap = new MultiValueMap();
        // put values into map for A
        multiMap.put("A", "Apple");
        multiMap.put("A", "Aeroplane");
        // put values into map for B
        multiMap.put("B", "Bat");
        multiMap.put("B", "Banana");
        // put values into map for C
        multiMap.put("C", "Cat");
        multiMap.put("C", "Car");
        // retrieve and display values
        System.out.println("Fetching Keys and corresponding [Multiple] Values n");
        // get all the set of keys
        Set<String> keys = multiMap.keySet();
        // iterate through the key set and display key and values
        for (String key : keys) {
            System.out.println("Key = " + key);
            System.out.println("Values = " + multiMap.get(key) + "n");
        }
    }
    private static void getSeason()
    {
        Random rand = new Random();
        String[] series = {"FRIENDS", "HIMYM", "BBT"};
        int se = rand.nextInt(3);
        int s = rand.nextInt(11);
        int e = rand.nextInt(24);
        System.out.println("You should watch : "+ series[se] +" S" + s +"E"+e);
    }
}