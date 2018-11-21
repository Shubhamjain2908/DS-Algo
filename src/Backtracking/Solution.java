/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backtracking;

/**
 *
 * @author SHUBHAM
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution 
{

    static final int SIZE = 10;
    static final int[] R_OFFSETS = {0, 1};
    static final int[] C_OFFSETS = {1, 0};

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
        
//        crossword[0] = "+-++++++++";
//        crossword[1] = "+-++++++++";
//        crossword[2] = "+-------++";
//        crossword[3] = "+-++++++++";
//        crossword[4] = "+-++++++++";
//        crossword[5] = "+------+++";
//        crossword[6] = "+-+++-++++";
//        crossword[7] = "+++++-++++";
//        crossword[8] = "+++++-++++";
//        crossword[9] = "++++++++++";
        
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
        
        String[] words = {"POLAND","LHASA","SPAIN","INDIA"};
//        String[] words = {"AGRA","NORWAY","ENGLAND","GWALIOR"};
//        String[] words = {"ICELAND","MEXICO","PANAMA","ALMATY"};
        
        char[][] grid = getPuzzle(crossword);
        char[][] solution = solve(grid, words);
        IntStream.range(0, SIZE).forEach(r -> System.out.println(solution[r]));
    }
    
    private static char[][] solve(char[][] grid, String[] words) 
    {
        return search(grid, Arrays.stream(words).collect(Collectors.toSet()), 0, 0, 0);
    }

    private static char[][] search(char[][] grid, Set<String> remainWords, int r, int c, int direction) 
    {
        if (r == SIZE) 
        {
            return grid;
        }
        if (c == SIZE) 
        {
            return search(grid, remainWords, r + 1, 0, 0);
        }
        if (direction == R_OFFSETS.length) 
        {
            return search(grid, remainWords, r, c + 1, 0);
        }

        int insertLength = countInsertLength(grid, r, c, direction);
        if (insertLength > 1) 
        {
            for (String remainWord : new ArrayList<>(remainWords)) 
            {
                if (canInsert(grid, r, c, direction, insertLength, remainWord)) 
                {
                    List<Integer> insertOffsets = new ArrayList<>();

                    for (int insertOffset = 0; insertOffset < insertLength; insertOffset++) 
                    {
                        int insertR = r + R_OFFSETS[direction] * insertOffset;
                        int insertC = c + C_OFFSETS[direction] * insertOffset;

                        if (grid[insertR][insertC] == '-') 
                        {
                            grid[insertR][insertC] = remainWord.charAt(insertOffset);
                            insertOffsets.add(insertOffset);
                        }
                    }
                    remainWords.remove(remainWord);

                    char[][] subResult = search(grid, remainWords, r, c, direction + 1);
                    if (subResult != null) 
                    {
                        return subResult;
                    }

                    remainWords.add(remainWord);
                    for (int insertOffset : insertOffsets) 
                    {
                        int insertR = r + R_OFFSETS[direction] * insertOffset;
                        int insertC = c + C_OFFSETS[direction] * insertOffset;

                        grid[insertR][insertC] = '-';
                    }
                }
            }
            return grid;
        } 
        else 
        {
            return search(grid, remainWords, r, c, direction + 1);
        }
    }

    private static int countInsertLength(char[][] grid, int r, int c, int direction) 
    {
        int prevR = r - R_OFFSETS[direction];
        int prevC = c - C_OFFSETS[direction];
        if (prevR >= 0 && prevR < SIZE && prevC >= 0 && prevC < SIZE && grid[prevR][prevC] != '+') 
        {
            return 0;
        }

        int insertLength = 0;
        while (r >= 0 && r < SIZE && c >= 0 && c < SIZE && grid[r][c] != '+') 
        {
            insertLength++;
            r += R_OFFSETS[direction];
            c += C_OFFSETS[direction];
        }
        return insertLength;
    }

    private static boolean canInsert(char[][] grid, int r, int c, int direction, int insertLength, String word) 
    {
        return word.length() == insertLength && IntStream.range(0, word.length()).allMatch(i -> {
            int insertR = r + R_OFFSETS[direction] * i;
            int insertC = c + C_OFFSETS[direction] * i;

            return grid[insertR][insertC] == '-' || grid[insertR][insertC] == word.charAt(i);
        });
    }
    
    private static char[][] getPuzzle(String[] crossword)
    {
        char[][] puzzle = new char[10][10];
        for(int i=0;i<crossword.length;i++)
        {
            for(int j=0;j<crossword[i].length();j++)
            {
                puzzle[i][j] = crossword[i].charAt(j);
            }
        }
        return puzzle;
    }
}
