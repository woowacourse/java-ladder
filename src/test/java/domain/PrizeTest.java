package domain;

import constant.domain.NameExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @ParameterizedTest
    @DisplayName("결과가 없을 때 예외가 발생한다.")
    @NullAndEmptySource
    void noPrizeExceptionTest(String prize) {
        assertThatThrownBy(() -> new Prize(prize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 결과가 없습니다.");
    }

}
