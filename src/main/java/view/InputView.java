package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_CONTENTS_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final String RESULT_CONTENTS_DELIMITER = ",";
    private static final String NON_INTEGER_ERROR_MESSAGE = "높이는 정수만 입력 가능합니다.";
    private static final String RESULT_END_COMMAND = "all";
    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> requestPlayerNames() {
        String inputValue = requestUserInput(PLAYER_NAME_INPUT_MESSAGE);
        return Arrays.stream(inputValue.split(PLAYER_NAME_DELIMITER, -1))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int requestLadderHeight() {
        String heightInput = requestUserInput(LADDER_HEIGHT_INPUT_MESSAGE);
        try {
            return Integer.parseInt(heightInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR_MESSAGE);
        }
    }

    public String requestResultContents() {
        return requestUserInput(RESULT_CONTENTS_INPUT_MESSAGE);
    }

    public String requestResultPlayer() {
        breakLine();
        return requestUserInput(RESULT_INPUT_MESSAGE);
    }

    private void breakLine() {
        System.out.print(System.lineSeparator());
    }

    private String requestUserInput(String requestMessage) {
        System.out.println(requestMessage);
        String playerNames = SCANNER.nextLine();
        breakLine();
        return playerNames;
    }

    public String getPlayerNameDelimiter() {
        return PLAYER_NAME_DELIMITER;
    }

    public String getResultContentsDelimiter() {
        return RESULT_CONTENTS_DELIMITER;
    }

    public String getResultEndCommand() {
        return RESULT_END_COMMAND;
    }
}
