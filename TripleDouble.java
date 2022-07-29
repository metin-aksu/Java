/*
Triple Double
Have the function TripleDouble(num1,num2) take both parameters being passed, and return 1 if there is a straight triple of a number at any place in num1 and also a straight double of the same number in num2. For example: if num1 equals 451999277 and num2 equals 41177722899, then return 1 because in the first parameter you have the straight triple 999 and you have a straight double, 99, of the same number in the second parameter. If this isn't the case, return 0.

Examples
Input: 465555 & num2 = 5579
Output: 1
Input: 67844 & num2 = 66237
Output: 0
 */
public class TripleDouble {
    static int tripleDouble(int num1, int num2){
        char[] arr1 = String.valueOf(num1).toCharArray();
        String str2 = String.valueOf(num2);

        for(int i = 0; i < arr1.length-2; i++){

            if (arr1[i] == arr1[i+1] && arr1[i] == arr1[i+2]){

                if (str2.contains(String.valueOf(""+ arr1[i] + arr1[i+1]))){
                    return 1;
                }

            }
        }
        return 0;
    }
    public static void main(String[] args) {

        System.out.println("1) 0 = " + tripleDouble(1234,1234)); // 0
        System.out.println("2) 1 = " + tripleDouble(333,33)); // 1
        System.out.println("3) 0 = " + tripleDouble(12334455,12355555)); // 0
        System.out.println("4) 1 = " + tripleDouble(555666,5589)); // 1
        System.out.println("5) 0 = " + tripleDouble(5,5)); // 0
        System.out.println("6) 0 = " + tripleDouble(556668,556886)); // 0
        System.out.println("7) 1 = " + tripleDouble(3776777,87766)); // 1
        System.out.println("8) 1 = " + tripleDouble(17555,55144)); // 1
        System.out.println("9) 1 = " + tripleDouble(800000006,7800)); // 1
        System.out.println("10) 0 = " + tripleDouble(2233334,3)); // 0

    }
}
