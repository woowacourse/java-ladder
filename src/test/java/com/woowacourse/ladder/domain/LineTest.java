package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    Line line;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder();
        List<Boolean> bools = Arrays.asList(true, false, true, false);
        List<Point> points = ladder.createPoints(bools);
        List<Direction> directions = ladder.createDirections(bools);
        line = new Line(bools, points, directions);
    }

    @Test
    void point생성_테스트() {
        assertThat(line.createPoint(0)).isEqualTo(new Point(0, 1000));
    }

    @Test
    void direction생성_테스트() {
        assertThat(line.creatDirection(true, false)).isEqualTo(new Point(0, 1000));
    }

    @Test
    void Line출력해보기() {
        List<Boolean> booleanList = line.getBridges();
        for (int i = 0; i < booleanList.size(); i++) {
            System.out.print("|");
            printBridge(booleanList, i);
        }
        System.out.println("|");
    }

    private void printBridge(List<Boolean> booleanList, int i) {
        if (booleanList.get(i)) {
            System.out.print("=====");
            return;
        }
        System.out.print("     ");
    }
}
