package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PEOPLE_NAMES_DELIMITER = ",";
    private static final String PRIZE_NAMES_DELIMITER = ",";
    private static final String ASK_PEOPLE_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_PRIZE_NAMES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_VIEWER_NAME = "결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static List<String> readPeopleNames() {
        OutputView.printMessage(ASK_PEOPLE_NAMES);
        String peopleNames = SCANNER.nextLine();

        OutputView.printNewLine();
        return Arrays.stream(peopleNames.split(PEOPLE_NAMES_DELIMITER)).toList();
    }

    public static String readLadderHeight() {
        OutputView.printMessage(ASK_LADDER_HEIGHT);
        String ladderHeight = SCANNER.nextLine();

        OutputView.printNewLine();
        return ladderHeight;
    }

    public static List<String> readPrizeNames() {
        OutputView.printMessage(ASK_PRIZE_NAMES);
        String prizeNames = SCANNER.nextLine();

        OutputView.printNewLine();
        return Arrays.stream(prizeNames.split(PRIZE_NAMES_DELIMITER)).toList();
    }

    public static String readViewerName() {
        OutputView.printMessage(ASK_VIEWER_NAME);
        String viewerName = SCANNER.nextLine();

        OutputView.printNewLine();
        return viewerName;
    }
}
