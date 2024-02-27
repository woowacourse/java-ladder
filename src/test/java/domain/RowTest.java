package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowTest {
    @Test
    @DisplayName("다리 행은 다리들을 반환할 수 있음")
    void testGetBridge() {
        Bridges expected = new Bridges(List.of(true, false));
        Row row = new Row(expected);

        Bridges actual = row.getBridges();

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}