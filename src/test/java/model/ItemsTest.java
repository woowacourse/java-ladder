package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {

    @Test
    @DisplayName("결과 목록을 생성한다.")
    void createItems() {
        List<String> items = List.of("꽝", "5000", "꽝", "3000");
        assertThatCode(() -> new Items(items));
    }

    @Test
    @DisplayName("사다리 타기를 완료한 후, 해당 결과의 인덱스에 위치한 사람에게 주어진다.")
    void receiveItemByIndex() {
        Items items = new Items(List.of("꽝", "5000", "꽝", "3000"));

        assertAll(
                () -> assertThat(items.get(0)).isEqualTo("꽝"),
                () -> assertThat(items.get(1)).isEqualTo("5000"),
                () -> assertThat(items.get(2)).isEqualTo("꽝"),
                () -> assertThat(items.get(3)).isEqualTo("3000")
        );
    }
}
