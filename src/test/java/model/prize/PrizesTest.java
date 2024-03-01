package model.prize;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrizesTest {
    @Test
    void createPrizesTest() {
        List<String> names = List.of("꽝", "5000", "꽝", "3000");
        Assertions.assertThatCode(() -> {
            Prizes.from(names);
        }).doesNotThrowAnyException();
    }

    @Test
    void getPrizeByIndex() {
        int index = 3;
        List<String> names = List.of("꽝", "5000", "꽝", "3000");
        Prizes prizes = Prizes.from(names);
        Prize prize = prizes.getPrizeByIndex(index);
        Assertions.assertThat(prize).isEqualTo(new Prize("3000"));
    }
}
