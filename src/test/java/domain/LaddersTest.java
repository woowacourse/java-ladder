package domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("랜덤 값에 따라 사다리들이 정상적으로 생성되는지 테스트합니다.")
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

    @DisplayName("현재 위치를 입력하면 사다리 게임 결과 위치를 반환합니다.")
    @Test
    void ResultTest() {
        assertThat(ladders.getResult(0)).isEqualTo(0);
    }
}
