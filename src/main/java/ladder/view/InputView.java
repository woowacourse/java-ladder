package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView implements Input{

    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    private static final Scanner sc = new Scanner(System.in);

    public List<String> inputPlayerNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String input = sc.nextLine();
        validateNull(input);

        return splitInputByDelimiter(input);
    }

    public int inputHeightOfLadder() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        try {
            String input = sc.nextLine();
            validateNull(input);

            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    private List<String> splitInputByDelimiter(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }


}
