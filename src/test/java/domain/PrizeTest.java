package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.domain.PrizeExceptionMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PrizeTest {

    @Test
    @DisplayName("실행 결과가 5글자 초과일 때 예외가 발생한다.")
    void longPrizeExceptionTest() {
        assertThatThrownBy(() -> new Prize(List.of("정상글자", "정상", "테스트용글자")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PrizeExceptionMessage.OUT_OF_RANGE_PRIZE_LENGTH.getExceptionMessage());
    }

    @ParameterizedTest
    @DisplayName("실행 결과가 없을 때 예외가 발생한다.")
    @NullAndEmptySource
    void noPrizeExceptionTest(String name) {
        assertThatThrownBy(() -> new Prize(List.of(name)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PrizeExceptionMessage.OUT_OF_RANGE_PRIZE_LENGTH.getExceptionMessage());
    }
}
