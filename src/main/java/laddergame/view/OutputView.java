package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Names;

import java.util.List;

import static java.util.stream.Collectors.joining;

public enum OutputView {
    BLANK(" "),
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-");

    private final String ladderElement;

    OutputView(final String ladderElement) {
        this.ladderElement = ladderElement;
    }

    public static void printPlayerAll(final Names names) {
        System.out.println(System.lineSeparator() + "실행결과" + System.lineSeparator());

        final String allPlayerName = names.getNames().stream()
                .map(player -> makeNameFormat(names.findMaxNameLength(), player))
                .collect(joining(BLANK.ladderElement));

        System.out.println(allPlayerName);
    }

    public static void printLadder(final Names names, final Ladder ladder) {
        StringBuilder result = new StringBuilder();
        ladder.getLadder().forEach(line -> result.append(makeLadderFormat(line.getLine(), names)));
        System.out.println(result);
    }

    public static void printMessage(final String message) {
        System.out.println("[ERROR] " + message + System.lineSeparator());
    }

    private static String makeNameFormat(final int maxNameLength, final String name) {
        int count = maxNameLength - name.length();
        final String repeat = BLANK.ladderElement.repeat(count);

        return String.format("%s%s", name, repeat);
    }

    private static String makeLadderFormat(final List<Boolean> line, final Names names) {
        final StringBuilder result = new StringBuilder(setUpLadder(names.getFirstNameLengthDividedByTwoRounded()));

        line.forEach(existences -> result.append(makeLine(existences, names.findMaxNameLength())));
        result.append(System.lineSeparator());

        return result.toString();
    }

    private static String setUpLadder(final int numberOfBlanks) {
        return String.format("%s%s", BLANK.ladderElement.repeat(numberOfBlanks), VERTICAL_LINE.ladderElement);
    }

    private static String makeLine(final Boolean existences, final int maxNameLength) {
        return String.format("%s%s", visualizeExistences(existences).repeat(maxNameLength), VERTICAL_LINE.ladderElement);
    }

    private static String visualizeExistences(final boolean existences) {
        if (existences) {
            return HORIZONTAL_LINE.ladderElement;
        }
        return BLANK.ladderElement;
    }
}
