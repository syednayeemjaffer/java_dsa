package helper;

import java.util.Scanner;

/**
 * Wraps java.util.Scanner and validates input so a bad entry
 * (e.g. letters where a number is expected) does not crash the app.
 */
public class ScannerHelper {

    private final Scanner s = new Scanner(System.in);

    public int intValue(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(s.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public long longValue(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Long.parseLong(s.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public String stringValue(String msg) {
        System.out.print(msg);
        return s.nextLine().trim();
    }

}
