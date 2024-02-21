package ladder.view;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.*;

public class InputView {

    public static List<String> readNames(Supplier<String> reader) {
        String input = reader.get();

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("사용자 이름으로 공백을 넣을 수 없습니다.");
        }

        return parseNames(input);
    }

    private static List<String> parseNames(String names) {
        return stream(names.split(","))
                .toList();
    }
}
