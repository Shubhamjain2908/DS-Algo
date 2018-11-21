/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;
/**
 *
 * @author SHUBHAM
 */
public class VeryCoolNumber {

    public static void main(String[] args){

        String s;
        int count[] = new int[100001];
        for (int i = 5; i < count.length; i++) {
            String binary = Integer.toBinaryString(i);
            int c = 0;
            for (int j = 0; j <= binary.length() - 3; j++) {
                if (binary.substring(j, j + 3).equals("101")) {
                    c++;
                }
            }
            count[i] = c;
        }
        int R = 102;//Integer.parseInt(st.nextToken());
        int K = 2;//Integer.parseInt(st.nextToken());
        int c1 = 0;
        for (int i = 5; i <= R; i++) {
            if (count[i] >= K) {
                c1++;
            }
        }
        System.out.println(c1);
    }

    /*
    public static void main(String[] args) {
        int n = 23;
        int k = 2;
        System.out.println(countCoolNo(n, k));
    }
    private static int countCoolNo(int n, int k) 
    {
        int[] arr = new int[105];
        int c= 0;
        for (int i = 0; i < arr.length; i++) 
        {
            String s = Integer.toBinaryString(i);
            arr[i] = count101(s);
        }
        if (arr[n] < k) {
            return 1;
        }
        for (int i = 0; i < n; i++) 
        {
            if (arr[i] >= k) {
                c++;
            }
        }
        return c;
    }
    private static int count101(String s) 
    {
        int count = 0;
        for (int i = 0; i < s.length()-3; i++) 
        {
            String t = s.substring(i, i+3);
            System.out.println(t);
            if (t.equals("101")) {
                count++;
            }
        }
        System.out.println("C : "+count);
        return count;
    }
     */
}
