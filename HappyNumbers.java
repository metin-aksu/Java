/*
Happy Numbers
Have the function HappyNumbers(num) determine if a number is Happy, which is a number whose sum of the square of the digits eventually converges to 1. Return true if it's a Happy number, otherwise return false.

For example: the number 10 is Happy because 1^2 + 0^2 converges to 1.
Examples
Input: 1
Output: true
Input: 101
Output: false
 */

public class HappyNumbers{
    static Boolean happyNumbers(int num){
        int sum = 0, lastNumber = 0;
        while(num > 0){
            lastNumber = num % 10; //sayının son basamağını alır
            System.out.println(lastNumber);
            sum += Math.pow(lastNumber,2); // sayının son basamağının karesini toplama ekler
            num /= 10; // sayının son basamaktan önceki kısmını alır
            System.out.println(num);
        }
        System.out.println(sum);
        if (sum > 9) return happyNumbers(sum); // Eğer toplam 2 basamaklı ise tekrar ediyoruz(recursive)
        return sum == 1 ? true : false;
    }
    public static void main(String[] args){
        System.out.println("1) true = " + happyNumbers(1)); // true
        System.out.println("2) false = " + happyNumbers(2)); // false
        System.out.println("3) true = " + happyNumbers(10)); // true
        System.out.println("4) true = " + happyNumbers(100)); // true
        System.out.println("5) false = " + happyNumbers(101)); // false
        System.out.println("6) false = " + happyNumbers(0)); // false
        System.out.println("7) true = " + happyNumbers(5525)); // true
        System.out.println("8) true = " + happyNumbers(5255)); // true
        System.out.println("9) true = " + happyNumbers(2555)); // true
        System.out.println("10) true = " + happyNumbers(5552)); // true
    }
}