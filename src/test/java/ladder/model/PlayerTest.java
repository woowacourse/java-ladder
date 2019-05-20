package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {
    @Test
    void initTestA() {
        assertThat(new Player("ABC", "123")
                .toString())
                .isEqualTo("ABC : 123");
    }

    @Test
    void initTestB() {
        assertThat(new Player("ABC ", "123")
                .toString())
                .isEqualTo("ABC : 123");
    }

    @Test
    void initTestC() {
        assertThat(new Player("ABC", "12 ")
                .toString())
                .isEqualTo("ABC : 12");
    }

    @Test
    void initTestD() {
        assertThat(new Player(" ABC      ", "123 ")
                .toString())
                .isEqualTo("ABC : 123");
    }

    @Test
    void initTestE() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("", "123 "));
    }

    @Test
    void initTestF() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("sdgaeGdfhasr", "123 "));
    }
}