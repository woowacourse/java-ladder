package ladder.model;

public class LadderGame {
    private static final String NEW_LINE = "\n";
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
        for (Player player : this.players) {
            stringBuilder.append(player.getName()).append(" : ").append(this.getResultByName(player.getName())).append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public void playGame() {
        ladder.move(players);
    }
}
