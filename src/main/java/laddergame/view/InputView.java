package laddergame.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ERROR_BLANK = "참여자의 이름은 빈 문자열로 입력되어선 안됩니다.";
    private static final String READ_PERSON_NAMES_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";

    Scanner scanner = new Scanner(System.in);

    private void validateIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    public List<String> readPersonNames() {
        System.out.println(READ_PERSON_NAMES_MSG);
        String input = scanner.nextLine();
        validateIsBlank(input);
        return List.of(input.split(DELIMITER));
    }
}
