package ladder.view;

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

    public static int readLadderHeight(Supplier<String> reader) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = reader.get();
        validateEmpty(input);
        return parseLadderHeight(input);
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

    private static int parseLadderHeight(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 2 ~ 10 사이의 숫자로 입력해야 합니다.");
        }
    }
}
