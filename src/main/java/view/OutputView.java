package view;

import domain.Ladder;
import domain.LadderBridge;
import domain.Line;
import domain.PlayerNames;

import java.util.StringJoiner;

public class OutputView {
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

        for (int i = 0; i < playerNames.getCount(); i++) {
            String playerName = String.format("%5s", playerNames.getNameOfIndex(i));
            playerNamesJoiner.add(playerName);
        }
        System.out.println(playerNamesJoiner);
    }

    private void printLadder(Ladder ladder) {
        StringJoiner ladderJoiner;
        for (Line line : ladder.getLines()) {
            ladderJoiner = new StringJoiner(LADDER_FRAME, LADDER_FRAME, LADDER_FRAME);
            printLadderLine(line, ladderJoiner);
        }
    }

    private void printLadderLine(Line line, StringJoiner ladderJoiner) {
        System.out.print("\t");
        for (LadderBridge bridge : line.getBridges()) {
            addBridgeValue(bridge, ladderJoiner);
        }
        System.out.println(ladderJoiner);
    }

    private void addBridgeValue(LadderBridge bridge, StringJoiner ladderJoiner) {
        if (bridge.equals(LadderBridge.BRIDGE)) {
            ladderJoiner.add(bridge.getValue());
            return;
        }
        ladderJoiner.add(bridge.getValue());
    }
}
