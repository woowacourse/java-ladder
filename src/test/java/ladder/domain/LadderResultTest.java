package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.ResultStepLadderDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderResultTest {

    private Participants participants;
    private GamePrizes gamePrize;
    private Carpenter carpenter;

    @BeforeEach
    void setUp() {
        participants = new Participants(new ArrayList<>(List.of("aru", "pola", "jazz")));
        carpenter = new Carpenter(new Height("5"), participants.getParticipantsCount(), new Energy(() -> 6));

        gamePrize = new GamePrizes(new ArrayList<>(List.of("꽝", "5000", "꽝")));
    }

    @DisplayName("해당하는 position의 상품 position을 return 하는지 확인")
    @Test
    void notParticipant() {
        ResultStepLadderDto resultStepLadderDto = carpenter.getResultLadders2();
        carpenter.buildLadders(participants.getParticipantsCount());
        LadderResult ladderMap = new LadderResult(resultStepLadderDto, participants.getParticipantsCount());
        Integer prizePosition = ladderMap.getEndPosition(0);

        Assertions.assertThat(prizePosition).isEqualTo(1);
    }
}
