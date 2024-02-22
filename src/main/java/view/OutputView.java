package view;

import domain.Floor;
import domain.Ladder;
import domain.LadderBridge;
import domain.PlayerNames;
import java.util.StringJoiner;

public class OutputView {
    private static final String LADDER_FRAME = "|";
    private static final String PLAYER_NAMES_FORMAT = "%5s";

    public void printLadder(PlayerNames playerNames, Ladder ladder) {
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
            String playerName = String.format(PLAYER_NAMES_FORMAT, playerNames.getNameOfIndex(i));
            playerNamesJoiner.add(playerName);
        }
        System.out.println(playerNamesJoiner);
    }

    private void printLadder(Ladder ladder) {
        StringJoiner ladderJoiner;
        for (Floor floor : ladder.getFloors()) {
            ladderJoiner = new StringJoiner(LADDER_FRAME, LADDER_FRAME, LADDER_FRAME);
            printLadderLine(floor, ladderJoiner);
        }
    }

    private void printLadderLine(Floor floor, StringJoiner ladderJoiner) {
        System.out.print("\t");
        for (LadderBridge bridge : floor.getBridges()) {
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
