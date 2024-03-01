package ladder.view;

import java.util.Map;
import java.util.Map.Entry;
import ladder.dto.LineDto;
import java.util.List;

public class OutputView {
    private static final int PLAYER_NAME_PAD_SIZE = 6;
    private static final String RESULT_DESCRIPTION = "사다리 결과";
    private static final String REWARD_DESCRIPTION = "실행 결과";
    private static final String VERTICAL_CHAR = "|";
    private static final String HORIZONTAL_CHAR = "-";
    private static final String EMPTY_SPACE = " ";
    private static final String SEPERATOR = " : ";
    private static final int PATH_WIDTH = 5;

    private OutputView() {
    }

    public static void printResultDescription() {
        System.out.println(RESULT_DESCRIPTION + '\n');
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
        for (LineDto lineDto : ladder) {
            sb.append(createLineString(lineDto));
        }
        System.out.print(sb);
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

    public static void printRewards(List<String> rewards) {
        StringBuilder sb = new StringBuilder();
        for (String name : rewards) {
            sb.append(padName(name));
        }
        sb.append('\n');
        System.out.println(sb);
    }

    private static void printRewardDescription() {
        System.out.println(REWARD_DESCRIPTION);
    }

    public static void printRewardForAll(Map<String, String> gameResult) {
        StringBuilder sb = new StringBuilder();
        for (Entry<String, String> entry : gameResult.entrySet()) {
            sb.append(entry.getKey()).append(SEPERATOR).append(entry.getValue()).append('\n');
        }
        sb.append('\n');

        printRewardDescription();
        System.out.println(sb);
    }

    public static void printRewardForTarget(String rewardName) {
        printRewardDescription();
        System.out.println(rewardName);
    }
}
