package ladder.view;

import ladder.MessageCollection;
import ladder.model.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PIPE = "|";
    private static final String HYPHEN = "-";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

    public void showLadderGame(List<String> names, Ladder ladder, List<String> goalNames) {
        System.out.println(ENTER + MessageCollection.OUTPUT_LADDER_RESULT + ENTER);
        showPlayers(names);
        showLadder(ladder);
        showGoals(goalNames);
    }

    private void showPlayers(List<String> names) {
        for (String name : names) {
            System.out.print(name);
        }
        System.out.println();
    }

    private void showLadder(Ladder ladder) {
        System.out.println(printLadder(ladder));
    }

    private void showGoals(List<String> goalNames) {
        for (String goal : goalNames) {
            System.out.print(goal);
        }
        System.out.println();
    }

    public void showGameResult(String foundGoal) {
        if (foundGoal != null) {
            System.out.println(ENTER + MessageCollection.OUTPUT_RESULT);
            System.out.println(foundGoal);
        }
    }

    private String printLadder(Ladder ladder) {
        String crossbar = createCrossbar(HYPHEN, ladder);
        String notCrossbar = createCrossbar(BLANK, ladder);

        return ladder.getLines().stream().map(lineIndex -> PIPE + lineIndex.getCrossbars().stream().map(index -> {
            if (index.isCrossbar()) {
                return crossbar;
            }
            return notCrossbar;
        }).collect(Collectors.joining(PIPE)) + PIPE).collect(Collectors.joining(ENTER));

    }

    private String createCrossbar(String mark, Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ladder.getWidth(); i++) {
            stringBuilder.append(mark);
        }
        return stringBuilder.toString();
    }


}
