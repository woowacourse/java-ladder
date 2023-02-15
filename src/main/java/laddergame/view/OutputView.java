package laddergame.view;

import laddergame.domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public enum OutputView {
    BLANK(" "),
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-");

    private final String ladderElement;

    OutputView(final String ladderElement) {
        this.ladderElement = ladderElement;
    }

    public static void printPlayerAll(List<String> players) {
        final String allPlayerName = players.stream()
                .map(player -> makeNameFormat(player))
                .collect(Collectors.joining(BLANK.ladderElement));

        System.out.println(allPlayerName);
    }

    private static String makeNameFormat(String name) {
        int count = 5 - name.length();
        final String repeat = BLANK.ladderElement.repeat(count);

        return String.format("%s%s", name, repeat);
    }

    public static void printLadder(final int maxNameLength, final Ladder ladder) {
        StringBuilder result = new StringBuilder(VERTICAL_LINE.ladderElement);
        ladder.getLines().forEach(line -> result.append(makeLadderFormat(line.getStatuses(), maxNameLength)));
        System.out.println(result);
    }

    private static String makeLadderFormat(final List<Boolean> statuses, final int maxNameLength) {
        final StringBuilder result = new StringBuilder();
        statuses.forEach(status -> result.append(makeLine(status, maxNameLength)));
        result.append(VERTICAL_LINE.ladderElement);

        return result.toString();
    }

    private static String makeLine(final Boolean status, final int maxNameLength) {
        if (status) {
            return HORIZONTAL_LINE.ladderElement.repeat(maxNameLength);
        }

        return BLANK.ladderElement.repeat(maxNameLength);
    }

}
