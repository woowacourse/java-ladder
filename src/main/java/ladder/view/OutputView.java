package ladder.view;

import ladder.domain.Item;
import ladder.domain.Items;
import ladder.domain.Player;
import ladder.domain.Players;

/**
 * @author heebg
 * @version 1.0 2019-05-19
 */
public class OutputView {
    private static final String OUTPUT_RESULT = "사다리 결과";
    private static final String FORMAT_ALIGN_LEFT = "%-6s";

    public static void outputLadderShape(Players players, String ladder, Items items) {
        System.out.println(OUTPUT_RESULT);
        System.out.println(formatPlayers(players));
        System.out.println(ladder);
        System.out.println(formatItems(items));
    }

    private static String formatItems(Items items) {
        StringBuilder result = new StringBuilder();
        for (Item item : items) {
            result.append(String.format(FORMAT_ALIGN_LEFT, item));
        }
        return result.toString();
    }

    private static String formatPlayers(Players players) {
        StringBuilder result = new StringBuilder();
        for (Player player : players) {
            result.append(String.format(FORMAT_ALIGN_LEFT, player));
        }
        return result.toString();
    }

    public static void outputMatchItem(String matchItem) {
        System.out.println(matchItem);
    }
}
