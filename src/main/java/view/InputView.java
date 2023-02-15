package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    public static final int MINIMUM_LADDER_HEIGHT = 1;

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
        int height = scanner.nextInt();

        if (height < MINIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 이상이어야 합니다.");
        }

        return height;
    }
}
