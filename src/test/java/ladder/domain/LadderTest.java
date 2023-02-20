package ladder.domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수보다 작으면 예외가 발생한다.")
    void create_heightMinPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(makeLines(), 12);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("입력된 사다리의 높이가 인원 수의 2배보다 크면 예외가 발생한다.")
    void create_heightMaxPlayersCount() {
        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(makeLines(), 2);
        }).withMessage("[ERROR] 사다리의 높이는 사람 수보다 크거나, 사람 수의 두 배 보다 작아야 합니다.");
    }

    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void create_success() {
        // expect
        assertThatNoException().isThrownBy(() -> {
            new Ladder(makeLines(), 3);
        });
    }

    @Test
    @DisplayName("인덱스로 Line을 찾을 수 있어야 한다.")
    void findLineByIndex_success() {
        // given
        Ladder ladder = createLadder();

        // when
        Line foundLine = ladder.findLineByIndex(2);

        // then
        assertThat(foundLine.getSteps())
                .isEqualTo(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5, 6})
    @DisplayName("인덱스로 Line을 찾을 때 범위를 초과하면 예외가 발생한다.")
    void findLIneByIndex_wrongIndex(int index) {
        // given
        Ladder ladder = createLadder();

        // expect
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladder.findLineByIndex(index))
                .withMessage("[ERROR] 인덱스 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("사다리의 결과가 정확히 나와야 한다.")
    void getLadderIndexResult_success() {
        // given
        Ladder ladder = createLadder();
        // expect
        assertThat(ladder.getLadderIndexResult(0))
                .isEqualTo(2);
        assertThat(ladder.getLadderIndexResult(1))
                .isEqualTo(0);
        assertThat(ladder.getLadderIndexResult(2))
                .isEqualTo(3);
        assertThat(ladder.getLadderIndexResult(3))
                .isEqualTo(1);
    }

    private Ladder createLadder() {
        return new Ladder(List.of(
                new Line(List.of(Step.EXIST, Step.EMPTY, Step.EXIST)),
                new Line(List.of(Step.EMPTY, Step.EMPTY, Step.EMPTY)),
                new Line(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY))
        ), 3);
    }

    private List<Line> makeLines() {
        return IntStream.range(0, 5)
                .mapToObj(value -> new Line(List.of(Step.EMPTY)))
                .collect(toList());
    }
}
