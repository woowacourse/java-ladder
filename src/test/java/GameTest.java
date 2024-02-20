import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    @DisplayName("생성 테스트")
    @Test
    void creatGame() {
        Assertions.assertThatCode(() -> new Game())
                .doesNotThrowAnyException();
    }

    @DisplayName("사람들의 이름을 받아 사람 리스트로 반환한다.")
    @Test
    void parsePersonName() {
        Game game = new Game();

        List<Person> result = game.parsePersonName("아톰,산초");

        Assertions.assertThat(result)
                .containsExactly(new Person("아톰"), new Person("산초"));
    }
}
