package laddergame.domain.ladder;

import laddergame.domain.player.Players;
import laddergame.domain.result.Results;

import java.util.*;

public class Ladder {
    private static final int CONNECTING_BRIDGE_TRIAL_COUNT = 100;

    private final int height;
    private final int width;
    private List<Line> ladder;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        initializeLadder();
    }

    private void initializeLadder(){
        ladder = new ArrayList<>();
        for (int i = 0; i <= height; i++) {
            ladder.add(new Line(width));
        }
    }

    public void connectBridgesRandomly() {
        Random random = new Random();
        for (int i = 0; i < CONNECTING_BRIDGE_TRIAL_COUNT; i++) {
            int randomRow = random.nextInt(height) + 1;
            int randomColumn = random.nextInt(width) + 1;

            connectBridge(randomRow, randomColumn);
        }
    }

    public void connectBridge(int row, int column) {
        try {
            ladder.get(row).connect(column);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public int findIndexOfResult(int startPosition) {
        for (Line line : ladder) {
            startPosition += line.findRoute(startPosition);
        }
        return startPosition;
    }

    public boolean isLinked(int row, int column) {
        try {
            return ladder.get(row).isLinked(column);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Map<String, String> getResultOfPlayer(Players players, Results results){
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
        for (Line line : ladder.subList(1, ladder.size())) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }
}
