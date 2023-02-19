package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LadderResultTest {

    private int participantCount;

    @BeforeAll
    void init() {
        participantCount = 4;
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    @DisplayName("참여자의 이름 수만큼 사다리의 결과가 들어오면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final String ladderResults) {
        assertThatCode(() -> LadderResult.create(ladderResults))
                .doesNotThrowAnyException();

        assertThat(LadderResult.create(ladderResults))
                .isInstanceOf(LadderResult.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000", "꽝, 5000, 꽝, 3000", " 꽝, 5000, 꽝, 3000 "})
    @DisplayName("사다리의 결과의 수는, 참여자의 수와 동일해야 한다.")
    void create_givenValidSizeByLadderResult_thenSuccess(final String validLadderResults) {
        // given
        LadderResult ladderResult = LadderResult.create(validLadderResults);

        // when
        List<String> ladderResults = ladderResult.getResults();

        // then
        assertThat(ladderResults.size())
                .isEqualTo(participantCount);
    }
}
