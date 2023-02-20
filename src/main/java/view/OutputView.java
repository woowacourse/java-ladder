package view;

import java.util.List;

import domain.Ladder;
import domain.Lines;
import domain.Name;
import domain.Names;

public class OutputView {

    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private static final int BOUNDARY_OF_NAME_LENGTH = 4;
    private static final String BLANK = " ";
    private static final String CONNECTION = "-";
    private static final String BAR = "|";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final StringBuilder ladderOutput = new StringBuilder();
    private static final StringBuilder namesOutput = new StringBuilder();

    public void printResult(final Names names, final Ladder ladder) {
        System.out.println(NEW_LINE + "실행결과" + NEW_LINE);

        StringBuilder playerNames = makeNamesOutput(names);
        System.out.println(playerNames);

        StringBuilder ladderOutput = makeLadderOutput(names, ladder);
        System.out.println(ladderOutput);
    }

    private StringBuilder makeNamesOutput(final Names names) {
        int longestPlayerName = findLongestName(names);

        drawFirstPlayerName(names);

        for (int i = 1; i < names.getNames().size(); i++) {
            appendPlayerNames(longestPlayerName, names.getNames().get(i));
        }

        return namesOutput;
    }

    private int findLongestName(final Names names) {
        return names.getNames()
                .stream()
                .mapToInt(player -> player.getName().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void drawFirstPlayerName(final Names names) {
        namesOutput.append(findFirstPlayerName(names))
                .append(BLANK);
    }

    private String findFirstPlayerName(final Names names) {
        return names.getNames().get(0).getName();
    }

    private void appendPlayerNames(final int longestName, final Name name) {
        if (isMaximumLengthOfName(name)) {
            drawPlayerNameWhenMaximumLength(name);
            return;
        }
        drawPlayerName(longestName, name);
    }

    private boolean isMaximumLengthOfName(final Name name) {
        return name.getName().length() == MAXIMUM_LENGTH_OF_NAME;
    }

    private void drawPlayerNameWhenMaximumLength(final Name name) {
        namesOutput.append(BLANK)
                .append(name.getName());
    }

    private void drawPlayerName(final int longestName, final Name name) {
        int numberOfBlank = longestName - name.getName().length();
        namesOutput.append(LadderSymbol.draw(BLANK, numberOfBlank))
                .append(name.getName())
                .append(BLANK);
    }

    private StringBuilder makeLadderOutput(final Names names, final Ladder ladder) {
        for (int heightIndex = 0; heightIndex < findLadderHeight(ladder); heightIndex++) {
            int lengthOfFirstPlayerName = findLengthOfFirstPlayerName(names);

            drawSpaceAtFirst(lengthOfFirstPlayerName);
            drawInnerLadder(names, ladder, heightIndex);
            drawBarAtLast();
        }

        return ladderOutput;
    }

    private int findLadderHeight(final Ladder ladder) {
        return ladder.getHeight().getHeight();
    }

    private int findLengthOfFirstPlayerName(final Names names) {
        return names.getNames().get(0).getName().length();
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

    private void drawInnerLadder(final Names names, final Ladder ladder, final int heightIndex) {
        for (Boolean isExistFoothold : findSelectedLine(ladder.getLines(), heightIndex)) {
            ladderOutput.append(BAR);
            drawExistingConnection(names, isExistFoothold);
        }
    }

    public List<Boolean> findSelectedLine(final Lines lines, final int selectedPosition) {
        return lines.getLines().get(selectedPosition).getConnections();
    }

    private void drawExistingConnection(final Names names, final Boolean isExistFoothold) {
        if (isExistFoothold) {
            ladderOutput.append(CONNECTION.repeat(findLongestName(names)));
            return;
        }
        ladderOutput.append(BLANK.repeat(findLongestName(names)));
    }

    private void drawBarAtLast() {
        ladderOutput.append(BAR)
                .append(NEW_LINE);
    }
}
