import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PeopleTest {
    @DisplayName("참여자 이름에 예외적인 입력값이 들어왔을 때, People 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "abcdef", // 5글자 이상의 이름이 주어질 때
            "a@", // 숫자, 알파벳 이외의 문자로 구성될 때
            "" // 공백으로 주어질 때
    })
    void peopleNamesInvalidInput(String name) {
        assertThrows(IllegalArgumentException.class
                , () -> {
                    new People(List.of(name));
                });
    }

    @DisplayName("참여자 이름에 Null이 들어왔을 때, People 객체를 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    void peopleNamesNullInput(String name) {
        assertThrows(IllegalArgumentException.class
                , () -> {
                    List<String> names = new ArrayList<>();
                    names.add(name);
                    new People(names);
                });
    }

    @DisplayName("참여자 이름에 정상적인 입력값이 들어왔을 때, People 객체를 생성할 수 있다.")
    @Test
    void peopleNamesValidInput() {
        List<String> names = List.of("abcde", "a1234", "12345", "a");
        Assertions.assertDoesNotThrow(
                () -> {
                    new People(names);
                });
    }
}
