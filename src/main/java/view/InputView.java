package view;

import laddervalidate.HeightValidator;
import laddervalidate.PlayerNameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String HEIGHT_INPUT_REQUEST = "최대 사다리 높이는 몇 개인가요?";

    private final PlayerNameValidator playerNameValidator = new PlayerNameValidator();
    private final HeightValidator heightValidator = new HeightValidator();

    public List<String> readUserNames() {
        System.out.println(NAME_INPUT_REQUEST);
        String inputUserNames = scanner.nextLine();
        List<String> players = splitInputUserNames(inputUserNames);
        playerNameValidator.validate(players);
        return players;
    }

    public String readHeight() {
        System.out.println(HEIGHT_INPUT_REQUEST);
        String height = scanner.nextLine();
        heightValidator.validate(height);
        return height;
    }

    private List<String> splitInputUserNames(String inputUserNames) {
        return Arrays.asList(inputUserNames.split(DELIMITER));
    }
}
