package view;

import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.ladder.LadderBridge;
import domain.player.PlayerNames;

import java.util.StringJoiner;

public class OutputView {
    private static final String LADDER_FRAME = "|";
    private static final String PLAYER_NAMES_FORMAT = "%5s";
    private static final String LADDER_RESULTS_FORMAT = "%5s";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] : %s";

    public void printLadder(PlayerNames playerNames, Ladder ladder) {
        System.out.println("\n실행 결과\n");
        printPlayerNames(playerNames);
        printLadder(ladder);
        printLadderResult(ladder);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, errorMessage));
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
            printLadderFloor(floor, ladderJoiner);
        }
    }

    private void printLadderFloor(Floor floor, StringJoiner ladderJoiner) {
        System.out.print("\t");
        for (LadderBridge bridge : floor.getBridges()) {
            ladderJoiner.add(bridge.getValue());
        }
        System.out.println(ladderJoiner);
    }

    private void printLadderResult(Ladder ladder) {
        StringJoiner ladderResultJoiner = new StringJoiner(" ");

        for (int i = 0; i < ladder.getResultSize(); i++) {
            String playerName = String.format(LADDER_RESULTS_FORMAT, ladder.getLadderResultByIndex(i));
            ladderResultJoiner.add(playerName);
        }
        System.out.println(ladderResultJoiner);
    }
}
