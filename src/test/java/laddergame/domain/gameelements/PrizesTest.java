package laddergame.domain.gameelements;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PrizesTest {

    @DisplayName("보상의 수가 참여자의 수와 같지 않으면 Prizes가 생성되지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 5})
    void notSameLengthBetweenPrizesAndPlayersTest(int playerNumber) {
        List<String> prizeNames = new ArrayList<>(List.of("꽝", "5000", "꽝", "3000"));
        assertThatThrownBy(() -> new Prizes(prizeNames, playerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // TODO 검증에서 hasMessage를 통한 정확한 오류 발생 테스트하기
    @DisplayName("보상의 수가 참여자의 수와 같다면 Prizes가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {4})
    void sameLengthBetweenPrizesAndPlayersTest(int playerNumber) {
        assertDoesNotThrow(() ->
                new Prizes(List.of("꽝", "5000", "꽝", "3000"), playerNumber));
    }

}
