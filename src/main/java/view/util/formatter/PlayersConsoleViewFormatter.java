package view.util.formatter;

import domain.player.Player;
import domain.player.Players;

public class PlayersConsoleViewFormatter {

    private static final String BLANK = " ";
    private static final String PLAYER_RESULT_SEPARATOR = " : ";

    public static String formatPlayers(Players players) {
        StringBuilder playersFormat = new StringBuilder();
        for (Player player : players.getPlayers()) {
            playersFormat.append(LadderContentConsoleViewFormatter.formatContent(player.getPlayerName()))
                    .append(BLANK);
        }

        return playersFormat.toString();
    }

    public static String formatResultPlayers(Players players) {
        StringBuilder playersFormat = new StringBuilder();
        for (Player player : players.getPlayers()) {
            playersFormat.append(player.getPlayerName())
                    .append(PLAYER_RESULT_SEPARATOR)
                    .append(player.getResultContent())
                    .append(System.lineSeparator());
        }

        return playersFormat.toString();
    }
}
