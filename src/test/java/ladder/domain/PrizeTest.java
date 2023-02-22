package ladder.domain;

import ladder.common.CustomException;
import ladder.domain.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @Test
    void 결과_생성_테스트() {
        assertThatCode(() -> new Prize("성공"))
                .doesNotThrowAnyException();
    }

    @Test
    void 결과_이름이_5자를_넘으면_예외_발생() {
        assertThatThrownBy(() -> new Prize("여섯글자에요"))
                .isInstanceOf(CustomException.class);
    }

    @Test
    void 결과_이름이_1자_미만이면_예외_발생() {
        assertThatThrownBy(() -> new Prize(""))
                .isInstanceOf(CustomException.class);
    }
}