package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ItemNameTest {

    @ParameterizedTest(name = "이름이 NULL, 빈값, 6자 이상인 경우 예외를 던진다. 입력값: \"{0}\"")
    @NullAndEmptySource
    @ValueSource(strings = {"우아한상품들"})
    void 이름이_NULL_빈값_6자_이상인_경우_예외를_던진다(final String name) {
        assertThatThrownBy(() -> new ItemName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과명은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    void 실행결과는_이름을_가진다() {
        final ItemName name = new ItemName("name");

        assertThat(name.getValue()).isEqualTo("name");
    }
}
