package com.woowacourse.laddergame.domain;

import com.woowacourse.laddergame.util.NaturalNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> ladder;

    public Ladder(NaturalNumber height, NaturalNumber countOfPerson) {
        ladder = new ArrayList<>();
        for (int h = 0; h < height.getNumber(); h++) {
            ladder.add(new Line(countOfPerson));
        }
    }

    public Ladder(NaturalNumber height, NaturalNumber countOfPerson, BooleanGenerator generator) {
        ladder = new ArrayList<>();
        for (int h = 0; h < height.getNumber(); h++) {
            ladder.add(new Line(countOfPerson, generator));
        }
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getCountOfPerson() {
        return ladder.get(0).size();
    }

    public boolean isContainsLine(NaturalNumber height, Line line) {
        return ladder.get(height.convertIndex()).equals(line);
    }

    public int takeLadder(NaturalNumber personNo) {
        int currentPosition = personNo.getNumber();
        for (Line line : ladder) {
            currentPosition = line.movePosition(new NaturalNumber(currentPosition));
        }
        return currentPosition;
    }

    public void putBridge(NaturalNumber height, NaturalNumber position) {
        ladder.get(height.convertIndex()).putBridge(position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder) {
            sb.append(line.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(this.ladder, ladder.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
