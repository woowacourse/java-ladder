package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    private static List<String> splitComma(String input) {
        return Arrays.asList(input.split(","));
    }

    @DisplayName("사람 수는 2명 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"ab,cd", "ab,cd,ef,gh"})
    void createPlayersSuccessTest(String inputPeople) {
        List<String> names = splitComma(inputPeople);
        assertThat(new Players(names).getClass()).isEqualTo(Players.class);
    }

    @DisplayName("사다리 결과는 사람의 수 만큼 있어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"꽝,3000,꽝,1000", "2000,5000,꽝,꽝"})
    void validateLadderResultCountFailedTest(String inputResults) {
        List<String> playerNames = Arrays.asList("A", "B", "C");
        Players players = new Players(playerNames);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Results(players.getPlayersCount(), Arrays.asList(inputResults.split(",")));
        });
    }

    @DisplayName("사다리 결과는 사람의 수 만큼 있어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"꽝,3000,1000", "2000,5000,꽝"})
    void validateLadderResultCountSuccessTest(String inputResults) {
        List<String> playerNames = Arrays.asList("A", "B", "C");
        Players players = new Players(playerNames);

        new Results(players.getPlayersCount(), Arrays.asList(inputResults.split(",")));
        assertThat(new Results(players.getPlayersCount(), Arrays.asList(inputResults.split(","))).getClass()).isEqualTo(Results.class);
    }

}
