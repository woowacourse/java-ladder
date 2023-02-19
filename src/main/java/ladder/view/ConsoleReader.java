package ladder.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readLineByDelimiter(String delimiter) {
        String readValue = scanner.nextLine();
        if (readValue == null) {
            throw new NullPointerException("콘솔 입력값이 null입니다.");
        }
        return List.of(readValue.split(delimiter));
    }

    public static int readNaturalNumber() {
        int readValue = readInteger();
        if (readValue <= 0) {
            throw new IllegalArgumentException("콘솔 입력값이 자연수가 아닙니다.");
        }
        return readValue;
    }

    private static int readInteger() {
        String readValue = scanner.nextLine();
        try {
            return Integer.parseInt(readValue);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("콘솔 입력값이 정수가 아닙니다.");
        }
    }
}
