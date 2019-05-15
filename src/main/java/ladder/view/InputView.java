package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String FIND_RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        return SCANNER.nextLine();
    }

    public static int inputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String inputResultAll() {
        System.out.println(INPUT_RESULT_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String findResultName() {
        System.out.println(FIND_RESULT_NAME_MESSAGE);
        return SCANNER.nextLine();
    }
}
