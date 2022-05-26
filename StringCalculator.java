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
        String subStr, subStrResult;
        for (int i = 0; i < bracketCount; i++){
            bracketStartIndex = str.indexOf("(",bracketStartIndex);
            bracketEndIndex = str.indexOf(")",bracketEndIndex);
            subStr = str.substring(bracketStartIndex, bracketEndIndex+1); // (2*3)
            subStrResult = Calculate(str.substring(bracketStartIndex+1, bracketEndIndex)); // 2*3/4+3
            str = str.replace(subStr, subStrResult);
        }
        // parantezler kalktıktan sonra, kalan kısım hesaplanır.
        str = Calculate(str);

        return str;
   }
   //==============================================================
   static String Calculate(String str){
        String str2 = new String(str);

        // numaralar elde edildi
        StringTokenizer st = new StringTokenizer(str,"+-*/");
        int[] nums = new int[st.countTokens()]; // 3 5 2 4 2

        // numaralar bir diziye atandı
        int i = 0;
        while (st.hasMoreTokens()){
            nums[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        // stringden numaralar çıkarılıp işlemler bırakıldı +-*/
        for (i = 0; i < nums.length; i++) {
            str = str.replace(String.valueOf(nums[i]),""); //  +-*/
        }
        // işlemler bir diziye atandı
        String[] signs = str.split("");

        int result = 0;
        // işlemlere göre sonuç hesaplanmaya başlandı 3+5-8/2
        if (str2.indexOf("*") > 0){
                for (int x = 0; x < signs.length; x++){
                    if (signs[x].equals("*")){
                        result = nums[x] * nums[x+1];
                        String subs = nums[x] + "*" + nums[x+1];
                        str2 = str2.replace(subs,String.valueOf(result));
                        return Calculate(str2);
                    }
                }
        }
        if (str2.indexOf("/") > 0){
                for (int x = 0; x < signs.length; x++){
                    if (signs[x].equals("/")){
                        result = nums[x] / nums[x+1];
                        String subs = nums[x] + "/" + nums[x+1];
                        str2 = str2.replace(subs,String.valueOf(result));
                        return Calculate(str2);
                    }
                }
        }
        if (str2.indexOf("+") > 0){
                for (int x = 0; x < signs.length; x++){
                    if (signs[x].equals("+")){
                        result = nums[x] + nums[x+1];
                        String subs = nums[x] + "+" + nums[x+1];
                        str2 = str2.replace(subs,String.valueOf(result));
                        return Calculate(str2);
                    }
                }
        }
        if (str2.indexOf("-") > 0){
                for (int x = 0; x < signs.length; x++){
                    if (signs[x].equals("-")){
                        result = nums[x] - nums[x+1];
                        String subs = nums[x] + "-" + nums[x+1];
                        str2 = str2.replace(subs,String.valueOf(result));
                        return Calculate(str2);
                    }                
                }
        }
        return String.valueOf(Integer.parseInt(str2));
    } 
    //==============================================================
   public static void main(String[] args) {
      System.out.println(Calculator("(812/2)*(5-3)"));
   }
}
