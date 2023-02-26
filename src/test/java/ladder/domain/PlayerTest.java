package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("이름을 입력받아 Player를 생성한다")
    public void shouldCreatePlayerWhenInputName() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Player("name"));
    }

    @Test
    @DisplayName("결과를 입력받아 Player의 결과로 저장한다.")
    void shouldSaveResultWhenRequest() {
        Player player = new Player("name");
        assertDoesNotThrow(() -> player.saveResult(new Result("content")));
    }

    @Test
    @DisplayName("결과가 저장된 Player임을 확인한다.")
    void shouldBeTrueWhenSavedResult() {
        Player player = new Player("name");
        player.saveResult(new Result("content"));
        assertThat(player.haveResult()).isTrue();
    }

    @Test
    @DisplayName("결과가 저장되지 않은 Player임을 확인한다.")
    void shouldBeFalseWhenNotSavedResult() {
        Player player = new Player("name");
        assertThat(player.haveResult()).isFalse();
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void shouldReturnNameValueWhenRequest() {
        String name = "name";
        Player player = new Player(name);
        assertThat(player.getNameValue()).isEqualTo(name);
    }
}
