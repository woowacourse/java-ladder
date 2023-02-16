package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineSourceTest {

    @Test
    @DisplayName("1은 MakeLine을 생성하는 값이다.")
    void MakeLineTest() {
        assertThat(LineSource.of(1)).isEqualTo(LineSource.MakeLine);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 2, 3, 4, 5, 6})
    @DisplayName("1외의 값을 입력하면 MakeBlank를 생성한다.")
    void MakeBlankTest(int value) {
        assertThat(LineSource.of(value)).isEqualTo(LineSource.MakeBlank);
    }

}
