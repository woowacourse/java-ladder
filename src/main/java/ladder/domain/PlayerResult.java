package ladder.domain;

public class PlayerResult {
    private final Player player;
    private final Prize prize;

    public PlayerResult(Player player, Prize prize) {
        this.player = player;
        this.prize = prize;
    }

    public boolean isPlayerNameMatch(String playerName) {
        return player.isNameMatch(playerName);
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getPrize() {
        return prize.getPrize();
    }
}
