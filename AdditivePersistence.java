/*
Additive Persistence
Have the function AdditivePersistence(num) take the num parameter being passed which will always be a positive integer and return its additive persistence which is the number of times you must add the digits in num until you reach a single digit. For example: if num is 2718 then your program should return 2 because 2 + 7 + 1 + 8 = 18 and 1 + 8 = 9 and you stop at 9.
Examples
Input: 4
Output: 0
Input: 19
Output: 2
 */

public class AdditivePersistence {

    static int additivePersistence(int num) {
        int count = 0;
        while (num > 9) {
            num = getSum(num);
            count++;
        }        
        return count;
    }
    static int getSum(int num) {
        int sum = 0;
        while(num > 0){
            sum += num % 10; // Son rakamı alır, toplama ekler
            num /= 10; // Son rakamı siler
        }        
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("4 => " + additivePersistence(4) + " = 0");
        System.out.println("19 => " + additivePersistence(19) + " = 2");
        System.out.println("2718 => " + additivePersistence(2718) + " = 2");
        System.out.println("199 => " + additivePersistence(199) + " = 3");
        System.out.println("1 => " + additivePersistence(1) + " = 0");
        System.out.println("11 => " + additivePersistence(11) + " = 1");
        System.out.println("29 => " + additivePersistence(29) + " = 2");
        System.out.println("1999 => " + additivePersistence(1999) + " = 3");
        System.out.println("298 => " + additivePersistence(298) + " = 3");
        System.out.println("2567 => " + additivePersistence(2567) + " = 2");

    }
    
}
