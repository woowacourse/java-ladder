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
            return players.getPlayerNames();
        }

        Player player = command.toPlayer();
        validate(player);
        return List.of(player);
    }

    private void validate(Player player) {
        if (!players.contains(player)) {
            throw new IllegalArgumentException(INVALID_COMMAND_ERROR_MESSAGE);
        }
    }

}
