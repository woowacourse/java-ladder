package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class PlayerNameTest {
    
    @ParameterizedTest
    @ValueSource(strings = {"", "cheche"})
    @DisplayName("플레이어 이름이 5자를 초과할 시 예외가 발생한다.")
    void test_2(String inputPlayerName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName(inputPlayerName))
                .withMessage("각 이름 길이의 범위는 1~5 글자 입니다.");
    }
    
    @ParameterizedTest
    @CsvSource(value = {"abel, 4", "a, 1"})
    void getLength(String inputPlayerName, int playerNameLength) {
        PlayerName playerName = new PlayerName(inputPlayerName);
        Assertions.assertThat(playerName.getLength()).isEqualTo(playerNameLength);
    }
}