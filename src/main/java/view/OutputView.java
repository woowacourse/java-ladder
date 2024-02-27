package view;

import domain.Floor;
import domain.Ladder;
import domain.LadderBridge;
import domain.PlayerNames;
import java.util.StringJoiner;

public class OutputView {
    private static final String LADDER_FRAME = "|";
    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_NONE = "     ";
    private static final String PLAYER_NAMES_FORMAT = "%5s";

    public void printLadder(final PlayerNames playerNames, final Ladder ladder) {
        System.out.println("\n실행 결과\n");
        printPlayerNames(playerNames);
        printLadder(ladder);
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printPlayerNames(final PlayerNames playerNames) {
        StringJoiner playerNamesJoiner = new StringJoiner(" ");

        for (int i = 0; i < playerNames.getCount(); i++) {
            String playerName = String.format(PLAYER_NAMES_FORMAT, playerNames.getNameOfIndex(i));
            playerNamesJoiner.add(playerName);
        }
        System.out.println(playerNamesJoiner);
    }

    private void printLadder(final Ladder ladder) {
        StringJoiner ladderJoiner;
        for (Floor floor : ladder.getFloors()) {
            ladderJoiner = new StringJoiner(LADDER_FRAME, LADDER_FRAME, LADDER_FRAME);
            printLadderLine(floor, ladderJoiner);
        }
    }

    private void printLadderLine(final Floor floor, final StringJoiner ladderJoiner) {
        System.out.print("\t");
        for (LadderBridge bridge : floor.getBridges()) {
            addBridge(ladderJoiner, bridge);
        }
        System.out.println(ladderJoiner);
    }

    private void addBridge(final StringJoiner ladderJoiner, final LadderBridge bridge) {
        if (bridge.isExist(bridge)) {
            ladderJoiner.add(BRIDGE_EXIST);
            return;
        }
        ladderJoiner.add(BRIDGE_NONE);
    }
}
