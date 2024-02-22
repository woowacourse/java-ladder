package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PEOPLE_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private InputView() {
    }

    public static String readPeopleNames() {
        OutputView.printMessage(PEOPLE_NAMES_INPUT_MESSAGE);
        String peopleNames = scanner.nextLine();

        OutputView.printMessage("");
        return peopleNames;
    }

    public static String readLadderHeight() {
        OutputView.printMessage(LADDER_HEIGHT_INPUT_MESSAGE);
        String ladderHeight = scanner.nextLine();

        OutputView.printMessage("");
        return ladderHeight;
    }
}
