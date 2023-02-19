package view;

import java.util.List;

import domain.Ladder;
import domain.Lines;
import domain.Player;
import domain.Players;

public class OutputView {

    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private static final int BOUNDARY_OF_NAME_LENGTH = 4;
    private static final String BLANK = " ";
    private static final String CONNECTION = "-";
    private static final String BAR = "|";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final StringBuilder ladderOutput = new StringBuilder();
    private static final StringBuilder playerNamesOutput = new StringBuilder();

    public void printResult(final Players players, final Ladder ladder) {
        System.out.println(NEW_LINE + "실행결과" + NEW_LINE);

        StringBuilder playerNames = makePlayerNamesOutput(players);
        System.out.println(playerNames);

        StringBuilder ladderOutput = makeLadderOutput(players, ladder);
        System.out.println(ladderOutput);
    }

    private StringBuilder makePlayerNamesOutput(final Players players) {
        int longestPlayerName = findLongestPlayerName(players);

        drawFirstPlayerName(players);

        for (int i = 1; i < players.getPlayers().size(); i++) {
            appendPlayerNames(longestPlayerName, players.getPlayers().get(i));
        }

        return playerNamesOutput;
    }

    private int findLongestPlayerName(final Players players) {
        return players.getPlayers()
                .stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void drawFirstPlayerName(final Players players) {
        playerNamesOutput.append(findFirstPlayerName(players))
                .append(BLANK);
    }

    private String findFirstPlayerName(final Players players) {
        return players.getPlayers().get(0).getName();
    }

    private void appendPlayerNames(final int longestName, final Player player) {
        if (isMaximumLengthOfPlayerName(player)) {
            drawPlayerNameWhenMaximumLength(player);
            return;
        }
        drawPlayerName(longestName, player);
    }

    private boolean isMaximumLengthOfPlayerName(final Player player) {
        return player.getLengthOfPlayerName() == MAXIMUM_LENGTH_OF_NAME;
    }

    private void drawPlayerNameWhenMaximumLength(final Player player) {
        playerNamesOutput.append(BLANK)
                .append(player.getName());
    }

    private void drawPlayerName(final int longestName, final Player player) {
        int numberOfBlank = longestName - player.getName().length();
        playerNamesOutput.append(LadderSymbol.draw(BLANK, numberOfBlank))
                .append(player.getName())
                .append(BLANK);
    }

    private StringBuilder makeLadderOutput(final Players players, final Ladder ladder) {
        for (int heightIndex = 0; heightIndex < findLadderHeight(ladder); heightIndex++) {
            int lengthOfFirstPlayerName = findLengthOfFirstPlayerName(players);

            drawSpaceAtFirst(lengthOfFirstPlayerName);
            drawInnerLadder(players, ladder, heightIndex);
            drawBarAtLast();
        }

        return ladderOutput;
    }

    private int findLadderHeight(final Ladder ladder) {
        return ladder.getHeight().getHeight();
    }

    private int findLengthOfFirstPlayerName(final Players players) {
        return players.getPlayers().get(0).getLengthOfPlayerName();
    }

    private void drawSpaceAtFirst(final int lengthOfFirstPlayerName) {
        if (isLengthOfNameMoreThanBoundary(lengthOfFirstPlayerName)) {
            ladderOutput.append(BLANK.repeat(BOUNDARY_OF_NAME_LENGTH));
            return;
        }
        ladderOutput.append(BLANK.repeat(lengthOfFirstPlayerName));
    }

    private boolean isLengthOfNameMoreThanBoundary(final int lengthOfFirstPlayerName) {
        return lengthOfFirstPlayerName >= BOUNDARY_OF_NAME_LENGTH;
    }

    private void drawInnerLadder(final Players players, final Ladder ladder, final int heightIndex) {
        for (Boolean isExistFoothold : findSelectedLine(ladder.getLines(), heightIndex)) {
            ladderOutput.append(BAR);
            drawExistingConnection(players, isExistFoothold);
        }
    }

    public List<Boolean> findSelectedLine(final Lines lines, final int selectedPosition) {
        return lines.getLines().get(selectedPosition).getConnections();
    }

    private void drawExistingConnection(final Players players, final Boolean isExistFoothold) {
        if (isExistFoothold) {
            ladderOutput.append(CONNECTION.repeat(findLongestPlayerName(players)));
            return;
        }
        ladderOutput.append(BLANK.repeat(findLongestPlayerName(players)));
    }

    private void drawBarAtLast() {
        ladderOutput.append(BAR)
                .append(NEW_LINE);
    }
}
