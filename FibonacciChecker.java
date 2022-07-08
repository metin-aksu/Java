/*
Fibonacci Checker
Have the function FibonacciChecker(num) return the string yes if the number given is part of the Fibonacci sequence. This sequence is defined by: Fn = Fn-1 + Fn-2, which means to find Fn you add the previous two numbers up. The first two numbers are 0 and 1, then comes 1, 2, 3, 5 etc. If num is not in the Fibonacci sequence, return the string no.
Examples
Input: 34
Output: yes
Input: 54
Output: no
 */

public class FibonacciChecker {
    static String checkFibonacci(int num){
        int num1 = 0, num2 = 1,sum = 1;
        
        while(sum <= num) {
            if(sum == num) return "yes";
            num1 = num2;
            num2 = sum;
            sum = num1 + num2;
        }
        return "no";
    }
    public static void main(String[] args){

        System.out.println("1 = yes = " + checkFibonacci(1));// yes
        System.out.println("8 = yes = " + checkFibonacci(8));// yes        
        System.out.println("13 = yes = " + checkFibonacci(13));// yes        
        System.out.println("12 = no = " + checkFibonacci(12));// no        
        System.out.println("10 = no = " + checkFibonacci(10));// no        
        System.out.println("987 = yes = " + checkFibonacci(987));// yes        
        System.out.println("986 = no = " + checkFibonacci(986));// no        
        System.out.println("75025 = yes = " + checkFibonacci(75025));// yes        
        System.out.println("1000 = no = " + checkFibonacci(1000));// no        
        System.out.println("1001 = no = " + checkFibonacci(1001));// no
    }
}
