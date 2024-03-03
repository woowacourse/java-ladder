package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    public void create() {
        assertThatCode(() ->
                Ladder.of(2, new Height(5), new FixedBooleanGenerator(true)))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 정보를 원시값으로 생성한다..")
    @Test
    public void createInformation() {
        Ladder ladder = Ladder.of(4, new Height(5), new FixedBooleanGenerator(true));

        Map<Integer, List<Boolean>> actual = ladder.getLinesInformation();
        Map<Integer, List<Boolean>> expected = new LinkedHashMap<>();
        for (int i = 1; i <= 5; i++) {
            expected.put(i, List.of(true, false, true));
        }

        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Players, Prizes 의 사다리 결과를 생성한다.")
    void getResult() {
       /*
       wiib    pobi    haha
        |------|      |
        |------|      |
        |------|      |
        꽝     당첨    꽝
        */
        Ladder ladder = Ladder.of(3, new Height(3), new FixedBooleanGenerator(true));
        Players players = new Players(List.of("wiib","pobi","haha"));
        Prizes prizes = Prizes.of(List.of("꽝","당첨","꽝"),3);

        Map<Player,Prize> actual = ladder.getResult(players,prizes);
        Map<Player,Prize> expected = new LinkedHashMap<>();
        expected.put(new Player("wiib"),new Prize("당첨"));
        expected.put(new Player("pobi"),new Prize("꽝"));
        expected.put(new Player("haha"),new Prize("꽝"));


        assertThat(actual).containsExactlyEntriesOf(expected);
    }
}
