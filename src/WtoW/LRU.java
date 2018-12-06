/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WtoW;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author SHUBHAM
 */
public class LRU 
{
    private final int size;
    private final Deque<String> q;
    
    public LRU(int size)
    {
        this.size = size;
        q = new LinkedList<>();
    }
    
    public boolean add(String value)
    {
        boolean b = contains(value);
        if (b) 
        {
            q.remove(value);
        }
        if (q.size() == size) {
            q.remove();
        }
        q.add(value);
        return b;
    }
    
    private boolean contains(String value)
    {
        Queue<String> q2 = new LinkedList<>();
        q2.addAll(q);
        for (int i = 0; i < q2.size(); i++) 
        {
            String s = q2.poll();
            if (s == null ? value == null : s.equals(value)) {
                return true;
            }
        }
        return false;
    }
    
    public List<String> getCache()
    {
        List<String> arr = new ArrayList<>(size);
        Queue<String> q2 = new LinkedList<>();
        q2.addAll(q);
        for (int i = 0; i < q2.size(); i++) 
        {
            arr.add(q2.poll());
        }
        return arr;
    }
    
}
