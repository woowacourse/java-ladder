package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    @DisplayName("")
    void person(){
        new Person("무민");
    }

    @Test
    @DisplayName("")
    void name_6(){
        assertThatThrownBy(() -> new Person("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
