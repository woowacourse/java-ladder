package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;


    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>();
        this.lines.addAll(lines);
    }


    public List<Line> getLines() {
        List<Line> lines = new ArrayList<>();
        lines.addAll(this.lines);
        return lines;
    }

    public List<Integer> takeAllLadder() {
        List<Integer> resultPositions = new ArrayList<>();
        for (int i = 0; i < lines.get(0).getWidth(); i++) {
            resultPositions.add(takeLadder(i));
        }
        return resultPositions;
    }

    public int takeLadder(int playerIndex) {
        int playerPosition = playerIndex;

        for (int i = 0; i < lines.size(); i++) {
            playerPosition = lines.get(i).requestNextDestination(playerPosition);
        }

        return playerPosition;
    }
}

