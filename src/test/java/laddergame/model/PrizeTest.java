package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 내용 테스트")
class PrizeTest {
    @Test
    @DisplayName("앞 뒤의 공백이 있는 문자열이 입력되면 공백 제거")
    void Should_Trim_When_FrontAndBackBlank() {
        assertThat(new Prize(" 1000 ").getPrize()).isEqualTo("1000");
    }

}
