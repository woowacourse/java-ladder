package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    void player_LongerThanFiveLength_ExceptionThrown() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("pobiii"));
    }

    @Test
    @DisplayName("이름에 공백은 포함하지 않는다.")
    void player_WithBlank_DoesNotContainsBlank() {
        // given
        String rawName = "     jk      ";

        // when
        Player player = new Player(rawName);

        // then
        assertThat(player).extracting("value")
                .asString()
                .isEqualTo("jk");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("이름이 공백이라면 예외가 발생한다.")
    void player_hasBlank_ExceptionThrown(String blankName) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(blankName));
    }

    @Test
    @DisplayName("이름이 같다면 두 객체의 값이 같다.")
    void player_SameValue_IsEqual() {
        String name = "pobi";

        Player pobi1 = new Player(name);
        Player pobi2 = new Player(name);

        assertThat(pobi1).isEqualTo(pobi2);
    }

    @Test
    @DisplayName("all이라는 이름을 생성할 수 없다.")
    void player_All_ExceptionThrown() {
        // given
        String all = "all";

        // when & then
        assertThatThrownBy(() -> new Player(all))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
