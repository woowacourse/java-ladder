package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.participant.Participants;
import domain.result.Prizes;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizesTest {

    @Test
    @DisplayName("실행 결과가 참가자 수와 다를 때 예외가 발생한다.")
    void notMatchPrizeExceptionTest() {
        assertThatThrownBy(
                () -> new Prizes(List.of("정상글자", "정상", "정상값"), new Participants(List.of("a", "b", "c", "d"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과의 개수는 참가자 수와 일치해야 합니다.");
    }

    @Test
    @DisplayName("각 참가자의 실행 결과를 반환한다.")
    void getParticipantPrizeTest() {
        Prizes prizes = new Prizes(List.of("정상글자", "정상", "정상값"), new Participants(List.of("a", "b", "c")));
        assertThat(prizes.getParticipantPrize(2)).isEqualTo("정상값");
    }
}
