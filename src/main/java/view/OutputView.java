package view;

import java.util.List;
import java.util.Map;

import domain.Ladder;
import domain.Lines;
import domain.Name;
import domain.Result;

public class OutputView {

    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private static final int BOUNDARY_OF_NAME_LENGTH = 4;
    private static final String BLANK = " ";
    private static final String CONNECTION = "-";
    private static final String BAR = "|";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final StringBuilder namesOutput = new StringBuilder();
    private static final StringBuilder ladderOutput = new StringBuilder();
    private static final StringBuilder resultOutput = new StringBuilder();

    public static void printLadder(final List<Name> names, final Ladder ladder, final List<Result> results) {
        System.out.println(NEW_LINE + "사다리결과" + NEW_LINE);

        System.out.println(makeNamesOutput(names));
        System.out.print(makeLadderOutput(names, ladder));
        System.out.println(makeResultsOutput(results, names));
    }

    private static StringBuilder makeNamesOutput(final List<Name> names) {
        namesOutput.append(findFirstPlayerName(names))
                .append(BLANK);

        for (int i = 1; i < names.size(); i++) {
            appendPlayerNames(findLongestLengthOfName(names), names.get(i));
        }

        return namesOutput;
    }

    private static String findFirstPlayerName(final List<Name> names) {
        return names.get(0).getValue();
    }


    private static int findLongestLengthOfName(final List<Name> names) {
        return names.stream()
                .mapToInt(player -> player.getValue().length())
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static void appendPlayerNames(final int longestName, final Name name) {
        if (isMaximumLengthOfName(name)) {
            namesOutput.append(BLANK)
                    .append(name.getValue());
            return;
        }
        drawPlayerName(longestName, name);
    }

    private static boolean isMaximumLengthOfName(final Name name) {
        return name.getValue().length() == MAXIMUM_LENGTH_OF_NAME;
    }

    private static void drawPlayerName(final int longestName, final Name name) {
        int numberOfBlank = longestName - name.getValue().length();
        namesOutput.append(LadderSymbol.draw(BLANK, numberOfBlank))
                .append(name.getValue())
                .append(BLANK);
    }

    private static StringBuilder makeLadderOutput(final List<Name> names, final Ladder ladder) {
        for (int heightIndex = 0; heightIndex < findLadderHeight(ladder); heightIndex++) {
            drawSpaceAtFirst(findLengthOfFirstPlayerName(names));
            drawInnerLadder(names, ladder, heightIndex);
        }

        return ladderOutput;
    }

    private static int findLadderHeight(final Ladder ladder) {
        return ladder.getHeight().getValue();
    }

    private static int findLengthOfFirstPlayerName(final List<Name> names) {
        return names.get(0).getValue().length();
    }

    private static void drawSpaceAtFirst(final int lengthOfFirstPlayerName) {
        if (lengthOfFirstPlayerName >= BOUNDARY_OF_NAME_LENGTH) {
            ladderOutput.append(BLANK.repeat(BOUNDARY_OF_NAME_LENGTH));
            return;
        }
        ladderOutput.append(BLANK.repeat(lengthOfFirstPlayerName));
    }

    private static void drawInnerLadder(final List<Name> names, final Ladder ladder, final int heightIndex) {
        for (Boolean isExistingConnection : findSelectedLine(ladder.getLines(), heightIndex)) {
            ladderOutput.append(BAR);
            drawExistingConnection(names, isExistingConnection);
        }
        ladderOutput.append(BAR)
                .append(NEW_LINE);
    }

    private static List<Boolean> findSelectedLine(final Lines lines, final int selectedPosition) {
        return lines.getLines().get(selectedPosition).getConnections();
    }

    private static void drawExistingConnection(final List<Name> names, final Boolean isExistingConnection) {
        if (isExistingConnection) {
            ladderOutput.append(CONNECTION.repeat(findLongestLengthOfName(names)));
            return;
        }
        ladderOutput.append(BLANK.repeat(findLongestLengthOfName(names)));
    }

    private static StringBuilder makeResultsOutput(final List<Result> results, final List<Name> names) {
        for (Result result : results) {
            resultOutput.append(result.getValue())
                    .append(BLANK.repeat(findLongestLengthOfName(names) - result.getValue().length()));
        }

        return resultOutput;
    }

    public static void printResult(final String inputName, final Map<String, String> gameResult) {
        System.out.println(NEW_LINE + "실행 결과");
        validateExistingName(inputName, gameResult);

        if (inputName.equals("all")) {
            makeAllNameAndResult(gameResult);
            return;
        }
        System.out.println(gameResult.get(inputName));
    }

    private static void validateExistingName(final String name, final Map<String, String> gameResult) {
        if (!(name.equals("all") || gameResult.containsKey(name))) {
            throw new IllegalArgumentException("해당 되는 이름을 가진 사람은 참여하지 않았습니다.");
        }
    }

    private static void makeAllNameAndResult(final Map<String, String> gameResult) {
        for (String name : gameResult.keySet()) {
            System.out.println(name + " : " + gameResult.get(name));
        }
    }
}
