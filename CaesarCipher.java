public class CaesarCipher {

    public static String caesarCipher(String str, int num) {
        int code, newcode;
        String result = "", newchar;
    
        for (int i = 0; i < str.length(); i++){
          code = (int) str.charAt(i);
          newcode = code + num;
    
          if (code >= 65 && code <= 90){
            if (newcode > 90) newcode = 64 + (newcode - 90); 
          }
          else if (code >= 97 && code <= 122){
            if (newcode > 122) newcode = 96 + (newcode - 122);
          }
          else
            newcode = code;
    
          newchar = String.valueOf((char) newcode);
          result += newchar;
        }
        return result;
      }

    public static void main(String[] args){
        System.out.println(caesarCipher("Arguments goes here",2));

    }
}