import java.util.Random;

/**
 * WhackaMoe class handles the logic behind the game
 * @author Brandon N. Wroblewski
 */
public class WhackaMole {

    /** constant class instance int which represents number of rows */
    public static final int ROWS = 5;
    
    /** constant class instance int which represents number of columns */
    public static final int COLS = 5;
    
    /** constant class instance string array which represents symbol names*/
    public static final String[][] SYMBOL_NAMES = {{"cat", "dog", "tiger", "frog", "cat"}, 
        {"tiger", "lion", "dog", "tiger", "frog"},
        {"lion", "frog", "mole",  "dog", "cat"},
        {"frog", "dog", "tiger", "cat", "lion"},
        {"cat", "frog", "lion", "dog", "tiger"}};

    /** constant class instance int array which represents symbol values */
    public static final int[][] SYMBOL_POINTS = {{10, 15, 30, 20, 10},
        {30, 40, 15, 30, 20},
        {40, 20, 50, 15, 10},
        {20, 15, 30, 10, 40},
        {10, 20, 40, 15, 30}};

    /** 
     * private instance field which keeps track of whether game is being played
     * in testing mode
    */
    private boolean testing;

    /** a private instance variable that represents the total score */
    private int totalScore;

    /** a private instance variable that keeps track of number of misses */
    private int numberOfMisses;

    /** A grid object which represents the way symbols will be arranged in the game */
    private Grid grid;

    /** A random number generator instance which randomly places symbols on grid */
    private Random rand;

    /** private instance int which represents row that next symbol will be at */
    private int nextRow;

    /** private instance int which represents column that next symbol will be at */
    private int nextCol;

    /**
     * A constructor of the class that has a parameter of the variable
     * testing which allows the program to know if it is testing or not.
     * The constructor  also creates a new Grid object  that is filled with symbols
     * that uses the point/name values provided in SYMBOL_POINTS and SYMBOL_NAMES 
     * arrays. When testing is true the row of next row/column are set to 0, if
     * false then the random object is created
     * @param testing whether program is in testing mode
     */
    public WhackaMole(boolean testing) {
        //assigns parameter to current instance variable testing
        this.testing = testing;
        //assigns current instance variables of total score/ misses a value of 0
        this.totalScore = 0;
        this.numberOfMisses = 0;
        //creates a grid and random number generator
        grid = new Grid(ROWS, COLS);
        rand = new Random();
        //if testing it sets next row and column equal to 0
        if (testing) {
            nextRow = 0;
            nextCol = 0;
            //else it sets next row and column to a random column/row
        } else {
            nextRow = rand.nextInt(ROWS);
            nextCol = rand.nextInt(COLS);
        }
    }

    /**
     * method returns the total score of user
     * @return total score
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * method returns the number of misses
     * @return number of misses
     */
    public int getNumberOfMisses() {
        return numberOfMisses;
    }

    /**
     * returns next row symbol will be displayed on
     * @return next row number
     */
    public int getNextRow() {
        return nextRow;
    }

    /**
     * returns next column symbol will be displayed on
     * @return next column number
     */
    public int getNextCol() {
        return nextCol;
    }

    /**
     * This method returns the symbol name at a given position in grid
     * @param row represents row number on grid that symbol is at
     * @param col represents column number on grid that symbol is at
     * @return symbol name
     * @throws IllegalArgumentException if row or column is less than 0 or greater than/
     * equal to total number of rows/columns
     */
    public String getSymbolName(int row, int col) {
        if (row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Invalid col");
        }
        return SYMBOL_NAMES[row][col];
    }

    /**
     * This method returns the symbol points at a given position in grid
     * @param row represents row number on grid that symbol is at
     * @param col represents column number on grid that symbol is at
     * @return symbol points
     * @throws IllegalArgumentException if row or column is less than 0 or greater than/
     * equal to total number of rows/columns
     */
    public int getSymbolPoints(int row, int col) {
        if (row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Invalid col");
        }
        return SYMBOL_POINTS[row][col];
    }

    /**
     * Method returns true if given symbol at given row/col has been clicked
     * on, false otherwise. 
     * @param row represents a row on grid
     * @param col represents a column on grid 
     * @return whether the symbol was clicked on
     * @throws IllegalArgumentException if row or column is less than 0 or greater than/
     * equal to total number of rows/columns
     */
    public boolean hasBeenClickedOn(int row, int col) {
        if (row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Invalid col");
        }
        return grid.getSymbol(row, col).hasBeenClickedOn();
    }

    /**
     * Checks if every symbol on grid had been clicked on
     * @return true if all symbols on grid were clicked on, else it returns
     * false
     */
    public boolean allSymbolsClickedOn() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (!grid.getSymbol(row, col).hasBeenClickedOn()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method sets the next position on the grid for the symbol to be
     * displayed, if all symbols have been clicked on then it ends the game
     */
    private void updateNextRowAndCol() {
        if (allSymbolsClickedOn()) {
            nextRow = -1;
            nextCol = -1;
            return;
        }
    
        if (testing) {
            do {
                nextCol++;
                if (nextCol >= COLS) {
                    nextCol = 0;
                    nextRow++;
                }
                if (nextRow >= ROWS) {
                    nextRow = 0;
                }
            } while (grid.getSymbol(nextRow, nextCol).hasBeenClickedOn());
        } else {
            Random random = new Random();
            do {
                nextRow = random.nextInt(ROWS);
                nextCol = random.nextInt(COLS);
            } while (grid.getSymbol(nextRow, nextCol).hasBeenClickedOn());
        }
    }

    /**
     * If symbol in given element of array has not been clicked on
     * this method sets the symbol to "has been clicked on", then updates score
     * with points for the symbol and calls updateNextRowAndCol method
     * @param row represents row grid element is on
     * @param col represents column grid element is on
     */
    public void clickOnSymbol(int row, int col) {

    }
    
    /**
     * Method adds one to number of misses when called on
     * then ucalls upon updateNextRowAndCol method
     */
    public void addMiss() {
        numberOfMisses++;
        updateNextRowAndCol();
    }
    
    /**
     * Method returns the grid instance
     * @return grid insance
     */
    public Grid getGrid() {
        return grid;
    }
    
    
    
}
