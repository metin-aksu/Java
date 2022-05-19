/*
Swap Case                                                                           
Using the JavaScript language, have the function SwapCase(str) take the str         
parameter and swap the case of each character. For example: if str is "Hello World"
the output should be hELLO wORLD. Let numbers and symbols stay the way they are. 
*/
public class SwapCase {

    //== METHOD 1 

    public static String SwapCase1(String str) {
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

    // METHOD 2

    public static String SwapCase2(String str) {
      String letter, lower, newstr="";
      char[] arrStr = str.toCharArray();

      for(char c:arrStr) {
          letter = String.valueOf(c);
          lower = letter.toLowerCase();
          newstr += letter == lower ? letter.toUpperCase() : lower;
      }
      return newstr;
    }
  
    public static void main(String[] args) {  
      System.out.println(SwapCase2("Hello World!"));
    } 
  
  }
