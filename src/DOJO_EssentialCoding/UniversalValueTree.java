/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOJO_EssentialCoding;

/**
 *
 * @author SHUBHAM
 */
public class UniversalValueTree 
{
    public static void main(String[] args) 
    {
        UniversalTree d = new UniversalTree(3);
        d.left = new UniversalTree(2);
        d.right = new UniversalTree(3);
        d.right.right = new UniversalTree(2);
        d.right.right.left = new UniversalTree(2);
        d.right.right.right = new UniversalTree(2);
        
        System.out.println(countUnivals(d));
        d.print(d);
    }
    private static int countUnivals(UniversalTree root)
    {
        if (root == null) {
            return 1;
        }
        int total = countUnivals(root.left) + countUnivals(root.right);
        if (isUnival(root)) {
            total += 1;
        }
        return total;
    }
    private static boolean isUnival(UniversalTree root)
    {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.data != root.data) {
            return false;
        }
        if (root.right != null && root.right.data != root.data) {
            return false;
        }
        if (isUnival(root.left) && isUnival(root.right)) {
            return false;
        }
        return false;
    }
}
class UniversalTree{
    int data;
    UniversalTree right, left;
    public UniversalTree(int data){
        this.data = data;
    }
    public void print(UniversalTree root){
        if (root.left != null) {
            print(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            print(root.right);
        }
    }
}