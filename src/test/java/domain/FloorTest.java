package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FloorTest {
    @Test
     void 한층_만들기() {
        assertThat(new Floor(4)).isEqualTo(new Floor(4));
    }
}
