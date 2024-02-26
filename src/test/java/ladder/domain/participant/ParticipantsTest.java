package ladder.domain.participant;

import ladder.domain.generator.LadderStepGenerator;
import ladder.domain.generator.TestLadderStepGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자들에게 필요한 사다리 너비를 계산한다.")
    void getParticipantsCountTest() {
        // given
        final List<String> names = List.of("mia", "pota", "dora");
        final Participants participants = new Participants(names);

        // when
        final int count = participants.getNecessaryLadderWidth();

        // then
        assertThat(count).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("getInvalidParticipantsNames")
    @DisplayName("참가자 수가 1명 이하일 경우 예외가 발생한다.")
    void checkParticipantsCountTest(final List<String> names) {
        // given & when
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("참가자 수는 2명 이상입니다.");
    }

    static Stream<List<String>> getInvalidParticipantsNames() {
        return Stream.of(List.of("mia"), List.of());
    }

    @Test
    @DisplayName("입력된 순서대로 사다리 위치를 가진 참자들을 생성한다.")
    void createOrderedParticipantsTest() {
        // given
        final List<String> names = List.of("mia", "pota", "dora", "jojo");

        // when
        final Participants participants = new Participants(names);

        // then
        List<Participant> createdParticipants = participants.getValues();
        assertThat(createdParticipants)
                .extracting(Participant::getPosition)
                .containsExactly(0, 1, 2, 3);
    }

    @Test
    @DisplayName("")
    void play() {
        // given
        final List<String> names = List.of("mia", "pota", "dora", "jojo");
        final Participants participants = new Participants(names);

        final int stepWidth = 3;
        final Height height = new Height(3);
        final LadderStepGenerator ladderStepGenerator = new TestLadderStepGenerator();
        final Ladder ladder = new Ladder(height, stepWidth, ladderStepGenerator);

        // when
        participants.playAll(ladder);

        // then
        List<Participant> finishedParticipants = participants.getValues();
        assertThat(finishedParticipants)
                .extracting(Participant::getPosition)
                .containsExactly(1, 0, 3, 2);
    }
}
