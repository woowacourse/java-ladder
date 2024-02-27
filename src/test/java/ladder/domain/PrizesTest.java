package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("실행 결과")
public class PrizesTest {
    @Test
    @DisplayName("문자열 리스트를 통해 보상 리스트를 생성한다")
    public void createTest() {
        // given
        int peopleCount = 4;
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");

        // when & then
        assertThatCode(() -> Prizes.from(prizes, 4))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사람들의 수와 보상 개수가 다를 경우 예외가 발생한다.")
    public void validateCount() {
        // given
        int peopleCount = 5;
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");

        // when & then
        assertThatThrownBy(() -> Prizes.from(prizes, 4))
                .isInstanceOf(IllegalAccessError.class)
                .hasMessageContaining("보상 개수가 사람의 수와 다릅니다.");
    }
}
