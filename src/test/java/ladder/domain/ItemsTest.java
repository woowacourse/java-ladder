package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    @DisplayName("아이템의 위치는 입력 순이다")
    void shouldItemsOrderIsSameWithInputOrderWhenCreate() {
        //given
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));
        //when
        Items items = Items.generate(names);
        List<Item> itemList = items.toUnmodifiableItems();
        //then
        assertAll(
                () -> assertThat(itemList.get(0).getPosition()).isEqualTo(new Position(0)),
                () -> assertThat(itemList.get(1).getPosition()).isEqualTo(new Position(1)),
                () -> assertThat(itemList.get(2).getPosition()).isEqualTo(new Position(2))
        );
    }

    @Test
    @DisplayName("아이템 수를 반환한다")
    void shouldReturnSizeWhenRequest() {
        //given
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));
        //when
        Items items = Items.generate(names);
        //then
        assertThat(items.getSize()).isEqualTo(3);
    }
}
