package ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputView {
    private static final String INPUT_NAME_DESCRIPTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_DESCRIPTION = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_ERROR_MESSAGE = "입력 값을 받는 도중 에러가 발생했습니다.";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> inputPlayerNames() {
        System.out.println(INPUT_NAME_DESCRIPTION);
        try {
            return splitWithComma(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(INPUT_ERROR_MESSAGE);
        }
    }

    public static List<String> inputLadderResult() {
        System.out.println(INPUT_LADDER_RESULT);
        try {
            return splitWithComma(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_HEIGHT_DESCRIPTION);
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(INPUT_ERROR_MESSAGE);
        }
    }

    private static List<String> splitWithComma(String input) {
        return List.of(input.split(","));
    }
}
