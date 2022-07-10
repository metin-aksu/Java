/*
 Permutation Step
Have the function PermutationStep(num) take the num parameter being passed and return the next number greater than num using the same digits. For example: if num is 123 return 132, if it's 12453 return 12534. If a number has no greater permutations, return -1 (ie. 999).
Examples
Input: 11121
Output: 11211
Input: 41352
Output: 41523
 */

import java.util.Arrays;

public class PermutationStep {

    public static int permutationStep(int num) {
        return findNextGreatNumber(String.valueOf(num).toCharArray());
    }

    static int findNextGreatNumber(char arr[]){
        int findIndex = 0,  arrLen = arr.length;
        StringBuilder mResult = new StringBuilder();

        // Rakam tek basamaklý ise -1 döndür.
        if (arrLen == 1) return -1;

        // Saðýndaki rakamdan daha küçük olan basamaðýn indexini bul
        for (findIndex = arrLen - 1; findIndex > 0; findIndex--)
            if (arr[findIndex] > arr[findIndex - 1]) break;

        // Eðer böyle bir rakam bulunamazsa, rakamlar azalan sýradadýr
        // Ayný rakamlarla daha büyük bir sayý olamaz -1 döndür
        if (findIndex == 0) return -1;
        else {
            int minNumber = arr[findIndex - 1], minIndex = findIndex;

            // findIndex'den sonraki(saðýndaki) en küçük basamaðý buluyoruz
            for (int j = findIndex + 1; j < arrLen; j++)
                if (arr[j] > minNumber && arr[j] < arr[minIndex]) minIndex = j;

            // findIndexin solundaki sayý ile saðýnda bulunan en küçük sayýyý deðiþtiriyoruz
            char temp = arr[findIndex-1];
            arr[findIndex - 1] = arr[minIndex];
            arr[minIndex] = temp;

            // findIndex'den sonraki rakamlarý küçükten büyüðe sýralýyoruz
            Arrays.sort(arr, findIndex, arrLen);

            // Arrayý stringe çevirip, integere parse ediyoruz
            for (int i = 0; i < arrLen; i++)
                mResult.append(arr[i]);
        }

        return Integer.parseInt(mResult.toString());
    }
    public static void main(String[] args) {
        System.out.println("1) 11121 => 11211 = " + permutationStep(11121));
        System.out.println("2) 41352 => 41523 = " + permutationStep(41352));
        System.out.println("3) 456 => 465 = " + permutationStep(456));
        System.out.println("4) 111 => -1 = " + permutationStep(111));
        System.out.println("5) 23514 => 23541 = " + permutationStep(23514));
        System.out.println("6) 897654321 => 912345678 = " + permutationStep(897654321));
        System.out.println("7) 12 => 21 = " + permutationStep(12));
        System.out.println("8) 9 => -1 = " + permutationStep(9));
        System.out.println("9) 44444444 => -1 = " + permutationStep(44444444));
        System.out.println("10) 76666666 => -1 = " + permutationStep(76666666));
    }
}
