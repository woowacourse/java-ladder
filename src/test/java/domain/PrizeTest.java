package domain;

import static domain.Prizes.MAX_OF_PRIZE_LENGTH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

public class PrizeTest {

    @Test
    @DisplayName("실행 결과가 5글자 초과일 때 예외가 발생한다.")
    void longPrizeExceptionTest() {
        assertThatThrownBy(() -> new Prizes(List.of("정상글자", "정상", "테스트용글자"), new Participants(List.of("a", "b", "c"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과의 길이는 " + MAX_OF_PRIZE_LENGTH + "글자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("실행 결과가 없을 때 예외가 발생한다.")
    @EmptySource
    void noPrizeExceptionTest(String name) {
        assertThatThrownBy(() -> new Prizes(List.of(name, name, name), new Participants(List.of("a", "b", "c"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 실행 결과가 없습니다.");
    }

}
