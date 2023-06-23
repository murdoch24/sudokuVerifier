public class Main {
    public static void main(String[] args) {


        // creates a new sudoku with a correct solution
        SudokuVerifier sudokuCorrect = new SudokuVerifier(true);

        // creates a new sudoku with an incorrect solution
        SudokuVerifier sudokuIncorrect = new SudokuVerifier(false);

        // Checks all rows, columns and blocks and prints correct solution
        sudokuCorrect.verifySolution();

        // Checks all rows, columns and blocks and prints incorrect solution
        sudokuIncorrect.verifySolution();


    }
}
