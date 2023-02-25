package laddergame.domain.participant;

import laddergame.domain.ladder.Line;
import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

    private static final int MOVING_UNIT = 1;
    private static final BooleanGenerator TRUE_BOOLEAN_GENERATOR = () -> true;
    private static final BooleanGenerator FALSE_BOOLEAN_GENERATOR = () -> false;

    private String participantName;
    private Line lineWithRung;
    private Line lineWithoutRung;

    @BeforeEach
    void setUp() {
        participantName = "poby";
        final int rungCount = 1;
        lineWithRung = Line.create(rungCount, TRUE_BOOLEAN_GENERATOR); // |-----|
        lineWithoutRung = Line.create(rungCount, FALSE_BOOLEAN_GENERATOR); // |     |
    }

    @Nested
    @DisplayName("사다리 가로대가 존재할 때")
    class MoveTestWithRung {

        @Test
        @DisplayName("오른쪽으로 움직이면 참여자의 위치 1 증가한다.")
        void increases_by_1_if_participant_moves_to_the_right() {
            final int basePosition = 0;
            Participant participant = Participant.create(participantName, basePosition);

            participant.move(lineWithRung);

            assertThat(participant.getParticipantPosition()).isEqualTo(basePosition + MOVING_UNIT);
        }

        @Test
        @DisplayName("왼쪽으로 움직이면 참여자의 위치 1 감소한다.")
        void decreases_by_1_if_participant_moves_to_the_left() {
            final int basePosition = 1;
            Participant participant = Participant.create(participantName, basePosition);

            participant.move(lineWithRung);

            assertThat(participant.getParticipantPosition()).isEqualTo(basePosition - MOVING_UNIT);
        }
    }

    @Nested
    @DisplayName("사다리 가로대가 존재하지 않을 때")
    class MoveTestWithoutRung {

        @Test
        @DisplayName("오른쪽으로 움직이면 참여자의 위치는 증가하지 않는다")
        void does_not_increase_if_participant_moves_to_the_right() {
            final int basePosition = 0;
            Participant participant = Participant.create(participantName, basePosition);

            participant.move(lineWithoutRung);

            assertThat(participant.getParticipantPosition()).isEqualTo(basePosition);
        }

        @Test
        @DisplayName("왼쪽으로 움직이면 참여자의 위치 1 감소한다.")
        void does_not_decrease_if_participant_moves_to_the_left() {
            final int basePosition = 1;
            Participant participant = Participant.create(participantName, basePosition);

            participant.move(lineWithoutRung);

            assertThat(participant.getParticipantPosition()).isEqualTo(basePosition);
        }
    }
}
