package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        assertThatCode(() -> LadderResult.create(ladderResults, participantCount))
                .doesNotThrowAnyException();

        assertThat(LadderResult.create(ladderResults, participantCount))
                .isInstanceOf(LadderResult.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000", "꽝, 5000, 꽝, 3000", " 꽝, 5000, 꽝, 3000 "})
    @DisplayName("사다리의 결과의 수는 참여자 수와 동일해야 한다.")
    void create_givenValidSizeByLadderResult_thenSuccess(final String validLadderResults) {
        // given
        LadderResult ladderResult = LadderResult.create(validLadderResults, participantCount);

        // when
        List<LadderResultName> ladderResultNames = ladderResult.getResultNames();

        // then
        assertThat(ladderResultNames.size())
                .isEqualTo(participantCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "꽝, 5000", "꽝,5000,꽝", "꽝,5000, 3000, 꽝, 2000"})
    @DisplayName("사다리의 결과의 수와 참여자의 수가 일치하지 않으면, 예외가 발생한다.")
    void create_givenInValidSizeByLadderResult_thenFail(final String invalidLadderResults) {
        assertThatThrownBy(() -> LadderResult.create(invalidLadderResults, participantCount))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 사다리 결과의 개수는 4개여야 합니다.");
    }
}
