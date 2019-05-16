package ladder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultNameTest {
    @Test
    void 결과명_길이_검사_0() {
        assertThrows(IllegalArgumentException.class, ()->{
            ResultName resultName = new ResultName("");
        });
    }

    @Test
    void 결과명_길이_검사_5초과() {
        assertThrows(IllegalArgumentException.class, ()->{
            ResultName resultName = new ResultName("ABCDEF");
        });
    }

    @Test
    void 결과명_공백포함_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            ResultName resultName = new ResultName("ABC F");
        });
    }
}
