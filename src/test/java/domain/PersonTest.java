package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("")
    @ParameterizedTest
    @ValueSource(strings = {""," ","   "})
    void name_blank(String blankName){
        assertThatThrownBy(() -> new Person(blankName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
