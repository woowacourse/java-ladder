package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    @DisplayName("사람은 이름을 가진다.")
    void personNameTest() {
        //given
        Person person = new Person("name1");
        Person person2 = new Person("name2");

        //when & then
        assertThat(person.getName()).isEqualTo("name1");
        assertThat(person2.getName()).isEqualTo("name2");
    }

    @Test
    @DisplayName("사람의 이름은 5글자를 초과하면 예외를 발생시킨다.")
    void personMaxNameLengthTest() {
        assertThatThrownBy(() -> new Person("namena"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사람의 이름은 공백만 입력되면 예외를 발생시킨다.")
    void personNonBlankTest() {
        assertThatThrownBy(() -> new Person(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

