/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;
import java.util.*;
/**
 *
 * @author SHUBHAM
 */
public class BestIndex {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();                 
        //int[] arr = new int[N];
        sc.nextLine();
        String[] no = sc.nextLine().split(" ");
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            al.add(Integer.valueOf(no[i]));
        }
        System.out.println(sum(al));
    }
    public static int sum(List<Integer> al) 
    {
        int s = 0;
        int index = 1;
        List<Integer> list = new ArrayList<>();
        List<Integer> copyList = al.subList(0, al.size());
        for (int i = 0; i < al.size(); i++) {
            list.add(helper(copyList,i+1));
            copyList = al.subList(i+1, al.size());
        }
        list.forEach(t -> System.out.println("T-> "+ t));
        return Collections.max(list);
    }
    private static int helper(List<Integer> l, int k)
    {
        if (k>l.size()) return 0;
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += l.get(i+k-1);
        }
        return s;
    }
}
