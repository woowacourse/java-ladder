package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {
    @Test
    public void size_테스트() {
        assertThatThrownBy(() -> People.from(List.of("에밀"))).isInstanceOf(IllegalArgumentException.class);
    }
}