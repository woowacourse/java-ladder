package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String receivePlayer() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String playerNames = input();
        isBlank(playerNames);

        return playerNames;
    }

    public static int receiveHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        String height = input();
        isBlank(height);
        isDigit(height);

        return Integer.parseInt(height);
    }

    private static void isBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private static void isDigit(String height) {
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
