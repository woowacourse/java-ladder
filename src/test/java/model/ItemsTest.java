package model;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    @DisplayName("결과 목록을 생성한다.")
    void createItems() {
        List<String> itemsText = List.of("꽝", "5000", "꽝", "3000");
        assertThatCode(() -> new Items(itemsText));
    }
}
