package domain;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final GameResults gameResults;

    public LadderGame(final Players players, final Ladder ladder, final GameResults gameResults) {
        this.players = players;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public GameResults getGameResults() {
        return gameResults;
    }

    public GameResult getGameResultOf(String playerName) {
        return getGameResult(players.get(playerName));
    }

    private GameResult getGameResult(Player player) {
        int currentXIndex = players.getCurrentPosition(player);
        int currentLineIndex = 0;
        List<Line> lines = ladder.getLines();
        while (currentLineIndex < lines.size()) {
            currentXIndex += getMovingPosition(lines.get(currentLineIndex), currentXIndex);
            currentLineIndex++;
        }
        return gameResults.getGameResultAt(currentXIndex);
    }

    private int getMovingPosition(Line line, int currentXIndex) {
        if (isNextPointExist(line, currentXIndex)) {
            return getMovingPositionSide(line, currentXIndex);
        }
        return PointPosition.NONE.getMovingPosition();
    }

    private boolean isNextPointExist(Line line, int currentXposition) {
        if (currentXposition == 0) {
            return line.getPointAt(currentXposition).isExist();
        } else if (currentXposition == line.getPoints().size()) {
            return line.getPointAt(currentXposition - 1).isExist();
        }
        return line.getPointAt(currentXposition - 1).isExist() |
                line.getPointAt(currentXposition).isExist();
    }

    private int getMovingPositionSide(Line line, int currentXIndex) {
        if (currentXIndex < line.getPoints().size() && line.getPointAt(currentXIndex).isExist()) {
            return PointPosition.RIGHT.getMovingPosition();
        }
        return PointPosition.LEFT.getMovingPosition();
    }
}
