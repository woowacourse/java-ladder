package ladder.domain.game;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizesTest {

    @Test
    @DisplayName("사다리 게임 결과에 해당하는 상품들에 정보를 가진다.")
    void createPrizes() {
        Prizes prizes = new Prizes(List.of("5000", "꽝", "3000", "꽝"), 4);

        assertThat(prizes).extracting("prizes", InstanceOfAssertFactories.list(String.class))
                .containsExactly("5000", "꽝", "3000", "꽝");
    }

    @Test
    @DisplayName("상품들의 수와 게임에 참여하는 참여자의 수가 다르면 예외가 발생한다.")
    void invalidPrizes() {
        assertThatThrownBy(() -> new Prizes(List.of("5000", "꽝", "3000", "꽝"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
