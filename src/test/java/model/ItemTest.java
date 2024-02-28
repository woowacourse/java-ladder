package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    @DisplayName("실행 결과는 이름을 가진다.")
    void getItemName() {
        String name = "꽝";
        Item item = new Item(name);
        assertThat(item.getName()).isEqualTo(name);
    }
}
