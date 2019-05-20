package ladder.model.laddergame;

import ladder.model.ladder.Ladder;
import ladder.model.player.Players;

public class LadderGame {
    private static final String NEW_LINE = "\n";
    private static final String COLON = " : ";
    private Players players;
    private Ladder ladder;
    private LadderGameResult ladderGameResult;

    public LadderGame(Players players, Ladder ladder, LadderGameResult ladderGameResult) {
        this.players = players;
        this.ladder = ladder;
        this.ladderGameResult = ladderGameResult;
    }

    public String getResultByName(String name) {
        if (players.isContains(name)) {
            return ladderGameResult.getResultByPosition(players.getPositionByName(name));
        }
        throw new IllegalArgumentException("없는 플레이어의 이름을 입력하였습니다.");
    }

    public String getAllResult() {
        StringBuilder stringBuilder = new StringBuilder();
        players.forEach(player ->
                stringBuilder.append(player.getName())
                        .append(COLON)
                        .append(this.getResultByName(player.getName()))
                        .append(NEW_LINE));

        return stringBuilder.toString();
    }

    public void playGame() {
        ladder.move(players);
    }

    public boolean isFinished(String name) {
        return "all".equals(name);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(players).append(NEW_LINE);
        stringBuilder.append(ladder);
        stringBuilder.append(ladderGameResult).append(NEW_LINE);

        return stringBuilder.toString();
    }
}
