package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * <example>
     * pobi,honux,crong,jk
     */
    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String input = scanner.nextLine();
        return parseNames(input);
    }

    private List<String> parseNames(final String input) {
        return Arrays.stream(input.split(",", -1))
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * <example>
     * 5
     */
    public int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final String input = scanner.nextLine();
        return parseHeight(input);
    }

    private int parseHeight(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자만 입력 가능합니다. 현재 입력은 " + input + " 입니다.");
        }
    }

    /**
     * <example>
     * 꽝,5000,꽝,3000
     */
    public List<String> readPrizeNames() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final String input = scanner.nextLine();
        return parseNames(input);
    }

    /**
     * <example>
     * pobi
     */
    public String readTarget() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
