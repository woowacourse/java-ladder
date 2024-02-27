package view;

import domain.ladder.Floor;
import domain.ladder.LadderBridge;
import domain.result.LadderResults;
import java.util.StringJoiner;

public class OutputView {
    private static final String LADDER_FRAME = "|";
    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_NONE = "     ";
    private static final String JOIN_DELIMITER = " ";
    private static final String OUTPUT_FORMAT = "%5s";

    public void printLadderResults(final LadderResults ladderResults) {
        System.out.println("\n사다리 결과\n");
        printPlayerNames(ladderResults);
        printLadder(ladderResults);
        printExecutionResult(ladderResults);
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

    private void printPlayerNames(final LadderResults ladderResults) {
        StringJoiner playerNamesJoiner = new StringJoiner(JOIN_DELIMITER);

        for (int i = 0; i < ladderResults.getPlayerCount(); i++) {
            String playerName = String.format(OUTPUT_FORMAT, ladderResults.getPlayerNameOfIndex(i));
            playerNamesJoiner.add(playerName);
        }
        System.out.println(playerNamesJoiner);
    }

    private void printLadder(final LadderResults ladderResults) {
        StringJoiner ladderJoiner;
        for (Floor floor : ladderResults.getFloors()) {
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

    private void printExecutionResult(final LadderResults ladderResults) {
        StringJoiner resultJoiner = new StringJoiner(JOIN_DELIMITER);
        for (int i = 0; i < ladderResults.getLadderResultsSize(); i++) {
            String formattedResult = String.format(OUTPUT_FORMAT, ladderResults.getLadderResultOfIndex(i));
            resultJoiner.add(formattedResult);
        }
        System.out.println(resultJoiner);
    }
}
