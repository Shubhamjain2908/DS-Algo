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

public class SimpleTextEditor 
{
    static String S = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        Stack<String> str = new Stack<>();
        Stack<String> ss = new Stack<>();
        int q = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<q;i++)
        {
            
            String[] sr = sc.nextLine().split(" ");
            int operation = Integer.valueOf(sr[0]);
            st.push(operation);
            ss.push(S);
            if(sr.length == 2)
            {
                String x = sr[1];
                str.push(x);
                perform(st, str, ss);
            }
            else 
            {
                str.push("");
                perform(st, str, ss);
            }
        }
    }
    private static void perform(Stack<Integer> st, Stack<String> str, Stack<String> ss)
    {
        int operation = st.peek();
        String k = str.peek();
        String s = ss.peek();
        switch (operation) 
        { 
        case 1: 
            S += k; 
//            System.out.println("1o S: " + S);
            break; 
        case 2: 
            S = S.substring(0, S.length() - Integer.valueOf(k)); 
//            System.out.println(k);
//            System.out.println("2o S: " + S);
            break; 
        case 3: 
            System.out.println(S.charAt(Integer.valueOf(k)-1));
            break; 
        case 4: 
            st.pop();
            str.pop();
            ss.pop();
            undo(st, str, ss);
            break;
        default:
            break; 
        } 
    }
    private static void undo(Stack<Integer> st, Stack<String> str, Stack<String> ss)
    {
        int operation = st.peek();
        String k = str.peek();
        String s = ss.peek();
        switch (operation) 
        { 
        case 1: 
            S = s; 
//            System.out.println("1u S: " + S);
            break; 
        case 2: 
            S = s; 
//            System.out.println("2u S: " + S);
            break; 
        case 3: 
            st.pop();
            str.pop();
            ss.pop();
            undo(st, str, ss);
            break; 
        case 4: 
            st.pop();
            str.pop();
            ss.pop();
            undo(st, str, ss);
            break;
        default: 
            break; 
        } 
    }
}
class Solution2{
public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack<Command> stack = new Stack<>();
        Scanner input = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int q = input.nextInt();
        for(int i=0; i<q; i++){
            int c = input.nextInt();
            switch (c) {
                case 1:
                    String arg = input.next();
                    stack.push(new Command(c,arg));
                    str.append(arg);
                    break;
            //System.out.println(str);
                case 2:
                    {
                        int k = input.nextInt();
                        stack.push(new Command(c,str.substring(str.length()-k)));
                        str.delete(str.length()-k,str.length());
                        break;
                    }
                case 3:
                    {
                        int k = input.nextInt();
                        System.out.println(str.charAt(k-1));
                        break;
                    }
                default:
                    Command cmd = stack.pop();
                    if(cmd.code == 1){
                        str.delete(str.length()-cmd.arg.length(),str.length());
                    }else{
                        str.append(cmd.arg);
                    }   break;
            }
        }
    }
    
    public static class Command{
        public int code;
        public String arg;
        
        Command(int code, String arg){
            this.code = code;
            this.arg = arg;
        }
    }
}    
