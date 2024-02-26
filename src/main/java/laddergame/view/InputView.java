package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import laddergame.domain.Players;

public class InputView {
    private static final String IOEXCEPTION_ERROR = "입력 과정 도중 에러가 발생했습니다.";
    private static final String PLAYER_NAME_INPUT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_HEIGHT_INPUT = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_SEPARATOR = ",";
    private static final String RESULTS_NAME_INPUT = System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String DESIRED_NAME_INPUT = System.lineSeparator() + "결과를 보고 싶은 사람은?";
    private static final String INVALID_DESIRED_NAME_ERROR = "참여자 또는 all을 입력해주세여. 입력된 이름: %s";
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public List<String> readPlayersName() {
        System.out.println(PLAYER_NAME_INPUT);
        try {
            return Arrays.stream(bufferedReader.readLine().split(NAME_SEPARATOR))
                    .map(String::trim)
                    .toList();
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    public String readLadderHeight() {
        System.out.println(MAX_HEIGHT_INPUT);
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    public List<String> readResultNames() {
        System.out.println(RESULTS_NAME_INPUT);
        try {
            return Arrays.stream(bufferedReader.readLine().split(NAME_SEPARATOR))
                    .map(String::trim)
                    .toList();
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    public String readDesiredPlayerName(final Players players) {
        System.out.println(DESIRED_NAME_INPUT);
        try {
            final String input = bufferedReader.readLine().trim();
            checkDesiredPlayerName(input, players);
            return input;
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    private void checkDesiredPlayerName(final String name, final Players players) {
        if (ReservedWords.isIncluded(name)) {
            return;
        }
        if (players.isIncluded(name)) {
            return;
        }
        throw new IllegalArgumentException(String.format(INVALID_DESIRED_NAME_ERROR, name));
    }
}
