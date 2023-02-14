package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FloorTest {

    @DisplayName("참가자의 수는 2명 이상 100명 이하이다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 100})
    void validPersonCountTest(int personCount) {
        assertDoesNotThrow(() -> new Floor(personCount));
    }

    @DisplayName("1명 이하, 101명 이상의 참가자는 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 101, 102})
    void invalidPersonCountTest(int personCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Floor(personCount));
    }
}