/*
Knight Jumps

Have the function KnightJumps(str) read str which will be a string consisting of the location of a knight on a standard 8x8 chess board with no other pieces on the board. The structure of str will be the following: "(x y)" which represents the position of the knight with x and y ranging from 1 to 8. Your program should determine the number of spaces the knight can move to from a given location. For example: if str is "(4 5)" then your program should output 8 because the knight can move to 8 different spaces from position x=4 and y=5.
Examples
Input: "(1 1)"
Output: 2
Input: "(2 8)"
Output: 3
 */

public class KnightJumps {

    public static int knightJumps(String str) {
        int moveSum = 0, newX, newY;
        int x = str.charAt(1) - '0';
        int y = str.charAt(3) - '0';

        for (int i = -2; i <= 2; i++){
          for (int j = -2; j <= 2; j++){

            if (Math.abs(i) + Math.abs(j) == 3){

              newX = x + i;
              newY = y + j;

              if (newX >= 1 && newX <= 8 && newY >= 1 && newY <= 8)
                moveSum++;

            }
          }
        }
        return moveSum;
    }



  static int knightJumps2(String str){
		int moveSum = 0;
		int[][] moves = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
		int x = str.charAt(1) - '0';
		int y = str.charAt(3) - '0';

		for(int i = 0; i < moves.length; i++){
			int newX = x + moves[i][0];
			int newY = y + moves[i][1];

			if(newX >= 1 || newX <= 8 || newY >= 1 || newY <= 8)
				moveSum++;
		}
		return moveSum;
	}

    public static void main(String[] args) {
        System.out.println("8 = " + knightJumps("(4 5)"));
        System.out.println("2 = " + knightJumps("(1 1)"));
        System.out.println("3 = " + knightJumps("(2 8)"));
        System.out.println("2 = " + knightJumps("(1 8)"));
        System.out.println("8 = " + knightJumps("(5 4)"));
        System.out.println("4 = " + knightJumps("(8 3)"));
        System.out.println("4 = " + knightJumps("(2 2)"));
        System.out.println("2 = " + knightJumps("(8 8)"));
        System.out.println("8 = " + knightJumps("(6 3)"));
        System.out.println("6 = " + knightJumps("(7 3)"));

    }
}