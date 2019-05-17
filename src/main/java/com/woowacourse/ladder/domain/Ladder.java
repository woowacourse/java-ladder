package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int width;

    public Ladder(List<Line> lines, final int width) {
        this.lines = lines;
        this.width = width;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Integer> stripeAllLader() {
        List<Integer> resultPositions = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            resultPositions.add(stripeLadder(i));
        }
        return resultPositions;
    }

    public int stripeLadder(int playerIndex) {
        int playerPosition = playerIndex;

        for (int i = 0; i < lines.size(); i++) {
            playerPosition = lines.get(i).requestNextDestination(playerPosition);
        }

        return playerPosition;
    }
}

