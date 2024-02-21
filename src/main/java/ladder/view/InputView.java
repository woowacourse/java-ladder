package ladder.view;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.*;

public class InputView {

    public static List<String> readNames(Supplier<String> reader) {
        String input = reader.get();
        validateEmpty(input);
        return parseNames(input);
    }

    private static void validateEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("사용자 이름으로 공백을 넣을 수 없습니다.");
        }
    }

    private static List<String> parseNames(String names) {
        return stream(names.split(","))
                .toList();
    }
}
