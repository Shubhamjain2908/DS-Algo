/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author SHUBHAM
 */
public class ClosestToOrigin {
    public static void main(String[] args) {
        int[] p1 = {-2,4};
        int[] p2 = {0,-2};
        int[] p3 = {-1,0};
        int[] p4 = {3,5};
        int[] p5 = {-2,-3};
        int[] p6 = {3,2};
        List<int[]> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        List<int[]> l2 = getClosestPoints(list, 2);
        l2.forEach(t -> System.out.println(Arrays.toString(t)));
    }
    private static List<int[]> getClosestPoints(List<int[]> list, int k)
    {
        List<int[]> l2 = new ArrayList<>();
        List<Node> node = new ArrayList<>();
      
        for (int i = 0; i < list.size(); i++) 
        {
            int[] c = list.get(i);
            Double distance = getDistance(c);
      
            Node n = new Node();
            n.setCoordinates(c);
            n.setDistance(distance);
            node.add(n);
        }
        Collections.sort(node, new SortbyDistance());
        for (int i = 0; i < k; i++) 
        {
            l2.add(node.get(i).getCoordinates());
        }
        return l2;
    } 
    private static double getDistance(int[] points)
    {
        double d = 0;
        int x = points[0];
        int y = points[1];
        d = Math.sqrt((x*x) + (y*y));
        return d;
    }
}
class Node{
    int[] coordinates;
    Double distance;

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
    
}
class SortbyDistance implements Comparator<Node> 
{ 
    public int compare(Node a, Node b) 
    { 
        return (int) (a.distance - b.distance); 
    } 
} 