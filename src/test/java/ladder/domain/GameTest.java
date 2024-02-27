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
        int position = 3;
        int expected = 0;

        // when
        int result = game.calculateOne(position);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("특정 깊이와 위치에서 한 번 내려간 결과를 생성한다.")
    void calculateOneDepthTest() {
        assertThat(game.calculateOneDepth(0, 1)).isEqualTo(0);
        assertThat(game.calculateOneDepth(1, 1)).isEqualTo(2);
        assertThat(game.calculateOneDepth(2, 1)).isEqualTo(1);
        assertThat(game.calculateOneDepth(3, 1)).isEqualTo(3);
    }
}
