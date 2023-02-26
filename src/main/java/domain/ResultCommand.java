package domain;

import java.util.List;

public class ResultCommand {

    private final Players players;

    public ResultCommand(Players players) {
        this.players = players;
    }

    public List<Player> getCommandResult(Command command) {
        if (command.isAllCommand()) {
            return players.getPlayers();
        }

        return List.of(players.findByName(command.getCommand()));
    }

}
