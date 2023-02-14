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
            throw new IllegalArgumentException();
        }

        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputHeightOfLadder() {
        int height = scanner.nextInt();

        if (height < 1) {
            throw new IllegalArgumentException();
        }

        return height;
    }
}
