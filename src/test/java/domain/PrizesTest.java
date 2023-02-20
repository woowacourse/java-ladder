package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("결과들은 ")
class PrizesTest {
    @DisplayName("참가자의 수만큼 있다")
    @Test
    void resultSizeEqualsParticipantSize() {
        int participantSize = 3;
        List<String> results = List.of("hi", "hi", "hi");

        assertDoesNotThrow(() -> new Prizes(results, participantSize));
    }

    @DisplayName("참가자의 수와 다르면 예외가 발생한다")
    @Test
    void resultSizeNotEqualsParticipantSize() {
        int participantSize = 2;
        List<String> results = List.of("hi", "hi", "hi");

        assertThatThrownBy(() -> new Prizes(results, participantSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 결과는 참가자의 수와 같아야 합니다");
    }

    @DisplayName("위치로 결과를 가져올 수 있다")
    @Test
    void getResultByPosition() {
        List<String> resultStrings = List.of("a", "b", "c");
        Prizes prizes = new Prizes(resultStrings, resultStrings.size());

        assertThat(List.of(0, 1, 2)).map(prizes::getPrizeByPosition).isEqualTo(resultStrings);
    }
}