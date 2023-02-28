package ui.input;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String INPUT_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PLAYER = "결과를 보고 싶은 사람은?";

    public static String getPlayersName() {
        System.out.println(INPUT_PLAYERS_NAME);
        return sc.next();
    }

    public static int getLadderHeight() {
        System.out.println("\n" + INPUT_LADDER_HEIGHT);
        return sc.nextInt();
    }

    public static String getResult() {
        System.out.println("\n" + INPUT_LADDER_RESULT);
        return sc.next();
    }

    public static String getPlayer() {
        System.out.println("\n" + INPUT_PLAYER);
        return sc.next();
    }
}
