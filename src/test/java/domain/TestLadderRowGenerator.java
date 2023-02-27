package domain;

import static domain.Point.*;

import java.util.List;

import domain.ladderRowGenerator.LadderRowGenerator;

public class TestLadderRowGenerator implements LadderRowGenerator {
    private final List<List<Point>> ladder = List.of(
            List.of(RIGHT, LEFT, RIGHT, LEFT),
            List.of(NONE, RIGHT, LEFT, NONE),
            List.of(RIGHT, LEFT, NONE, NONE),
            List.of(NONE, RIGHT, LEFT, NONE),
            List.of(RIGHT, LEFT, RIGHT, LEFT)
    );
    private int index = 0;

    @Override
    public LadderRow generate(int userCount) {
        List<Point> points = ladder.get(index++);
        return new LadderRow(points);
    }
}
