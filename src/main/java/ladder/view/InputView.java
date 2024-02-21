package ladder.view;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.stream;

public class InputView {

    private InputView() {
    }

    public static List<String> readNames(Supplier<String> reader) {
        String input = reader.get();
        validateEmpty(input);
        return parseNames(input);
    }

    public static int readLadderHeight(Supplier<String> reader) {
        String input = reader.get();
        validateEmpty(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 2 ~ 10 사이의 숫자로 입력해야 합니다.");
        }
    }

    private static void validateEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("공백을 넣을 수 없습니다.");
        }
    }

    private static List<String> parseNames(String names) {
        return stream(names.split(","))
                .toList();
    }
}
