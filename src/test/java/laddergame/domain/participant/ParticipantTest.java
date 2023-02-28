package laddergame.domain.participant;

import laddergame.domain.ladder.Ladder;
import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

    private static final BooleanGenerator TRUE_BOOLEAN_GENERATOR = () -> true;
    private static final BooleanGenerator FALSE_BOOLEAN_GENERATOR = () -> false;
    private static final int FIRST_POSITION = 0;
    private static final int SECOND_POSITION = 1;
    private static final String PARTICIPANT_NAME = "후추";
    
    private Ladder ladderWithOneLineAndOneRung;
    private Ladder ladderWithOneLineButNoRung;

    @BeforeEach
    void setUp() {
        final int participantCount = 2;
        final String height = "1";
        ladderWithOneLineAndOneRung = new Ladder(TRUE_BOOLEAN_GENERATOR, height, participantCount); // |-----|
        ladderWithOneLineButNoRung = new Ladder(FALSE_BOOLEAN_GENERATOR, height, participantCount); // |     |
    }

    @Nested
    @DisplayName("사다리 가로대가 있는 사다리가 입력 되었을 때")
    class MoveToDestinationTestWithRung {

        @Test
        @DisplayName("첫 번째 위치에 있던 참여자는 두 번째 위치로 도착한다.")
        void arrives_at_the_second_position_if_participant_was_in_the_first_position() {
            Participant participant = Participant.create(PARTICIPANT_NAME, FIRST_POSITION);

            participant.moveToDestination(ladderWithOneLineAndOneRung);

            assertThat(participant.getParticipantPosition()).isEqualTo(SECOND_POSITION);
        }

        @Test
        @DisplayName("두 번째 위치에 있던 참여자는 첫 번째 위치로 도착한다.")
        void arrives_at_the_first_position_if_participant_was_in_the_second_position() {
            Participant participant = Participant.create(PARTICIPANT_NAME, SECOND_POSITION);

            participant.moveToDestination(ladderWithOneLineAndOneRung);

            assertThat(participant.getParticipantPosition()).isEqualTo(FIRST_POSITION);
        }
    }

    @Nested
    @DisplayName("사다리 가로대가 없는 사다리가 입력 되었을 때")
    class MoveToDestinationTestWithoutRung {

        @ParameterizedTest
        @ValueSource(ints = {FIRST_POSITION, SECOND_POSITION})
        @DisplayName("출발점과 같은 위치에 도착한다")
        void arrives_at_the_same_position_as_the_start(final int position) {
            Participant participant = Participant.create(PARTICIPANT_NAME, position);

            participant.moveToDestination(ladderWithOneLineButNoRung);

            assertThat(participant.getParticipantPosition()).isEqualTo(position);
        }
    }
}
