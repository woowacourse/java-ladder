package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class LadderGame {

    public static final int FIRST_INDEX_OF_POINTS = 0;
    private static final boolean NOT_EXIST = false;

    private final Players players;
    private final Ladder ladder;
    private final GameResults gameResults;

    public LadderGame(final Players players, final Ladder ladder, final GameResults gameResults) {
        this.players = players;
        this.ladder = ladder;
        this.gameResults = gameResults;
    }

    public GameResult getGameResultOf(final String playerName) {
        return getGameResult(players.get(playerName));
    }

    public LinkedHashMap<String, GameResult> getGameResultsOfAllPlayers() {
        LinkedHashMap<String, GameResult> results = new LinkedHashMap<>();
        for (Player player : players.get()) {
            results.put(player.getName(), getGameResult(player));
        }
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(players.getPlayerNames());
    }

    public GameResults getGameResults() {
        return gameResults;
    }

    private GameResult getGameResult(final Player player) {
        int currentXIndex = players.getCurrentPosition(player);
        int currentLineIndex = 0;
        List<Line> lines = ladder.getLines();
        while (currentLineIndex < lines.size()) {
            currentXIndex += getMovingPosition(lines.get(currentLineIndex), currentXIndex);
            currentLineIndex++;
        }
        return gameResults.getGameResultAt(currentXIndex);
    }

    private int getMovingPosition(final Line line, final int currentXIndex) {
        if (isNextPointExist(line, currentXIndex)) {
            return getMovingPositionSide(line, currentXIndex);
        }
        return PointSide.NONE.getMovingPosition();
    }

    private boolean isNextPointExist(final Line line, final int currentXPosition) {
        return isLeftPointExist(line, currentXPosition) | isRightPointExist(line, currentXPosition);
    }

    private static boolean isRightPointExist(final Line line, final int currentXPosition) {
        if (currentXPosition == line.getPoints().size()) {
            return NOT_EXIST;
        }
        return line.getPointAt(currentXPosition).isExist();
    }

    private static boolean isLeftPointExist(final Line line, final int currentXPosition) {
        if (currentXPosition == FIRST_INDEX_OF_POINTS) {
            return NOT_EXIST;
        }
        return line.getPointAt(currentXPosition - 1).isExist();
    }

    private int getMovingPositionSide(final Line line, final int currentXIndex) {
        if (currentXIndex < line.getPoints().size() && line.getPointAt(currentXIndex).isExist()) {
            return PointSide.RIGHT.getMovingPosition();
        }
        return PointSide.LEFT.getMovingPosition();
    }

}
