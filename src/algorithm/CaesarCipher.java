/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author SHUBHAM
 */
public class CaesarCipher {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        System.out.println(cipher.cipherString("Shubham Jain", 3));
    }
    public String cipherString(String str, int num) {
        String cipher ="";
        for (int i = 0; i < str.length(); i++) {
            if((int)str.charAt(i) != 32)
                cipher += Character.toString ((char) ((int)str.charAt(i) + num));
            else
                cipher += " ";
        }
        return cipher;
    }
}
