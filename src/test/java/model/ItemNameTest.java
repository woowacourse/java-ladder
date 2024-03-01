package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemNameTest {
    @Test
    @DisplayName("결과 이름을 생성한다.")
    void createItemName() {
        String name = "꽝";
        assertThatCode(() -> new ItemName(name));
    }

    @ParameterizedTest(name = "실행 결과의 이름은 공백일 수 없다.")
    @ValueSource(strings = {"", " "})
    void createItemNameThrowException(String itemNames) {
        assertThatThrownBy(() -> new ItemName(itemNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 이름은 공백일 수 없습니다.");
    }
}
