package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @ParameterizedTest(name = "이름이 길이가 안맞아 {0}이면 예외 던지기")
    @ValueSource(strings = {"aaaaaa", "", "1234567"})
    public void 생성_fail_길이(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름 길이는 1이상 5이하여야합니다.");
    }

    @ParameterizedTest(name = "이름이 공백으로만 이루어져있는 {0}이면 예외 던지기")
    @ValueSource(strings = {"    ", " "})
    public void 생성_fail_공백(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름은 공백으로만 이루어질 수 없습니다.");
    }

    @ParameterizedTest(name = "이름이 금지어이면 예외 던지기")
    @ValueSource(strings = {"end", "all"})
    public void 생성_fail_금지어(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "이름이 {0}이면 정상 생성")
    @ValueSource(strings = {"abc", "에밀과홍고", "에"})
    public void 생성_success(String name) {
        assertThatNoException().isThrownBy(() -> new Name(name));
    }
}
