/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.algo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author SHUBHAM
 */
public class TCSTimeAndDate {
    
    final static String DATE_FORMAT = "MM/dd";
    
    final static ArrayList<Integer> digitsArray = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] s = str.split(",");
        for (int i = 0; i < s.length; i++) {
            digitsArray.add(Integer.valueOf(s[i]));
        }
        DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");
        String d = dateFormat.format(new Date());
        String month = d.split("/")[0];
        String day = d.split("/")[1].split(" ")[0];
        String time = d.split("/")[1].split(" ")[1];
        int getDate = checkDate(day);
        int getMonth = checkMonth(month);
        String getTime = checkTime(time);
        System.out.println(getDate + "/" + getMonth + " " + getTime);
        System.out.println(isDateValid(getDate + "/" + getMonth + " " + getTime));
    }
    
    public static int checkMonth(String month)
    {
        ArrayList<Integer> al = new ArrayList<>();
        digitsArray.forEach(t -> {
            if (t <= Integer.valueOf(month)) {
                al.add(t);
            }
        });
        int x = Collections.max(al);
        digitsArray.remove(digitsArray.indexOf(x));
        return x;
    }
    
    public static int checkDate(String date)
    {
        ArrayList<Integer> al = new ArrayList<>();
        digitsArray.forEach(t -> {
            if (t < Integer.valueOf(date)) {
                al.add(t);
            }
        });
        int x = Collections.max(al);
        digitsArray.remove(digitsArray.indexOf(x));
        return x;
    }
    
    public static String checkTime(String time)
    {
        String hour = time.split(":")[0];
        String min = time.split(":")[1];
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        
        digitsArray.forEach(t -> {
            if (t < Integer.valueOf(hour)) {
                al1.add(t);
            }
        });
        int x1 = Collections.max(al1);
        digitsArray.remove(digitsArray.indexOf(x1));
        
        digitsArray.forEach(t -> {
            if (t < Integer.valueOf(min)) {
                al2.add(t);
            }
        });
        int x2 = Collections.max(al2);
        digitsArray.remove(digitsArray.indexOf(x2));
        return x1+":"+x2;
    }
    
    public static boolean isDateValid(String date) 
    {
        try 
        {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        }
        catch (ParseException e) 
        {
            System.out.println(e);
            return false;
        }
    }
}
