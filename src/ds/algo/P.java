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
public class P {
    public static void main(String[] args) {
        combine("hegf", new StringBuffer(), 0);
    }
    public static void combine(String instr, StringBuffer outstr, int index)
    {
        for (int i = index; i < instr.length(); i++)
        {
            outstr.append(instr.charAt(i));
            if (outstr.length() == instr.length()) {
                System.out.println(outstr);
            }
            System.out.println(outstr);
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    } 

}
