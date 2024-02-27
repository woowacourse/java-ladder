package view.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemFormatterTest {
    @Test
    @DisplayName("실행 결과는 좌측 정렬하여 출력한다.")
    void format() {
        ItemFormatter itemFormatter = new ItemFormatter();
        String itemName = "꽝";
        String formattedItemName = itemFormatter.format(itemName);
        assertThat(formattedItemName).isEqualTo("꽝   ");
    }
}
