package ladder.domain;

public final class LadderGame {
    private final Ladder ladder;
    private final GamePlayers gamePlayers;

    public LadderGame(final int height, final GamePlayers gamePlayers) {
        this.ladder = new Ladder(height, gamePlayers.size());
        this.gamePlayers = gamePlayers;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public GamePlayers getPlayers() {
        return gamePlayers;
    }

    //TODO 나중에 DTO 혹은 복사해서 값을 전달하는 방식으로 변경
}
