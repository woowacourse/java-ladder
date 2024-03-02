package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowGeneratorTest {
    @Test
    @DisplayName("설정한 폭 만큼 Bridge 생성")
    void testGenerateBridgeSize() {
        RowGenerator rowGenerator = new RowGenerator(() -> Bridge.EXIST);

        int expected = 5;
        Row row = rowGenerator.generate(expected);
        int actual = row.getBridges().size();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("인접한 Bridge가 존재할 경우, Bridge가 생성되지 않음")
    void testGenerate() {
        RowGenerator rowGenerator = new RowGenerator(() -> Bridge.EXIST);
        Row row = rowGenerator.generate(4);
        List<Bridge> actual = row.getBridges();
        List<Bridge> expected = List.of(Bridge.EXIST, Bridge.NONE, Bridge.EXIST, Bridge.NONE);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}