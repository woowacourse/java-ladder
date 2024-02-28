package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    @DisplayName("결과 목록을 생성한다.")
    void createItems() {
        List<Item> items = List.of(
                new Item("꽝"),
                new Item("5000"),
                new Item("꽝"),
                new Item("3000")
        );
        assertThatCode(() -> new Items(items));
    }

    @Test
    @DisplayName("참여 인원 수와 결과 목록의 수가 동일해야 한다.")
    void checkItemCountWithPersonCount() {
        List<Item> items = List.of(
                new Item("꽝"),
                new Item("5000"),
                new Item("꽝"),
                new Item("3000"));
        int personCount = 3;
        assertThatThrownBy(() -> Items.of(items, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원 수와 결과 목록의 수가 동일하지 않습니다.");
    }

    @Test
    @DisplayName("사다리 타기를 완료한 후, 해당 결과의 인덱스에 위치한 사람에게 주어진다.")
    void receiveItemByIndex() {
        Item item1 = new Item("꽝");
        Item item2 = new Item("5000");
        Item item3 = new Item("3000");
        Items items = new Items(
                List.of(item1, item2, item1, item3)
        );

        assertAll(
                () -> assertThat(items.get(0)).isEqualTo(item1),
                () -> assertThat(items.get(1)).isEqualTo(item2),
                () -> assertThat(items.get(2)).isEqualTo(item1),
                () -> assertThat(items.get(3)).isEqualTo(item3)
        );
    }
}
