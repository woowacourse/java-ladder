package view;

import domain.Ladder;
import domain.Player;
import domain.Players;

public class OutputView {

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

        for (Player player : players.getPlayers()) {
            appendPlayerNames(longestName, player);
        }

        return playerNamesOutput;
    }

    private void appendPlayerNames(final int longestName, final Player player) {
        int blankSpace = longestName - player.getName().length();
        playerNamesOutput.append(BLANK.repeat(blankSpace))
                .append(player.getName())
                .append(BLANK);
    }

    public StringBuilder makeLadder(final Players players, final Ladder ladder) {
        for (int height = 0; height < ladder.findLadderHeight(); height++) {
            int lengthOfFirstPlayerName = players.findLengthOfFirstPlayerName();

            drawSpaceAtFirst(lengthOfFirstPlayerName);
            drawInnerLadder(players, ladder, height);
            drawBarAtLast();
        }

        return ladderOutput;
    }

    private void drawSpaceAtFirst(int lengthOfFirstPlayerName) {
        ladderOutput.append(BLANK.repeat(lengthOfFirstPlayerName));
    }

    private void drawInnerLadder(Players players, Ladder ladder, int height) {
        for (Boolean isExistFoothold : ladder.getLines().findSelectedLine(height)) {
            ladderOutput.append(BAR);
            drawExistingFoothold(players, isExistFoothold);
        }
    }

    private void drawExistingFoothold(Players players, Boolean isExistFoothold) {
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
