/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author SHUBHAM
 */
public class GraphColouring 
{
    private static final Map<Integer, List<Integer>> nodes = new HashMap<>();
    private static Map<Integer, String> ans = new HashMap<>(); 
    private static final String[] colors = {"RED", "GREEN", "BLUE"};
    private static Stack<Integer> completed = new Stack<>();
    
    public static void main(String[] args) 
    {
        G graph = new G(5);
        graph.addEdge(0, 1); 
        graph.addEdge(0, 4); 
        graph.addEdge(1, 2); 
        graph.addEdge(1, 3); 
        graph.addEdge(1, 4); 
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        List<Integer>[] adjList = graph.getAdjList();
        for (int i = 0; i < adjList.length; i++) {
            nodes.put(i, adjList[i]);
        }
        nodes.keySet().forEach(s -> ans.put(s, ""));
        
        nodes.entrySet().forEach(e -> {
            System.out.print(e.getKey() + " : ");
            e.getValue().forEach(t -> System.out.print(t + " -> "));
            System.out.println("");
        });
        solve();
        ans.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
    
    private static boolean solve()
    {
        if (backtrack(0, 0)) {
            return true;
        }
        System.out.println("Cannot be solved");
        return false;
    }
    private static boolean backtrack(int nodeIndex, int optionIndex)
    {
        while(optionIndex < colors.length)
        {
            if (!isPossible(nodeIndex, colors[optionIndex])) 
            {
                optionIndex += 1;
            } 
            else
            {
                ans.put(nodeIndex, colors[optionIndex]);
                completed.push(nodeIndex);
                if (completed.size() == nodes.size()) 
                {
                    return true;
                } 
                else
                {
                    if (backtrack(nodeIndex+1, 0)) {
                        return true;
                    }
                    else 
                    {
                        ans.put(nodeIndex, "");
                        completed.pop();
                        optionIndex += 1;
                    }
                }
            }
        }
        return false;
    }
    private static boolean isPossible(int node, String color)
    {
        List<Integer> adjacentNodes = nodes.get(node);
        for (int i = 0; i < adjacentNodes.size(); i++) {
            int g = adjacentNodes.get(i);
            if (ans.get(g) == null ? color == null : ans.get(g).equals(color)) {
                return false;
            }
        }
        return true;
    }
}

class G
{
    private int V;
    private List<Integer>[] adjList;

    public int getV() {
        return V;
    }

    public void setV(int V) {
        this.V = V;
    }

    public List<Integer>[] getAdjList() {
        return adjList;
    }

    public void setAdjList(List<Integer>[] adjList) {
        this.adjList = adjList;
    }
    
    public G(int V)
    {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            this.adjList[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest)
    {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }
    
}