package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String READ_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String READ_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INVALID_NUMBER_MESSAGE = "정수만 입력 가능합니다.";
    private static final int HEIGHT_LOWER_BOUND = 1;
    private static final String INVALID_HEIGHT_MESSAGE = "높이는 최소 " + HEIGHT_LOWER_BOUND + "이상이어야 합니다.";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(READ_PLAYER_NAMES_MESSAGE);
        final String input = scanner.nextLine();

        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int readLadderHeight() {
        System.out.println(READ_LADDER_HEIGHT_MESSAGE);
        final String input = scanner.nextLine();

        final int height = parseInt(input);
        validateHeight(height);

        return height;
    }

    private int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private void validateHeight(final int height) {
        if (height < HEIGHT_LOWER_BOUND) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
    }
}
