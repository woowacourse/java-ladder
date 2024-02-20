package view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputView {

    public static List<String> readNames(Supplier<String> input) {
        String inputString = input.get();
        return Arrays.stream(inputString.split(","))
                .toList();
    }
}
