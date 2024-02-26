package domain;

import java.util.List;
import util.Generator;

public class CustomGenerator implements Generator {

    private final List<Boolean> customNumbers;

    public CustomGenerator(List<Boolean> input) {
        this.customNumbers = input;
    }

    @Override
    public List<Integer> generate(int personCount) {
        return customNumbers.stream()
                .map((number) -> {
                    if (number) {
                        return 5;
                    }
                    return 4;
                })
                .toList();
    }
}
