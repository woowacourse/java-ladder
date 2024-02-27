import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CustomLineGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameResultTest {

    @DisplayName("LadderGameResult를 생성하면 사다리 타기 게임의 결과가 저장된다.")
    @Test
    void name() {
        Ladder ladder = Ladder.from(5, 3, new CustomLineGenerator());
        List<Player> players = List.of(new Player("pobi"), new Player("honux"), new Player("crong"), new Player("jk"));
        List<Result> results = List.of(new Result("꽝"), new Result("5000"), new Result("꽝"), new Result("3000"));
        LadderGameResult ladderGameResult = new LadderGameResult(ladder, new Players(players), new Results(results, players.size()));

        assertAll(
                () -> assertThat(ladderGameResult.get(players.get(0)).getResult()).isEqualTo("5000"),
                () -> assertThat(ladderGameResult.get(players.get(1)).getResult()).isEqualTo("꽝"),
                () -> assertThat(ladderGameResult.get(players.get(2)).getResult()).isEqualTo("3000"),
                () -> assertThat(ladderGameResult.get(players.get(3)).getResult()).isEqualTo("꽝")
        );
    }

}
