package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> new Game(List.of("pobi", "atom"), List.of("꽝", "3000"), 3))
                .doesNotThrowAnyException();
    }

    @DisplayName("실행 결과는 사용자의 수와 동일하다.")
    @Test
    void checkGameResultSize() {
        assertThatThrownBy(() -> new Game(List.of("pobi", "atom"), List.of("3000"), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 위치를 입력하면, 게임 결과를 받아올 수 있다.")
    @Test
    void showResult() {
        Game game = new Game(
                List.of("pobi", "atom", "mang", "jay"),
                List.of("3000", "1000", "2000", "꽝"),
                createLadder());

        GameResult result = game.showResult("atom");

        assertThat(result.getName()).isEqualTo("꽝");
    }

    private Ladder createLadder() {
        List<Stick> line1 = List.of(
                Stick.NOT_FILLED,
                Stick.FILLED,
                Stick.NOT_FILLED
        );

        List<Stick> line2 = List.of(
                Stick.NOT_FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        );

        return new Ladder(List.of(new Line(line1), new Line(line2)));
    }
}
