package domain.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"일", "일이삼사오"})
    @DisplayName("5글자 이내의 상은 예외를 던지지 않는가")
    void normal_prize_doesnt_throws_exception(String name) {
        assertThatCode(() -> new Prize(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("1 미만, 5 초과하는 상 이름은 예외를 던지는가")
    void prize_name_exceed_five_throws_exception(String name) {
        assertThatThrownBy(() -> new Prize(name))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
