package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import laddergame.TestDummy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @DisplayName("사다리 게임은 참여자와 실행결과를 받아 생성된다.")
    @Test
    void createWithParticipantsAndLadderResult() {
        //given
        Participants participants = TestDummy.PARTICIPANTS_SIZE_2;
        LadderResult ladderResult = TestDummy.LADDER_RESULT_SIZE_2;
        //when
        //then
        assertDoesNotThrow(() -> new LadderGame(participants, ladderResult));
    }

}
