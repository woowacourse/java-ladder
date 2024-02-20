import java.util.List;

class Game {

    private final Players players;

    public Game(String input) {
        this.players = new Players(input);
    }

    public List<Player> getPlayers() {
        return this.players.getPlayers();
    }
}
