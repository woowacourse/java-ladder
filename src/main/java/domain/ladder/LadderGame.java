package domain.ladder;

import domain.Command;
import domain.Player;
import domain.Players;
import domain.ResultCommand;
import domain.Results;
import domain.Rewards;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Rewards rewards;

    public LadderGame(Ladder ladder, Players players, Rewards rewards) {
        this.players = players;
        this.rewards = rewards;
        playersMove(ladder, players);
    }

    private void playersMove(Ladder ladder, Players players) {
        players.move(ladder);
    }

    public Results getResults(Command command) {
        ResultCommand resultCommand = new ResultCommand(players);
        List<Player> playerFromCommand = resultCommand.getCommandResult(command);
        return Results.from(playerFromCommand, rewards.getRewards());
    }

}
