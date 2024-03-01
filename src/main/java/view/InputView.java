package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_DELIMITER = ",";

    public InputView() {
    }

    private static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 구분자(" + SPLIT_DELIMITER + ")로 구분하세요)");
        String initialInput = input();
        return Arrays.stream(initialInput.split(SPLIT_DELIMITER))
                     .map(String::trim)
                     .toList();
    }

    public static List<String> inputRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 구분자(" + SPLIT_DELIMITER + ")로 구분하세요)");
        String initialInput = input();
        return Arrays.stream(initialInput.split(SPLIT_DELIMITER))
                     .map(String::trim)
                     .toList();
    }

    public static String inputResultPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return input();
    }

    public static String inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return input();
    }
}
