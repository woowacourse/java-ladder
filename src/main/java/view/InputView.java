package view;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.stream;

public class InputView {

    private InputView() {
    }

    public static List<String> readStringsWithDelimiter(Supplier<String> reader, String message) {
        System.out.println(message);
        String input = reader.get();
        validateEmpty(input);
        System.out.println();
        return parseStringWithDelimiter(input);
    }

    public static int readNumber(Supplier<String> reader, String message) {
        System.out.println(message);
        String input = reader.get();
        validateEmpty(input);
        return parseNumber(input);
    }

    private static void validateEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백을 넣을 수 없습니다.");
        }
    }

    private static List<String> parseStringWithDelimiter(String input) {
        return stream(input.split(","))
                .toList();
    }

    private static int parseNumber(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }
    }

    public static String inputString(Supplier<String> reader, final String message) {
        System.out.println(message);
        String input = reader.get();
        validateEmpty(input);

        return input;
    }
}
