package laddergame.view;

import laddergame.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LADDER_SEPARATOR = "|";
    private static final String SPACE = "\t";
    private static final String RESULT_FORMAT = "%s : %s";

    public void writeLadderResult(LadderGame ladderGame) {
        System.out.println(LINE_SEPARATOR + "사다리 결과" + LINE_SEPARATOR);
        writePlayersName(ladderGame.getPlayers());
        writeLadder(ladderGame.getLadder());
        writeResultItems(ladderGame.getItems());
    }

    public void writeResultItem(ResultItem item) {
        System.out.println(LINE_SEPARATOR + "실행결과");
        System.out.println(item.item());
    }

    public void writeAllResultItems(Map<Player, ResultItem> result) {
        System.out.println(LINE_SEPARATOR + "실행결과");
        List<String> itemsFormat = new ArrayList<>();
        for (Player player : result.keySet()) {
            itemsFormat.add(String.format(RESULT_FORMAT, player.getName(), result.get(player).item()));
        }
        System.out.println(String.join(LINE_SEPARATOR, itemsFormat));
    }

    public static void writeErrorMessage(final String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    private void writePlayersName(final Players players) {
        System.out.println(String.join(SPACE, players.getPlayers().stream()
                .map(Player::getName)
                .toList()));
    }

    private void writeLadder(final Ladder ladder) {
        ladder.getLines().forEach(this::writeLine);
    }

    private void writeLine(final Line line) {
        String formatted = line.getLine().stream()
                .map(LineSymbol::getSymbolByLine)
                .collect(Collectors.joining(LADDER_SEPARATOR, SPACE + LADDER_SEPARATOR, LADDER_SEPARATOR));

        System.out.println(formatted);
    }

    private void writeResultItems(final List<ResultItem> items) {
        System.out.println(String.join(SPACE, items.stream()
                .map(ResultItem::item)
                .toList())
        );
    }
}
