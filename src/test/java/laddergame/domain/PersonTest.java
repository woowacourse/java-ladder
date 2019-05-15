package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void 이름이_5자를_넘어가면_예외_발생() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Person("abcdef");
        });
    }
}