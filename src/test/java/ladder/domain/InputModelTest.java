package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputModelTest {
    private InputModel inputModel;

    @BeforeEach
    void setUp() {
        inputModel = new InputModel();
    }

    @Test
    void null_또는_빈문자인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputModel.getValidNames(null);
            inputModel.getValidNames("");
        });
    }

    @Test
    void 여섯자_이상인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputModel.getValidNames("abcdefg");
        });
    }

    @Test
    void 이름_중복() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputModel.getValidNames("ab,ab");
        });
    }

    @Test
    void 입력이_쉼표만() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputModel.getValidNames(",,");
        });
    }

    @Test
    void 참가자수와_결과수가_다른_경우() {
        assertThrows(IllegalArgumentException.class, () ->{
            inputModel.getValidReward("ef", 2);
        });
    }
}