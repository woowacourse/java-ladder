package laddergame.model.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LadderGameGeneratorTest {

    @DisplayName("null, 빈 리스트, 크기가 제각각 다른 불린 리스트는 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("createDoublyBooleansAllDiffSize")
    void validateBooleans(List<List<Boolean>> given) {
        //when //then
        assertThatThrownBy(() -> new LadderGameGenerator(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LadderGame을 생성하면 이중리스트 크기와 선의 개수가 동일하다.")
    @ParameterizedTest
    @MethodSource("createDoublyBooleansAllSameSize")
    void getLadderGame(List<List<Boolean>> given) {
        //when
        LadderGameGenerator generator = new LadderGameGenerator(given);
        LadderGame ladderGame = generator.getLadderGame();
        //then
        assertThat(ladderGame.getLines()).hasSize(given.size());
    }

    private static Stream<Arguments> createDoublyBooleansAllDiffSize() {
        return Stream.of(
                Arguments.arguments(List.of(
                        List.of(true, false),
                        List.of(true, false, true)
                )),
                Arguments.arguments(List.of(
                        List.of(true, false),
                        List.of(true, false, true),
                        List.of(true, false, true, false)
                )),
                Arguments.arguments(List.of(
                        List.of(true, false, true),
                        List.of(true, false, true),
                        List.of(true, false)
                ))
        );
    }

    private static Stream<Arguments> createDoublyBooleansAllSameSize() {
        return Stream.of(
                Arguments.arguments(List.of(
                        List.of(true, false, true),
                        List.of(true, false, true)
                )),
                Arguments.arguments(List.of(
                        List.of(true, false, false, true),
                        List.of(true, false, true, false),
                        List.of(true, false, true, false)
                )),
                Arguments.arguments(List.of(
                        List.of(true, false, true),
                        List.of(true, false, true),
                        List.of(true, false, false),
                        List.of(true, true, false),
                        List.of(true, false, true)
                ))
        );
    }
}
