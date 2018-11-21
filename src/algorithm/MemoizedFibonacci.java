/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;

/**
 *
 * @author SHUBHAM
 */
public class MemoizedFibonacci {
    public static void main(String[] args) {
        MemoizedFibonacci mf = new MemoizedFibonacci();
        ArrayList<Integer> cache = new ArrayList<>();
        System.out.println(mf.fibMemo(6, cache));
    }
    public int fibMemo(int index, ArrayList<Integer> cache) {
        if (cache.size() >0 && cache.get(index) == null) {
            return cache.get(index);
        }
        else {
            if (index < 3) {
                return 1;
            }
            else {
                cache.add(index, fibMemo(index - 1, cache) + fibMemo(index - 2, cache));
                //cache.set(index, fibMemo(index - 1, cache) + fibMemo(index - 2, cache));
//                cache.get(index) = fibMemo(index - 1, cache) + fibMemo(index - 2, cache);
            }
        }
        return cache.get(index);
    }
}
