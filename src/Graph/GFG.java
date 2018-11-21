/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class GFG 
{
    public static void main(String[] args)
    {
        int V = 5; 
        Graph graph = new Graph(V); 
        graph.addEdge( 0, 1); 
        graph.addEdge( 0, 4); 
        graph.addEdge( 1, 2); 
        graph.addEdge( 1, 3); 
        graph.addEdge( 1, 4); 
        graph.addEdge( 2, 3); 
        graph.addEdge( 3, 4);
        
        graph.printAdjacencyList();
        System.out.println("");
        graph.printAdjacencyMatrix();
    }
}
class Graph
{

    private final int V;
    private final List<Integer>[] adjListArray;
    private final int[][] adjMatrix;
    
    public Graph(int V)
    {
        this.V = V;
        adjListArray = new ArrayList[V];
        adjMatrix = new int[V][V];
        
        for (int i = 0; i < V; i++) 
        {
            adjListArray[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest)
    {
        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
        
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
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
    
    public void printAdjacencyMatrix()
    {
        for (int i = 0; i < adjMatrix.length; i++) 
        {
            for (int j = 0; j < adjMatrix[i].length; j++) 
            {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}