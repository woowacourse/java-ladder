package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderResultTest {
    @DisplayName("ladderResult를 생성하는 과정에서 오류가 발생하지 않는다.")
    @Test
    void generateLadderResult() {
        Height height = new Height("3");
        Participants participants = new Participants(List.of(
                new Participant("daon"),
                new Participant("ash")
        ));

        Prizes prizes = new Prizes(List.of(
                new Prize("꽝"),
                new Prize("3,000")
        ), participants.getSize());

        Ladder ladder = new Ladder(height, participants.getSize(), new RandomGenerator());

        Assertions.assertThatCode(() -> new LadderResult(participants, prizes, ladder))
                .doesNotThrowAnyException();
    }

    @DisplayName("특정 Participant를 조회했을 때 Prize 값이 반환된다.")
    @Test
    void shouldReturnOnePrize_WhenSearchOneTarget() {
        Participant ash = new Participant("ash");
        Participant daon = new Participant("daon");
        Participants participants = new Participants(List.of(ash, daon));

        Prizes prizes = new Prizes(List.of(
                new Prize("꽝"),
                new Prize("3,000")
        ), participants.getSize());

        Ladder ladder = new Ladder(new Height("3"), participants.getSize(), new RandomGenerator());

        LadderResult ladderResult = new LadderResult(participants, prizes, ladder);

        Assertions.assertThat(ladderResult.searchOne(ash)).isInstanceOf(Prize.class);
    }

    @DisplayName("participants와 크기가 똑같은 게임 결과가 반환된다.")
    @Test
    void shouldReturnExactSizeOfGameParticipants_WhenSearchAll() {
        List<Participant> participants = List.of(
                new Participant("daon"),
                new Participant("ash")
        );

        Prizes prizes = new Prizes(List.of(
                new Prize("꽝"),
                new Prize("3,000")
        ), participants.size());

        Ladder ladder = new Ladder(new Height("3"), participants.size(), new RandomGenerator());

        LadderResult ladderResult = new LadderResult(new Participants(participants), prizes, ladder);

        Assertions.assertThat(ladderResult.getEntireResult().size()).isEqualTo(participants.size());
    }
}
