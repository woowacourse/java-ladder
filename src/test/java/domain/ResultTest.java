package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    private Map<Player, Prize> getPlayerPrize(Players players, Prizes prizes) {
        List<Player> playersList = players.getPlayers();
        List<Prize> prizeList = prizes.getPrizes();

        return IntStream.range(0, playersList.size())
                .boxed()
                .collect(Collectors.toMap(playersList::get, prizeList::get));
    }

    @DisplayName("사다리 게임 결과를 생성한다")
    @Test
    public void create() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players, List.of("꽝", "5000", "꽝", "3000"));
        assertThatCode(() -> new Result(getPlayerPrize(players, prizes)))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름과 상품들로 해당 플레이어의 결과를 반환한다")
    @Test
    public void matchResult() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players, List.of("꽝", "5000", "꽝", "3000"));
        Result result = new Result(getPlayerPrize(players, prizes));

        Prize pobi = result.match("pobi");
        Prize honux = result.match("honux");
        Prize crong = result.match("crong");
        Prize jk = result.match("jk");

        assertAll(
                () -> assertThat(pobi.getPrize()).isEqualTo("꽝"),
                () -> assertThat(honux.getPrize()).isEqualTo("5000"),
                () -> assertThat(crong.getPrize()).isEqualTo("꽝"),
                () -> assertThat(jk.getPrize()).isEqualTo("3000")
        );
    }

    @DisplayName("all을 입력하면 모든 플레이어의 상품 결과를 반환한다")
    @Test
    public void matchAllResult() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players, List.of("꽝", "5000", "꽝", "3000"));
        Result result = new Result(getPlayerPrize(players, prizes));

        Map<Player, Prize> allResult = result.matchAll();

        assertThat(allResult).isEqualTo(Map.of(
                new Player("pobi"), new Prize("꽝"),
                new Player("honux"), new Prize("5000"),
                new Player("crong"), new Prize("꽝"),
                new Player("jk"), new Prize("3000")));
    }
}
