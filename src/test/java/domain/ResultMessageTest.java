package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.domain.HeightExceptionMessage;
import exception.domain.NameExceptionMessage;
import exception.domain.ParticipantsExceptionMessage;
import exception.domain.ResultMessageExceptionMessage;
import java.util.List;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultMessageTest {

    @Test
    @DisplayName("실행 결과가 5글자 초과일 때 예외가 발생한다.")
    void longNameExceptionTest() {
        assertThatThrownBy(() -> new ResultMessage(List.of("정상글자", "정상", "테스트용글자")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ResultMessageExceptionMessage.OUT_OF_RANGE_RESULT_MESSAGE_LENGTH.getExceptionMessage());
    }
}
