package laddergame.domain.ladder;

import laddergame.domain.exception.RangeException;
import laddergame.domain.exception.TypeException;
import laddergame.domain.rung.RungGenerator;
import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LadderTest {

    private int participantCount;
    private BooleanGenerator rungGenerator;

    @BeforeAll
    void init() {
        participantCount = 4;
        rungGenerator = new RungGenerator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10000"})
    @DisplayName("1 이상의 정수 범위의 사다리 높이가 들어오면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final String validHeight) {
        // when & then
        assertThatCode(() -> Ladder.create(validHeight, participantCount, rungGenerator))
                .doesNotThrowAnyException();

        assertThat(Ladder.create(validHeight, participantCount, rungGenerator))
                .isInstanceOf(Ladder.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "23fgie", "@#$%$"})
    @DisplayName("정수 값이 아닌 사다리 높이가 들어오면, 예외가 발생한다.")
    void create_givenInvalidTypeLadderHeight_thenFail(final String invalidHeight) {
        // when & then
        assertThatThrownBy(() -> Ladder.create(invalidHeight, participantCount, rungGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(TypeException.class)
                .hasMessage(TypeException.errorMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10001"})
    @DisplayName("1~10000 범위를 벗어난 사다리 높이가 입력되면, 예외가 발생한다.")
    void create_givenInvalidRangeLadderHeight_thenFail(final String invalidHeight) {
        // when & then
        assertThatThrownBy(() -> Ladder.create(invalidHeight, participantCount, rungGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .isExactlyInstanceOf(RangeException.class)
                .hasMessage(String.format(RangeException.errorMessage, 1, 10_000));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    @DisplayName("참여자의 순서대로 사다리 게임을 진행하면, 최종 사다리 결과 위치를 반환한다.")
    void start_givenParticipantCount_thenReturnLadderResultPosition(final int participantOrder,
                                                                    final int expectedResultPosition) {
        // given
        final BooleanGenerator trueRungGenerator = () -> true;
        final String ladderHeight = "5";
        Ladder ladder = Ladder.create(ladderHeight, participantCount, trueRungGenerator);

        // when
        int finalRungPosition = ladder.startGame(participantOrder);

        // then
        assertThat(finalRungPosition)
                .isEqualTo(expectedResultPosition);
    }
}
