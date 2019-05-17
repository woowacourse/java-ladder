package com.woowacourse.ladder.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PartGeneratorTest {
    List<Boolean> bools;

    @BeforeEach
    void setUp() {
        bools = Arrays.asList(true, false, true, false);
    }

    @Test
    void Generate_Directions메소드_테스트() {
        List<Direction> directions = PartGenerator.generateDirections(bools);
        assertThat(directions.size()).isEqualTo(5);
        assertThat(directions.get(0)).isEqualTo(Direction.first(bools.get(0)));
        for (int i = 1; i < bools.size() ; i++) {
            assertThat(directions.get(i)).isEqualTo(Direction.middle(bools.get(i - 1), bools.get(i)));
        }

        assertThat(directions.get(directions.size()-1)).isEqualTo(Direction.last(bools.get(bools.size()-1)));
    }

    @Test
    void Generate_Line메소드_테스트() {
        List<Direction> directions = PartGenerator.generateDirections(bools);
        PartGenerator.generateLine(bools,directions);
    }

    @Test
    void Generate_BoolList_테스트() {
        List<Boolean> bools2 = Arrays.asList(true, false, true, false);
        assertThat(PartGenerator.generateBoolList(5).size()).isEqualTo(bools2.size());
    }
}
