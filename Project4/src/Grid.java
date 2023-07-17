/**
 * The grid class represents the two dimensional layout of symbols
 * @author Brandon N. Wroblewski
 */
public class Grid {
    
    /** private integer instance field that represents rows */
    private int rows;

    /** private integer instance field that represents columns*/
    private int cols;

    /** 
     * private 2D symbol array instance field that represents a
     * single symbol object
     */
    private Symbol[][] symbols;

    /**
     * Constructor of Grid class with values of rows and columns
     * as parameter which are assigned to instance variables by method
     * @param rows represents number of rows in 2D array
     * @param cols represents number of columns in 2D array
     * @throws IllegalArgumentException if rows/columns are less than one
     */
    public Grid(int rows, int cols) {
        //throws IllegalArgumentException if rows/columns less than 1
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Invalid rows/cols");
        }
        //assigns parameter values to current instance variables
        this.rows = rows;
        this.cols = cols;
        symbols = new Symbol[rows][cols];
    }

    /**
     * This method returns number of rows in grid
     * @return int value of number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * This method returns number of columns in grid
     * @return int value of number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * This method stores the symbol in the 2D array at any given row/column
     * @param row represents given row value
     * @param col represents given column value 
     * @param symbol represents a symbol at a given element in array
     * @throws IllegalArgumentException if symbol is null, or if row/column is
     * greater than/ equal to number of rows/columns or less than 0
     */
    public void setSymbol(int row, int col, Symbol symbol) {
        if (symbol == null) {
            throw new IllegalArgumentException("Null symbol");
        }
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid col");
        }
        symbols[row][col] = symbol;
    }

    /**
     * method returns the symbol in 2D array at the given row/column
     * @param row represents given row value
     * @param col represents given column value
     * @return symbol at given array element
     * @throws IllegalArgumentException if row/column is
     * greater than/ equal to number of rows/columns or less than 0
     */
    public Symbol getSymbol(int row, int col) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid col");
        }
        return symbols[row][col];
    }

    /**
     * This method creates a string representation of grid that contains the
     * name of each symbol in the grid, the names in each row are seperated by
     * a single space but no space after last symbol in row
     * @return string of array
     */
    public String toString() {
        //creates empty string to store result
        String result = "";
        // iterates through each row
        for (int i = 0; i < rows; i++) {
            //iterates through each column of row
            for (int j = 0; j < cols; j++) {
                //adds the name of each symbol from column to the result string
                result += symbols[i][j].getName();
                //adds a space after each symbol if it is not last symbol
                if (j != cols - 1) {
                    result += " ";
                }
            }
            //adds new line before moving onto next row
            result += "\n";
        }
        //returns result
        return result;
    }
    
    
}
