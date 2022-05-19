
public class SwapCase {

    public static String swapCase(String str) {
      String str2 = "",letter="";
      int code;
  
      for (int i = 0; i < str.length(); i++){
        code = (int) str.charAt(i);
        letter = String.valueOf(str.charAt(i));

        if (code >= 65 && code <= 90) 
          str2 += letter.toLowerCase();
        else if (code >= 97 && code <= 122) 
          str2 += letter.toUpperCase(); 
        else
          str2 += letter;     
      } 
      
      return str2;
    }
  
    public static void main(String[] args) {  
      System.out.println(swapCase("Hello World!"));
    } 
  
  }