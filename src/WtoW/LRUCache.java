/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WtoW;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Google
 * @author SHUBHAM
 *  Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:
    set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
    get(key): gets the value at key. If no such key exists, return null.
    Each operation should run in O(1) time.
 */
public class LRUCache 
{
    public static void main(String[] args) 
    {  
        LRUCache l = new LRUCache();
        l.createFile();
        l.readFile();
        l.deleteFile();
    }
    public void readFile()
    {
        try 
        {
            String data = new String(Files.readAllBytes(Paths.get("./src/WtoW/Words.txt")));
            System.out.println(data.split(" ").length);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LRUCache.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

    }
    public void createFile()
    {
        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("./src/WtoW/Words.txt");
        try 
        {
            Files.write(file, lines, Charset.forName("UTF-8"));
        }
        catch (IOException ex)
        {
            Logger.getLogger(LRUCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteFile()
    {
        try
        { 
            Files.deleteIfExists(Paths.get("./src/WtoW/Words.txt")); 
            System.out.println("deleted");
        } 
        catch(IOException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
          
    }
}
class LRU
{
    private final int size;
    private final Map<Integer, Integer> map = new HashMap<>();
    private final Queue<Integer> q = new LinkedList<>();
    
    public LRU(int size)
    {
        this.size = size;
    }
    
    public void set(int key, int value)
    {
        if (q.size() == size) {
            map.remove(q.poll());
        }
        map.put(key, value);
        q.add(key);
    }
    
    public int get(int key)
    {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return 0;
    }
    
    public int[] getCache()
    {
        int[] arr = new int[size];
        int[] i = {0};
        map.entrySet().forEach(e -> {
            arr[i[0]] = e.getValue();
            i[0]++;
        });
        return arr;
    }
}
