package ladder.domain;

public class PlayerWithMatchingCommand {
    private final Player player;
    private final MatchingCommand matching;

    private PlayerWithMatchingCommand(Player player, MatchingCommand matchingCommand) {
        this.player = player;
        this.matching = matchingCommand;
    }

    public static PlayerWithMatchingCommand of(Player player, MatchingCommand matchingCommand) {
        return new PlayerWithMatchingCommand(player, matchingCommand);
    }

    public boolean isFinished() {
        return MatchingCommand.FINISHED.equals(matching);
    }

    public Player getPlayer() {
        return player;
    }
}
