/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingCodingInterview.ArrayString;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list
 * @author SHUBHAM
 */
public class DeleteDups 
{
    public static void main(String[] args) 
    {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 10; i++) 
        {
            l.add(i);
            l.add(i+1);
        }
        l.forEach(t->System.out.println("Before -> "+t));
        deleteDups(l).forEach(t->System.out.println(t));
    }
    public static LinkedList deleteDups(LinkedList n)
    {
        LinkedList se = new LinkedList();
        Set set = new HashSet();
        for (int i = 0; i < n.size(); i++) 
        {
            set.add(n.get(i));
        }
        set.forEach(t->se.add(t));
        return se;
    }
}
//Alternate
/*
class RemoveDups {
	void deleteDups(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while(n != null) {
			if(set.contains(n.data)) {
				previous.next = n.next;
			}
			else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
}
*/