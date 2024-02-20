package domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    @DisplayName(" 사람은 이름을 가진다.")
    void personNameTest() {
        //given
        Person person = new Person("name1");
        Person person2 = new Person("name2");
        //when & then
        Assertions.assertThat(person.getName()).isEqualTo("name1");
        Assertions.assertThat(person2.getName()).isEqualTo("name2");
    }

    @Test
    @DisplayName("사람의 이름은 5글자를 초과하면 예외를 발생시킨다.")
    void personMaxNameLengthTest() {
        Assertions.assertThatThrownBy(() -> new Person("namena"))
                .isInstanceOf(IllegalStateException.class);
    }


    @Test
    @DisplayName("사람의 이름은 공백만 입력되면 예외를 발생시킨다.")
    void personNonBlankTest() {
        Assertions.assertThatThrownBy(() -> new Person(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

