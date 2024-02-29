package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.carpenter.Carpenter;
import ladder.domain.carpenter.Energy;
import ladder.domain.dto.MadeLadderDto;
import ladder.domain.ladder.Height;
import ladder.domain.ladderGame.LadderResult;
import ladder.domain.participant.Participants;
import ladder.domain.prize.GamePrizes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineResultTest {

    private Participants participants;
    private GamePrizes gamePrize;
    private Carpenter carpenter;

    @BeforeEach
    void setUp() {
        participants = new Participants(new ArrayList<>(List.of("aru", "pola", "jazz")));
        carpenter = new Carpenter(new Height("5"), participants.size(), new Energy(() -> 6));

        gamePrize = new GamePrizes(new ArrayList<>(List.of("꽝", "5000", "꽝")), 3);
    }

    @DisplayName("해당하는 position의 상품 position을 return 하는지 확인")
    @Test
    void notParticipant() {
        MadeLadderDto resultStepLadderDto = carpenter.getResultLadders();
        carpenter.buildLadders(participants.size());
        LadderResult ladderMap = new LadderResult(resultStepLadderDto, participants.size());
        Integer prizePosition = ladderMap.getEndPosition(0);

        Assertions.assertThat(prizePosition).isEqualTo(1);
    }
}
