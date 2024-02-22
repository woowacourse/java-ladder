package domain.name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    @Test
    void 중복된_이름이_존재하면_예외가_발생한다() {
        // given
        final PlayerName duplicateName1 = new PlayerName("prin");
        final PlayerName duplicateName2 = new PlayerName("prin");
        final PlayerName uniqueName = new PlayerName("ddang");
        final List<PlayerName> names = List.of(duplicateName1, duplicateName2, uniqueName);

        // when & then
        assertThatThrownBy(() -> new Players(names))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름이_없으면_예외가_발생하지_않는다() {
        // given
        final PlayerName uniqueName1 = new PlayerName("prin");
        final PlayerName uniqueName2 = new PlayerName("ddang");
        final PlayerName uniqueName3 = new PlayerName("pobi");
        final List<PlayerName> names = List.of(uniqueName1, uniqueName2, uniqueName3);

        // when & then
        assertDoesNotThrow(() -> new Players(names));
    }
}
