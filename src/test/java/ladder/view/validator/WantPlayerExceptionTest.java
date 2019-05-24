package ladder.view.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WantPlayerExceptionTest {
    @Test
    void wantName_값이_Null값이_있는_경우_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            WantPlayerValidate.wantName(null);
        });
    }

    @Test
    void wantName_값이_빈_값이_있는_경우_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            WantPlayerValidate.wantName("");
        });
    }

    @Test
    void wantName_값이_공백이_있는_경우_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            WantPlayerValidate.wantName("   ");
        });
    }
}
