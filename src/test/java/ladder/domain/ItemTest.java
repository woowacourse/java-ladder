package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    @DisplayName("Item은 itemName, position으로 생성한다")
    void shouldCreateItemWhenInputItemNameAndPosition() {
        //given
        //when
        Item item = new Item("3000", 0);
        //then
        assertAll(
                () -> assertThat(item.getName()).isEqualTo(new ItemName("3000")),
                () -> assertThat(item.getPosition()).isEqualTo(new Position(0))
        );
    }
}
