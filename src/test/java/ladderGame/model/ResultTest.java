package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("실행 결과는 6글자 이상일 시 예외처리 된다.")
    void validateResultLength() {
        assertThatThrownBy(() -> new Result("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 최대 5글자까지 가능합니다.");
    }

}
