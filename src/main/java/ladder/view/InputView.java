package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(READ_NAMES_MESSAGE);
        final String input = scanner.nextLine();
        return generatePlayerNames(input);
    }

    private List<String> generatePlayerNames(final String input) {
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
