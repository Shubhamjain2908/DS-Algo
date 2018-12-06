/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WtoW;

import java.util.Random;

/**
 *
 * @author SHUBHAM
 */
public class WhatToWatch {
    public static void main(String[] args) 
    {
        String wTow;
        LRUCache l = new LRUCache();
        do
        {
            wTow = getSeason();
        } while(l.shouldWatch(wTow));
        System.out.println("You should watch : "+ wTow);
    }
    private static String getSeason()
    {
        Random rand = new Random();
        String[] series = {"FRIENDS", "HIMYM", "BBT"};
        int se = rand.nextInt(3);
        int s = rand.nextInt(11);
        int e = rand.nextInt(24);
        String wTow = series[se] +" S" + s +"E"+e;
        return wTow;
    }
}