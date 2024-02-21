package view;

import constant.Exception;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Pattern FINISH_WITH_DELIMITER_REGEX = Pattern.compile(".*,$");
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        validateNames(names);
        return List.of(names.split(DELIMITER));
    }

    private void validateNames(String names) {
        if (FINISH_WITH_DELIMITER_REGEX.matcher(names).matches()) {
            throw new IllegalArgumentException(Exception.NO_LAST_NAME.getExceptionMessage());
        }
    }

    public int readHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        String height = scanner.nextLine();
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exception.NOT_INTEGER.getExceptionMessage());
        }
    }
}
