package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ResultsTest {

    @Test
    @DisplayName("입력된 결과의 수가 인원 수와 다르면 IllegalArgumentException 예외가 발생한다.")
    void create_mismatchWithPlayerCount() {
        // given
        List<String> inputResult = List.of("꽝", "꽝", "5,000", "3,000");
        int playerCount = 3;

        // expect
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Results(inputResult, playerCount)
        ).withMessage("[ERROR] 입력된 결과의 수가 인원 수와 다를 수 없습니다.");
    }

    @Test
    @DisplayName("입력된 결과가 정상적으로 생성된다.")
    void create_success() {
        // given
        List<String> inputResult = List.of("O", "X", "X", "X");
        int playerCount = 4;

        // expect
        assertThatNoException().isThrownBy(() ->
                new Results(inputResult, playerCount)
        );
    }
}
