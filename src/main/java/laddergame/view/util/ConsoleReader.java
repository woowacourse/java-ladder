package laddergame.view.util;

import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readLineByDelimiter(final String delimiter) {
        final String readValue = scanner.nextLine();
        if (readValue == null) {
            throw new NullPointerException("콘솔 입력값이 null입니다.");
        }
        return List.of(readValue.split(delimiter));
    }

    public static int readNaturalNumber() {
        final int readValue = readInteger();
        if (readValue <= 0) {
            throw new IllegalArgumentException("콘솔 입력값이 자연수가 아닙니다.");
        }
        return readValue;
    }

    private static int readInteger() {
        final String readValue = scanner.nextLine();
        try {
            return Integer.parseInt(readValue);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("콘솔 입력값이 정수가 아닙니다.");
        }
    }

    public static String readLine() {
        final String readValue = scanner.nextLine();
        if (readValue == null) {
            throw new IllegalArgumentException("콘솔 입력값이 null값입니다.");
        }
        if (readValue.isEmpty()) {
            throw new IllegalArgumentException("콘솔 입력값이 빈 문자열입니다.");
        }
        return readValue;
    }
}
