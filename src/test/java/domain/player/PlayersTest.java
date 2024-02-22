package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    @Test
    void 중복된_이름이_존재하면_예외가_발생한다() {
        // given
        final Name duplicateName1 = new Name("prin");
        final Name duplicateName2 = new Name("prin");
        final Name uniqueName = new Name("ddang");
        final List<Name> names = List.of(duplicateName1, duplicateName2, uniqueName);

        // when & then
        assertThatThrownBy(() -> new Players(names))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름이_없으면_예외가_발생하지_않는다() {
        // given
        final Name uniqueName1 = new Name("prin");
        final Name uniqueName2 = new Name("ddang");
        final Name uniqueName3 = new Name("pobi");
        final List<Name> names = List.of(uniqueName1, uniqueName2, uniqueName3);

        // when & then
        assertDoesNotThrow(() -> new Players(names));
    }
}
