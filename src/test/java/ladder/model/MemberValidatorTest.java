package ladder.model;

import ladder.model.validator.MemberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberValidatorTest {

    @Test
    void 쉼표_구분자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            MemberValidator.checkSeparator("pobi:crong:sloth:chulsea");
        });
    }

    @Test
    void 이름이_공백인_경우_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            MemberValidator.checkNameLength("");
        });
    }

    @Test
    void 이름_길이가_5초과_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            MemberValidator.checkNameLength("woowahanbros");
        });
    }

    @Test
    void 결과의_갯수와_멤버의_갯수가_다를_때_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            MemberValidator.checkMemberCount(2, 3);
        });
    }
}
