package view;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String END_WITH_DELIMITER = "이름이 누락되었습니다. 입력은 쉼표(,)로 끝날 수 없습니다.";
    public static final String INVALID_HEIGHT_FORMAT = "높이는 숫자여야 합니다.";
    private static final String DELIMITER = ",";
    private static final InputView instance = new InputView();
    private final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String rawNames = scanner.nextLine().trim();
        validateEndWithDelimiter(rawNames);

        return Arrays.stream(rawNames.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateEndWithDelimiter(final String rawNames) {
        if (rawNames.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(END_WITH_DELIMITER);
        }
    }

    public List<String> readResults() {
        System.out.println(System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final String rawResults = scanner.nextLine().trim();

        return Arrays.stream(rawResults.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int readHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_HEIGHT_FORMAT);
        }
    }

    public String readTarget() {
        System.out.println(System.lineSeparator() + "결과를 보고 싶은 사람은?");

        return scanner.nextLine().trim();
    }
}
