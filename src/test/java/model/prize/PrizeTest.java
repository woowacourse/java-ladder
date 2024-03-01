package model.prize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    void createPrize() {
        String name = "꽝";
        Assertions.assertThatCode(() -> {
            new Prize(name);
        }).doesNotThrowAnyException();
    }
}
