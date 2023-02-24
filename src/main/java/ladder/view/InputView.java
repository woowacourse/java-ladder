package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String READ_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String READ_ITEM_NAMES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String READ_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String READ_PLAYER_NAME_MESSAGE = NEXT_LINE + "결과를 보고 싶은 사람은? [all 입력시 전체 결과 출력 후 종료]";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(READ_PLAYER_NAMES_MESSAGE);
        final String input = scanner.nextLine();

        return splitCsvInput(input);
    }

    private List<String> splitCsvInput(String input) {
        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> readItemNames() {
        System.out.println(READ_ITEM_NAMES_MESSAGE);
        final String input = scanner.nextLine();

        return splitCsvInput(input);
    }

    public String readLadderHeight() {
        System.out.println(READ_LADDER_HEIGHT_MESSAGE);
        return scanner.nextLine();
    }

    public String readPlayerName() {
        System.out.println(READ_PLAYER_NAME_MESSAGE);
        return scanner.nextLine();
    }
}
