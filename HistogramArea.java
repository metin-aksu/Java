/*
Histogram Area
Have the function HistogramArea(arr) read the array of non-negative integers stored in arr which will represent the heights of bars on a graph (where each bar width is 1), and determine the largest area underneath the entire bar graph. For example: if arr is [2, 1, 3, 4, 1] then this looks like the following bar graph:

histogram.jpg

You can see in the above bar graph that the largest area underneath the graph is covered by the x's. The area of that space is equal to 6 because the entire width is 2 and the maximum height is 3, therefore 2 * 3 = 6. Your program should return 6. The array will always contain at least 1 element.

Examples
Input: [6, 3, 1, 4, 12, 4]
Output: 12
Input: [5, 6, 7, 4, 1]
Output: 16
 */

public class HistogramArea {
    
        public static int HistogramArea(int[] arr) {
            if (arr.length == 1) return arr[0];

            int max = 0, temp;
            for (int i = 0; i < arr.length; i++) {
                temp = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    temp = Math.min(temp, arr[j]);
                    max = Math.max(max, temp * (j - i + 1));
                }
            }
            return max;
        }
    
        public static void main(String[] args) {  

            System.out.println("1) " + HistogramArea(new int[] {2, 1, 3, 4, 1}) + " = 6");
            System.out.println("2) " + HistogramArea(new int[] {6, 3, 1, 4, 12, 4}) + " = 12");
            System.out.println("3) " + HistogramArea(new int[] {5, 6, 7, 4, 1}) + " = 16");
            System.out.println("4) " + HistogramArea(new int[] {1, 1, 1, 1, 1, 1}) + " = 6");
            System.out.println("5) " + HistogramArea(new int[] {2, 2}) + " = 4");
            System.out.println("6) " + HistogramArea(new int[] {12}) + " = 12");
            System.out.println("7) " + HistogramArea(new int[] {100, 2, 40, 105, 55, 6, 4, 106, 24, 67}) + " = 120");
            System.out.println("8) " + HistogramArea(new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}) + " = 110");
            System.out.println("9) " + HistogramArea(new int[] {10, 20, 30, 20, 10}) + " = 60");
            System.out.println("10) " + HistogramArea(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10}) + " = 30");
    
        }
}
