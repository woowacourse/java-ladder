package domain;

import java.util.List;

public class ResultCommand {

    private static final String INVALID_COMMAND_ERROR_MESSAGE = "all 이나 Player 의 이름만 입력이 가능합니다.";

    private final Players players;

    public ResultCommand(Players players) {
        this.players = players;
    }

    public List<Player> getCommandResult(Command command) {
        if (command.isAllCommand()) {
            return players.getPlayers();
        }

        return List.of(players.getPlayers()
                .stream()
                .filter(command::isCommandMatches)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_ERROR_MESSAGE)));
    }

}
