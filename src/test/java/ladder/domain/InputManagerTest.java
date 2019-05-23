package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputManagerTest {
    private InputManager inputManager;

    @BeforeEach
    void setUp() {
        inputManager = new InputManager();
    }

    @Test
    void null_또는_빈문자인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputManager.getValidNames(null);
            inputManager.getValidNames("");
        });
    }

    @Test
    void 여섯자_이상인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputManager.getValidNames("abcdefg");
        });
    }

    @Test
    void 이름_중복() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputManager.getValidNames("ab,ab");
        });
    }

    @Test
    void 입력이_쉼표만() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputManager.getValidNames(",,");
        });
    }

    @Test
    void 높이가_0_이하인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputManager.getValidLadderHeight(-2);
        });
    }

}