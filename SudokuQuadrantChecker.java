/* 
Sudoku Quadrant Checker
Have the function SudokuQuadrantChecker(strArr) read the strArr parameter being passed which will represent a 9x9 Sudoku board of integers ranging from 1 to 9. The rules of Sudoku are to place each of the 9 integers integer in every row and column and not have any integers repeat in the respective row, column, or 3x3 sub-grid. The input strArr will represent a Sudoku board and it will be structured in the following format: ["(N,N,N,N,N,x,x,x,x)","(...)","(...)",...)] where N stands for an integer between 1 and 9 and x will stand for an empty cell. Your program will determine if the board is legal; the board also does not necessarily have to be finished. If the board is legal, your program should return the string legal but if it isn't legal, it should return the 3x3 quadrants (separated by commas) where the errors exist. The 3x3 quadrants are numbered from 1 to 9 starting from top-left going to bottom-right.

For example, if strArr is: ["(1,2,3,4,5,6,7,8,1)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(1,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)"] then your program should return 1,3,4 since the errors are in quadrants 1, 3 and 4 because of the repeating integer 1.

Another example, if strArr is: ["(1,2,3,4,5,6,7,8,9)","(x,x,x,x,x,x,x,x,x)","(6,x,5,x,3,x,x,4,x)","(2,x,1,1,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,9)"] then your program should return 3,4,5,9.
Examples
Input: ["(1,2,3,4,5,6,7,8,1)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(1,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)","(x,x,x,x,x,x,x,x,x)"]
Output: 1,3,4
 */

class SudokuQuadrantChecker {

    static String SudokuChecker(String[] arr) {
        StringBuilder mResult = new StringBuilder();
        String[][] sudoku = new String[9][9];
        String row;

        // Sudoku tablosunun doldurulması
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                row = arr[x].replace("(", "").replace(")", "").replace(",", "");
                sudoku[x][y] = row.substring(y, y + 1).trim();
            }
        }

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {

                if (!sudoku[x][y].equals("x")) {

                    for (int a = 0; a < 9; a++) // Dikey eksende kontrol
                        if(sudoku[x][y].equals(sudoku[a][y]) && x != a)
                            if (mResult.indexOf(getBoard(x,y)) < 0)
                                mResult.append(getBoard(x,y)).append(",");

                    
                    for (int b = 0; b < 9; b++) // Yatay eksende kontrol
                        if(sudoku[x][y].equals(sudoku[x][b]) && y != b)
                            if (mResult.indexOf(getBoard(x,y)) < 0)
                                mResult.append(getBoard(x,y)).append(",");

                }

            }
        }

        return mResult.length() > 0 ? mResult.toString().substring(0, mResult.length()-1) : "legal";
    }

    static String getBoard(int x, int y) {
        x++;y++;

        if (x <= 3 && y <= 3) return "1";
        if (x <= 3 && y <= 6) return "2";
        if (x <= 3 && y <= 9) return "3";

        if (x <= 6 && y <= 3) return "4";
        if (x <= 6 && y <= 6) return "5";
        if (x <= 6 && y <= 9) return "6";

        if (x <= 9 && y <= 3) return "7";
        if (x <= 9 && y <= 6) return "8";
        if (x <= 9 && y <= 9) return "9";

        return "0";
    }

    public static void main(String[] args) {

        String[] sudoku1 = {"(1,2,3,4,5,6,7,8,1)", 
                            "(x,x,x,x,x,x,x,x,x)", 
                            "(x,x,x,x,x,x,x,x,x)", 
                            "(1,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)", 
                            "(x,x,x,x,x,x,x,x,x)", 
                            "(x,x,x,x,x,x,x,x,x)", 
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)" }; // 1,3,4
                
        String[] sudoku2 = {"(1,2,3,4,5,6,7,8,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(6,x,5,x,3,x,x,4,x)",
                            "(2,x,1,1,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,9)"}; //  3,4,5,9
                
        String[] sudoku3 = {"(1,2,3,4,5,6,7,8,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(6,x,5,x,3,x,x,4,x)",
                            "(2,x,1,1,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)"}; // 4,5
                
        String[] sudoku4 = {"(1,2,3,4,5,6,7,8,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(6,x,5,x,3,x,x,4,x)",
                            "(2,x,1,5,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,8)"}; // legal
                
        String[] sudoku5 = {"(1,2,3,4,5,6,7,8,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(6,x,5,x,3,x,x,4,x)",
                            "(2,x,1,5,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,4)",
                            "(9,1,2,3,4,5,6,7,8)"}; // legal
                
        String[] sudoku6 = {"(1,2,3,4,5,6,7,8,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(6,x,5,x,3,x,x,4,x)",
                            "(2,x,1,5,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,9)",
                            "(9,1,2,3,4,5,6,7,8)"}; // 3,9
                
        String[] sudoku7 = {"(1,2,3,4,5,6,7,8,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(6,x,5,x,3,x,x,4,x)",
                            "(2,x,1,5,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,9)",
                            "(9,1,2,3,4,5,6,7,8)"}; // 3,6,9
                
        String[] sudoku8 = {"(9,2,3,4,5,6,7,8,9)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(6,x,5,x,3,x,x,4,x)",
                            "(2,x,1,5,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,1)",
                            "(x,x,x,x,x,x,x,x,2)",
                            "(9,1,2,3,4,5,6,7,8)"}; // 1,3,7
                
        String[] sudoku9 = {"(1,2,3,4,5,6,7,8,9)",
                            "(4,5,6,x,x,x,x,x,x)",
                            "(7,8,9,x,x,x,x,x,x)",
                            "(2,3,4,x,x,x,x,x,x)",
                            "(5,6,7,x,x,x,x,x,x)",
                            "(8,9,1,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,1)"}; // legal
                
        String[] sudoku10 ={"(1,2,3,4,5,6,7,8,9)",
                            "(4,5,6,1,2,3,x,x,x)",
                            "(7,8,9,x,x,6,x,x,x)",
                            "(2,3,4,x,x,x,x,x,x)",
                            "(5,6,7,x,x,x,x,x,x)",
                            "(8,9,1,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,x)",
                            "(x,x,x,x,x,x,x,x,1)"}; // 2

        System.out.println("1,3,4 = " + SudokuChecker(sudoku1));
        System.out.println("3,4,5,9 = " + SudokuChecker(sudoku2));
        System.out.println("4,5 = " + SudokuChecker(sudoku3));
        System.out.println("legal = " + SudokuChecker(sudoku4));
        System.out.println("legal = " + SudokuChecker(sudoku5));
        System.out.println("3,9 = " + SudokuChecker(sudoku6));
        System.out.println("3,6,9 = " + SudokuChecker(sudoku7));
        System.out.println("1,3,7 = " + SudokuChecker(sudoku8));
        System.out.println("legal = " + SudokuChecker(sudoku9));
        System.out.println("2 = " + SudokuChecker(sudoku10));
    }
}