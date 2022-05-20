import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        final String PATTERN = "(\\d+)|([-\\d]+)";
        Pattern p = Pattern.compile(PATTERN);
        Matcher matcher = p.matcher(line);
        boolean result = matcher.find();
        System.out.println(result);
    }
}
