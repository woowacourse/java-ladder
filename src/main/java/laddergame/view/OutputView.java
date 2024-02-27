package laddergame.view;

import laddergame.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LADDER_SEPARATOR = "|";
    private static final String SPACE = "\t";
    private static final String RESULT_FORMAT = "%s : %s";

    public void writePlayersName(final Players players) {
        System.out.println(String.join(SPACE, players.getPlayers().stream()
                .map(Player::getName)
                .toList()));
    }

    public void writeLadder(final Ladder ladder, final ResultItems items) {
        ladder.getLines().forEach(this::writeLine);
        System.out.println(String.join(SPACE, items.getElements().stream().toList()));
    }

    private void writeLine(final Lines lines) {
        String formatted = lines.getLines().stream()
                .map(Line::getSymbol)
                .collect(Collectors.joining(LADDER_SEPARATOR, SPACE + LADDER_SEPARATOR, LADDER_SEPARATOR));

        System.out.println(formatted);
    }

    public void writeResultTitle() {
        System.out.println(LINE_SEPARATOR + "실행결과" + LINE_SEPARATOR);
    }

    public void writeResultItem(String item) {
        System.out.println(LINE_SEPARATOR + "실행결과");
        System.out.println(item);
    }

    public void writeAllResultItems(Players players) {
        System.out.println(LINE_SEPARATOR + "실행결과");
        List<String> itemsFormat = new ArrayList<>();
        for (Player player : players.getPlayers()) {
            itemsFormat.add(String.format(RESULT_FORMAT, player.getName(), player.getItem()));
        }
        System.out.println(String.join(LINE_SEPARATOR, itemsFormat));
    }

    public static void writeErrorMessage(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
