/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author SHUBHAM
 */
import java.util.*;

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

}

public class MoreLinkedList {

    public static Node removeDuplicates(Node head) {
        //Write your code here
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            set.add(head.data);
            head = head.next;
        }
        Node newHead = null;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int i = it.next();
            newHead = insert(newHead, i);
        }
        return newHead;
    }

    public static Node insert(Node head, int data) {
        Node p = new Node(data);
        if (head == null) {
            head = p;
        } else if (head.next == null) {
            head.next = p;
        } else {
            Node start = head;
            while (start.next != null) {
                start = start.next;
            }
            start.next = p;

        }
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int T = 20;//sc.nextInt();
        int[] t = {3,
9,
9,
11,
11,
11,
11,
89,
89,
100,
100,
101,
102,
103,
108,
200,
250,
250,
250,
250};
        while (T-- > 0) {
            int ele = t[T];
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }
}

