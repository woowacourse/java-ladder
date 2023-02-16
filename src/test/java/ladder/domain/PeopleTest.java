package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {
    @Test
    public void size_예외던지기() {
        assertThatThrownBy(() -> People.from(List.of("에밀"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void get_People_Size(){
        assertThat(People.from(List.of("에밀", "홍고")).getPeopleSize()).isEqualTo(2);
    }
}