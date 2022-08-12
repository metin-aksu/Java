/* 
Kaprekars Constant

Have the function KaprekarsConstant(num) take the num parameter being passed which will be a 4-digit number with at least two distinct digits. Your program should perform the following routine on the number: Arrange the digits in descending order and in ascending order (adding zeroes to fit it to a 4-digit number), and subtract the smaller number from the bigger number. Then repeat the previous step. Performing this routine will always cause you to reach a fixed number: 6174. Then performing the routine on 6174 will always give you 6174 (7641 - 1467 = 6174). Your program should return the number of times this routine must be performed until 6174 is reached. For example: if num is 3524 your program should return 3 because of the following steps: (1) 5432 - 2345 = 3087, (2) 8730 - 0378 = 8352, (3) 8532 - 2358 = 6174.
Examples
Input: 2111
Output: 5
Input: 9831
Output: 7
 */

import java.util.Arrays;

public class KaprekarsConstant {

    static int count = 0;

    static int KaprekarsConstant(int num){
        String[] arr = String.valueOf(num).split("");
        Arrays.sort(arr);
        StringBuilder str = new StringBuilder(Arrays.toString(arr));

        int num1 = convertNumber(str.toString());
        int num2 = convertNumber(str.reverse().toString());

        int diff = num2 - num1;

        if (diff < 1000) diff = convertNumber(diff + "0");
        if (diff < 100) diff = convertNumber(diff + "00");
        if (diff < 10) diff = convertNumber(diff + "000");

        count++;

        return diff == 6174 ? count : KaprekarsConstant(diff);
    }
    static int convertNumber(String str){
        str = str.replaceAll("[^0-9]","");
        return Integer.parseInt(str);
    }
    public static void main(String[] args){
        System.out.println("3 = " + KaprekarsConstant(3524));// 3        
        // System.out.println("5 = " + KaprekarsConstant(2111));// 5
        // System.out.println("7 = " + KaprekarsConstant(9831));// 7
        // System.out.println("7 = " + KaprekarsConstant(9813));// 7
        // System.out.println("7 = " + KaprekarsConstant(4371));// 7
        // System.out.println("1 = " + KaprekarsConstant(7614));// 1
        // System.out.println("4 = " + KaprekarsConstant(8774));// 4
        // System.out.println("4 = " + KaprekarsConstant(7847));// 4
        // System.out.println("5 = " + KaprekarsConstant(1121));// 5
        // System.out.println("3 = " + KaprekarsConstant(5342));// 3
        
    }
}
