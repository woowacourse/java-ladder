package laddergame.domain.ladder;

import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Nested
    @DisplayName("사다리 객체 생성 시")
    class creationTest {

        private BooleanGenerator booleanGenerator;

        @BeforeEach
        void setUp() {
            booleanGenerator = new RandomBooleanGenerator();
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3", "4", "5"})
        @DisplayName("입력받은 사다리 높이와 실제 사다리 크기가 같은지 확인한다")
        void is_same_size_as_height_number(final String height) {
            //given
            final int heightNumber = Integer.parseInt(height);
            final int participantCount = 5;
            Ladder ladder = new Ladder(booleanGenerator, height, participantCount);

            //when
            int actualSize = getLadderSize(ladder);

            //then
            assertThat(actualSize).isEqualTo(heightNumber);
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, 5, 6})
        @DisplayName("사다리의 가로 길이가 참가자 수보다 1 작은지 확인한다")
        void is_one_less_line_size_than_the_number_of_participants(final int participantCount) {
            //given
            final String height = "5";
            Ladder ladder = new Ladder(booleanGenerator, height, participantCount);

            //when
            int actualSize = getLadderLineSize(ladder);

            //then
            assertThat(actualSize).isEqualTo(participantCount - 1);
        }

        private int getLadderSize(final Ladder ladder) {
            List<Line> lines = ladder.getLines();
            return lines.size();
        }

        private int getLadderLineSize(final Ladder ladder) {
            List<Line> lines = ladder.getLines();
            Line line = lines.get(0);
            List<Rung> rungs = line.getRungs();
            return rungs.size();
        }
    }

    private Ladder ladderWithSameStartAndEndPosition;
    private Participants participants;

    @BeforeEach
    void setUp() {
        ladderWithSameStartAndEndPosition = new Ladder(() -> true, "2", 4);
        participants = Participants.create("1st,2nd,3rd,4th");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("참여자를 입력하면, 도착지로 이동시키는지 확인한다.")
    void moves_participant_test(int startPosition) {
        Participant participant = participants.getParticipants().get(startPosition);

        ladderWithSameStartAndEndPosition.moveToDestination(participant);
        int endPosition = participant.getParticipantPosition();

        assertThat(endPosition).isEqualTo(startPosition);
    }
}
