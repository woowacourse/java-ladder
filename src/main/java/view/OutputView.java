package view;

import domain.Ladder;
import domain.Player;
import domain.Players;

public class OutputView {

    public void printResult(final Players players, final Ladder ladder) {
        System.out.println("실행결과");

        StringBuilder playerNames = getPlayerNames(players);
        System.out.println(playerNames);

        StringBuilder ladderOutput = makeLadder(players, ladder);
        System.out.println(ladderOutput);
    }

    public StringBuilder getPlayerNames(final Players players) {
        StringBuilder playerNames = new StringBuilder();
        int longestName = players.findLongestPlayerName();

        for (Player player : players.getPlayers()) {
            int blankSpace = longestName - player.getName().length();
            playerNames.append(player.getName())
                    .append(" ".repeat(blankSpace))
                    .append(" ");
        }

        return playerNames;
    }

    public StringBuilder makeLadder(Players players, Ladder ladder) {
        StringBuilder ladderOutput = new StringBuilder();

        for (int i = 0; i < ladder.getHeight().getHeight(); i++) {
            ladderOutput.append(" ".repeat(players.findFirstPlayer().getName().length()));
            drawFoothold(players, ladder, ladderOutput, i);
        }
        return ladderOutput;
    }

    private void drawFoothold(Players players, Ladder ladder, StringBuilder ladderOutput, int i) {
        for (Boolean isExist : ladder.getLines().existFoothold(i)) {
            ladderOutput.append("|");
            checkExistingFoothold(players, ladderOutput, isExist);
        }
        ladderOutput.append("|\n");
    }

    private void checkExistingFoothold(Players players, StringBuilder ladderOutput, Boolean isExist) {
        if (isExist) {
            ladderOutput.append("-".repeat(players.findLongestPlayerName()));
        }
        if (!isExist) {
            ladderOutput.append(" ".repeat(players.findLongestPlayerName()));
        }
    }

}
