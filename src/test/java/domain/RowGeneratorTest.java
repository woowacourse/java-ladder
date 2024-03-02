package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RowGeneratorTest {
    @Test
    @DisplayName("폭 만큼 Bridge가 생성된다.")
    void testGenerateBridgeSize() {
        RowGenerator rowGenerator = new RowGenerator(new BridgeGenerator() {
            @Override
            public Bridge generate() {
                return Bridge.EXIST;
            }
        });
        int expected = 5;
        Row row = rowGenerator.generate(expected);
        int actual = row.getBridges().size();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("인접한 Bridge가 존재할 경우, Bridge는 존재하지 않음")
    void testGenerate() {
        List<Bridge> expected = List.of(Bridge.EXIST, Bridge.NONE, Bridge.EXIST, Bridge.NONE);
        RowGenerator rowGenerator = new RowGenerator(new BridgeGenerator() {
            @Override
            public Bridge generate() {
                return Bridge.EXIST;
            }
        });
        Row row = rowGenerator.generate(4);
        List<Bridge> actual = row.getBridges();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}