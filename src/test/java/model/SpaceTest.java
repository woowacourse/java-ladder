package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {

    @Test
    @DisplayName("주어지는 인자에 따라 알맞은 사다리의 한칸을 표현할 수 있다.")
    void of(){
        assertAll(
                () -> assertThat(Space.of(true)).isEqualTo(Space.LINE),
                () -> assertThat(Space.of(false)).isEqualTo(Space.EMPTY)
        );

    }

}