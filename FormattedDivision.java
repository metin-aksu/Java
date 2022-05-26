
import java.text.DecimalFormat;

public class FormattedDivision {
    static String formattedDivision(int a, int b) {
        DecimalFormat df = new DecimalFormat("#,##0.0000");
        return df.format((double) a/b);
    }

    public static void main(String[] args) {
        System.out.println(formattedDivision(503394930, 43));
        System.out.println(formattedDivision(9112, 2));
        System.out.println(formattedDivision(101077282 , 21123));
        System.out.println(formattedDivision(2 , 3));
        System.out.println(formattedDivision(123456789 , 10000));
    }
}
