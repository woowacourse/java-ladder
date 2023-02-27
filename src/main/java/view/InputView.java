package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static String receivePlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String playerNames = input();
        validateBlank(playerNames);
        validateDelimiter(playerNames);

        return playerNames;
    }

    public static String receiveResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String results = input();
        validateBlank(results);
        validateDelimiter(results);

        return results;
    }

    public static int receiveHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        String height = input();
        validateBlank(height);
        validateDigit(height);

        return Integer.parseInt(height);
    }

    public static String receivePlayerName() {
        System.out.println("\n결과를 보고싶은 사람은?");

        String playerName = input();
        validateBlank(playerName);

        return playerName;
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private static void validateDelimiter(String names) {
        if (!names.contains(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 구분자는 쉼표(,) 입니다.");
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
