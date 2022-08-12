/*
Off Binary

Have the function OffBinary(strArr) read the array of strings stored in strArr, which will contain two elements, the first will be a positive decimal number and the second element will be a binary number. Your goal is to determine how many digits in the binary number need to be changed to represent the decimal number correctly (either 0 change to 1 or vice versa). For example: if strArr is ["56", "011000"] then your program should return 1 because only 1 digit needs to change in the binary number (the first zero needs to become a 1) to correctly represent 56 in binary.
Examples
Input: ["5624", "0010111111001"]
Output: 2
Input: ["44", "111111"]
Output: 3
 */

public class OffBinary {
    static int OffBinary(String[] strArr) {

        int count = 0;
        String num1 = Integer.toBinaryString(Integer.parseInt(strArr[0]));
        String num2 = strArr[1];

        for (int i = 0; i< num1.length(); i++)
            if (num1.charAt(i) != num2.charAt(i)) count++;

        return count;
    }

    public static void main(String[] args) {

        System.out.println("1 = " + OffBinary(new String[] { "56", "011000" }));// 1
        System.out.println("2 = " + OffBinary(new String[]{"5624","0010111111001"}));// 2
        System.out.println("3 = " + OffBinary(new String[]{"44", "111111"}));// 3
        System.out.println("0 = " + OffBinary(new String[]{"1", "1"}));// 0
        System.out.println("1 = " + OffBinary(new String[]{"1111", "00001010111"}));// 1
        System.out.println("3 = " + OffBinary(new String[]{"1111", "10001010000"}));// 3
        System.out.println("0 = " + OffBinary(new String[]{"1234567", "100101101011010000111"}));// 0
        System.out.println("6 = " + OffBinary(new String[]{"1234567", "111101100011010010100"}));// 6
        System.out.println("3 = " + OffBinary(new String[]{"97", "0000000"}));// 3
        System.out.println("6 = " + OffBinary(new String[]{"97456", "10011110010000111"}));// 6


    }
}
