package view;

import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.ladder.LadderBridge;
import domain.ladder.LadderResults;
import domain.player.PlayerNames;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    private static final String LADDER_FRAME = "|";
    private static final String PLAYER_NAMES_FORMAT = "%5s";
    private static final String LADDER_RESULTS_FORMAT = "%5s";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] : %s";
    private static final String PLAYERS_LADDER_RESULT_FORMAT = "%s : %s";
    private static final String LADDER_RESULTS_DELIMITER = " ";
    private static final String PLAYER_NAMES_DELIMITER = " ";
    private static final String TAB = "    ";

    private static final Map<LadderBridge, String> bridgeToMarker;

    static {
        bridgeToMarker = new HashMap<>();
        bridgeToMarker.put(LadderBridge.BRIDGE, "-----");
        bridgeToMarker.put(LadderBridge.NONE, "     ");
    }

    public void printGeneratedLadder(final Ladder ladder, final PlayerNames playerNames, final LadderResults results) {
        System.out.println(System.lineSeparator() + "실행 결과" + System.lineSeparator());
        printPlayerNames(playerNames);
        printLadder(ladder);
        printLadderResult(results);
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, errorMessage));
    }

    private void printPlayerNames(final PlayerNames playerNames) {
        StringJoiner playerNamesJoiner = new StringJoiner(PLAYER_NAMES_DELIMITER);

        for (String playerName : playerNames.getPlayerNames()) {
            playerNamesJoiner.add(String.format(PLAYER_NAMES_FORMAT, playerName));
        }
        System.out.println(playerNamesJoiner);
    }

    private void printLadder(final Ladder ladder) {
        for (Floor floor : ladder.getFloors()) {
            printLadderFloor(floor, new StringJoiner(LADDER_FRAME, LADDER_FRAME, LADDER_FRAME));
        }
    }

    private void printLadderFloor(final Floor floor, final StringJoiner ladderJoiner) {
        System.out.print(TAB);
        for (LadderBridge bridge : floor.getBridges()) {
            ladderJoiner.add(bridgeToMarker.get(bridge));
        }
        System.out.println(ladderJoiner);
    }

    private void printLadderResult(final LadderResults results) {
        StringJoiner ladderResultJoiner = new StringJoiner(LADDER_RESULTS_DELIMITER);

        for (int i = 0; i < results.size(); i++) {
            String playerName = String.format(LADDER_RESULTS_FORMAT, results.getValueByIndex(i));
            ladderResultJoiner.add(playerName);
        }
        System.out.println(ladderResultJoiner);
    }

    public void printPlayerLadderResult(final Map<String, String> playerNameAndResult) {
        if (playerNameAndResult.size() > 1) {
            printAllPlayerLadderResult(playerNameAndResult);
        } else if (playerNameAndResult.size() == 1) {
            printSinglePlayerLadderResult(playerNameAndResult);
        }
    }

    private void printAllPlayerLadderResult(final Map<String, String> playerNameAndResults) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (Map.Entry<String, String> nameAndResult : playerNameAndResults.entrySet()) {
            System.out.println(String.format(PLAYERS_LADDER_RESULT_FORMAT, nameAndResult.getKey(), nameAndResult.getValue()));
        }
    }

    private void printSinglePlayerLadderResult(final Map<String, String> playerNameAndResult) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (String playerLadderResult : playerNameAndResult.values()) {
            System.out.println(playerLadderResult);
        }
    }

    public void printEndMessage() {
        System.out.println(System.lineSeparator() + "게임 종료");
    }
}
