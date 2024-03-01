package domain;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        validateCountEqual(ladder, players, prizes);
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public LadderResult drive(PlayerName playerName) {
        ColumnPosition arrivalPoint = ladder.drive(players.columnPositionOf(playerName));
        Prize prize = prizes.getPrize(arrivalPoint);
        return new LadderResult(prize.getPrizeName(), playerName.getName());
    }

    public LadderResults driveAll() {
        return new LadderResults(players.getPlayers().stream()
                .map(player -> this.drive(player.getPlayerName()))
                .toList());
    }

    private void validateCountEqual(Ladder ladder, Players players, Prizes prizes) {
        if (ladder.getColumnCount() != prizes.getPrizeCount()) {
            System.out.println("ladder.getColumnCount() = " + ladder.getColumnCount());
            System.out.println("prizes.getPrizeCount() = " + prizes.getPrizeCount());
            throw new IllegalArgumentException("[ERROR] 사다리 열과 결과의 개수가 일치하지 않습니다");
        }
    }
}
