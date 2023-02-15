package view;

import domain.Ladder;
import domain.Players;

public class OutputView {

    public void printResult(final Players players, final Ladder ladder) {
        System.out.println("실행결과");

        StringBuilder playerNames = players.getPlayerNames();
        System.out.println(playerNames);

        StringBuilder ladderOutput = makeLadder(players, ladder);
        System.out.println(ladderOutput);
    }

    public StringBuilder makeLadder(Players players, Ladder ladder) {
        StringBuilder ladderOutput = new StringBuilder();

        for (int i = 0; i < ladder.getHeight().getHeight(); i++) {
            for (Boolean isExist : ladder.getLines().existFoothold(i)) {
                ladderOutput.append("|");
                if (isExist) {
                    ladderOutput.append("-".repeat(players.findLongestPlayerName()));
                    continue;
                }
                ladderOutput.append(" ".repeat(players.findLongestPlayerName()));
            }
            ladderOutput.append("|\n");
        }
        return ladderOutput;
    }
}
