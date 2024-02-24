package utils;

import java.util.Scanner;

public class Console {

    private static Scanner scanner;
    public static final String NEW_LINE = System.lineSeparator();

    private Console() {
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    private static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
