/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 *
 * @author SHUBHAM
 */
public class CrosswordPuzzle 
{
    
    static String[][] puzzle = new String[10][10]; 
    static Map<Integer, List<int[]>> nodes = new HashMap<>();
    static List<String> allWords = new ArrayList<>(); 
    static Stack<Map<String, List<int[]>>> completed = new Stack<>();
    static List<Integer> keys = new ArrayList<>();
    static List<Boolean> placed = new ArrayList<>();
    
    public static void main(String[] args) 
    {

        String[] crossword = new String[10];
        
        crossword[0] = "++++++++++";
        crossword[1] = "+------+++";
        crossword[2] = "+++-++++++";
        crossword[3] = "+++-++++++";
        crossword[4] = "+++-----++";
        crossword[5] = "+++-++-+++";
        crossword[6] = "++++++-+++";
        crossword[7] = "++++++-+++";
        crossword[8] = "++++++-+++";
        crossword[9] = "++++++++++";
        
        
//        crossword[0] = "XXXXXX-XXX";
//        crossword[1] = "XX------XX";
//        crossword[2] = "XXXXXX-XXX";
//        crossword[3] = "XXXXXX-XXX";
//        crossword[4] = "XXX------X";
//        crossword[5] = "XXXXXX-X-X";
//        crossword[6] = "XXXXXX-X-X";
//        crossword[7] = "XXXXXXXX-X";
//        crossword[8] = "XXXXXXXX-X";
//        crossword[9] = "XXXXXXXX-X";
        
        String words = "POLAND;LHASA;SPAIN;INDIA";
//        String words = "ALMATY;MEXICO;PANAMA;ICELAND";

        String[] solvedPuzzle = crosswordPuzzle(crossword, words);
        for (String p : solvedPuzzle) {
            System.out.println(p);
        }
//        printSolution(puzzle);
    }
    
    /**
     * Initial function which fills all the constrant and constants
     * @param crossword
     * @param words
     * @return 
     */
    private static String[] crosswordPuzzle(String[] crossword, String words) {
        allWords = new ArrayList<>(Arrays.asList(words.split(";")));
        allWords.forEach((item) -> {
            placed.add(false);
        });
        fillPuzzle(crossword);
        Map<Integer, List<int[]>> hor = findHorizontal();
        Map<Integer, List<int[]>> ver = findVertical();
        nodes.putAll(hor);
        nodes.putAll(ver);
        keys = new ArrayList<>();
        nodes.keySet().forEach((key) -> {
            keys.add(key);
        });
        if (backTrack(0, 0)) {
            completed.forEach(s -> {
                s.entrySet().forEach(e->{
                    insertWord(e.getValue(), e.getKey());
                });
            });
        }
        return getStringArr();
    }
    
    /**
     * Backtrack function which takes nodeIndex & wordIndex
     * @param nodeIndex
     * @param wordIndex
     * @return 
     */
    private static boolean backTrack(int nodeIndex, int wordIndex)
    {
        while(wordIndex < 4)
        {
            if (!canInsert(nodes.get(keys.get(nodeIndex)), allWords.get(wordIndex), wordIndex)) 
            {
                wordIndex += 1;
            } 
            else 
            {
                placed.add(wordIndex, true);
                Map<String, List<int[]>> m = new HashMap<>();
                m.put(allWords.get(wordIndex), nodes.get(keys.get(nodeIndex)));
                completed.push(m);
                if (completed.size() == allWords.size()) 
                {
                    return true;
               }
                else
                {
                    if (backTrack(nodeIndex+1, wordIndex)) 
                    {
                        return true;
                    }
                    else
                    {
                        placed.add(wordIndex, false);
                        completed.pop();
                        wordIndex += 1;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Method which checks whether a word can be placed on the following indexes or not
     * @param index
     * @param word
     * @param wordIndex
     * @return 
     */
    private static boolean canInsert(List<int[]> index, String word, int wordIndex)
    {
        if (index.size() != word.length()) {
            return false;
        }
        if (placed.get(wordIndex)) {
            return false;
        }
        return IntStream.range(0, word.length()).allMatch(i -> {
            int x =  index.get(i)[0];
            int y =  index.get(i)[1];
            return "-".equals(puzzle[x][y]) || (puzzle[x][y] == null ? String.valueOf(word.charAt(i)) == null : puzzle[x][y].equals(String.valueOf(word.charAt(i))));
        });
    }
    
    /**
     * Method to insert word at the following positions in crossword
     * @param index
     * @param word 
     */
    private static void insertWord(List<int[]> index, String word)
    {
        for (int i = 0; i < index.size(); i++) 
        {
            int x = index.get(i)[0];
            int y = index.get(i)[1];
            puzzle[x][y] = String.valueOf(word.charAt(i));
        }
    }
    
    /**
     * Removing the word from the crossword
     * @param index 
     */
    private static void removeWord(List<int[]> index)
    {
        for (int i = 0; i < index.size(); i++) 
        {
            int x = index.get(i)[0];
            int y = index.get(i)[1];
            puzzle[x][y] = "-";
        }
    }
    
    /**
     * Finding row coordinates where words have to be inserted
     * @return 
     */
    private static Map<Integer, List<int[]>> findHorizontal()
    {
        Map<Integer, List<int[]>> nodeSpace = new HashMap<>();
        for (int i = 0; i < 10; i++) 
        {
            List<int[]> lArr = new ArrayList<>();
            for (int j = 0; j < 10; j++) 
            {
                String current = puzzle[i][j];
                if (current.equals("-")) {
                    int[] arr = {i,j};
                    lArr.add(arr);
                }
            }
            if (lArr.size() >=2) {
                boolean safe = true;
                for (int j = 0; j < lArr.size()-1; j++) {
                    if (Math.abs(lArr.get(j)[1] - lArr.get(j+1)[1]) != 1) {
                        safe = false;
                    }
                }
                if (safe) {
                    nodeSpace.put(i, lArr);
                }
            }
        }
        return nodeSpace;
    }
    
    /**
     * Finding column coordinates where words have to be inserted
     * @return 
     */
    private static Map<Integer, List<int[]>> findVertical()
    {
        Map<Integer, List<int[]>> nodeSpace = new HashMap<>();
        boolean recordFound = true;
        int colIndex = 0;
        while(recordFound) {
            List<int[]> lArr = new ArrayList<>();
            recordFound = false;
            for(int row=0; row<puzzle.length; row++) 
            {
                String[] rowArray = puzzle[row];
                if(colIndex < rowArray.length) {
                    if (rowArray[colIndex].equals("-")) 
                    {
                        int[] arr = {row,colIndex};
                        lArr.add(arr);
                    }
                    recordFound = true;
                }
            }
            colIndex++;
            if (lArr.size() >=2) {
                for (int j = 0; j < lArr.size()-1; j++) {
                    if (Math.abs(lArr.get(j)[0] - lArr.get(j+1)[0]) != 1) {
                        lArr.remove(j);
                    }
                }
                if (lArr.size() >=2) {
                    nodeSpace.put(colIndex-1, lArr);
                }
            }
        }
        return nodeSpace;
    }
    
    /**
     * Filling the puzzle matrix with the initial values
     * @param crossword 
     */    
    private static void fillPuzzle(String[] crossword)
    {
        for(int i=0;i<crossword.length;i++)
        {
            for(int j=0;j<crossword[i].length();j++)
            {
                String s = String.valueOf(crossword[i].charAt(j));
                puzzle[i][j] = s;
            }
        }
    }
    
    /**
     * Getting the final string array after crossword has been solved
     * @return 
     */
    private static String[] getStringArr()
    {
        String[] str = new String[10];
        for (int i = 0; i < 10; i++) {
            String s = "";
            for (int j = 0; j < 10; j++) {
                s += puzzle[i][j];
            }
            str[i] = s;
        }
        return str;
    }
    
    /**
     * Method to print 2D array
     * @param board 
     */
    private static void printSolution(String[][] board)
    {
        for (String[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board1[j] + " ");
            }
            System.out.println();
        }
    }
}