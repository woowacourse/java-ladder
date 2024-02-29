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
        // when
        result.put(new Player("pobi"), new ResultItem("꽝"));

        // then
        assertThat(result.get(new Player("pobi"))).containsAllEntriesOf(Map.of(
                new Player("pobi"), new ResultItem("꽝")
        ));
    }

    @DisplayName("특정 참여자의 결과 항목을 조회한다.")
    @Test
    void get() {
        // given
        result.put(new Player("pobi"), new ResultItem("꽝"));

        // when
        Map<Player, ResultItem> expected = result.get(new Player("pobi"));

        // then
        assertThat(expected).containsAllEntriesOf(Map.of(
                new Player("pobi"), new ResultItem("꽝")
        ));
    }

    @DisplayName("모든 참여자의 결과 항목을 조회한다.")
    @Test
    void getAll() {
        // given
        result.put(new Player("pobi"), new ResultItem("꽝"));
        result.put(new Player("honux"), new ResultItem("3000"));
        result.put(new Player("crong"), new ResultItem("꽝"));
        result.put(new Player("jk"), new ResultItem("5000"));

        // when
        Map<Player, ResultItem> expected = result.getAll();

        // then
        assertThat(expected).containsAllEntriesOf(Map.of(
                new Player("pobi"), new ResultItem("꽝"),
                new Player("honux"), new ResultItem("3000"),
                new Player("crong"), new ResultItem("꽝"),
                new Player("jk"), new ResultItem("5000")
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
