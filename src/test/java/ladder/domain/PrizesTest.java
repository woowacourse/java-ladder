package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("실행 결과")
public class PrizesTest {
    @Test
    @DisplayName("문자열 리스트를 통해 보상 리스트를 생성한다")
    public void createTest() {
        // given
        int peopleCount = 4;
        List<String> prizeNames = List.of("   꽝", "5000 ", "  꽝", "3000  ");
        List<String> result = List.of("꽝", "5000", "꽝", "3000");

        // when
        Prizes prize = Prizes.from(prizeNames, 4);

        // then
        assertThat(prize.getNames()).isEqualTo(result);
    }

    @Test
    @DisplayName("사람들의 수와 보상 개수가 다를 경우 예외가 발생한다.")
    public void validateCount() {
        // given
        int peopleCount = 5;
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");

        // when & then
        assertThatThrownBy(() -> Prizes.from(prizes, peopleCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상 개수가 사람의 수와 다릅니다.");
    }
}
