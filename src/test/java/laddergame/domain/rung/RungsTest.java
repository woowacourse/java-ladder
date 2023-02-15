package laddergame.domain.rung;

import laddergame.util.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RungsTest {

    private NumberGenerator rungNumberGenerator;

    @BeforeEach
    void init() {
        rungNumberGenerator = new RungNumberGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Rungs 객체가 정상적으로 생성되는지 테스트한다.")
    void create_test(int rungCount) {
        assertDoesNotThrow(() -> new Rungs(rungCount, rungNumberGenerator));

        assertThat(new Rungs(rungCount, rungNumberGenerator))
                .isInstanceOf(Rungs.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Rungs 객체 내부의 리스트의 길이가 rungCount와 같은지 확인한다.")
    void create_rung_size_test(int rungCount) {
        // when
        Rungs rungs = new Rungs(rungCount, rungNumberGenerator);
        List<Rung> specificRungs = rungs.getRungs();

        // then
        assertThat(specificRungs.size())
                .isEqualTo(rungCount);
    }

    @ParameterizedTest
    @MethodSource("getTestRungsWithNumberGenerator")
    @DisplayName("NumberGenerator에 따라 Rungs의 형태가 달라지는지 확인한다.")
    void create_rungs_test_by_number_generator(int rungCount, NumberGenerator numberGenerator, List<Rung> expectedRungs) {
        // given
        Rungs rungs = new Rungs(rungCount, numberGenerator);

        // when
        List<Rung> actualRungs = rungs.getRungs();

        // then
        assertThat(actualRungs).isEqualTo(expectedRungs);
    }

    private static Stream<Arguments> getTestRungsWithNumberGenerator() {
        final NumberGenerator sufficientMaterialGenerator = () -> 1;
        final NumberGenerator insufficientMaterialGenerator = () -> 0;

        return Stream.of(
                Arguments.arguments(1, sufficientMaterialGenerator, List.of(new Rung(1))),
                Arguments.arguments(2, sufficientMaterialGenerator, List.of(new Rung(1), new Rung(0))),
                Arguments.arguments(3, sufficientMaterialGenerator, List.of(new Rung(1), new Rung(0), new Rung(1))),
                Arguments.arguments(4, sufficientMaterialGenerator, List.of(new Rung(1), new Rung(0), new Rung(1), new Rung(0))),
                Arguments.arguments(1, insufficientMaterialGenerator, List.of(new Rung(0))),
                Arguments.arguments(2, insufficientMaterialGenerator, List.of(new Rung(0), new Rung(0))),
                Arguments.arguments(3, insufficientMaterialGenerator, List.of(new Rung(0), new Rung(0), new Rung(0))),
                Arguments.arguments(4, insufficientMaterialGenerator, List.of(new Rung(0), new Rung(0), new Rung(0), new Rung(0)))
        );
    }
}
