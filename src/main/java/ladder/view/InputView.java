package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ladder.util.BaseException;

public class InputView {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String USER_NAME_FOR_GAME_END = "all";
    private static final int MIN_LADDER_HEIGHT = 1;

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateInput(input);
        return Arrays.stream(input.split(SEPARATOR))
                .toList();
    }

    private void validateInput(String input) {
        if (input.isEmpty() || input.endsWith(SEPARATOR)) {
            throw new BaseException("올바르지 않은 사용자 이름입니다.");
        }
    }

    public List<String> readPrizeNames() {
        System.out.println(NEW_LINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validatePrizeInput(input);
        return Arrays.stream(input.split(SEPARATOR))
                .toList();
    }

    private void validatePrizeInput(String input) {
        if (input.isEmpty() || input.endsWith(SEPARATOR)) {
            throw new BaseException("올바르지 않은 실행 결과 이름입니다.");
        }
    }

    public int readLadderHeight() {
        System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return convertInteger(input);
    }

    private int convertInteger(String input) {
        int ladderHeight = parseInt(input);
        validatePositive(ladderHeight);
        return ladderHeight;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BaseException("최대 사다리 높이는 숫자만 가능합니다.");
        }
    }

    private void validatePositive(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new BaseException("최대 사다리 높이는 양의 정수여야 합니다.");
        }
    }

    public String readUserNameForResult() {
        System.out.println(NEW_LINE + "결과를 보고 싶은 사람은? ('all' 입력 시 종료)");
        return scanner.nextLine();
    }

    public boolean validateUserNameForGameEnd(String userName) {
        return userName.equals(USER_NAME_FOR_GAME_END);
    }
}
