package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {


    public OutputView() {
    }

    public void print(Players players, Ladder ladder, LadderRewards ladderRewards) {
        System.out.println(ConsoleMessages.OUTPUT_LADDER.message());
        printPlayers(players);
        printLadder(ladder);
        printRewards(ladderRewards);
    }

    private void printRow(LadderRow row) {
        System.out.println(line(row));
    }

    private void printLadder(Ladder ladder) {
        for (LadderRow ladderRow : ladder.rows()) {
            printRow(ladderRow);
        }
    }

    public void printResult(String message) {
        System.out.println(ConsoleMessages.OUTPUT_RESULT.message());
        System.out.println(message);
    }

    public String line(LadderRow row) {
        List<LadderLine> lines = row.status();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ");
        for (int i = 0; i < lines.size() - 1; i++) {
            stringBuilder.append("|").append((mark(lines.get(i))));
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private String mark(LadderLine line) {
        if (line.direction() == LadderRules.RIGHT) {
            return "-----";
        }
        return "     ";
    }

    private void printPlayers(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players.list()) {
            stringBuilder.append(String.format("%6s", player.name()));
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());
    }

    private void printRewards(LadderRewards ladderRewards) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String reward : ladderRewards.reward()) {
            stringBuilder.append(String.format("%6s", reward));
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
}
