package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ladder.dto.ResultRequest;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_DELIMITER = ",";
    private static final String TOTAL_PLAYER_REQUEST = "all";

    public List<String> inputPlayerNames() {
        System.out.println();
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return inputNames();
    }

    public List<String> inputProductNames() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return inputNames();
    }

    private List<String> inputNames() {
        String names = SCANNER.nextLine();
        return Arrays.asList(names.split(NAME_DELIMITER));
    }

    public int inputHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        String exceptionMessage = "사다리 높이는 숫자이여야 합니다.";
        return inputInt(exceptionMessage);
    }

    private int inputInt(String exceptionMessage) {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(exceptionMessage, exception);
        }
    }

    public ResultRequest inputResultRequest() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");

        String input = SCANNER.nextLine();
        if (TOTAL_PLAYER_REQUEST.equals(input)) {
            return ResultRequest.ALL;
        }
        return new ResultRequest(input);
    }
}
