package util;

import static org.assertj.core.api.Assertions.assertThat;

import view.LineItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class RandomLineItemGeneratorTest {

    @DisplayName("랜덤 값이 CONNECTED 또는 UNCONNECTED만 갖도록 생성되는지 검증한다.")
    @Test
    void generateRandomLineItem() {
        RandomLineItemGenerator lineItemGenerator = new RandomLineItemGenerator();

        assertThat(lineItemGenerator.generate()).isIn(List.of(LineItem.CONNECTED, LineItem.UNCONNECTED));
    }
}
