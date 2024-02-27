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
    private Prizes prizes;

    @BeforeEach
    void setUp() {
        participants = new Participants(new ArrayList<>(List.of("aru", "pola", "jazz")));
        prizes = new Prizes(new ArrayList<>(List.of("3000", "꽝", "5000")), 3);
    }

    @DisplayName("사다리 결과와 상품을 매칭해서 게임 결과를 반환한다.")
    @Test
    void generateGameResultTest() {
        Map<Name, String> gameResult = new GameResult(participants, prizes).getGameResult();

        assertAll(
                () -> assertEquals("3000", gameResult.get(new Name("aru"))),
                () -> assertEquals("꽝", gameResult.get(new Name("pola"))),
                () -> assertEquals("5000", gameResult.get(new Name("jazz")))
        );
    }

    @DisplayName("조회하려는 사람 이름이 게임 결과에 존재하지 않을 때 에러를 발생한다.")
    @Test
    void notExistNameInGameResultTest() {
        GameResult gameResult = new GameResult(participants, prizes);
        String nameInput = "loki";

        assertThatThrownBy(() -> gameResult.containsName(nameInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("조회하려는 사람이 존재하지 않습니다.");
    }
}
