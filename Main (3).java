import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (i % 3 != 0) {
                result.append(string.charAt(i));
            }
        }

        System.out.println(result);
    }
}