package laddergame.domain.rung;

import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RungsTest {

    private int rungCount;
    private int rungPosition;
    private BooleanGenerator rungGenerator;

    @BeforeAll
    void init() {
        rungCount = 4;
        rungPosition = 0;
        rungGenerator = new RungGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Rungs 객체가 정상적으로 생성된다면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final int rungCount) {
        assertThatCode(() -> Rungs.create(rungCount, rungGenerator))
                .doesNotThrowAnyException();

        assertThat(Rungs.create(rungCount, rungGenerator))
                .isInstanceOf(Rungs.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Rungs의 Rung 리스트의 길이는 rung의 개수와 동일해야 한다.")
    void getRungs_whenGetRungsSize_thenReturnRungCount(final int rungCount) {
        // when
        Rungs rungs = Rungs.create(rungCount, rungGenerator);
        List<Rung> specificRungs = rungs.getRungs();

        // then
        assertThat(specificRungs.size())
                .isEqualTo(rungCount);
    }

    @ParameterizedTest
    @MethodSource("getTestRungsWithNumberGenerator")
    @DisplayName("NumberGenerator의 반환값에 따라, 생성되는 Rungs의 형태가 달라진다.")
    void getRungs_whenCreateWithNumberGenerator_thenReturnRungs(final int rungCount,
                                                              final BooleanGenerator booleanGenerator,
                                                              final List<Rung> expectedRungs) {
        // given
        Rungs rungs = Rungs.create(rungCount, booleanGenerator);

        // when
        List<Rung> actualRungs = rungs.getRungs();

        // then
        assertThat(actualRungs).isEqualTo(expectedRungs);
    }

    @Test
    @DisplayName("대상 위치에 사다리 가로대가 존재하면, 다음 행의 다음 가로대로 이동이 가능하다.")
    void canMoveDown_whenTargetRungExists_thenReturnTrue() {
        // given
        final BooleanGenerator sufficientMaterialGenerator = () -> true;
        Rungs rungs = Rungs.create(rungCount, sufficientMaterialGenerator);

        // when
        boolean canMoveDown = rungs.canMoveNext(rungPosition);

        // then
        assertThat(canMoveDown)
                .isTrue();
    }

    @Test
    @DisplayName("대상 위치에 사다리 가로대가 존재하지 않으면, 다음 행의 다음 가로대로 이동이 불가능하다.")
    void canMoveDown_whenTargetRungExists_thenReturnFalse() {
        // given
        final BooleanGenerator sufficientMaterialGenerator = () -> false;
        Rungs rungs = Rungs.create(rungCount, sufficientMaterialGenerator);

        // when
        boolean canMoveDown = rungs.canMoveNext(rungPosition);

        // then
        assertThat(canMoveDown)
                .isFalse();
    }

    private static Stream<Arguments> getTestRungsWithNumberGenerator() {
        final BooleanGenerator sufficientMaterialGenerator = () -> true;
        final BooleanGenerator insufficientMaterialGenerator = () -> false;

        return Stream.of(
                Arguments.arguments(1, sufficientMaterialGenerator, List.of(Rung.create(true))),
                Arguments.arguments(2, sufficientMaterialGenerator, List.of(Rung.create(true), Rung.create(false))),
                Arguments.arguments(3, sufficientMaterialGenerator, List.of(Rung.create(true), Rung.create(false), Rung.create(true))),
                Arguments.arguments(4, sufficientMaterialGenerator, List.of(Rung.create(true), Rung.create(false), Rung.create(true), Rung.create(false))),
                Arguments.arguments(1, insufficientMaterialGenerator, List.of(Rung.create(false))),
                Arguments.arguments(2, insufficientMaterialGenerator, List.of(Rung.create(false), Rung.create(false))),
                Arguments.arguments(3, insufficientMaterialGenerator, List.of(Rung.create(false), Rung.create(false), Rung.create(false))),
                Arguments.arguments(4, insufficientMaterialGenerator, List.of(Rung.create(false), Rung.create(false), Rung.create(false), Rung.create(false)))
        );
    }
}
