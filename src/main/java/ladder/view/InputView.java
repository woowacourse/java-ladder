package ladder.view;

import java.util.List;
import ladder.utils.ConsoleReader;

public class InputView {
    private static final String INPUT_NAME_DESCRIPTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_DESCRIPTION = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";

    private InputView() {
    }

    public static List<String> inputPlayerNames() {
        System.out.println(INPUT_NAME_DESCRIPTION);
        String rawNames = ConsoleReader.readLine();

        return List.of(rawNames.split(NAME_DELIMITER));
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_HEIGHT_DESCRIPTION);
        return Integer.parseInt(ConsoleReader.readLine());
    }
}
