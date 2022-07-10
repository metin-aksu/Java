import javax.swing.text.StyledEditorKit;

/*
Coin Determiner
Have the function CoinDeterminer(num) take the input, which will be an integer ranging from 1 to 250, and return an integer output that will specify the least number of coins, that when added, equal the input integer. Coins are based on a system as follows: there are coins representing the integers 1, 5, 7, 9, and 11. So for example: if num is 16, then the output should be 2 because you can achieve the number 16 with the coins 9 and 7. If num is 25, then the output should be 3 because you can achieve 25 with either 11, 9, and 5 coins or with 9, 9, and 7 coins.

Examples
Input: 6
Output: 2
Input: 16
Output: 2 
 */
public class CoinDeterminer {
    
    static final int[] coins = new int[] {1, 5, 7, 9, 11};

    static int coinDeterminer(int num) {
        int minCount = num;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int count = getCount(num, i, j);
                if (count < minCount) minCount = count;            
            }
        }
        return minCount;
    }

    static int getCount(int num, int maxIndex, int startIndex) {
        int count = 0;

        if (num >= coins[maxIndex]) {
            num -= coins[maxIndex];
            count++;
        }

        for (int i = startIndex; i >= 0; i--) {
            while (num >= coins[i]) {
                num -= coins[i];
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        System.out.println("Number = 16, expected = 2, output = " + coinDeterminer(16));
        System.out.println("Number = 25, expected = 3, output = " + coinDeterminer(25));
        System.out.println("Number = 12, expected = 2, output = " + coinDeterminer(12));
        System.out.println("Number = 5, expected = 1, output = " + coinDeterminer(5));
        System.out.println("Number = 34, expected = 4, output = " + coinDeterminer(34));
        System.out.println("Number = 37, expected = 5, output = " + coinDeterminer(37));
        System.out.println("Number = 100, expected = 10, output == " + coinDeterminer(100));
        System.out.println("Number = 14, expected = 2, output = " + coinDeterminer(14));
        System.out.println("Number = 6, expected = 2, output = " + coinDeterminer(6));
    }
}
