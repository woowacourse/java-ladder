package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public String readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = readLine();
        validateDelimiter(input);
        return input;
    }

    private String readLine() {
        return scanner.nextLine();
    }

    private void validateDelimiter(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(",로 끝날 수 없습니다");
        }
    }

    public String readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = readLine();
        validateDelimiter(input);
        return input;
    }

    public int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = readLine();
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.", exception);
        }
    }

    public String readPersonName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return readLine();
    }
}
