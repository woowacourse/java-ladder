package ladder.view;

import ladder.dto.LineDto;

import java.util.List;

public class OutputView {
    private static final int PLAYER_NAME_PAD_SIZE = 6;
    private static final String LADDER_DESCRIPTION = "사다리 결과";
    private static final String LADDER_RESULT_DESCRIPTION = "실행 결과";

    public static void printLadderDescription() {
        System.out.println(LADDER_DESCRIPTION);
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
            sb.append(LineStringFormatter.create(lineDto));
        }
        System.out.println(sb);
    }

    public static void printLadderResultDescription() {
        System.out.println(LADDER_RESULT_DESCRIPTION);
    }

    public static void printLadderResult(String questionedPlayer, List<String> playerNames,
                                         List<String> changedLadderResult) {
        if (questionedPlayer.equals("all")) {
            printAllLadderResult(playerNames, changedLadderResult);
            return;
        }

        int position = playerNames.indexOf(questionedPlayer);
        System.out.println(changedLadderResult.get(position));
    }

    private static void printAllLadderResult(List<String> playerNames, List<String> changedLadderResult) {
        for (int i = 0; i < playerNames.size(); i++) {
            String player = playerNames.get(i);
            String result = changedLadderResult.get(i);

            System.out.println(player + " : " + result);
        }
    }

    private static String padName(String name) {
        return String.format("%-" + PLAYER_NAME_PAD_SIZE + "s", name);
    }
}
