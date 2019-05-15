package ladder.model;

import ladder.model.MemberValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberValidatorTest {

    @Test
    void 쉼표_구분자가_아닌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            MemberValidator.checkSeperator("pobi:crong:sloth:chulsea");
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
}
