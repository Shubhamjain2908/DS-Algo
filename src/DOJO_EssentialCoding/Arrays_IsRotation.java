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
public class Arrays_IsRotation {
    public static void main(String[] args) 
    {
        int[] A = {1,2,3,4,5,6,7};
        int[] B = {4,5,6,7,1,2,3};
        System.out.println(isRotatedVersion(A, B));
    }
    private static boolean isRotation(int[] A, int[] B)
    {
        int n = A.length;
        if (n != B.length) {
            return false;
        }
        int key = A[0];
        int key_i = -1;
        for (int i = 0; i < n; i++) {
            if (B[i] == key) {
                key_i = i;
                break;
            }
        }
        if (key_i == -1) {
            return false;
        }
        for (int i = 0; i < n-1; i++) 
        {
            int j = (key_i + i) % n;
            if (A[i] != B[j]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isRotatedVersion(int[] a, int[] b){
        //Check length of arrays
        if(a.length != b.length)
            return false;

        //Declare two pointers. One for each array
        int aPointer = 0;
        int bPointer = 0;

        //This flag will prevent us walking through the 2nd array in a loop only once
        //Helps avoid going into infinite walk loop
        boolean isFirstTimeWalk = true;

        //This loop will run from 0 to n of array 1
        while(aPointer < a.length){

            //If elements at position aPointer and bPointer are equal then incr both pointer 
            // to move to the element in both array
            if(a[aPointer] == b[bPointer]){
                aPointer++;
                if(bPointer < b.length-1)
                    bPointer++;
                else{ //If reached end of second array then it reset pointer to 0 to rotate
                    //Once rotated done mark is1stTimeWalked to false so avoid future loops
                    isFirstTimeWalk = false;
                    bPointer = 0;
                }
            }else if(isFirstTimeWalk && bPointer < b.length-1){
                //Move bPointer until a match is found
                bPointer++;
            }else {
                return false;
            }
        }
        return true;
    }
}

