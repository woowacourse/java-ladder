package ladder.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultNamesTest {

    @Test
    void 입력개수_검증_실패() {
        Assertions.assertThatThrownBy(() -> new ResultNames("aaa,aaa,aaa,aaa",3)).hasMessage("실행 결과의 개수는 플레이어의 인원 수(3)와 같아야 합니다.(입력된 실행 결과의 수 : 4)")
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 입력개수_검증_성공() {
        assertDoesNotThrow(() ->new ResultNames("aaa,aaa,aaa",3));
    }


}
