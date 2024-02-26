package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static String readName() {
        System.out.println(System.lineSeparator() + "결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    public static List<String> readNames() {
        System.out.println(System.lineSeparator() +
                "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return List.of
                (scanner.nextLine()
                        .split(DELIMITER));
    }

    public static String readHeight() throws NumberFormatException {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        return scanner.nextLine();
    }

    public static List<String> readCompensation() {
        System.out.println(System.lineSeparator() +
                "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return List.of
                (scanner.nextLine()
                        .split(DELIMITER));
    }
}
