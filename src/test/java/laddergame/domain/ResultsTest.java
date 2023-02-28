package laddergame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 게임의 결과 목록은 ")
class ResultsTest {

    @DisplayName("유저 목록의 크기와 같다.")
    @Test
    public void gameResult_success() {
        List<GameResult> results = new ArrayList<>(List.of(
                new GameResult("꽝")
                , new GameResult("3000원")
                , new GameResult("5000원")
        ));
        int userCount = 3;

        assertDoesNotThrow(() -> {
            new Results(results, userCount);
        });
    }

    @DisplayName("유저 목록의 크기와 같지 않으면 예외가 발생한다.")
    @Test
    public void gameResult_fail() {
        List<GameResult> results = new ArrayList<>(List.of(
                new GameResult("꽝")
                , new GameResult("3000원")
                , new GameResult("5000원")
        ));
        int userCount = 4;

        assertThrows(IllegalArgumentException.class, () -> new Results(results, userCount));
    }
}
