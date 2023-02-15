package laddergame.view;

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

}
