package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 100})
    void 높이는_1이상_100이하로_생성된다(int parsedInteger) {
        assertDoesNotThrow(() -> new Height(parsedInteger));
    }

    @Test
    void 높이는_1이상_100이하_숫자를_가진다() {
        Height height = new Height(100);
        assertThat(height.getHeight()).isEqualTo(100);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    void 높이는_1미만_100초과시_예외를_던진다(int parsedInteger) {
        assertThatThrownBy(() -> new Height(parsedInteger))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 1, 최대 100까지 가능합니다.");
    }
}
