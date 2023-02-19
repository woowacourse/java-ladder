package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class LadderResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    @DisplayName("참여자의 이름 수만큼 사다리의 결과가 들어오면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final String ladderResults) {
        assertThatCode(() -> LadderResult.create(ladderResults))
                .doesNotThrowAnyException();

        assertThat(LadderResult.create(ladderResults))
                .isInstanceOf(LadderResult.class);
    }
}
