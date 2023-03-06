package view;

import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] receivePlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String playerNames = input();
        validateBlank(playerNames);
        validaDelimiter(playerNames);

        return playerNames.split(DELIMITER);
    }

    public static String[] receiveResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String results = input();
        validateBlank(results);
        validaDelimiter(results);

        return results.split(DELIMITER);
    }

    public static int receiveHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        String height = input();
        validateBlank(height);
        validateDigit(height);

        return Integer.parseInt(height);
    }

    public static String[] receiveMatchingName() {
        System.out.println("결과를 보고 싶은 사람은?");

        String matchingName = input();
        validateBlank(matchingName);

        return matchingName.split(",");
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private static void validaDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 구분자로 콤마(,)를 포함해야 합니다.");
        }
    }

    private static void validateDigit(String height) {
        boolean isDigit = height.chars()
                .allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }

    private static String input() {
        return scanner.nextLine();
    }
}
