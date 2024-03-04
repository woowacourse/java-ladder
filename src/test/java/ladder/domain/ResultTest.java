package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    private Result result;

    @BeforeEach
    void createResult() {
        Players players = new Players("pobi", "honux", "crong", "jk");
        result = new Result(players);
    }

    @DisplayName("특정 참여자의 결과 항목을 저장한다.")
    @Test
    void put() {
        // given
        Player player = new Player("pobi");
        ResultItem resultItem = new ResultItem("꽝");

        // when
        result.put(player, resultItem);

        // then
        assertThat(result.get(player)).containsAllEntriesOf(Map.of(player, resultItem));
    }

    @DisplayName("특정 참여자의 결과 항목을 조회한다.")
    @Test
    void get() {
        // given
        Player player = new Player("pobi");
        ResultItem resultItem = new ResultItem("꽝");
        result.put(player, resultItem);

        // when
        Map<Player, ResultItem> expected = result.get(player);

        // then
        assertThat(expected).containsAllEntriesOf(Map.of(player, resultItem));
    }

    @DisplayName("모든 참여자의 결과 항목을 조회한다.")
    @Test
    void getAll() {
        // given
        Player player1 = new Player("pobi");
        ResultItem resultItem1 = new ResultItem("꽝");

        Player player2 = new Player("honux");
        ResultItem resultItem2 = new ResultItem("3000");

        Player player3 = new Player("crong");
        ResultItem resultItem3 = new ResultItem("꽝");

        Player player4 = new Player("jk");
        ResultItem resultItem4 = new ResultItem("5000");

        result.put(player1, resultItem1);
        result.put(player2, resultItem2);
        result.put(player3, resultItem3);
        result.put(player4, resultItem4);

        // when
        Map<Player, ResultItem> expected = result.getAll();

        // then
        assertThat(expected).containsAllEntriesOf(Map.of(
                player1, resultItem1,
                player2, resultItem2,
                player3, resultItem3,
                player4, resultItem4
        ));
    }

    @DisplayName("null 값이 있는지 확인한다.")
    @Test
    void hasNullValue() {
        // given
        result.put(new Player("pobi"), new ResultItem("꽝"));
        result.put(new Player("honux"), new ResultItem("3000"));
        result.put(new Player("crong"), new ResultItem("꽝"));

        // when
        boolean expected = result.hasNullValue();

        // then
        assertThat(expected).isTrue();
    }

    @DisplayName("null 값이 없는지 확인한다.")
    @Test
    void noNullValue() {
        // given
        result.put(new Player("pobi"), new ResultItem("꽝"));
        result.put(new Player("honux"), new ResultItem("3000"));
        result.put(new Player("crong"), new ResultItem("꽝"));
        result.put(new Player("jk"), new ResultItem("5000"));

        // when
        boolean expected = result.hasNullValue();

        // then
        assertThat(expected).isFalse();
    }

    @DisplayName("특정 참여자의 결과 항목이 null인지 확인한다.")
    @Test
    void hasNullValueForKey() {
        // when
        boolean beforeUpdate = result.hasNullValueForKey(new Player("pobi"));

        result.put(new Player("pobi"), new ResultItem("꽝"));
        boolean afterUpdate = result.hasNullValueForKey(new Player("pobi"));

        // then
        assertAll(
                () -> assertThat(beforeUpdate).isTrue(),
                () -> assertThat(afterUpdate).isFalse()
        );
    }
}
