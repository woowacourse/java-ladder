package domain;

import domain.LadderGame.LadderGameBuilder;
import dto.LadderGameResult;
import dto.LadderGameResults;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"robin,2등", "phobi,1등"})
    @DisplayName("게임 실행 결과 검증")
    void start(String playerName, String giftName) {
        LadderGame ladderGame = makeTestLadderGame();
        LadderGameResults actualGameResults = ladderGame.start(playerName);
        Assertions.assertThat(actualGameResults)
                .isEqualTo(new LadderGameResults(List.of(new LadderGameResult(playerName, giftName))));
    }

    private LadderGame makeTestLadderGame() {
        return LadderGameBuilder.builder()
                .players("robin", "phobi")
                .gifts("1등", "2등")
                .lineGenerateStrategy(new TestLineGenerateStrategy())
                .ladderHeight(5)
                .build();
    }

    @Test
    @DisplayName("게임 실행 시 없는 참여자 결과 조회 안되는지 검증")
    void validateOperator() {
        LadderGame ladderGame = makeTestLadderGame();
        Assertions.assertThatThrownBy(() -> ladderGame.start("none"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("없는 참가자 입니다.");
    }
}
