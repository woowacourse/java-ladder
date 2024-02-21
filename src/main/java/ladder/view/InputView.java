package ladder.view;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.*;

public class InputView {

    public static List<String> readNames(Supplier<String> reader) {
        return parseNames(reader.get());
    }

    private static List<String> parseNames(String names) {
        return stream(names.split(","))
                .toList();
    }
}
