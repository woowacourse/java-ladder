package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderRowTest {

    @ParameterizedTest(name = "lines의 값 중 연속된 true가 존재하면 예외를 던진다.")
    @CsvSource({"true,true,false,false", "false,true,true,false,", "false,false,true,true"})
    void ladderRowFailTest(boolean value1, boolean value2, boolean value3, boolean value4) {
//      -----|----- 같은 형태가 생겨나지 않기 위함.
        List<Boolean> lines = List.of(value1, value2, value3, value4);

        Assertions.assertThatThrownBy(() -> new LadderRow(lines))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lines의 값 중 연속된 true가 없다면 생성에 성공한다.")
    void ladderRowSuccessTest() {
        List<Boolean> lines = List.of(true, false, false);

        Assertions.assertThatCode(() -> new LadderRow(lines))
                .doesNotThrowAnyException();
    }
}
