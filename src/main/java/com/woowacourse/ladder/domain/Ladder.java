package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines.stream().map(Line::clone).collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return this.lines.stream().map(Line::clone).collect(Collectors.toList());
    }

    public int takeLadder(int playerIndex) {
        int playerPosition = playerIndex;

        for (int i = 0; i < lines.size(); i++) {
            playerPosition = lines.get(i).requestNextDestination(playerPosition);
        }

        return playerPosition;
    }
}

