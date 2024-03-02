package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("이름 도메인 테스트")
class PlayerNameTest {

    @DisplayName("이름의 길이가 1자에서 5자 사이가 아니면 생성 검증에 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void testCreateNameWithInvalidLength(String name) {
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름의 길이는 1자에서 5자 사이여야 합니다");
    }

    @DisplayName("검증 조건을 통과하면 생성에 성공한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void testCreateWithValidLength(String name) {
        assertThatCode(() -> new PlayerName(name)).doesNotThrowAnyException();
    }

    @DisplayName("이름이 특수 예약어가 아닌 경우를 확인할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void testCheckSpecialKeyword(String name) {
        assertThat(new PlayerName(name).isNotSpecialKeyWord()).isTrue();
    }
}
