package ladder.view;

import ladder.dto.LineDto;
import java.util.List;

public class OutputView {
    private static final int PLAYER_NAME_PAD_SIZE = 6;
    private static final String RESULT_DESCRIPTION = "실행 결과";
    private static final String VERTICAL_CHAR = "|";
    private static final String HORIZONTAL_CHAR = "-";
    private static final String EMPTY_SPACE = " ";
    private static final int PATH_WIDTH = 5;

    private OutputView() {
    }

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

    public static void printLadder(List<LineDto> ladder) {
        StringBuilder sb = new StringBuilder();
        for (LineDto ld : ladder) {
            sb.append(createLineString(ld));
        }
        System.out.println(sb);
    }

    private static String padName(String name) {
        return String.format("%-" + PLAYER_NAME_PAD_SIZE + "s", name);
    }

    private static String createLineString(LineDto lineDto) {
        StringBuilder sb = new StringBuilder();
        lineDto.getConnected()
                .forEach(val -> sb.append(convertLine(val)));
        sb.append(VERTICAL_CHAR + "\n");
        return sb.toString();
    }

    private static String convertLine(boolean connected) {
        if (connected) {
            return VERTICAL_CHAR + HORIZONTAL_CHAR.repeat(PATH_WIDTH);
        }
        return VERTICAL_CHAR + EMPTY_SPACE.repeat(PATH_WIDTH);
    }
}
