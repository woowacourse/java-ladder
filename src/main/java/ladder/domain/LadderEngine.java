package ladder.domain;

public class LadderEngine {
    private Players players;
    private final Ladder ladder;

    public LadderEngine(Ladder ladder, Players playersBeforeGame) {
        validateNotNull(ladder);
        validateNotNull(playersBeforeGame);
        this.ladder = ladder;
        this.players = playersBeforeGame;
    }

    private void validateNotNull(Ladder ladder) {
        if (ladder == null) {
            throw new IllegalArgumentException("사다리는 null일 수 없습니다.");
        }
    }

    private void validateNotNull(Players players) {
        if (players == null) {
            throw new IllegalArgumentException("플레이어들은 null일 수 없습니다.");
        }
    }

    public Players playLadderGame() {
        while(ladder.hasNextLine()) {
            players = players.goDown(ladder.getNextLine());
        }
        return players;
    }
}
