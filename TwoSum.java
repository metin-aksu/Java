/*
Two Sum
Have the function TwoSum(arr) take the array of integers stored in arr, and determine if any two numbers (excluding the first element) in the array can sum up to the first element in the array. For example: if arr is [7, 3, 5, 2, -4, 8, 11], then there are actually two pairs that sum to the number 7: [5, 2] and [-4, 11]. Your program should return all pairs, with the numbers separated by a comma, in the order the first number appears in the array. Pairs should be separated by a space. So for the example above, your program would return: 5,2 -4,11

If there are no two numbers that sum to the first element in the array, return -1

Examples
Input: [17, 4, 5, 6, 10, 11, 4, -3, -5, 3, 15, 2, 7]
Output: 6,11 10,7 15,2
Input: [7, 6, 4, 1, 7, -2, 3, 12]
Output: 6,1 4,3
 */

public class TwoSum{
    static String twoSum(int[] arr){
        int sum = arr[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length-1; i++){

            for(int j = i+1; j < arr.length; j++)
                if((arr[i]) + (arr[j]) == sum)
                    sb.append(arr[i]).append(",").append(arr[j]).append(" ");              
        }
        return sb.length() > 0 ? sb.toString().trim() : "-1";
    }
    
    static public void main(String[] args){
        int[] arr1 = {7, 3, 5, 2, -4, 8, 11}; // 5,2 -4,11
        int[] arr2 = {9, 5, 4, 2, 6, 1}; // 5,4
        int[] arr3 = {7, 6, 4, 1, 7, -2, 3, 12}; // 6,1 4,3
        int[] arr4 = {6, 2}; // -1
        int[] arr5 = {100, 90, 90, 90, 90, 11}; // -1
        int[] arr6 = {17, 4, 5, 6, 10, 11, 4, -3, -5, 3, 15, 2, 7}; // 6,11 10,7 15,2
        int[] arr7 = {8, -5, 4, 2, 7, -6, 4}; // 4,4
        int[] arr8 = {21, 10, 12, 4, 6, 3, 3, 7, 8, 9}; // 12,9
        int[] arr9 = {8, 1, 2, 3, 4, 5, 7}; // 1,7 3,5
        int[] arr10 = {4, 5, 2, 1}; // -1

        System.out.println("5,2 -4,11 = " + twoSum(arr1));
        System.out.println("5,4 = " + twoSum(arr2));
        System.out.println("6,1 4,3 = " + twoSum(arr3));
        System.out.println("-1 = " + twoSum(arr4));
        System.out.println("-1 = " + twoSum(arr5));
        System.out.println("6,11 10,7 15,2 = " + twoSum(arr6));
        System.out.println("4,4 = " + twoSum(arr7));
        System.out.println("12,9 = " + twoSum(arr8));
        System.out.println("1,7 3,5 = " + twoSum(arr9));
        System.out.println("-1 = " + twoSum(arr10));

    }
}