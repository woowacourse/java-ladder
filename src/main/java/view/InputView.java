package view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Pattern FINISH_WITH_DELIMITER_REGEX = Pattern.compile(".*,$");
    public static final String NO_LAST_NAME = "[ERROR] 마지막 이름이 존재하지 않습니다.";
    public static final String NOT_INTEGER = "[ERROR] 최대 사다리 높이는 정수여야 합니다.";
    public static final String NO_LAST_PRIZE = "[ERROR] 마지막 결과가 존재하지 않습니다.";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        validateNames(names);
        return List.of(names.split(DELIMITER));
    }

    private void validateNames(String names) {
        if (FINISH_WITH_DELIMITER_REGEX.matcher(names).matches()) {
            throw new IllegalArgumentException(NO_LAST_NAME);
        }
    }

    public int readHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        String height = scanner.nextLine();
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    public List<String> readPrizes() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String prizes = scanner.nextLine();
        validatePrizes(prizes);
        return List.of(prizes.split(DELIMITER));
    }

    private void validatePrizes(String prizes) {
        if (FINISH_WITH_DELIMITER_REGEX.matcher(prizes).matches()) {
            throw new IllegalArgumentException(NO_LAST_PRIZE);
        }
    }

    public String readResultChoice() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
