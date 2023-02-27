package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public List<String> readNames() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", DELIMITER);
        String input = readLine();
        validateDelimiter(input);
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    private String readLine() {
        return scanner.nextLine();
    }

    private void validateDelimiter(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(String.format("%s로 끝날 수 없습니다", DELIMITER));
        }
    }

    public int readMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return toNumber(readLine());
    }

    private int toNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.", exception);
        }
    }

    public List<String> readResults() {
        System.out.printf("실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요)\n", DELIMITER);
        String input = scanner.nextLine();
        validateDelimiter(input);
        return Arrays.stream(input.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public String readResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
