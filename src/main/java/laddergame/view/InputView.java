package laddergame.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String READ_PERSON_NAMES_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final String READ_PRIZES_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String READ_RESULT_TYPE_MSG = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readPersonNames() {
        System.out.println(System.lineSeparator() + READ_PERSON_NAMES_MSG);
        String input = scanner.nextLine();
        validateIsBlank(input);
        return List.of(input.split(DELIMITER));
    }

    public List<String> readPrizes() {
        System.out.println(System.lineSeparator() + READ_PRIZES_MSG);
        String input = scanner.nextLine();
        validateIsBlank(input);
        return List.of(input.split(DELIMITER));
    }

    public String readResultType() {
        System.out.println(System.lineSeparator() + READ_RESULT_TYPE_MSG);
        String input = scanner.nextLine();
        validateIsBlank(input);
        return input;
    }

    private void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("참여자의 이름은 빈 문자열로 입력되어선 안됩니다.");
        }
    }

    public int readLadderHeight() {
        System.out.println(System.lineSeparator() + READ_LADDER_HEIGHT_MSG);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리의 높이는 숫자로 입력되어야합니다.");
        }
    }
}
