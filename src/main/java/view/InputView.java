package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PLAYER_NAME_INPUT_NOTICE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PRIZE_INPUT_NOTICE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_NOTICE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_OF_PLAYER_CHECK_NOTICE = "결과를 보고 싶은 사람은?";
    private static final String NOT_INTEGER_MESSAGE = "숫자가 아닙니다.";

    public List<String> readPlayerNames() {
        System.out.println(PLAYER_NAME_INPUT_NOTICE);
        return readCsv();
    }

    public String readCheckPlayer() {
        System.out.println(RESULT_OF_PLAYER_CHECK_NOTICE);
        return readInput();
    }

    public List<String> readPrizeNames() {
        System.out.println(PRIZE_INPUT_NOTICE);
        return readCsv();
    }

    private List<String> readCsv() {
        String[] csv = readInput().split(DELIMITER);
        return Arrays.stream(csv)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private String readInput() {
        return scanner.nextLine();
    }

    public int readLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_NOTICE);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }

}
