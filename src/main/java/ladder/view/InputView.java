package ladder.view;

import ladder.domain.player.Player;
import ladder.utils.InputValidator;

import java.util.Scanner;
import java.util.Set;

public class InputView {
    private static Scanner SCANNER = new Scanner(System.in);
    private static final String GAME_USER_NAME_INPUT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GAME_LADDER_HEIGHT_INPUT_MGS = "최대 사다리 높이는 몇 개인가요?";
    private static final String GAME_PRIZE_INPUT_MGS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PLAYER_FOR_RESULT_INPUT_MSG = "\n결과를 보고 싶은 사람은?";

    public static String inputNames() {
        System.out.println(GAME_USER_NAME_INPUT_MSG);
        String input;
        try {
            input = SCANNER.nextLine();
            InputValidator.checkValidNames(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputNames();
        }
    }

    public static int inputHeight() {
        System.out.println(GAME_LADDER_HEIGHT_INPUT_MGS);
        int input;
        try {
            input = Integer.parseInt(SCANNER.nextLine());
            InputValidator.checkPositive(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputHeight();
        }

    }

    public static String inputRewards() {
        System.out.println(GAME_PRIZE_INPUT_MGS);
        String input;
        try {
            input = SCANNER.nextLine();
            InputValidator.checkWrongLength(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputRewards();
        }
    }

    public static String inputPlayerForResult(Set<Player> players) {
        System.out.println(PLAYER_FOR_RESULT_INPUT_MSG);
        String input;
        try {
            input = SCANNER.nextLine();
            InputValidator.checkExistPlayer(input, players);
            return input;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return inputPlayerForResult(players);
        }
    }
}
