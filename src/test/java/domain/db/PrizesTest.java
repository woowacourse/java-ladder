package domain.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class PrizesTest {

    @Test
    @DisplayName("상들이 정상적으로 생성되는가")
    void do_prizes_creat_correctly() {
        String[] prizeNames = {"꽝", "5000", "꽝", "3000"};

        assertThatCode(() -> new Prizes(prizeNames)).doesNotThrowAnyException();
    }
}
