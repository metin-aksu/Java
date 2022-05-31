import java.util.StringTokenizer;

public class StringCalculator {
    static String Calculator(String str){
        str = str.replaceAll("\\s", "");
        str = str.replaceAll("[)][(]", ")*(");
        str = str.replaceAll("([0-9])[(]", "$1*(");
        str = str.replaceAll("[)]([0-9])", ")*$1");


        // parantez sayısı hesaplanır
        int bracketCount = 0, bracketStartIndex = 0, bracketEndIndex = 0;
        char[] arrStr = str.toCharArray();
        for (int i = 0;i < arrStr.length; i++)
            if (arrStr[i] == '(') bracketCount++;

        // parantezler arası hesaplanır ve string hesaplanmış hali ile değiştirilir.
        if (bracketCount > 0) {
            String subStr, subStrResult;
            for (int i = 0; i < bracketCount; i++) {
                bracketStartIndex = str.indexOf("(", bracketStartIndex);
                bracketEndIndex = str.indexOf(")", bracketEndIndex);
                subStr = str.substring(bracketStartIndex, bracketEndIndex + 1);
                subStrResult = Calculator(str.substring(bracketStartIndex + 1, bracketEndIndex));
                str = str.replace(subStr, subStrResult);
            }
        }
        // parantezler kalktıktan sonra, kalan kısım hesaplanır.
        str = Calculate(str);

        return str;
   }
   //==============================================================
   static String Calculate(String str){
        String str2 = str;

        // numaralar elde edildi
        StringTokenizer st = new StringTokenizer(str,"+-*/");
        int[] nums = new int[st.countTokens()]; 

        // numaralar bir diziye atandı
        int i = 0;
        while (st.hasMoreTokens()){
            nums[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        // stringin ilk karakteri - ise, nums[0] negatif sayı yapılır.

        if (str2.charAt(0) == '-') {
            nums[0] = 0 - nums[0];
        }

        // stringden numaralar çıkarılıp işlemler bırakıldı
        for (i = 0; i < nums.length; i++) {
            str = str.replace(String.valueOf(nums[i]),"");
        }
        // işlemler bir diziye atandı
        String[] signs = str.split("");

            int result = 0;
            String subs="";
            // işlemlere göre sonuç hesaplanmaya başlandı
            
            for (int x = 0; x < signs.length; x++){
                if (signs[x].equals("*")  || signs[x].equals("/")) {

                    result = signs[x].equals("*") ? nums[x] * nums[x+1] : nums[x] / nums[x+1];
                    subs = signs[x].equals("*") ? nums[x] + "*" + nums[x+1] : nums[x] + "/" + nums[x+1];
                    str2 = str2.replace(subs,String.valueOf(result));
                    return Calculate(str2);
                }
            }
            
            for (int x = 0; x < signs.length; x++){
                if (signs[x].equals("+") || signs[x].equals("-")) {

                    result = signs[x].equals("+") ? nums[x] + nums[x+1] : nums[x] - nums[x+1];
                    subs = signs[x].equals("+") ? nums[x] + "+" + nums[x+1] : nums[x] + "-" + nums[x+1];
                    str2 = str2.replace(subs,String.valueOf(result));
                    return Calculate(str2);
                }
            }

        return str2;
    }
    //==============================================================
   public static void main(String[] args) {
        // String str = "6(4/2)+3*1"; // 15
        // String str = "1+1+1+2"; // 5
        // String str = "7-2+(5-2)"; // 8
        // String str = "(4/2)(3-1)"; // 4
        // String str = "6-3/1"; // 3
        // String str = "45-10*2-1"; // 24
        // String str = "100*2"; // 200
        // String str = "812/2*(5-3)"; // 812
        // String str = "7-4-1+8(3)/2"; // 14
        String str = "8-7(12+100/2)*9-2"; // -3900
        System.out.println(Calculator(str));
   }
}
