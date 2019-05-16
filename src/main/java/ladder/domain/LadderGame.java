package ladder.domain;

public final class LadderGame {
    private final Ladder ladder;
    private final GamePlayers gamePlayers;
    private final PlayerRewards playerRewards;

    public LadderGame(final int height, final GamePlayers gamePlayers, final PlayerRewards playerRewards) {
        validateSize(gamePlayers.size(), playerRewards.size());
        this.ladder = new Ladder(height, gamePlayers.size());
        this.gamePlayers = gamePlayers;
        this.playerRewards = playerRewards;
    }

    private void validateSize(int countOfPlayers, int countOfResults) {
        if (countOfPlayers != countOfResults) {
            throw new IllegalArgumentException("사람의 수와 결과의 수가 다릅니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }

    public GamePlayers getPlayers() {
        return gamePlayers;
    }

    public PlayerRewards getPlayerRewards() {
        return playerRewards;
    }

    //TODO 나중에 DTO 혹은 복사해서 값을 전달하는 방식으로 변경
}
