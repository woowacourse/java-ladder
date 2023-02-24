package ladder.domain.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import ladder.domain.player.Position;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ItemTest {

    @Test
    void 아이템이_잘_생성됨() {
        assertDoesNotThrow(() -> new Item("pobi", 0));
    }

    @Test
    void 이름을_반환한다() {
        Item item = new Item("pobi", 0);
        assertThat(item.getName())
                .isEqualTo("pobi");
    }

    @Test
    void 위치를_반환한다() {
        Item item = new Item("pobi", 0);
        assertThat(item.isSamePosition(Position.valueOf(0)))
                .isTrue();
    }

    @Test
    void 위치가_다르면_다른_위치() {
        Item item = new Item("pobi", 0);
        assertThat(item.isSamePosition(Position.valueOf(1)))
                .isFalse();
    }
}
