package domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LaddersTest {
    private Ladders ladders;

    @BeforeEach
    void init() {
        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(false, true, true).forEach(randomNumber::add);
        ladders = new Ladders(2, new Height(3), new CustomRandomGenerator(randomNumber));
    }

    @Test
    void LaddersTest() {
        List<List<Position>> result = ladders.getLadders()
                .stream()
                .map(Ladder::getLadder)
                .collect(Collectors.toList());

        assertThat(result)
                .isEqualTo(Arrays.asList(
                        Arrays.asList(Position.DOWN, Position.DOWN),
                        Arrays.asList(Position.LEFT, Position.RIGHT),
                        Arrays.asList(Position.LEFT, Position.RIGHT)
                ));
    }

    @Test
    void ResultTest() {
        assertThat(ladders.getResult(0)).isEqualTo(0);
    }
}
