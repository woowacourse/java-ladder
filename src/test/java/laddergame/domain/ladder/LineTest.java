package laddergame.domain.ladder;

import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    private static final int DEFAULT_RUNG_COUNT = 1;

    private BooleanGenerator rungBooleanGenerator;

    @BeforeEach
    void init() {
        rungBooleanGenerator = new RandomBooleanGenerator();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("rungCount와 numberGenerator를 입력하면, 객체가 생성되는지 확인한다.")
    void succeeds_creation_if_rung_count_and_number_generator_are_entered(int rungCount) {
        assertThat(Line.create(rungCount, rungBooleanGenerator))
                .isInstanceOf(Line.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6})
    @DisplayName("객체의 사이즈가 rungCount와 같은지 확인한다.")
    void is_same_size_as_rung_count(int participantCount) {
        // when
        Line line = Line.create(participantCount, rungBooleanGenerator);
        List<Rung> specificRungs = line.getRungs();

        // then
        assertThat(specificRungs.size()).isEqualTo(participantCount - DEFAULT_RUNG_COUNT);
    }

    @ParameterizedTest
    @MethodSource("getTestRungsWithBooleanGenerator")
    @DisplayName("객체의 형태가 BooleanGenerator에 따라 달라지는지 확인한다.")
    void creates_various_rungs_according_to_boolean_generator(int participantCount, BooleanGenerator booleanGenerator, List<Rung> expectedRungs) {
        // given
        Line line = Line.create(participantCount, booleanGenerator);

        // when
        List<Rung> actualRungs = line.getRungs();

        // then
        assertThat(actualRungs).isEqualTo(expectedRungs);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("사다리 가로대 존재 여부를 반환하는지 확인한다.")
    void returns_true_if_rung_exists_input_index(int inputIndex) {
        int participantCount = 6;
        Line line = Line.create(participantCount, rungBooleanGenerator);
        List<Rung> rungs = line.getRungs();
        Rung rung = rungs.get(inputIndex);

        assertThat(line.hasRung(inputIndex)).isEqualTo(rung.exists());
    }

    private static Stream<Arguments> getTestRungsWithBooleanGenerator() {
        final BooleanGenerator sufficientMaterialGenerator = () -> true;
        final BooleanGenerator insufficientMaterialGenerator = () -> false;
        final boolean canMakeRung = true;
        final boolean canNotMakeRung = !canMakeRung;
        return Stream.of(
                Arguments.arguments(2, sufficientMaterialGenerator, List.of(Rung.create(canMakeRung))),
                Arguments.arguments(3, sufficientMaterialGenerator, List.of(Rung.create(canMakeRung), Rung.create(canNotMakeRung))),
                Arguments.arguments(4, sufficientMaterialGenerator, List.of(Rung.create(canMakeRung), Rung.create(canNotMakeRung), Rung.create(canMakeRung))),
                Arguments.arguments(5, sufficientMaterialGenerator, List.of(Rung.create(canMakeRung), Rung.create(canNotMakeRung), Rung.create(canMakeRung), Rung.create(canNotMakeRung))),
                Arguments.arguments(2, insufficientMaterialGenerator, List.of(Rung.create(canNotMakeRung))),
                Arguments.arguments(3, insufficientMaterialGenerator, List.of(Rung.create(canNotMakeRung), Rung.create(canNotMakeRung))),
                Arguments.arguments(4, insufficientMaterialGenerator, List.of(Rung.create(canNotMakeRung), Rung.create(canNotMakeRung), Rung.create(canNotMakeRung))),
                Arguments.arguments(5, insufficientMaterialGenerator, List.of(Rung.create(canNotMakeRung), Rung.create(canNotMakeRung), Rung.create(canNotMakeRung), Rung.create(canNotMakeRung)))
        );
    }
}
