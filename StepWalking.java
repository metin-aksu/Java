/*
Step Walking
Have the function StepWalking(num) take the num parameter being passed which will be an integer between 1 and 1,000 that represents the number of stairs you will have to climb. You can climb the set of stairs by taking either 1 step or 2 steps, and you can combine these in any order. So for example, to climb 3 steps you can either do: (1 step, 1 step, 1 step) or (2, 1) or (1, 2). So for 3 steps we have 3 different ways to climb them, so your program should return 3. Your program should return the number of combinations of climbing num steps.
Examples
Input: 1
Output: 1
Input: 3
Output: 3
*/

public class StepWalking {

    public static int StepWalking(int num) {
        if(num == 1 || num == 2) return num;
        return StepWalking(num - 1) + StepWalking(num - 2);
    }

    public static void main (String[] args) {  
        
        System.out.println("1) " + StepWalking(1) + " = 1");
        System.out.println("2) " + StepWalking(2) + " = 2");        
        System.out.println("3) " + StepWalking(3) + " = 3");        
        System.out.println("4) " + StepWalking(4) + " = 5");        
        System.out.println("5) " + StepWalking(5) + " = 8");        
        System.out.println("6) " + StepWalking(6) + " = 13");        
        System.out.println("7) " + StepWalking(7) + " = 21");        
        System.out.println("8) " + StepWalking(8) + " = 34");        
        System.out.println("9) " + StepWalking(9) + " = 55");        
        System.out.println("10) " + StepWalking(13) + " = 377");

    }
}
