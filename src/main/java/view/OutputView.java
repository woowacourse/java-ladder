package view;

import domain.Ladder;
import domain.Line;
import domain.PlayerName;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String POINT = "-----";
    private static final String NONE_POINT = "     ";
    private static final String LADDER_FRAME = "|";

    public void printResult(List<PlayerName> playerNames, Ladder ladder) {
        System.out.println("\n실행 결과\n");
        printPlayerNames(playerNames);
        printLadder(ladder);
    }

    private void printPlayerNames(List<PlayerName> playerNames) {
        StringJoiner playerNamesJoiner = new StringJoiner(" ");
        int leftNameCount = playerNames.size() / 2;

        for (int i = 0; i < leftNameCount; i++) {
            String playerName = String.format("%-5s", playerNames.get(i).getName());
            playerNamesJoiner.add(playerName);
        }
        for (int i = leftNameCount; i < playerNames.size(); i++) {
            String playerName = String.format("%5s", playerNames.get(i).getName());
            playerNamesJoiner.add(playerName);
        }
        System.out.println(playerNamesJoiner);
    }

    private void printLadder(Ladder ladder) {
        StringJoiner ladderJoiner = new StringJoiner(LADDER_FRAME, LADDER_FRAME, LADDER_FRAME);
        for (Line line : ladder.getLines()) {
            for (Boolean point : line.getPoints()) {
                if (point) {
                    ladderJoiner.add(POINT);
                    continue;
                }
                ladderJoiner.add(NONE_POINT);
            }
            System.out.print("    ");
            System.out.println(ladderJoiner);
            ladderJoiner = new StringJoiner(LADDER_FRAME, LADDER_FRAME, LADDER_FRAME);
        }
    }
}
