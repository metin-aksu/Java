/*
Dash Insert

Have the function DashInsert(str) insert dashes ('-') between each two odd numbers in str. For example: if str is 454793 the output should be 4547-9-3. Don't count zero as an odd number.
Examples
Input: 99946
Output: 9-9-946
Input: 56730
Output: 567-30
 */

public class DashInsert {

    public static String dashInsert(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && str.charAt(i) % 2 != 0 && str.charAt(i - 1) % 2 != 0) {
                sb.append("-");
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    } 
    
    public static void main(String[] args) {
        System.out.println("9-9-946 = " + dashInsert("99946"));
        System.out.println("567-30 = " + dashInsert("56730"));

        System.out.println("1-562 = " + dashInsert("1562"));
        System.out.println("3-5-56 = " + dashInsert("3556"));
        System.out.println("567 = " + dashInsert("567"));
        System.out.println("7-7-9-9-3 = " + dashInsert("77993"));
        System.out.println("10120 = " + dashInsert("10120"));
        System.out.println("12 = " + dashInsert("12"));
        System.out.println("2129 = " + dashInsert("2129"));
        System.out.println("3-9-9047 = " + dashInsert("399047"));
        System.out.println("6049-7 = " + dashInsert("60497"));
        System.out.println("6674889-583-745-5-3 = " + dashInsert("667488958374553"));
    }
}