package laddergame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.view.OutputView.LINE_SEPARATOR;

public class InputView {
    private static final String IOEXCEPTION_ERROR = "입력 과정 도중 에러가 발생했습니다.";
    private static final String ELEMENTS_DELIMITER = ",";

    public List<String> readPlayersName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return splitToSeparator(bufferedReader.readLine());
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    public String readLadderHeight() {
        System.out.println(LINE_SEPARATOR + "최대 사다리 높이는 몇 개인가요?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    public List<String> readLadderResult() {
        System.out.println(LINE_SEPARATOR + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return splitToSeparator(bufferedReader.readLine());
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    public String readPlayerNameWantToSeeResult() {
        System.out.println(LINE_SEPARATOR + "결과를 보고 싶은 사람은?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IllegalArgumentException(IOEXCEPTION_ERROR);
        }
    }

    private List<String> splitToSeparator(String input) {
        return Arrays.stream(input.split(ELEMENTS_DELIMITER))
                .map(String::trim)
                .toList();
    }
}
