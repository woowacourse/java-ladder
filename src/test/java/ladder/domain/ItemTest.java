package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ItemTest {

    @Test
    void 실행결과는_이름을_가진다() {
        final Item item = new Item("name", Position.valueOf(1));

        assertThat(item.getName()).isEqualTo("name");
    }

    @Test
    void 실행결과는_위치를_가진다() {
        final Item item = new Item("name", Position.valueOf(1));

        assertThat(item.getPosition()).isEqualTo(Position.valueOf(1));
    }
}
