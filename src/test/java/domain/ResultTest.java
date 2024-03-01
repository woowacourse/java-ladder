package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @DisplayName("사다리 게임 결과를 생성한다")
    @Test
    public void create() {
        assertThatCode(() -> new Result(Map.of("pobi", 1, "honux", 0, "crong", 3, "jk", 2)))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름과 상품들로 해당 플레이어의 결과를 반환한다")
    @Test
    public void matchResult() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players, List.of("꽝", "5000", "꽝", "3000"));
        Result result = new Result(Map.of("pobi", 1, "honux", 0, "crong", 3, "jk", 2));

        String pobiResult = result.match("pobi", prizes);
        String honuxResult = result.match("honux", prizes);
        String crongResult = result.match("crong", prizes);
        String jkResult = result.match("jk", prizes);

        assertAll(
                () -> assertThat(pobiResult).isEqualTo("5000"),
                () -> assertThat(honuxResult).isEqualTo("꽝"),
                () -> assertThat(crongResult).isEqualTo("3000"),
                () -> assertThat(jkResult).isEqualTo("꽝")
        );
    }

    @DisplayName("all을 입력하면 모든 플레이어의 상품 결과를 반환한다")
    @Test
    public void matchAllResult() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(players, List.of("꽝", "5000", "꽝", "3000"));
        Result result = new Result(Map.of("pobi", 1, "honux", 0, "crong", 3, "jk", 2));

        Map<String, String> allResult = result.matchAll(prizes);

        assertThat(allResult).isEqualTo(Map.of(
                "pobi", "5000",
                "honux", "꽝",
                "crong", "3000",
                "jk", "꽝"));
    }

    @DisplayName("이름을 받아 결과에 존재하는 이름인지 반환")
    @Test
    public void isContain() {
        Result result = new Result(Map.of("pobi", 1, "honux", 0, "crong", 3, "jk", 2));

        assertThat(result.isContain("pobi")).isTrue();
    }
}
