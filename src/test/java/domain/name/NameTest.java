package domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("이름 도메인 테스트")
class NameTest {

    @DisplayName("이름의 길이가 1자에서 5자 사이가 아니면 생성 검증에 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void testCreateNameWithInvalidLength(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름의 길이는 1자에서 5자 사이여야 합니다");
    }

    @DisplayName("이름의 길이가 1자에서 5자 사이이면 생성 검증에 통과한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void testCreateWithValidLength(String name) {
        assertThatCode(() -> new Name(name)).doesNotThrowAnyException();
    }
}
