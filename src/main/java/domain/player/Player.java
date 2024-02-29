package domain.player;

public record Player(PlayerName playerName) {

    public boolean hasSamePlayerName(PlayerName targetPlayerName) {
        return this.playerName.equals(targetPlayerName);
    }
}
