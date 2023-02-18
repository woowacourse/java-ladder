package domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LaddersTest {

    @Test
    void LaddersTest() {
        Queue<Boolean> randomNumber = new LinkedList<>();
        Arrays.asList(false, true, true).forEach(randomNumber::add);
        List<List<Position>> result = new Ladders(2, new Height(3), new CustomRandomGenerator(randomNumber))
                .getLadders()
                .stream()
                .map(Ladder::getLadder)
                .collect(Collectors.toList());

        Assertions.assertThat(result)
                .isEqualTo(Arrays.asList(
                        Arrays.asList(Position.DOWN, Position.DOWN),
                        Arrays.asList(Position.LEFT, Position.RIGHT),
                        Arrays.asList(Position.LEFT, Position.RIGHT)
                ));
    }
}
