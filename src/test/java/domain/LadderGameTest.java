package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    private static final String VALID_NAMES = "a,b,c";
    private static final String VALID_LADDER_RESULTS = "당첨,꽝,당첨";
    private static final int VALID_HEIGHT = 5;
    private static final RowGenerator VALID_GENERATOR = new RowGenerator(() -> Bridge.EXIST);
    
    @Test
    @DisplayName("적절한 참여자 이름과, 높이로 생성하면 예외가 발생하지 않음")
    void testCreateLadderGame() {
        Assertions.assertThatCode(
                        () -> new LadderGame(VALID_NAMES, VALID_LADDER_RESULTS, VALID_HEIGHT, VALID_GENERATOR))
                .doesNotThrowAnyException();
    }


    @Test
    @DisplayName("사다리 게임 계산")
    void testCalculateLadderGameResult() {
        LadderGame ladderGame = new LadderGame(VALID_NAMES, VALID_LADDER_RESULTS, VALID_HEIGHT, VALID_GENERATOR);
        LadderGameResult ladderGameResult = ladderGame.play();
        String actual = ladderGameResult.getLadderResultFromName(new Name("a")).getLadderResult();
        String expected = "꽝";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}