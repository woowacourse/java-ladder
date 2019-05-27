package com.woowacourse.laddergame.domain;

import com.woowacourse.laddergame.util.NaturalNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Position> line;

    public Line(NaturalNumber countOfPerson) {
        line = new ArrayList<>();
        for (int positionIndex = 0; positionIndex < countOfPerson.getNumber(); positionIndex++) {
            line.add(Position.STOP);
        }
    }

    Line(NaturalNumber countOfPerson, BooleanGenerator generator) {
        this(countOfPerson);
        for (int positionNo = 1; positionNo < line.size(); positionNo++) {
            generateBridge(generator, positionNo);
        }
    }

    private void generateBridge(BooleanGenerator generator, int positionNo) {
        if (!isBridgeExist(new NaturalNumber(positionNo)) && generator.generate()) {
            putBridge(new NaturalNumber(positionNo));
        }
    }

    public int size() {
        return line.size();
    }

    public int getPositionCount() {
        return line.size();
    }

    public void putBridge(NaturalNumber number) {
        NaturalNumber lineSize = new NaturalNumber(line.size());
        if (number.isBiggerThan(lineSize) || number.equals(lineSize)) {
            throw new IllegalArgumentException("다리를 놓을 수 없습니다");
        }

        if (isBridgeExist(number)) {
            throw new IllegalArgumentException("다리가 존재하거나 연속되게 놓을 수 없습니다.");
        }

        line.set(number.convertIndex(), Position.RIGHT);
        line.set(number.convertIndex() + 1, Position.LEFT);
    }

    public boolean isBridgeExist(NaturalNumber number) {
        return line.get(number.convertIndex()) != Position.STOP;
    }

    public int movePosition(NaturalNumber positionNo) {
        return line.get(positionNo.convertIndex()).move(positionNo.getNumber());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Position position : line) {
            if (position.equals(Position.LEFT)) {
                sb.append("-----|");
                continue;
            }
            sb.append("     |");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
