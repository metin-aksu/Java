/*
Max Subarray
Have the function MaxSubarray(arr) take the array of numbers stored in arr and determine the largest sum that can be formed by any contiguous subarray in the array. For example, if arr is [-2, 5, -1, 7, -3] then your program should return 11 because the sum is formed by the subarray [5, -1, 7]. Adding any element before or after this subarray would make the sum smaller.

Examples
Input: [1, -2, 0, 3]
Output: 3
Input: [3, -1, -1, 4, 3, -1]
Output: 8
*/

public class MaxSubarray {

    public static int MaxSubarray(int[] arr) {

        int max = arr[0], sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];            
            max = Math.max(max, sum);
            
            if(sum < 0) sum = 0;
        }
        return max;
    }

    public static void main (String[] args) {        
        System.out.println("1)" + MaxSubarray(new int[]{-2, 5, -1, 7, -3}) + " = 11");
        System.out.println("2)" + MaxSubarray(new int[]{1, -2, 0, 3}) + " = 3");
        System.out.println("3)" + MaxSubarray(new int[]{3, -1, -1, 4, 3, -1}) + " = 8");
        System.out.println("4)" + MaxSubarray(new int[]{1,1,1,1}) + " = 4");
        System.out.println("5)" + MaxSubarray(new int[]{-4, -5, -6}) + " = -4");
        System.out.println("6)" + MaxSubarray(new int[]{10, -2}) + " = 10");
        System.out.println("7)" + MaxSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) + " = 6");
        System.out.println("8)" + MaxSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) + " = 6");
        System.out.println("9)" + MaxSubarray(new int[]{-1,1,-1,1,-1}) + " = 1");
        System.out.println("10)" + MaxSubarray(new int[]{-4, 2, 3, -5, 1, 2, -4, 2}) + " = 5");
    }
}
