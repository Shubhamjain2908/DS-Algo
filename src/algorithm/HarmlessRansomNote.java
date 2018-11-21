/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SHUBHAM
 */
public class HarmlessRansomNote {
    public static void main(String[] args) {
        String noteText = "this is a secret note for you from a secret admirer";
        String magazineText = "puerto rico is a place of great wonder and excitement it has many secret waterfall locatoins that i am an admirer of you must hike quite a distance to find the secret places as they are far from populated areas but it is worth the effort a tip i have for you is to go early in the morning when it is not so hot out also note that you must wear hiking boots this is one of the best places i have ever visited";
        HarmlessRansomNote h = new HarmlessRansomNote();
        System.out.println(h.isAlgoValid(noteText, magazineText));
        System.out.println(h.isAlgoValid("a a c v","a c g js ks k a c v v k q w er"));
    }
    public boolean isAlgoValid(String noteText, String magazineText) 
    {
        Map<String, Integer> map = new HashMap<>();
        int k=0;
        String[] a = noteText.split(" ");
        String[] b = magazineText.split(" ");
        for (String b1 : b) {
            if (map.containsKey(b1)) {
                map.put(b1, map.get(b1) + 1);
            } else {
                map.put(b1, 1);
            }
        }
        // map.keySet().forEach(key -> System.out.println(key + "->" + map.get(key)));
        for (String a1 : a) {
            if (map.containsKey(a1) && map.get(a1) > 0) {
                map.put(a1, map.get(a1) - 1);
                k++; 
            }
        }
        return k == a.length ;
    }
}
