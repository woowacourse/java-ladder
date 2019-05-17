package ladder.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void isEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("");
        });
    }

    @Test
    void 띄어쓰기가_있는_이름() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("   ");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("P O B I");
        });
    }

    @Test
    void 입력_다섯글자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("AAAAAA");
        });
    }

    @Test
    void 중복이름_존재() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("Buddy,Buddy");
        });
    }

    @Test
    void 이름_all() {
        String name = "all";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName(name);
        });
    }

    @Test
    void 콤마로끝() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidName("pobi,brown,");
        });
    }

    @Test
    void 높이_최소값_이하() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isLowerLimit(0);
        });
    }

    @Test
    void 실행결과수_이름수_불일치() {
        String[] names = {"pobi", "brown", "buddy"};
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.checkValidResultCandidate(Arrays.asList(names), "꽝,5000,5000,꽝");
        });
    }

    @Test
    void 초기이름에_미포함_결과이름_요청() {
        String[] names = {"pobi", "brown", "buddy"};
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.isNotContainName(Arrays.asList(names), "woni");
        });
    }
}