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

public class RungsTest {

    private NumberGenerator rungNumberGenerator;

    @BeforeEach
    void init() {
        rungNumberGenerator = new RungNumberGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("rungCount와 numberGenerator를 입력하면, Rungs 객체가 생성되는지 확인한다.")
    void succeeds_creation_if_rung_count_and_number_generator_are_entered(int rungCount) {
        assertThat(Rungs.create(rungCount, rungNumberGenerator))
                .isInstanceOf(Rungs.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Rungs 객체의 사이즈가 rungCount와 같은지 확인한다.")
    void is_same_size_as_rung_count(int rungCount) {
        // when
        Rungs rungs = Rungs.create(rungCount, rungNumberGenerator);
        List<Rung> specificRungs = rungs.getRungs();

        // then
        assertThat(specificRungs.size()).isEqualTo(rungCount);
    }

    @ParameterizedTest
    @MethodSource("getTestRungsWithNumberGenerator")
    @DisplayName("Rungs의 형태가 NumberGenerator에 따라 달라지는지 확인한다.")
    void creates_various_rungs_according_to_number_generator(int rungCount, NumberGenerator numberGenerator, List<Rung> expectedRungs) {
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
