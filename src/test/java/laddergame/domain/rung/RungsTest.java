package laddergame.domain.rung;

import laddergame.util.NumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
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

    private NumberGenerator rungNumberGenerator;

    @BeforeAll
    void init() {
        rungNumberGenerator = new RungNumberGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Rungs 객체가 정상적으로 생성된다면, 예외가 발생하지 않는다.")
    void create_thenSuccess(final int rungCount) {
        assertThatCode(() -> Rungs.create(rungCount, rungNumberGenerator))
                .doesNotThrowAnyException();

        assertThat(Rungs.create(rungCount, rungNumberGenerator))
                .isInstanceOf(Rungs.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Rungs의 Rung 리스트의 길이는 rung의 개수와 동일해야 한다.")
    void getRungs_whenGetRungsSize_thenReturnRungCount(final int rungCount) {
        // when
        Rungs rungs = Rungs.create(rungCount, rungNumberGenerator);
        List<Rung> specificRungs = rungs.getRungs();

        // then
        assertThat(specificRungs.size())
                .isEqualTo(rungCount);
    }

    @ParameterizedTest
    @MethodSource("getTestRungsWithNumberGenerator")
    @DisplayName("NumberGenerator의 반환값에 따라, 생성되는 Rungs의 형태가 달라진다.")
    void getRungs_whenCreateWithNumberGenerator_thenReturnRungs(final int rungCount,
                                                              final NumberGenerator numberGenerator,
                                                              final List<Rung> expectedRungs) {
        // given
        Rungs rungs = Rungs.create(rungCount, numberGenerator);

        // when
        List<Rung> actualRungs = rungs.getRungs();

        // then
        assertThat(actualRungs).isEqualTo(expectedRungs);
    }

    private static Stream<Arguments> getTestRungsWithNumberGenerator() {
        final NumberGenerator sufficientMaterialGenerator = () -> 1;
        final NumberGenerator insufficientMaterialGenerator = () -> 0;

        return Stream.of(
                Arguments.arguments(1, sufficientMaterialGenerator, List.of(Rung.create(1))),
                Arguments.arguments(2, sufficientMaterialGenerator, List.of(Rung.create(1), Rung.create(0))),
                Arguments.arguments(3, sufficientMaterialGenerator, List.of(Rung.create(1), Rung.create(0), Rung.create(1))),
                Arguments.arguments(4, sufficientMaterialGenerator, List.of(Rung.create(1), Rung.create(0), Rung.create(1), Rung.create(0))),
                Arguments.arguments(1, insufficientMaterialGenerator, List.of(Rung.create(0))),
                Arguments.arguments(2, insufficientMaterialGenerator, List.of(Rung.create(0), Rung.create(0))),
                Arguments.arguments(3, insufficientMaterialGenerator, List.of(Rung.create(0), Rung.create(0), Rung.create(0))),
                Arguments.arguments(4, insufficientMaterialGenerator, List.of(Rung.create(0), Rung.create(0), Rung.create(0), Rung.create(0)))
        );
    }
}
