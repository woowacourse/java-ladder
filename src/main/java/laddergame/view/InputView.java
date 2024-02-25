package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import laddergame.domain.Players;
import laddergame.util.ReservedWords;

public class InputView {
    private static final String IOEXCEPTION_ERROR = "입력 과정 도중 에러가 발생했습니다.";
    private static final String PLAYER_NAME_INPUT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_HEIGHT_INPUT = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_SEPARATOR = ",";
    private static final String RESULTS_NAME_INPUT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String DESIRED_NAME_INPUT = "결과를 보고 싶은 사람은?";
    private static final String INVALID_DESIRED_NAME_ERROR = "적절하지 않은 이름입니다.";

    public List<String> readPlayersName() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println(MAX_HEIGHT_INPUT);
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    public List<String> readResultNames() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
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
        throw new IllegalArgumentException(INVALID_DESIRED_NAME_ERROR);
    }
}
