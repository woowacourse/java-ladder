package domain;

import domain.LadderGame.LadderGameBuilder;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"robin,2등", "phobi,1등"})
    @DisplayName("게임 실행 결과 검증")
    void start(String playerName, String giftName) {
        LadderGame ladderGame = LadderGameBuilder.builder()
                .players("robin", "phobi")
                .gifts("1등", "2등")
                .ladderMakeStrategy(() -> new Boolean[]{true, false})
                .ladderHeight(5)
                .build();
        LadderGameResults actualGameResults = ladderGame.start(playerName);
        Assertions.assertThat(actualGameResults)
                .isEqualTo(new LadderGameResults(List.of(new LadderGameResult(playerName, giftName))));
    }
}
