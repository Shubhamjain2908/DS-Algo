/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author SHUBHAM
 */
public class TopologicalSort 
{
    static class Graph
    {
        private final int V;
        private final List<Integer>[] adjListArray;
        
        public List<Integer>[] getAdjListArray() {
            return adjListArray;
        }
        
        public Graph(int V)
        {
            this.V = V;
            adjListArray = new ArrayList[V];

            for (int i = 0; i < V; i++) 
            {
                adjListArray[i] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int dest)
        {
            adjListArray[src].add(dest);
            adjListArray[dest].add(src);
        }
        
        public void printAdjacencyList()
        {
            for (int i = 0; i < V; i++) 
            {
                System.out.print("head " + i + " : ");
                for (Integer p: adjListArray[i]) {
                    System.out.print(" -> " + p);
                }
                System.out.println("");
            }
        }
    }
    public static void main(String[] args) 
    {
        int V = 8;
        Graph graph = new Graph(V);
        graph.addEdge( 0, 2); 
        graph.addEdge( 1, 2); 
        graph.addEdge( 2, 3); 
        graph.addEdge( 3, 5); 
        graph.addEdge( 5, 6); 
        graph.addEdge( 1, 4); 
        graph.addEdge( 4, 5);
        graph.printAdjacencyList();
        topologicalSort(graph);
    }
    private static void topologicalSort(Graph graph)
    {
        Stack<Integer> st = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer>[] adjListArray = graph.getAdjListArray();
        for (int i = 0; i < adjListArray.length; i++) 
        {
            if (true) {
                
            }
        }
    }
}
