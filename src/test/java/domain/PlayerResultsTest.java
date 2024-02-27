package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class PlayerResultsTest {

    @DisplayName("각 참가자는 하나의 결과를 가진다.")
    @Test
    void createPlayerResults() {
        //given
        final List<String> names = List.of("pobi", "honux", "crong", "jk");
        final Names players = new Names(names);
        int playerCount = players.count();

        List<String> rawResults = List.of("꽝", "2000", "꽝", "5000");
        Results results = Results.of(rawResults, playerCount);

        HashMap<Name, Result> playerResults = new HashMap<>();
        for (int i = 0; i < playerCount; i++) {
            playerResults.put(players.getValues().get(i), results.getValues().get(i));
        }

        //when & then
        Assertions.assertThatCode(() -> new PlayerResults(playerResults)).doesNotThrowAnyException();

    }
}
