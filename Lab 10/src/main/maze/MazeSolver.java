package maze;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * MazeSolver is a backtracking version of MazeGame.
 * 
 * @author Mitch Parry
 * @author Willow Sapphire
 * @author Frederick Adongo
 * @version 17th April, 2025
 */
public class MazeSolver
{
    /**
     * The height of game maps.
     */
    private final static int HEIGHT = 99;

    /**
     * The width of game maps.
     */
    private final static int WIDTH = 99;

    /**
     * The game map, as a 2D array of booleans.
     * True indicates the spot is blocked.
     */
    private boolean[][] wall;

    private boolean[][] board;

    /**
     * Constructor sets up the maps and the path list.
     * 
     * @param mazeFile name of the file containing the map.
     */
    public MazeSolver(String mazeFile)
    {
        loadMaze(mazeFile);
    }

    /**
     * Loads the data from the maze file and creates the map
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     */
    private void loadMaze(String mazeFile)
    {
        wall = new boolean[HEIGHT][WIDTH];
        board = new boolean[HEIGHT][WIDTH];
        Scanner mazeScanner;
        try
        {
            mazeScanner = new Scanner(new FileReader(mazeFile));
            for (int i = 0; i < HEIGHT; i++)
            {
                for (int j = 0; j < WIDTH; j++)
                {
                    if (mazeScanner.next().equals("1"))
                    {
                        wall[i][j] = true;
                    }
                }
            }
            mazeScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + mazeFile);
        }
    }

    /**
     * 
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(int row, int col)
    {
        return (row >= 0 && row <= 98 && col >= 0 
                && col <= 98 && wall[row][col] == false);
    }

    /**
     * 
     * @return
     */
    public String findSolution()
    {
        String path = "";
        return backtrack(0, 0, path);
    }

    /**
     * 
     * @param row
     * @param col
     * @param path
     * @return
     */
    private String backtrack(int row, int col, String path)
    {
        String result;
        board[row][col] = true;
        // base case: if at goal, return path
        // else: search up(row - 1 col), down(row + 1 col), left(row col - 1), right(row col + 1), and current
        if (board[98][98])
        {
            return path;
        }
        else
        {
            // up
            if (isValid(row - 1, col) && board[row - 1][col] == false)
            {
                result = backtrack(row - 1, col, path + " up");
                if (result != null)
                {
                    return result;
                }
            }
            // down
            if (isValid(row + 1, col) && board[row + 1][col] == false)
            {
                result = backtrack(row + 1, col, path + " down");
                if (result != null)
                {
                    return result;
                }
            }
            // left
            if (isValid(row, col - 1) && board[row][col - 1] == false)
            {
                result = backtrack(row, col - 1, path + " left");
                if (result != null)
                {
                    return result;
                }
            }
            // right
            if (isValid(row, col + 1) && board[row][col + 1] == false)
            {
                result = backtrack(row, col + 1, path + " right");
                if (result != null)
                {
                    return result;
                }
            }
        }

        return null;
    }

    /**
     * Prints the map.
     */
    public void printMap()
    {
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                if (wall[i][j])
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
