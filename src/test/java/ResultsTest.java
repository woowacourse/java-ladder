import domain.PlayerCount;
import domain.Players;
import domain.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultsTest {
    @DisplayName("참여자의 수와 실행 결과의 수가 일치하지 않으면 예외를 발생시킨다.")
    @Test
    void name() {
        Players players = Players.from(List.of("bito", "kirby"));

        Assertions.assertThatThrownBy(() -> Results.from(List.of("1000", "2000", "3000"), PlayerCount.fromPlayers(players)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
