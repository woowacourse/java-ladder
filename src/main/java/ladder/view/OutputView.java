package ladder.view;

import java.util.List;

public class OutputView {
    private static final int PLAYER_NAME_PAD_SIZE = 6;
    private static final String RESULT_DESCRIPTION = "실행 결과";

    public static void printResultDescription() {
        System.out.println(RESULT_DESCRIPTION);
    }

    public static void printPlayerNames(List<String> playerNames) {
        StringBuilder sb = new StringBuilder();
        for (String name : playerNames) {
            sb.append(padName(name));
        }
        System.out.println(sb);
    }

    public static void printLadder() {

    }

    private static String padName(String name) {
        return String.format("%-" + PLAYER_NAME_PAD_SIZE + "s", name);
    }
}
