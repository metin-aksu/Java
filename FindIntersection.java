/*
Find Intersection

Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements: the first element will represent a list of comma-separated numbers sorted in ascending order, the second element will represent a second list of comma-separated numbers (also sorted). Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order. If there is no intersection, return the string false.
Examples
Input: ["1, 3, 4, 7, 13", "1, 2, 4, 13, 15"]
Output: 1,4,13
Input: ["1, 3, 9, 10, 17, 18", "1, 4, 9, 10"]
Output: 1,9,10
 */

class FindIntersection {
    public static String findIntersection(String[] strArr) {

        String[] arr1 = strArr[0].split(", ");
        String[] arr2 = strArr[1].split(", ");

        StringBuilder sb = new StringBuilder();

        for (String item1 : arr1){
            for (String item2 : arr2){
                if (item1.equals(item2)){
                    sb.append(item1).append(",");
                }
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "false";
      }

      public static void main (String[] args) {
        String[] arr1 = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}; // 1,4,13
        String[] arr2 = {"2, 5, 7, 10, 11, 12", "2, 7, 8, 9, 10, 11, 15"}; // 2,7,10,11
        String[] arr3 = {"1, 5, 6, 7, 10, 11, 12", "5, 6, 8, 11, 17"}; // 5,6,11
        String[] arr4 = {"2, 3, 4", "3"}; // 3
        String[] arr5 = {"1, 2, 3, 4, 5", "6, 7, 8, 9, 10"}; // false
        String[] arr6 = {"1, 2, 4, 5, 6, 9", "2, 3, 4, 8, 10"}; // 2,4
        String[] arr7 = {"5, 6, 9, 11, 12, 16", "4, 6, 7, 11, 16"}; // 6,11,16
        String[] arr8 = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}; // 1,9,10
        String[] arr9 = {"11, 12, 14, 16, 20", "11, 12, 13, 18, 21"}; // 11,12
        String[] arr10 = {"21, 22, 23, 25, 27, 28", "21, 24, 25, 29"}; // 21,25

        System.out.println("Expected Result : 1,4,13 = " + findIntersection(arr1));
        System.out.println("Expected Result : 2,7,10,11 = " + findIntersection(arr2));
        System.out.println("Expected Result : 5,6,11 = " + findIntersection(arr3));
        System.out.println("Expected Result : 3 = " + findIntersection(arr4));
        System.out.println("Expected Result : false = " + findIntersection(arr5));
        System.out.println("Expected Result : 2,4 = " + findIntersection(arr6));
        System.out.println("Expected Result : 6,11,16 = " + findIntersection(arr7));
        System.out.println("Expected Result : 1,9,10 = " + findIntersection(arr8));
        System.out.println("Expected Result : 11,12 = " + findIntersection(arr9));
        System.out.println("Expected Result : 21,25 = " + findIntersection(arr10));
      }
}