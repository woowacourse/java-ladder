package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderRowTest {

    @ParameterizedTest(name = "bars의 값 중 연속된 true가 존재하면 예외를 던진다.")
    @CsvSource({"true,true,false,false", "false,true,true,false,", "false,false,true,true"})
    void ladderRowFailTest(boolean value1, boolean value2, boolean value3, boolean value4) {
//      -----|----- 같은 형태가 생겨나지 않는지 확인하기 위한 테스트.
        List<Boolean> bars = List.of(value1, value2, value3, value4);

        Assertions.assertThatThrownBy(() -> new LadderRow(bars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("bars의 값 중 연속된 true가 없다면 생성에 성공한다.")
    void ladderRowSuccessTest() {
        List<Boolean> bars = List.of(true, false, false);

        Assertions.assertThatCode(() -> new LadderRow(bars))
                .doesNotThrowAnyException();
    }
}
