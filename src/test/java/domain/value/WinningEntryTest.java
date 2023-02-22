package domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("WinningEntry(당첨 항목) 는")
public class WinningEntryTest {

    @Test
    void 빈_값으로_생성될_수_없다() {
        // given
        String empty = "";

        // when & then
        assertThatThrownBy(() ->
                new WinningEntry(empty)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "문자열(ex: {arguments})을 통해 생성된다.")
    @ValueSource(strings = {"2단계도", "잘", "부탁드려요", "바다!", "너무", "감사합니다"})
    void 문자열을_통해_생성된다(final String entry) {
        // when
        WinningEntry winningEntry = new WinningEntry(entry);

        // then
        assertThat(winningEntry.value())
                .isEqualTo(entry);
    }

    @ParameterizedTest(name = "값이 동일하면 동등하다")
    @ValueSource(strings = {"말랑", "바다"})
    void 값이_동일하면_동등하다(final String entry) {
        // when
        WinningEntry winningEntry1 = new WinningEntry(entry);
        WinningEntry winningEntry2 = new WinningEntry(entry);

        // then
        assertThat(winningEntry1)
                .isEqualTo(winningEntry2);
    }

    @ParameterizedTest(name = "0글자이거나, 5글자를 초과하는 값(ex: {0})이 들어오면 예외가 발생한다")
    @ValueSource(strings = {"", "안녕하세요오"})
    void createFail(final String value) {
        // when & then
        assertThatThrownBy(() ->
                new WinningEntry(value)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
