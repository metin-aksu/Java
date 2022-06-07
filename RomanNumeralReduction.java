/*
Roman Numeral Reduction

İşlevi al RomanNumeralReduction (str) okumak str azalan sısrada bir dizi roman rakami olacaktır. Kullanılan rakamlar: I 1 için V 5 için X 10 için L 50 için C 100 için D 500 ve M 1000 için. Programınız verilen numarayı döndürmelidir str daha kücük bir roman rakamları seti kullanarak. Örneğin: ek str "LLLXXXVVVV" bu 200, bu yüzden programınız geri dönmelidir CC çünkü bu, yukarıda verilen roma rakam sistemini kullanarak 200 yazmanın en kısa yoludur. Bir dize en kısa biçiminde verilirse, aynı dizeyi döndürmeniz yeterlidir.
Örnekler
Input: "XXXVVIIIIIIIIII"
Çıktı: L
Input: "DDLL"
Çıktı: MC
 */

public class RomanNumeralReduction {

    static String romanNumeralReduction(String str){
        return reduce(calculate(str));
    }
    static String reduce(int num) {
        String mResult = "";
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                mResult += letters[i];
                num -= values[i];
            }
            i++;
        }
        return mResult;
    }
    static int calculate(String roman){
        int sum = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i + 1 < roman.length() && value(roman.charAt(i)) < value(roman.charAt(i + 1)))
                sum -= value(roman.charAt(i));
            else
                sum += value(roman.charAt(i));
        }
        return sum;
    }
    static int value(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
        // return -1;
    }
    public static void main(String[] args) {
        String str1 = "LLLXXXVVVV"; // 200 = CC
        String str2 = "XXXVVIIIIIIIIII"; // 50 = L
        String str3 = "DDLL"; // 1100 = MC
        String str4 = "CCCCLL"; // 500 = D
        String str5 = "CCCCCCCCLLLL"; // 1000 = M
        String str6 = "IIIII"; // 5 = V
        String str7 = "IIIIIIIIII"; // 10 = X
        String str8 = "XXXVVVIIIII"; // 50 = L
        String str9 = "LXXXVVVIIIII"; // 100 = C
        System.out.println(str1 + " = CC = " + romanNumeralReduction(str1));
        System.out.println(str2 + " = L = " + romanNumeralReduction(str2));
        System.out.println(str3 + " = MC = " + romanNumeralReduction(str3));
        System.out.println(str4 + " = D = " + romanNumeralReduction(str4));
        System.out.println(str5 + " = M = " + romanNumeralReduction(str5));
        System.out.println(str6 + " = V = " + romanNumeralReduction(str6));
        System.out.println(str7 + " = X = " + romanNumeralReduction(str7));
        System.out.println(str8 + " = L = " + romanNumeralReduction(str8));
        System.out.println(str9 + " = C = " + romanNumeralReduction(str9));

    }
}