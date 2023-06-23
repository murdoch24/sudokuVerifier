import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku verifier checks for a valid sudoku solution in a 9x9
 * 2d Array
 *
 * @author Amy Murdoch
 * @version 23/06/2023
 */
public class SudokuVerifier {

    private int[][] grid;


    /**
     * Constructor for objects of class SudokuVerifier
     */
    public SudokuVerifier(int[][] initGrid) {
        // initialise instance variables
        this.grid = initGrid;

    }

    public SudokuVerifier(boolean isTrue) {
        if (isTrue) {
            populateGrid1();// populates the grid with a correct solution

        } else {
            populateGrid2(); //populates the grid with incorrect solution
        }
    }

    /**
     * Checks a single row with index specified by parameter
     * Returns true if the row contains each of the digits 1 to 9
     *
     * @param row int that must be a valid row index
     * @return true if the row is valid, otherwise returns false
     */

    private boolean checkARow(int row) {
        Set<Integer> tempSet = createSet();
        for (int i = 0; i < grid[0].length; i++) {
            tempSet.remove(grid[row][i]);
        }
        return tempSet.isEmpty();

    }

    /**
     * Checks each row of the puzzle
     * Returns true if ALL rows are correct, otherwise false
     *
     * @return true if all rows are valid, otherwise false
     */

    private boolean checkAllRows() {
        for (int i = 0; i < grid.length; i++) {
            if (!checkARow(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks a single column with index specified by parameter
     * Returns true if column contains each digit of 1 to 9
     *
     * @param column an int that must be a valid column index
     * @return true if the column is valid, otherwise false
     */

    private boolean checkAColumn(int column) {
        Set<Integer> tempSet = createSet();
        for (int i = 0; i < grid[0].length; i++) {
            tempSet.remove(grid[i][column]);
        }

        return tempSet.isEmpty();
    }

    /**
     * Checks all columns in the puzzle
     *
     * @return true if all columns are valid, false otherwise
     */

    private boolean checkAllColumns() {
        for (int i = 0; i < grid.length; i++) {
            if (!checkAColumn(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks a single block with row index and coolumn index of its
     * left hand element being specified by the two parameters
     * Returns true if the block contains each of the digits 1 to 9
     *
     * @param rowIndex    an int that must be a valid row index
     * @param columnIndex an int that must be a valid column index
     * @return true if the block is a valid block, otherwise false
     */

    private boolean checkABlock(int rowIndex, int columnIndex) {
        Set<Integer> tempSet = createSet();

        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = columnIndex; j < columnIndex + 3; j++) {
                tempSet.remove(grid[i][j]);
            }
        }

        return tempSet.isEmpty();
    }

    /**
     * Check each lock of the puzzle
     * Returns true if all blocks are correct, otherwise false
     *
     * @return true if all blocks are valid, otherwise false
     */

    private boolean checkAllBlocks() {
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!checkABlock(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks all blocks, all rows and all columns
     * prints "Correct solution" if grid represents a correct solution
     * prints "Incorrect solution" if grid represents an incorrect solution
     */

    public void verifySolution() {
        if (checkAllBlocks() && checkAllRows() && checkAllColumns()) {
            System.out.println("Correct solution");
        } else {
            System.out.println("Incorrect solution");
        }
    }


    /**
     * Populates grid with a correct solution
     */
    private void populateGrid1() {
        int[][] tempArray = {{2, 4, 1, 6, 9, 5, 3, 8, 7},
                {7, 3, 5, 4, 2, 8, 1, 6, 9},
                {8, 6, 9, 7, 3, 1, 4, 2, 5},
                {4, 1, 3, 8, 7, 9, 2, 5, 6},
                {6, 9, 2, 5, 1, 3, 7, 4, 8},
                {5, 8, 7, 2, 4, 6, 9, 3, 1},
                {1, 7, 8, 3, 6, 4, 5, 9, 2},
                {9, 5, 4, 1, 8, 2, 6, 7, 3},
                {3, 2, 6, 9, 5, 7, 8, 1, 4}};
        grid = tempArray;
    }

    /**
     * Populates grid with an incorrect solution
     */
    private void populateGrid2() {
        int[][] tempArray = {{2, 4, 1, 6, 9, 5, 3, 8, 1},
                {7, 3, 5, 4, 2, 8, 1, 6, 9},
                {8, 6, 9, 7, 3, 1, 4, 2, 5},
                {4, 1, 3, 8, 7, 9, 2, 5, 6},
                {6, 9, 2, 5, 2, 3, 7, 4, 8},
                {5, 8, 7, 2, 4, 6, 9, 3, 1},
                {1, 7, 8, 3, 6, 4, 5, 9, 2},
                {8, 5, 4, 1, 8, 2, 6, 7, 3},
                {3, 2, 6, 9, 5, 7, 8, 1, 4}};
        grid = tempArray;
    }

    private Set<Integer> createSet() {
        Set<Integer> intSet = new HashSet<>();
        intSet.add(1);
        intSet.add(2);
        intSet.add(3);
        intSet.add(4);
        intSet.add(5);
        intSet.add(6);
        intSet.add(7);
        intSet.add(8);
        intSet.add(9);
        return intSet;

    }


}



