/*
Simple Mode
Have the function SimpleMode(arr) take the array of numbers stored in arr and return the number that appears most frequently (the mode). 
For example: if arr contains [10, 4, 5, 2, 4] the output should be 4. If there is more than one mode return the one that appeared 
in the array first (ie. [5, 10, 10, 6, 5] should return 5 because it appeared first). If there is no mode return -1. The array will not be empty.
Examples
Input: [5,5,2,2,1]
Output: 5
Input: [3,4,1,6,10]
Output: -1
 */
import java.util.*;

public class SimpleMode {
    static int simpleMode(int[] arr){

        Arrays.sort(arr);
        int counter = 1;
        int maxCounter = 0;
        int mResult = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1])
                counter++;            
            else
                counter = 1;            
            
            if(counter > maxCounter){
                maxCounter = counter;
                mResult = arr[i];
            }
        }

        if(maxCounter == 1) 
            return -1;
        else
            return mResult;               

    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,2,3}; // 2
        int[] arr2 = {2,2,2,5,5,5,6}; // 2
        int[] arr3 = {100,200,100,45,3}; // 100
        int[] arr4 = {4,5,1,6,7,8,100,200,1000,5}; // 5
        int[] arr5 = {0,0,0,1,2}; // 0
        int[] arr6 = {7,8,1,2,3,4,89,94,109,76}; // -1
        int[] arr7 = {4,4,5,6,7,8,8,8,8,8}; // 8
        int[] arr8 = {1,1,1,2,3,4,5,1,1,1,1}; // 1
        int[] arr9 = {4,5,6,1,2,4}; // 4
        int[] arr10 = {6,6,5,4,3,7,7}; // 6

        System.out.println("arr1 = 2 : " + simpleMode(arr1) );
        System.out.println("arr2 = 2 : " + simpleMode(arr2) );
        System.out.println("arr3 = 100 : " + simpleMode(arr3) );
        System.out.println("arr4 = 5 : " + simpleMode(arr4) );
        System.out.println("arr5 = 0 : " + simpleMode(arr5) );
        System.out.println("arr6 = -1 : " + simpleMode(arr6) );
        System.out.println("arr7 = 8 : " + simpleMode(arr7) );
        System.out.println("arr8 = 1 : " + simpleMode(arr8) );
        System.out.println("arr9 = 4 : " + simpleMode(arr9) );
        System.out.println("arr10 = 6 : " + simpleMode(arr10) );       
    }
}
