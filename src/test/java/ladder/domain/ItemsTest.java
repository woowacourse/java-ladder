package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:ab", "2:abc"}, delimiter = ':')
    @DisplayName("위치에 따라 아이템을 반환한다")
    void shouldReturnItemWhenInputPosition(int position, String itemName) {
        //given
        List<String> names = new ArrayList<>(List.of("a", "ab", "abc"));
        //when
        Items items = Items.generate(names);
        Item item = items.findBy(new Position(position));
        //then
        assertThat(item.getName()).isEqualTo(new ItemName(itemName));
    }
}
