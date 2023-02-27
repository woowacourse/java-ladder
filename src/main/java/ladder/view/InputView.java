package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return input.split(",");
    }

    public static int readLadderHeight() {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return stringToInt(input);
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public static String[] readResults() {
        System.out.println(System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return input.split(",");
    }

    public static String readTargetName() {
        System.out.println(System.lineSeparator() + "결과를 보고 싶은 사람은? (종료하려면 q를 누르세요.)");
        return scanner.nextLine();
    }
}
