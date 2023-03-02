package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @DisplayName("알맞은 결과를 입력하면 정상적으로 생성된다.")
    @Test
    void create_success() {
        assertDoesNotThrow(() -> new Result("꽝"));
    }

    @ParameterizedTest(name = "길이 조건에 맞지 안흔 결과를 입력하면 예외가 발생한다.")
    @ValueSource(strings = {"너무긴결과임", ""})
    void create_fail_with_wrong_length_name(String result) {
        assertThatThrownBy(() -> new Result(result))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과의 길이는 1자 이상, 5자 이하 입니다.");
    }

}
