package view;

import domain.Ladder;
import domain.Line;
import domain.PlayerNames;

import java.util.StringJoiner;

public class OutputView {
    private static final String POINT = "-----";
    private static final String NONE_POINT = "     ";
    private static final String LADDER_FRAME = "|";

    public void printResult(PlayerNames playerNames, Ladder ladder) {
        System.out.println("\n실행 결과\n");
        printPlayerNames(playerNames);
        printLadder(ladder);
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }


    private void printPlayerNames(PlayerNames playerNames) {
        StringJoiner playerNamesJoiner = new StringJoiner(" ");
        int leftNameCount = playerNames.getCount() / 2;

        for (int i = 0; i < leftNameCount; i++) {
            String playerName = String.format("%-5s", playerNames.getNameOfIndex(i));
            playerNamesJoiner.add(playerName);
        }
        for (int i = leftNameCount; i < playerNames.getCount(); i++) {
            String playerName = String.format("%5s", playerNames.getNameOfIndex(i));
            playerNamesJoiner.add(playerName);
        }
        System.out.println(playerNamesJoiner);
    }

    // TODO : indent depth 처리
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
