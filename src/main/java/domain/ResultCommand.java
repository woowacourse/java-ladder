package domain;

import java.util.List;

public class ResultCommand {

    private static final String INVALID_COMMAND_ERROR_MESSAGE = "all 이나 Player 의 이름만 입력이 가능합니다.";

    private final PlayerNames playerNames;

    public ResultCommand(PlayerNames playerNames) {
        this.playerNames = playerNames;
    }

    public List<PlayerName> getCommandResult(Command command) {
        if (command.isAllCommand()) {
            return playerNames.getPlayerNames();
        }

        PlayerName playerName = command.toPlayerName();
        validate(playerName);
        return List.of(playerName);
    }

    private void validate(PlayerName playerName) {
        if (!playerNames.contains(playerName)) {
            throw new IllegalArgumentException(INVALID_COMMAND_ERROR_MESSAGE);
        }
    }

}
