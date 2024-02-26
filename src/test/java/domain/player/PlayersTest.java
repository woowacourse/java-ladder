package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {
    @Test
    void 중복된_이름이_존재하면_예외가_발생한다() {
        // given
        final String duplicateName1 = "prin";
        final String duplicateName2 = "prin";
        final String uniqueName = "ddang";
        final List<String> names = List.of(duplicateName1, duplicateName2, uniqueName);

        // when & then
        assertThatThrownBy(() -> Players.from(names))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름이_없으면_예외가_발생하지_않는다() {
        // given
        final String uniqueName1 = "prin";
        final String uniqueName2 = "ddang";
        final String uniqueName3 = "pobi";
        final List<String> names = List.of(uniqueName1, uniqueName2, uniqueName3);

        // when & then
        assertDoesNotThrow(() -> Players.from(names));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 51})
    void 참가자_수가_범위를_벗어나면_예외가_발생한다(int playerCount) {
        // given
        List<String> names = IntStream.range(0, playerCount)
                .mapToObj(i -> "프린" + i)
                .toList();

        // when & then
        assertThatThrownBy(() -> Players.from(names))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 50})
    void 참가자_수가_범위_이내이면_예외가_발생하지_않는다(int playerCount) {
        // given
        List<String> names = IntStream.range(0, playerCount)
                .mapToObj(i -> "프린" + i)
                .toList();

        // when & then
        assertDoesNotThrow(() -> Players.from(names));
    }
}
