package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonsTest {
    @Test
    @DisplayName("올바른 값이 들어오면 오류가 발생하지 않는다.")
    void Should_Success_When_NameInput() {
        assertDoesNotThrow(() -> new Persons(List.of("name", "name2", "name3")));
    }

    @Test
    @DisplayName("참여자가 한명인 경우 예외 발생")
    void Should_ThrowException_When_OnePerson() {
        assertThatThrownBy(() -> new Persons(List.of("name")))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("최소 참여자의 수는");
    }

    @Test
    @DisplayName("참여자 이름이 중복된 경우 예외 발생")
    void Should_ThrowException_When_DuplicateNames() {
        assertThatThrownBy(() -> new Persons(List.of("name1", "name1", "name2")))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("참여자들 이름에 중복이 있어서는 안됩니다.");
    }
}
