package ladder.domain.item;

import static ladder.domain.ladder.Position.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ItemsTest {

    @Test
    void 실행결과는_참가인원과_동일한_개수가_아니라면_예외를_던진다() {
        assertThatThrownBy(() -> Items.from(List.of("item1", "item2"), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가인원과 동일한 개수의 실행결과를 입력해야 합니다.");
    }

    @Test
    void 입력받은_위치에_해당하는_실행결과가_없다면_예외를_던진다() {
        final Items items = Items.from(List.of("item1", "item2", "item3"), 3);

        assertThatThrownBy(() -> items.findByPosition(valueOf(10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 위치에 있는 아이템이 존재하지 않습니다.");
    }

    @Test
    void 입력받은_위치에_해당하는_실행결과를_반환한다() {
        final Items items = Items.from(List.of("item1", "item2", "item3"), 3);

        final Item item = items.findByPosition(valueOf(1));

        assertThat(item.getName()).isEqualTo("item2");
    }

    @Test
    void 모든_실행결과의_이름을_반환한다() {
        final Items items = Items.from(List.of("item1", "item2", "item3"), 3);

        assertThat(items.getNames()).containsExactly("item1", "item2", "item3");
    }
}
