/*
FizzBuzz
Have the function FizzBuzz(num) take the num parameter being passed and return all the numbers from 1 to num separated by spaces, but replace every number that is divisible by 3 with the word "Fizz", replace every number that is divisible by 5 with the word "Buzz", and every number that is divisible by both 3 and 5 with the word "FizzBuzz". For example: if num is 16, then your program should return the string "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16". The input will be within the range 1 - 50.

Examples
Input: 3
Output: 1 2 Fizz
Input: 8
Output: 1 2 Fizz 4 Buzz Fizz 7 8
*/

public class FizzBuzz {
    public static String FizzBuzz(int num) {

        String result = "";
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) result += "FizzBuzz ";
            else if (i % 3 == 0) result += "Fizz ";
            else if (i % 5 == 0) result += "Buzz ";
            else result += i + " ";
        }
        return result.trim();
    }

    public static void main (String[] args) {

        System.out.println(FizzBuzz(3) + " =  1 2 Fizz");
        System.out.println(FizzBuzz(8) + " =  1 2 Fizz 4 Buzz Fizz 7 8");
        System.out.println(FizzBuzz(16) + " =  1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16");
        System.out.println(FizzBuzz(17) + " =  1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17");
        System.out.println(FizzBuzz(18) + " =  1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz");
        System.out.println(FizzBuzz(2) + " =  1 2");
        System.out.println(FizzBuzz(4) + " =  1 2 Fizz 4");
        System.out.println(FizzBuzz(5) + " =  1 2 Fizz 4 Buzz");
        System.out.println(FizzBuzz(6) + " =  1 2 Fizz 4 Buzz Fizz");
        System.out.println(FizzBuzz(21) + " =  1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz");
    }
}
