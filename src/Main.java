import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        final String IMAGE_PATTERN = "(^([a-zA-Z\\d_ ]+)\\.(?i)(jpg|png|gif|bmp)$)";
        Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String line = sc.nextLine().trim();

            Matcher m = pattern.matcher(line);

            if (m.find())
            {
                String name = m.group(2);
                String extension = m.group(3);
                System.out.println(name + " " + extension);
            }
        }
    }
}