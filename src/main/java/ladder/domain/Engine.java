package ladder.domain;

import static ladder.util.NotNullValidator.validateNotNull;

public class Engine {
    private Players players;
    private final Ladder ladder;

    public Engine(Ladder ladder, Players playersBeforeGame) {
        validateNotNull(ladder);
        validateNotNull(playersBeforeGame);
        this.ladder = ladder;
        this.players = playersBeforeGame;
    }

    /**
     * 사다리를 타고 내려가 위치가 변화된 플레이어들을 반환하는 메소드
     */
    public Players playLadderGame() {
        while (ladder.hasNextLine()) {
            players = players.goDown(ladder.getNextLine());
        }
        ladder.endIteration();
        return players;
    }
}
