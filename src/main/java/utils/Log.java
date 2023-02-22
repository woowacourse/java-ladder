package utils;

public class Log {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void log(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
