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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

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
    private static final int size = 25;
    private final List<String> dataList;
    private final LRU l;
    
    public LRUCache()
    {
        l = new LRU(size);
        dataList = new ArrayList<>();
        loadList();
        loadCache();
    }
    
    public boolean shouldWatch(String season)
    {
        boolean b = l.add(season);
        deleteFile();
        createFile(l.getCache());
        return b;
    }
    
    private void loadCache()
    {
        dataList.forEach(e -> {
            if (e != null) {
                l.add(e);
            } 
        });
        System.out.println(l.getCache());
    }
    
    private void loadList()
    {
        try (Stream<String> stream = Files.lines(Paths.get("./src/WtoW/Words.txt"))) 
        {
                stream.forEach(e->{
                    dataList.add(e);
                });
        }
        catch (IOException ex) 
        {
            Logger.getLogger(LRUCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createFile(List<String> cache)
    {
        Path file = Paths.get("./src/WtoW/Words.txt");
        try 
        {
            Files.write(file, cache, Charset.forName("UTF-8"));
        }
        catch (IOException ex)
        {
            Logger.getLogger(LRUCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void deleteFile()
    {
        try
        { 
            Files.deleteIfExists(Paths.get("./src/WtoW/Words.txt")); 
        } 
        catch(IOException e) 
        { 
            Logger.getLogger(LRUCache.class.getName()).log(Level.SEVERE, null, e);
        } 
    }
}