package laddergame.domain.ladder;

import laddergame.domain.RandomGenerator;
import laddergame.domain.player.Players;
import laddergame.domain.result.Results;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ladder {
    private final int height;
    private final int width;
    private List<Line> lines;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        initializeLadder();
    }

    private void initializeLadder() {
        lines = new ArrayList<>();
        for (int i = 0; i <= height; i++) {
            lines.add(new Line(width));
        }
    }

    public void connectBridgesRandomly() {
        for (int i = 0; i < countAllSections(); i++) {
            int randomRow = RandomGenerator.generateNumber(height);
            int randomColumn = RandomGenerator.generateNumber(width - 1);

            connectBridge(randomRow, randomColumn);
        }
    }

    public void connectBridge(int row, int column) {
        lines.get(row).connect(column);
    }

    private int countAllSections() {
        return height * (width - 1);
    }

    public int findIndexOfResult(int startPosition) {
        for (Line line : lines) {
            startPosition += line.findRoute(startPosition);
        }
        return startPosition;
    }

    public boolean isLinked(int row, int column) {
        try {
            return lines.get(row).isLinked(column);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Map<String, String> getResultOfPlayer(Players players, Results results) {
        Map<String, String> resultOfPlayer = new TreeMap<>();
        for (int i = 0; i < players.getPlayersSize(); i++) {
            String player = players.getNameOfIndex(i);
            String result = results.getResult(findIndexOfResult(i));
            resultOfPlayer.put(player, result);
        }
        return resultOfPlayer;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines.subList(1, lines.size())) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }
}
