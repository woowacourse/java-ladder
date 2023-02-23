package laddergame.domain.ladder.result;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    void create_thenSuccess(final String ladderResultNames) {
        assertThatCode(() -> LadderResult.create(ladderResultNames, participantCount))
                .doesNotThrowAnyException();

        assertThat(LadderResult.create(ladderResultNames, participantCount))
                .isInstanceOf(LadderResult.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000", "꽝, 5000, 꽝, 3000", " 꽝, 5000, 꽝, 3000 "})
    @DisplayName("사다리의 결과의 수는 참여자 수와 동일해야 한다.")
    void create_givenValidSizeByLadderResult_thenSuccess(final String validLadderResultNames) {
        // given
        LadderResult ladderResult = LadderResult.create(validLadderResultNames, participantCount);

        // when
        List<LadderResultName> ladderResultNameNames = ladderResult.getResultNames();

        // then
        assertThat(ladderResultNameNames.size())
                .isEqualTo(participantCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "꽝, 5000", "꽝,5000,꽝", "꽝,5000, 3000, 꽝, 2000"})
    @DisplayName("사다리의 결과의 수와 참여자의 수가 일치하지 않으면, 예외가 발생한다.")
    void create_givenInValidSizeByLadderResult_thenFail(final String invalidLadderResultNames) {
        assertThatThrownBy(() -> LadderResult.create(invalidLadderResultNames, participantCount))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 사다리 결과의 개수는 4개여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:50000", "0:1000", "3:2000", "2:꽝"}, delimiter = ':')
    @DisplayName("사다리 게임 실행 후 최종 결과 위치를 입력받으면, 해당 위치에 존재하는 사다리 결과 이름을 반환한다.")
    void getNameByParticipant_givenParticipantOrder_thenReturnLadderResultName(final int actualFinalPosition,
                                                                               final String expectedResultName) {
        // given
        final String ladderResultNames = "1000,50000,꽝,2000";
        LadderResult ladderResult = LadderResult.create(ladderResultNames, participantCount);

        // when
        String actualResultName = ladderResult.getNameByPosition(actualFinalPosition);

        // then
        assertThat(actualResultName)
                .isEqualTo(expectedResultName);
    }
}
