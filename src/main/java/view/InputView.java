package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner reader = new Scanner(System.in);
    private static final String USER_NAME_DELIMITER = ",";


    public static String[] readNames() {
        printNameInputMessage();
        return removeBlank(reader.nextLine()).split(USER_NAME_DELIMITER);
    }

    public static int readHeight() {
        printLadderHeightInputMessage();
        try {
            return Integer.parseInt(reader.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해 주세요.");
        }
    }

    private static void printNameInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static String removeBlank(final String text) {
        return text.replace(" ", "");
    }

    private static void printLadderHeightInputMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }
}
