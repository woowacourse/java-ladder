package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String NEW_LINE = "\n";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println(NEW_LINE + "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitAndTrim(scanner.nextLine());
    }

    public List<String> readResultItems() {
        System.out.println(NEW_LINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return splitAndTrim(scanner.nextLine());
    }

    private List<String> splitAndTrim(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int readHeight() {
        System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
        return parseIntOrThrow(scanner.nextLine());
    }

    private int parseIntOrThrow(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }
}
