package view;

import domain.Height;
import domain.Names;
import domain.Rewards;
import java.util.Scanner;

public class InputView {
    private static final InputView instance = new InputView();
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public Names readNames() {
        String input = readInput(Message.INPUT_NAMES.message);
        return new Names(input);
    }

    public Height readHeight() {
        String input = readInput(Message.INPUT_LADDER_SIZE.message);
        return new Height(parseHeight(input));
    }

    public Rewards readRewards(int personCount) {
        String input = readInput(Message.INPUT_REWARDS.message);
        return new Rewards(input, personCount);
    }

    private static int parseHeight(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Message.EXCEPTION_INVALID_HEIGHT.message);
        }
    }

    private static String readInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    private enum Message {
        INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        INPUT_LADDER_SIZE("최대 사다리 높이는 몇 개인가요?"),
        INPUT_REWARDS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
        EXCEPTION_INVALID_HEIGHT("int 범위 내의 숫자만 입력 가능합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
