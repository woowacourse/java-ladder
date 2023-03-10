package model.vo;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 사다리 게임 결과 값을 Wrapping하는 클래스.
 * 원시타입 데이터의 getter는 테스트하지 않는다.
 */
public class ResultTest {
    private static final int MAXIMUM_RESULT_LENGTH = 5;
    private static final String MAXIMUM_RESULT_LENGTH_ERROR = "[ERROR] 게임 결과 입력값 길이는 %d 이하로만 가능합니다.";

    @Test
    @DisplayName("Result 객체 생성 성공 테스트")
    void createResultTest() {
        assertThatNoException().isThrownBy(() -> new Result("10000"));
    }

    @Test
    @DisplayName("결과값 길이 제한으로 인한 Result 객체 생성 실패 테스트")
    void limitResultLengthTest() {
        assertThatThrownBy(() -> new Result("5가 넘는 길이 결과"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(MAXIMUM_RESULT_LENGTH_ERROR, MAXIMUM_RESULT_LENGTH));
    }
}
