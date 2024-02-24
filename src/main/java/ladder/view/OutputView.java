package ladder.view;

import ladder.dto.LineDto;

import java.util.List;

public class OutputView {
    private static final int PLAYER_NAME_PAD_SIZE = 6;
    private static final String LADDER_DESCRIPTION = "\n사다리 결과\n";
    private static final String LADDER_RESULT_DESCRIPTION = "\n실행 결과";

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
        System.out.print(sb);
    }

    public static void printLadderResult(List<String> ladderResult) {
        StringBuilder sb = new StringBuilder();
        for (String result : ladderResult) {
            sb.append(padName(result));
        }
        System.out.println(sb);
    }

    public static void printQuestionedPlayerResultDescription() {
        System.out.println(LADDER_RESULT_DESCRIPTION);
    }

    public static void printOnePlayerResult(int playerIndex, List<String> changedLadderResult) {
        System.out.println(changedLadderResult.get(playerIndex));
    }

    public static void printAllPlayerResult(List<String> playerNames, List<String> changedLadderResult) {
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
