package ladder.domain;

import ladder.common.CustomException;
import ladder.domain.prize.Result;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @Test
    void 결과_생성_테스트() {
        assertThatCode(() -> new Result("성공"))
                .doesNotThrowAnyException();
    }

    @Test
    void 결과_이름이_5자를_넘으면_예외_발생() {
        assertThatThrownBy(() -> new Result("여섯글자에요"))
                .isInstanceOf(CustomException.class);
    }

    @Test
    void 결과_이름이_1자_미만이면_예외_발생() {
        assertThatThrownBy(() -> new Result(""))
                .isInstanceOf(CustomException.class);
    }

    @Test
    void 결과_이름이_1자이상_5자이하면_정상_작동() {
        String minimumLengthName = "꽝";
        String maximumLengthName = "다섯글자다";

        assertThatCode(() -> new Result(minimumLengthName))
                .doesNotThrowAnyException();
        assertThatCode(() -> new Result(maximumLengthName))
                .doesNotThrowAnyException();
    }
}