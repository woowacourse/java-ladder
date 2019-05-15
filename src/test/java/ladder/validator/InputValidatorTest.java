package ladder.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void isEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isEmpty(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isEmpty("");
        });
    }

    @Test
    void 띄어쓰기가_있는_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.hasSpace("   ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.hasSpace("P O B I");
        });
    }

    @Test
    void 입력_다섯글자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isOverMaxInputLimit("AAAAAA");
        });
    }

    @Test
    void 중복이름_존재() {
        String[] name = {"Buddy", "Buddy"};
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isDuplicate(name);
        });
    }

    @Test
    void 콤마로끝() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkLastIndex("pobi,brown,");
        });
    }

    @Test
    void 높이_최소값_이하() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isLowerLimit(0);
        });
    }

}