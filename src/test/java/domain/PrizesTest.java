package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.domain.PrizesExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

public class PrizesTest {

    @Test
    @DisplayName("실행 결과가 5글자 초과일 때 예외가 발생한다.")
    void longPrizeExceptionTest() {
        assertThatThrownBy(() -> new Prizes(List.of("정상글자", "정상", "테스트용글자"), new Participants(List.of("a", "b", "c"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PrizesExceptionMessage.OUT_OF_RANGE_PRIZE_LENGTH.getExceptionMessage());
    }

    @ParameterizedTest
    @DisplayName("실행 결과가 없을 때 예외가 발생한다.")
    @EmptySource
    void noPrizeExceptionTest(String name) {
        assertThatThrownBy(() -> new Prizes(List.of(name), new Participants(List.of("a", "b", "c"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PrizesExceptionMessage.NO_PRIZE.getExceptionMessage());
    }

    @Test
    @DisplayName("실행 결과가 참가자 수와 다를 때 예외가 발생한다.")
    void notMatchPrizeExceptionTest() {
        assertThatThrownBy(() -> new Prizes(List.of("정상글자", "정상", "정상값"), new Participants(List.of("a", "b", "c", "d"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PrizesExceptionMessage.NOT_MATCH_SIZE.getExceptionMessage());
    }
}
