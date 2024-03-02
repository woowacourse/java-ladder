package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    private Participants participants;
    private Prizes sortedPrizes;

    @BeforeEach
    void setUp() {
        participants = new Participants(new ArrayList<>(List.of("aru", "pola", "jazz")));
        sortedPrizes = new Prizes(new ArrayList<>(List.of("3000", "꽝", "5000")), 3);
    }

    @DisplayName("사다리 결과와 상품을 매칭해서 게임 결과를 반환한다.")
    @Test
    void generateGameResultTest() {
        Map<Name, Prize> gameResult = new GameResult(participants, sortedPrizes).getGameResult();

        assertAll(
                () -> assertEquals(new Prize("3000"), gameResult.get(new Name("aru"))),
                () -> assertEquals(new Prize("꽝"), gameResult.get(new Name("pola"))),
                () -> assertEquals(new Prize("5000"), gameResult.get(new Name("jazz")))
        );
    }

    @DisplayName("조회하려는 사람 이름이 게임 결과에 존재하지 않을 때 에러를 발생한다.")
    @Test
    void notExistNameInGameResultTest() {
        GameResult gameResult = new GameResult(participants, sortedPrizes);
        Name nameInput = new Name("loki");

        assertThatThrownBy(() -> gameResult.checkResultContainName(nameInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("조회하려는 참여자가 게임 결과에 존재하지 않습니다.");
    }
}
