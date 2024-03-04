package laddergame.model.laddergame;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import laddergame.exception.BaseException;
import laddergame.model.generator.LineConnectionDecisionGenerator;
import laddergame.model.participants.Participant;
import laddergame.model.participants.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderGameGeneratorTest {

    private LadderHeight ladderHeight;
    private Participants participants;

    @BeforeEach
    void setUp() {
        ladderHeight = new LadderHeight(3);
        participants = Stream.of("daon", "mason", "jk", "ted")
                .map(Participant::new)
                .collect(collectingAndThen(toList(), Participants::new));
    }

    @DisplayName("크기가 제각각 다른 불린 리스트는 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("createDoublyBooleansAllDiffSize")
    void validateBooleans(LineConnectionDecisionGenerator given) {
        //when //then
        assertThatThrownBy(() -> new LadderGameGenerator(ladderHeight, participants, given))
                .isInstanceOf(BaseException.class);
    }

    private static Stream<Arguments> createDoublyBooleansAllDiffSize() {
        return Stream.of(
                Arguments.arguments(
                        (LineConnectionDecisionGenerator) (ladderHeight, participants) -> List.of(
                                List.of(
                                        new LineConnectionDecision(true),
                                        new LineConnectionDecision(false)
                                ),
                                List.of(
                                        new LineConnectionDecision(true),
                                        new LineConnectionDecision(true),
                                        new LineConnectionDecision(true)
                                )
                        )
                ),
                Arguments.arguments(
                        (LineConnectionDecisionGenerator) (ladderHeight, participants) -> List.of(
                                List.of(
                                        new LineConnectionDecision(true),
                                        new LineConnectionDecision(true)
                                ),
                                List.of(
                                        new LineConnectionDecision(false),
                                        new LineConnectionDecision(false),
                                        new LineConnectionDecision(false)
                                ),
                                List.of(
                                        new LineConnectionDecision(false),
                                        new LineConnectionDecision(true),
                                        new LineConnectionDecision(false),
                                        new LineConnectionDecision(true)
                                )
                        )
                ),
                Arguments.arguments(
                        (LineConnectionDecisionGenerator) (ladderHeight, participants) -> List.of(
                                List.of(
                                        new LineConnectionDecision(false),
                                        new LineConnectionDecision(false),
                                        new LineConnectionDecision(false)
                                ),
                                List.of(
                                        new LineConnectionDecision(true),
                                        new LineConnectionDecision(true)
                                ),
                                List.of(
                                        new LineConnectionDecision(false),
                                        new LineConnectionDecision(false)
                                )
                        )
                )
        );
    }
}
