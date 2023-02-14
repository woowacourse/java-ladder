package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BarTest {

    @DisplayName("isExistBar()에서 랜덤값을 인자로 받아 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void test_1(boolean isExist) {
        // given & when
        Bar bar = new Bar(() -> isExist);

        // then
        Assertions.assertThat(bar.isExistBar()).isEqualTo(isExist);
    }
}
