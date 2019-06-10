package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberValidatorTest {

    @Test
    void 쉼표_구분자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkInput("pobi:crong:sloth:chulsea");
        });
    }

    @Test
    void 이름이_공백인_경우_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkInput("");
        });
    }

    @Test
    void 이름_길이가_5초과_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkInput("woowahanbros");
        });
    }

    @Test
    void 결과의_갯수와_멤버의_갯수가_다를_때_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.checkMemberCount(2, 3);
        });
    }
}
