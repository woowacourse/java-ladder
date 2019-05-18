package com.woowacourse.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LadderState {
    private List<LadderRow> rows;

    public LadderState(int numOfParticipants, int height, BooleanGenerator booleanGenerator) {
        rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(new LadderRow(numOfParticipants, booleanGenerator));
        }
    }

    public void forEachRows(Consumer<LadderRow> rowConsumer) {
        rows.forEach(rowConsumer);
    }

    public class LadderRow {
        List<Direction> directions;

        private LadderRow(int numOfParticipants, BooleanGenerator generator) {
            directions = new ArrayList<>();
            boolean canGoRight = generator.generateBoolean();
            Direction current = Direction.first(canGoRight);
            directions.add(current);

            for (int i = 1; i < numOfParticipants - 1; i++) {
                canGoRight = generator.generateBoolean();
                current = checkAndAddDirection(current, canGoRight);
            }

            directions.add(directions.get(directions.size() - 1).nextLast());
        }

        private Direction checkAndAddDirection(Direction current, boolean canGoRight) {
            if (current == Direction.RIGHT && canGoRight) {
                current = current.next(false);
                directions.add(current);
                return current;
            }
            current = current.next(canGoRight);
            directions.add(current);
            return current;
        }

        public List<Direction> getDirections() {
            return new ArrayList<>(directions);
        }
    }
}
