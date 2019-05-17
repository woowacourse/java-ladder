package ladderGame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String STRING_SEPERATOR = ",";
    private static final String ASK_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULTS ="실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    public static String[] readNames() {
        System.out.println(ASK_NAMES);
        String input = scanner.nextLine();
        return input.split(STRING_SEPERATOR);
    }

    public static String[] readResults() {
        System.out.println(ASK_RESULTS);
        String input = scanner.nextLine();
        return input.split(STRING_SEPERATOR);
    }

    public static int readRows() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readName() {
        return scanner.nextLine();
    }
}
