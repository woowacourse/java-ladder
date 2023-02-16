package view;

import domain.Ladder;
import domain.Player;
import domain.Players;

public class OutputView {

    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private static final String BLANK = " ";
    private static final String FOOTHOLD = "-";
    private static final String BAR = "|";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final StringBuilder ladderOutput = new StringBuilder();
    private static final StringBuilder playerNamesOutput = new StringBuilder();

    public void printResult(final Players players, final Ladder ladder) {
        System.out.println("실행결과");

        StringBuilder playerNames = getPlayerNames(players);
        System.out.println(playerNames);

        StringBuilder ladderOutput = makeLadder(players, ladder);
        System.out.println(ladderOutput);
    }

    public StringBuilder getPlayerNames(final Players players) {
        int longestName = players.findLongestPlayerName();

        playerNamesOutput.append(players.getPlayers().get(0).getName());
        playerNamesOutput.append(BLANK);

        for (int i = 1; i < players.getPlayers().size(); i++) {
            appendPlayerNames(longestName, players.getPlayers().get(i));
        }

        return playerNamesOutput;
    }

    private void appendPlayerNames(final int longestName, final Player player) {
        if (isMaximumLengthOfPlayerName(player)) {
            drawPlayerNameWhenMaximumLength(player);
            return;
        }
        drawPlayerName(longestName, player);
    }

    private void drawPlayerNameWhenMaximumLength(final Player player) {
        playerNamesOutput.append(BLANK)
                .append(player.getName());
    }

    private void drawPlayerName(final int longestName, final Player player) {
        int blankSpace = longestName - player.getName().length();
        playerNamesOutput.append(BLANK.repeat(blankSpace))
                .append(player.getName())
                .append(BLANK);
    }

    private boolean isMaximumLengthOfPlayerName(final Player player) {
        return player.getLengthOfPlayerName() == MAXIMUM_LENGTH_OF_NAME;
    }

    public StringBuilder makeLadder(final Players players, final Ladder ladder) {
        for (int heightIndex = 0; heightIndex < ladder.findLadderHeight(); heightIndex++) {
            int lengthOfFirstPlayerName = players.findLengthOfFirstPlayerName();

            drawSpaceAtFirst(lengthOfFirstPlayerName);
            drawInnerLadder(players, ladder, heightIndex);
            drawBarAtLast();
        }

        return ladderOutput;
    }

    private void drawSpaceAtFirst(final int lengthOfFirstPlayerName) {
        if (lengthOfFirstPlayerName == 5 || lengthOfFirstPlayerName == 4) {
            ladderOutput.append(BLANK.repeat(4));
            return;
        }
        ladderOutput.append(BLANK.repeat(lengthOfFirstPlayerName));
    }

    private void drawInnerLadder(final Players players, final Ladder ladder, final int heightIndex) {
        for (Boolean isExistFoothold : ladder.getLines().findSelectedLine(heightIndex)) {
            ladderOutput.append(BAR);
            drawExistingFoothold(players, isExistFoothold);
        }
    }

    private void drawExistingFoothold(final Players players, final Boolean isExistFoothold) {
        if (isExistFoothold) {
            ladderOutput.append(FOOTHOLD.repeat(players.findLongestPlayerName()));
            return;
        }
        ladderOutput.append(BLANK.repeat(players.findLongestPlayerName()));
    }

    private void drawBarAtLast() {
        ladderOutput.append(BAR)
                .append(NEW_LINE);
    }
}
