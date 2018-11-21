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
/**
 *
 * NOTE : Class Name should be Main 
 *
 **/
import java.io.*;
import java.util.*;
class RemoveSpace {
    public static String remove(String str){
        String[] s = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length;i++){
            if(s.length != 0){
                sb.append(s[i]+" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws InterruptedException {
        List<String> inputByLine = new ArrayList<String>();
        try {
            // Get the object of DataInputStream
            InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null){
                inputByLine.add(line.toString());
            }
            for (String line2 : inputByLine){
                line2 = remove(line2);
                System.out.println(line2);    
            }
            
            isr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}