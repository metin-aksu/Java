public class VowelCount {

    static int VowelCount1(String str) {
        str = str.toLowerCase();
        int count = 0;
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                count++;
        }
        return count;
    }
    
    static int VowelCount2(String str) {
        var count = 0;
        var vowels = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++)
            if (vowels.indexOf(str.charAt(i)) > -1) count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(VowelCount1("Merhaba Java"));
    }   
}
