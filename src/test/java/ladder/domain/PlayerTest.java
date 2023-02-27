package ladder.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("이름을 입력받아 Player를 생성한다")
    public void shouldCreatePlayerWhenInputName() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Player("name", 0));
    }

    @Test
    @DisplayName("결과를 입력받아 Player의 결과로 저장한다.")
    void shouldSaveResultWhenRequest() {
        Player player = new Player("name", 0);
        assertDoesNotThrow(() -> player.saveResult(new Result("content")));
    }

    @Test
    @DisplayName("결과가 저장된 Player임을 확인한다.")
    void shouldBeTrueWhenSavedResult() {
        Player player = new Player("name", 0);
        player.saveResult(new Result("content"));
        assertThat(player.haveResult()).isTrue();
    }

    @Test
    @DisplayName("결과가 저장되지 않은 Player임을 확인한다.")
    void shouldBeFalseWhenNotSavedResult() {
        Player player = new Player("name", 0);
        assertThat(player.haveResult()).isFalse();
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void shouldReturnNameValueWhenRequest() {
        String name = "name";
        Player player = new Player(name, 0);
        assertThat(player.getNameValue()).isEqualTo(name);
    }

    @Test
    @DisplayName("Player에 저장된 결과를 반환한다.")
    void shouldReturnValueOfResultWhenRequest() {
        Player player = new Player("name", 0);
        Result result = new Result("content");
        player.saveResult(result);
        assertThat(player.getResult()).isEqualTo(result);
    }

    @Test
    @DisplayName("Player에 결과가 저장되지 않은 채로 결과를 조회하면 예외가 발생한다.")
    void shouldThrowExceptionWhenGetResultNotSaved() {
        Player player = new Player("name", 0);
        assertThatThrownBy(() -> player.getResult())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("플레이어의 결과가 존재하지 않습니다.");
    }

    @Test
    @DisplayName("Player의 위치를 반환한다.")
    void shouldReturnIndexWhenRequest() {
        Player player = new Player("name", 3);
        assertThat(player.getIndex()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력받은 값과 같은 이름을 가지고 있으면 true를 반환한다.")
    void shouldTrueWhenHaveNameWithSameValue() {
        String nameValue = "name";
        Player player = new Player(nameValue, 0);
        assertThat(player.haveNameOf(nameValue)).isTrue();
    }

    @Test
    @DisplayName("입력받은 값과 같은 이름을 가지고 있지 않으면 false를 반환한다.")
    void shouldFalseWhenHaveNameWithDifferentValue() {
        String differentNameValue = "abcd";
        Player player = new Player("name", 0);
        assertThat(player.haveNameOf(differentNameValue)).isFalse();
    }

    @Test
    @DisplayName("Player가 가지고 있는 결과의 내용을 반환한다.")
    void shouldReturnContentOfResultWhenRequest() {
        Player player = new Player("name", 3);
        player.saveResult(new Result("content"));
        assertThat(player.getContentOfResult()).isEqualTo("content");
    }

    @Test
    @DisplayName("결과가 저장되지 않은 Player의 결과 내용을 요청하면 예외가 발생한다.")
    void shou() {
        Player player = new Player("name", 3);
        assertThatThrownBy(player::getContentOfResult)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("플레이어의 결과가 존재하지 않습니다.");
    }
}

