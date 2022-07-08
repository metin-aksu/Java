/* 
Chessboard Traveling

Have the function ChessboardTraveling(str) read str which will be a string consisting of the location of a space on a standard 8x8 chess board with no pieces on the board along with another space on the chess board. The structure of str will be the following: "(x y)(a b)" where (x y) represents the position you are currently on with x and y ranging from 1 to 8 and (a b) represents some other space on the chess board with a and b also ranging from 1 to 8 where a > x and b > y. Your program should determine how many ways there are of traveling from (x y) on the board to (a b) moving only up and to the right. For example: if str is (1 1)(2 2) then your program should output 2 because there are only two possible ways to travel from space (1 1) on a chessboard to space (2 2) while making only moves up and to the right.

Examples
Input: "(1 1)(3 3)"
Output: 6
Input: "(2 2)(4 3)"
Output: 3
*/

public class ChessboardTraveling{

    static int chessboardTraveling(String str){

        String[] arr = str.split("");
        int x = Integer.parseInt(arr[1]), y = Integer.parseInt(arr[3]),
        a = Integer.parseInt(arr[6]), b = Integer.parseInt(arr[8]);

        return goToSquare(x, y, a, b);
    }

    static int goToSquare(int x,int y, int a, int b){
        if (x == a && y == b) return 1;

        int path = 0;

        if(x < a) path += goToSquare(x+1, y, a, b);
        if(y < b) path += goToSquare(x, y+1, a, b);
        
        return path;
    }

    public static void main(String[] args) {

        System.out.println("Input = (1 1)(2 2), Expected = 2, Output = " + chessboardTraveling( "(1 1)(2 2)"));
        System.out.println("Input = (1 1)(3 3), Expected = 6, Output = " + chessboardTraveling( "(1 1)(3 3)"));
        System.out.println("Input = (2 2)(4 3), Expected = 3, Output = " + chessboardTraveling( "(2 2)(4 3)"));
        System.out.println("Input = (2 2)(3 4), Expected = 3, Output = " + chessboardTraveling( "(2 2)(3 4)"));
        System.out.println("Input = (2 2)(3 3), Expected = 2, Output = " + chessboardTraveling( "(2 2)(3 3)"));
        System.out.println("Input = (1 1)(4 4), Expected = 20, Output = " + chessboardTraveling( "(1 1)(4 4)"));
        System.out.println("Input = (1 1)(5 5), Expected = 70, Output = " + chessboardTraveling( "(1 1)(5 5)"));
        System.out.println("Input = (7 7)(8 8), Expected = 2, Output = " + chessboardTraveling( "(7 7)(8 8)"));
        System.out.println("Input = (1 1)(8 8), Expected = 3432, Output = " + chessboardTraveling( "(1 1)(8 8)"));
        System.out.println("Input = (1 1)(4 6), Expected = 56, Output = " + chessboardTraveling( "(1 1)(4 6)"));

    }
    
}
