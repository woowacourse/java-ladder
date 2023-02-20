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
    private String namesOutput = "";
    private String ladderOutput = "";

    public void printResult(final Names names, final Ladder ladder) {
        System.out.println(NEW_LINE + "실행결과" + NEW_LINE);

        System.out.println(makeNamesOutput(names));
        System.out.println(makeLadderOutput(names, ladder));
    }

    private String makeNamesOutput(final Names names) {
        namesOutput += (findFirstPlayerName(names) + BLANK);

        for (int i = 1; i < names.getNames().size(); i++) {
            appendPlayerNames(findLongestName(names), names.getNames().get(i));
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

    private String findFirstPlayerName(final Names names) {
        return names.getNames().get(0).getName();
    }

    private void appendPlayerNames(final int longestName, final Name name) {
        if (isMaximumLengthOfName(name)) {
            namesOutput += (BLANK + name.getName());
            return;
        }
        drawPlayerName(longestName, name);
    }

    private boolean isMaximumLengthOfName(final Name name) {
        return name.getName().length() == MAXIMUM_LENGTH_OF_NAME;
    }

    private void drawPlayerName(final int longestName, final Name name) {
        int numberOfBlank = longestName - name.getName().length();
        namesOutput += (LadderSymbol.draw(BLANK, numberOfBlank) + name.getName() + BLANK);
    }

    private String makeLadderOutput(final Names names, final Ladder ladder) {
        for (int heightIndex = 0; heightIndex < findLadderHeight(ladder); heightIndex++) {
            drawSpaceAtFirst(findLengthOfFirstPlayerName(names));
            drawInnerLadder(names, ladder, heightIndex);
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
        if (lengthOfFirstPlayerName >= BOUNDARY_OF_NAME_LENGTH) {
            ladderOutput += BLANK.repeat(BOUNDARY_OF_NAME_LENGTH);
            return;
        }
        ladderOutput += BLANK.repeat(lengthOfFirstPlayerName);
    }

    private void drawInnerLadder(final Names names, final Ladder ladder, final int heightIndex) {
        for (Boolean isExistingConnection : findSelectedLine(ladder.getLines(), heightIndex)) {
            ladderOutput += BAR;
            drawExistingConnection(names, isExistingConnection);
        }
        ladderOutput += (BAR + NEW_LINE);
    }

    public List<Boolean> findSelectedLine(final Lines lines, final int selectedPosition) {
        return lines.getLines().get(selectedPosition).getConnections();
    }

    private void drawExistingConnection(final Names names, final Boolean isExistingFoothold) {
        if (isExistingFoothold) {
            ladderOutput += CONNECTION.repeat(findLongestName(names));
            return;
        }
        ladderOutput += BLANK.repeat(findLongestName(names));
    }
}
