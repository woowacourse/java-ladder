package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임")
public class GameTest {
    Ladder ladder = new Ladder(List.of(
            new Line(List.of(true, false, true)),
            new Line(List.of(false, true, false)),
            new Line(List.of(true, false, true))
    ));
    Game game;

    @BeforeEach
    void createGame() {
        game = new Game(ladder);
    }

    @Test
    @DisplayName("결과를 생성한다.")
    void generateResultTest() {
        // given
        List<Integer> expected = List.of(3, 1, 2, 0);

        // when
        List<Integer> result = game.calculateResult();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("하나의 실행에 대한 결과 하나를 생성한다.")
    void calculateOneTest() {
        // given
        int order = 3;
        int expected = 0;

        // when
        int result = game.calculateOne(order);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
