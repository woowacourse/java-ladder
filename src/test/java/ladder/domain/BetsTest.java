package ladder.domain;

import ladder.error.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BetsTest {

    private List<String> bets;
    private int countOfParticipants;

    @BeforeEach
    void setup() {
        bets = Arrays.asList("A", "B", "C", "D", "E");
        countOfParticipants = bets.size();
    }

    @DisplayName("참여자 수와 내기 목록의 수가 같아야 한다.")
    @Test
    void createBetsFailTestByDifferentCountOfNamesAndBet() {
        countOfParticipants = 3;

        assertThatThrownBy(() -> new Bets(bets, countOfParticipants))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DIFFERENT_PARTICIPANTS_AND_BETS_COUNT.getMessage());
    }

    @DisplayName("참여자 수와 내기 목록의 수가 같아야 한다.")
    @Test
    void createBetsSuccessTestByCountOfNamesAndBet() {
        assertDoesNotThrow(() -> new Bets(bets, countOfParticipants));
    }

}
