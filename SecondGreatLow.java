/*
Second GreatLow

Have the function SecondGreatLow(arr) take the array of numbers stored in arr and return the second lowest and second greatest numbers, respectively, separated by a space. For example: if arr contains [7, 7, 12, 98, 106] the output should be 12 98. The array will not be empty and will contain at least 2 numbers. It can get tricky if there's just two numbers!
Examples
Input: [1, 42, 42, 180]
Output: 42 42
Input: [4, 90]
Output: 90 4
 */

import java.util.Arrays;

public class SecondGreatLow {
    static String SecondGreatLow(int[] arr){
        Arrays.sort(arr);
        int low = arr[1], great = arr[arr.length-2];        

        for(int i = arr.length-1; i > 0; i--)
            if (arr[i] > arr[i-1]) 
                low = arr[i];        

        for(int i = 0; i < arr.length-1; i++)
            if (arr[i] < arr[i+1]) 
                great = arr[i];

        return low + " " + great;
    }

    public static void main(String[] args) {

        System.out.println("1) 2 2 = " + SecondGreatLow(new int[]{1,2,2,3}));// 2 2
        System.out.println("2) 5 5 = " + SecondGreatLow(new int[]{2,2,2,5,5,5,6}));// 5 5
        System.out.println("3) 30 30 = " + SecondGreatLow(new int[]{100, 30, 6}));// 30 30
        System.out.println("4) 2 90 = " + SecondGreatLow(new int[]{78, 90, 100, 1, 2}));// 2 90
        System.out.println("5) -4 2 = " + SecondGreatLow(new int[]{-4, -5, 10, 2}));// -4 2
        System.out.println("6) 3 200 = " + SecondGreatLow(new int[]{100, 200, 3, 400, 5, 1}));// 3 200
        System.out.println("7) 7 60 = " + SecondGreatLow(new int[]{4, 60, 7, 188}));// 7 60
        System.out.println("8) 80 80 = " + SecondGreatLow(new int[]{80, 80}));// 80 80
        System.out.println("9) 90 23 = " + SecondGreatLow(new int[]{90, 23}));// 90 23
        System.out.println("10) 90 90 = " + SecondGreatLow(new int[]{7, 7, 90, 1000003}));// 90 90
        
    }
}