package model.items;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {
    @Test
    @DisplayName("결과를 생성한다.")
    void createItem() {
        String name = "꽝";
        assertThatCode(() -> new Item(name));
    }

    @Test
    @DisplayName("실행 결과는 이름을 가진다.")
    void getItemName() {
        String name = "꽝";
        Item item = new Item(name);
        assertThat(item.getName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "실행 결과의 이름은 공백일 수 없다.")
    @ValueSource(strings = {"", " "})
    void createItemNameThrowException(String itemNames) {
        assertThatThrownBy(() -> new Item(itemNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 이름은 공백일 수 없습니다.");
    }
}
