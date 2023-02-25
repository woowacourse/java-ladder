package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerNameTest {
    
    @ParameterizedTest
    @ValueSource(strings = {"", "cheche"})
    @DisplayName("플레이어 이름이 5자를 초과할 시 예외가 발생한다.")
    void test_2(String inputPlayerName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName(inputPlayerName))
                .withMessage("각 이름 길이의 범위는 1~5 글자 입니다.");
    }
    
    @Test
    @DisplayName("참여자 이름으로 all이 들어오는 경우 예외가 발생한다.")
    void validateImpossiblePlayerName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName("all"))
                .withMessage("참여자 이름으로 all은 입력할 수 없습니다.");
    }
    
    @ParameterizedTest
    @CsvSource(value = {"abel, 4", "a, 1"})
    @DisplayName("해당 플레이어 이름의 길이를 반환한다.")
    void getLength(String inputPlayerName, int playerNameLength) {
        // given
        PlayerName playerName = new PlayerName(inputPlayerName);
        
        // when
        int actualPlayerNameLength = playerName.getLength();
        
        // then
        assertThat(actualPlayerNameLength).isEqualTo(playerNameLength);
    }
}