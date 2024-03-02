package model.items;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import model.people.PersonCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    @DisplayName("결과 목록을 생성한다.")
    void createItems() {
        List<String> items = List.of("꽝", "5000", "꽝", "3000");
        PersonCount personCount = new PersonCount(4);
        assertThatCode(() -> Items.of(items, personCount));
    }

    @Test
    @DisplayName("사다리 타기를 완료한 후, 해당 결과의 인덱스에 위치한 사람에게 주어진다.")
    void receiveItemByIndex() {
        List<String> items = List.of("꽝", "5000", "꽝", "3000");
        PersonCount personCount = new PersonCount(4);
        Items generatedItems = Items.of(items, personCount);
        Item item1 = generatedItems.findBy(0);
        assertThat(item1.getName()).isEqualTo("꽝");
    }
}
