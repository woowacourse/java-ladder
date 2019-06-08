package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    @Test
    void 구분자_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkInput("가나:다라:마바");
        });
    }

    @Test
    void 길이_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkInput("가나다라마바,가나다");
        });
    }

    @Test
    void 사람_row_길이_비교() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkMemberCount(2, 3);
        });
    }
}
