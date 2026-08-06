package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Frederick Adongo
 * @version 23rd January, 2024
 * 
 */

public class MazeGame {

    public static final int HEIGHT = 19;
    public static final int WIDTH = 39;
    
    private static final int COL = 1;
    private static final int ROW = 0;

    private Scanner playerInput;
    private boolean[][] blocked;
    private boolean[][] visited;

    private int[] player;
    private int[] goal;
    private int[] start;

    /**
     * 
     * @param mazeFile
     * @throws IOException
     */
    public MazeGame(String mazeFile) throws FileNotFoundException
    {
        this(mazeFile, new Scanner(System.in));
    }

    /**
     * 
     * @param mazeFile
     * @param playerInput
     * @throws IOException
     */
    public MazeGame(String mazeFile, Scanner playerInput) throws FileNotFoundException
    {
        this.playerInput = playerInput;
        loadMaze(mazeFile);
    }

    /**
     * 
     */
    public void playGame()
    {      
        boolean quit = false;
        String move;
        Scanner playScanner = getPlayerInput();

        while (!quit)
        {
            prompt();
            move = playScanner.next();
            quit = makeMove(move);

        }
        
        if (playerAtGoal()) 
        {
            System.out.println("You Won!");
        } 
        else 
        {
            System.out.println("Goodbye!");

        }

    }

    /**
     * 
     */
    public void printMaze()
    {

        /**
         * Corner = "*"
         * Top = "-"
         * Sides = "|"
         * start[] = "S"
         * goal[] = "G"
         * player location = "@"
         * visited[][] = "."
         * 
         */
        System.out.println("*---------------------------------------*");
        for (int i = 0; i < HEIGHT; i++)
        {
            System.out.print("|");

            for (int j = 0; j < WIDTH; j++)
            {
                if (i == this.player[ROW] && j == this.player[COL])
                {
                    System.out.print("@");
                }
                else if (i == this.start[ROW] && j == this.start[COL])
                {
                    System.out.print("S");
                }
                else if (i == this.goal[ROW] && j == this.goal[COL])
                {
                    System.out.print("G");
                }
                else if (this.blocked[i][j])
                {
                    System.out.print("X");
                }
                else if (this.visited[i][j])
                {
                    System.out.print(".");
                }
                else
                {
                    System.out.print(" ");
                }
            }

            System.out.print("|");

            System.out.println();
        }
        System.out.println("*---------------------------------------*");
    }

    /**
     * 
     * @return
     */
    public int getPlayerRow()
    {
        return this.player[ROW];
    }

    /**
     * 
     * @return
     */
    public int getPlayerCol()
    {
        return this.player[COL];
    }

    /**
     * 
     * @return
     */
    public int getGoalRow()
    {
        return this.goal[ROW];
    }

    /**
     * 
     * @return
     */
    public int getGoalCol()
    {
        return this.goal[COL];
    }

    /**
     * 
     * @return
     */
    public int getStartRow()
    {
        return this.start[ROW];
    }

    /**
     * 
     * @return
     */
    public int getStartCol()
    {
        return this.start[COL];
    }   

    public boolean[][] getBlocked()
    {
        return copyTwoDimBoolArray(blocked);
    }

    public boolean[][] getVisited()
    {
        return copyTwoDimBoolArray(visited);
    }

    public Scanner getPlayerInput()
    {
        return playerInput;
    }

    public void setPlayerRow(int row)
    {
        if (row >= 0 && row < HEIGHT)
        {
            this.player[ROW] = row;
        }

    }

    public void setPlayerCol(int col)
    {
        if (col >= 1 && col < WIDTH)
        {
            this.player[COL] = col;
        }
    }

    public void setGoalRow(int row)
    {
        if (row >= 0 && row < HEIGHT)
        {
            this.goal[ROW] = row;
        }
    }

    public void setGoalCol(int col)
    {
        if (col >= 1 && col < WIDTH)
        {
            this.goal[COL] = col;
        }
    }

    public void setStartRow(int row)
    {
        if (row >= 0 && row < HEIGHT)
        {
            this.start[ROW] = row;
        }
    }

    public void setStartCol(int col)
    {
        if (col >= 1 && col < WIDTH)
        {
            this.start[COL] = col;
        }
    }

    public void setBlocked(boolean[][] blocked)
    {
        boolean[][] copyArray = copyTwoDimBoolArray(blocked);
        this.blocked = copyArray;
    }

    public void setVisited(boolean[][] visited)
    {
        boolean[][] copyArray = copyTwoDimBoolArray(visited);
        this.visited = copyArray;
    }

    /**
     * 
     * @param playerInput
     */
    public void setPlayerInput(Scanner playerInput)
    {
        this.playerInput = playerInput;
    }

    /**
     * 
     * @param arrayToCopy
     * @return 
     */
    private boolean[][] copyTwoDimBoolArray(boolean[][] arrayToCopy)
    {
        boolean[][] twoDimArray = new boolean[arrayToCopy.length][arrayToCopy[0].length];

        for (int i = 0; i < arrayToCopy.length; i++)
        {
            for (int j = 0; j < arrayToCopy[0].length; j++)
            {
                twoDimArray[i][j] = arrayToCopy[i][j];
            }
        }

        return twoDimArray;
    }

    /**
     * 
     */
    private void prompt()
    {
        printMaze();
        System.out.print("Enter your move (up, down, left, right, or q to quit): ");
    }

    /**
     * 
     * @return
     */
    private boolean playerAtGoal()
    {
        return (this.player[ROW] == this.goal[ROW] &&
                this.player[COL] == this.goal[COL]);
    }

    /**
     * 
     * @param row
     * @param col
     * @return
     */
    private boolean valid(int row, int col)
    {
        //if valid return true
        return row >= 0 && row < HEIGHT &&
                col >= 0 && col < WIDTH &&
                !this.blocked[row][col];

    }

    /**
     * 
     * @param row
     * @param col
     */
    private void visit(int row, int col)
    {
        this.visited[row][col] = true;
    }

    /**
     * 
     * @param mazeFile
     */
    private void loadMaze(String mazeFile) throws FileNotFoundException
    {
        File file = new File(mazeFile);
        Scanner readMaze = new Scanner(file);

        blocked = new boolean[HEIGHT][WIDTH];
        visited = new boolean[HEIGHT][WIDTH];
        player = new int[2];
        goal = new int[2];
        start = new int[2];

        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                char character = readMaze.next().charAt(0);

                switch(character)
                {
                    case 'S':
                        start[0] = i;
                        start[1] = j;
                        player[0] = i;
                        player[1] = j;
                        break;
                    case 'G':
                        goal[0] = i;
                        goal[1] = j;
                        break;
                    case '1':
                        blocked[i][j] = true;
                        break;
                    case '0':
                        blocked[i][j] = false;
                        break;
                    default:
                        break;
                }
            }
            
        }

        readMaze.close();
       
    }

    /**
     * 
     * @param move
     * @return
     */
    private boolean makeMove(String move)
    {
        move = move.toLowerCase();
        int newRow = getPlayerRow();
        int newCol = getPlayerCol();

        switch(move.charAt(0))
        {
            case 'q':
                return true;
            case 'l':
                newCol--;
                break;
            case 'r':
                newCol++;
                break;
            case 'u':
                newRow--;
                break;
            case 'd':
                newRow++;
                break;
            default:
                break;
        }

        if (valid(newRow, newCol))
        {
            visit(newRow, newCol);
            setPlayerCol(newCol);
            setPlayerRow(newRow);
            return playerAtGoal();
        }
        else
        {
            return false;
        }
    }
}