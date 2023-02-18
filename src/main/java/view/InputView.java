package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String HEIGHT_INPUT_REQUEST = "최대 사다리 높이는 몇 개인가요?";

    private final InputPlayerNameValidator inputPlayerNameValidator = new InputPlayerNameValidator();
    private final InputHeightValidator inputHeightValidator = new InputHeightValidator();

    public List<String> readUserNames() {
        System.out.println(NAME_INPUT_REQUEST);
        String inputUserNames = scanner.nextLine();
        List<String> playersNames = splitInputUserNames(inputUserNames);
        inputPlayerNameValidator.checkDuplicatePlayers(playersNames);
        inputPlayerNameValidator.checkPlayerNameLength(playersNames);
        inputPlayerNameValidator.checkPlayerCount(playersNames);
        return playersNames;
    }

    public int readHeight() {
        System.out.println(HEIGHT_INPUT_REQUEST);
        String inputHeight = scanner.nextLine();
        inputHeightValidator.checkNumberMissMatch(inputHeight);
        inputHeightValidator.checkNegativeNumber(inputHeight);
        return Integer.parseInt(inputHeight);
    }

    private List<String> splitInputUserNames(String inputUserNames) {
        return Arrays.asList(inputUserNames.split(DELIMITER));
    }
}
