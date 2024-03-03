package domain;

import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersTest {

    @Test
    @DisplayName("중복된 이름의 참가자가 생성되지 않는지 확인")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> Players.of(List.of("robin", "robin")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름이 같은 참가자는 있을 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    @DisplayName("참가자 인원 수가 너무 적거나 너무 많은지 확인")
    void validatePlayersCount(int playersCount) {
        List<String> playerNames = IntStream.rangeClosed(1, playersCount)
                .mapToObj("a%d"::formatted)
                .toList();

        Assertions.assertThatThrownBy(() -> Players.of(playerNames))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("참가자는 2명 이상 10명 이하여야 합니다.");
    }

}
