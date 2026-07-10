package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import constants.AppConstants;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT);

    private InputUtil() {}

    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid decimal number.");
            }
        }
    }

    public static String readString(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    public static LocalDateTime readLocalDateTime(String message) {
        while (true) {
            System.out.print(message + " (" + AppConstants.DATE_TIME_FORMAT + "): ");
            try {
                return LocalDateTime.parse(scanner.nextLine().trim(), dtf);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Please use " + AppConstants.DATE_TIME_FORMAT);
            }
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}