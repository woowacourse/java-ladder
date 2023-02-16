package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputNameOfParticipants() {
        String names = scanner.nextLine();

        if (!names.contains(DELIMITER)) {
            throw new IllegalArgumentException("이름에는 유효한 구분자가 포함되어야 합니다.");
        }

        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputHeightOfLadder() {
        return scanner.nextInt();
    }
}
