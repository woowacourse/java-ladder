package view;

import domain.Height;
import domain.Players;
import laddervalidate.PlayerNameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_INPUT_REQUEST = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";
    private static final String HEIGHT_INPUT_REQUEST = "최대 사다리 높이는 몇 개인가요?";

    public Players readUserNames() {
        System.out.println(NAME_INPUT_REQUEST);
        String inputUserNames = scanner.nextLine();
        List<String> inputPlayers = splitInputUserNames(inputUserNames);
        Players players = new Players(inputPlayers);
        return players;
    }

    public Height readHeight() {
        System.out.println(HEIGHT_INPUT_REQUEST);
        String inputHeight = scanner.nextLine();
        Height height = new Height(inputHeight);
        return height;
    }

    private List<String> splitInputUserNames(String inputUserNames) {
        return Arrays.asList(inputUserNames.split(DELIMITER));
    }
}
