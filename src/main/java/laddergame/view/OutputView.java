package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Link;
import laddergame.domain.Names;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static laddergame.view.OutputFormat.BLANK;
import static laddergame.view.OutputFormat.VERTICAL_LINE;

public class OutputView {

    private static final int HALF = 2;

    public static void printPlayerAll(final Names names) {
        System.out.println(System.lineSeparator() + "실행결과" + System.lineSeparator());

        final String allPlayerName = names.getNames().stream()
                .map(player -> makeNameFormat(names.findMaxNameLength(), player))
                .collect(joining(BLANK.getLadderElement()));

        System.out.println(allPlayerName);
    }

    public static void printLadder(final Names names, final Ladder ladder) {
        StringBuilder result = new StringBuilder();
        ladder.getLadder().forEach(line -> result.append(makeLadderFormat(line.getFloor(), names)));
        System.out.println(result);
    }

    public static void printMessage(final String message) {
        System.out.println("[ERROR] " + message + System.lineSeparator());
    }

    private static String makeNameFormat(final int maxNameLength, final String name) {
        int count = maxNameLength - name.length();
        final String repeat = BLANK.getLadderElement().repeat(count);

        return String.format("%s%s", name, repeat);
    }

    private static String makeLadderFormat(final List<Link> line, final Names names) {
        final StringBuilder result = new StringBuilder(setUpLadder(names.getFirstNameLength()));

        line.forEach(existences -> result.append(makeLine(existences, names.findMaxNameLength())));
        result.append(System.lineSeparator());

        return result.toString();
    }

    private static String setUpLadder(final int firstNameLength) {
        final int leftBlankCount = Math.round(firstNameLength / HALF);
        return String.format("%s%s", BLANK.getLadderElement().repeat(leftBlankCount), VERTICAL_LINE.getLadderElement());
    }

    private static String makeLine(final Link link, final int maxNameLength) {
        return String.format("%s%s", OutputFormat.convertFormat(link).repeat(maxNameLength), VERTICAL_LINE.getLadderElement());
    }


}
