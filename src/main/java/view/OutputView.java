package view;

import domain.ladder.Floor;
import domain.ladder.LadderBridge;
import domain.player.PlayerName;
import domain.player.PlayerNames;
import domain.result.LadderResult;
import domain.result.LadderResults;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String LADDER_FRAME = "|";
    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_NONE = "     ";
    private static final String JOIN_DELIMITER = " ";
    private static final String OUTPUT_FORMAT = "%5s";

    public void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printInputtedResultsOf(
            final PlayerNames playerNames,
            final List<Floor> ladder,
            final LadderResults ladderResults) {
        System.out.println("\n사다리 결과\n");
        printPlayerNames(playerNames);
        printLadder(ladder);
        printLadderResult(ladderResults);
    }

    private void printPlayerNames(final PlayerNames playerNames) {
        StringJoiner playerNamesJoiner = new StringJoiner(JOIN_DELIMITER);
        for (int i = 0; i < playerNames.getPlayerCount(); i++) {
            String playerName = String.format(OUTPUT_FORMAT, playerNames.getPlayerNameOfIndex(i).getValue());
            playerNamesJoiner.add(playerName);
        }
        System.out.println(playerNamesJoiner);
    }

    private void printLadder(final List<Floor> ladder) {
        StringJoiner ladderJoiner;
        for (Floor floor : ladder) {
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
        if (bridge.isExist()) {
            ladderJoiner.add(BRIDGE_EXIST);
            return;
        }
        ladderJoiner.add(BRIDGE_NONE);
    }

    private void printLadderResult(final LadderResults ladderResults) {
        StringJoiner resultJoiner = new StringJoiner(JOIN_DELIMITER);
        for (int i = 0; i < ladderResults.getLadderHeight(); i++) {
            String formattedResult = String.format(OUTPUT_FORMAT, ladderResults.getLadderResultOfIndex(i).getValue());
            resultJoiner.add(formattedResult);
        }
        System.out.println(resultJoiner);
    }

    public void printSingleClimbingLadderResult(final String result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    public void printAllClimbingLadderResults(final Map<PlayerName, LadderResult> results) {
        System.out.println("\n실행 결과");
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<PlayerName, LadderResult> result : results.entrySet()) {
            PlayerName playerName = result.getKey();
            LadderResult ladderResult = result.getValue();
            builder.append(String.format("%s : %s", playerName.getValue(), ladderResult.getValue()))
                    .append("\n");
        }
        System.out.println(builder);
    }
}
