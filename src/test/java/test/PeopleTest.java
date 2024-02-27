package test;

import ladder.domain.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {
    @DisplayName("참여자 이름에 예외적인 입력값이 들어왔을 때, domain.People 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "abcdef", // 5글자 이상의 이름이 주어질 때
            "a@", // 숫자, 알파벳 이외의 문자로 구성될 때
            "" // 공백으로 주어질 때
    })
    void peopleNamesInvalidInput(String invalidName) {
        List<String> names = List.of(invalidName);
        assertThrows(IllegalArgumentException.class
                , () -> new People(names));
    }

    @DisplayName("참여자 이름에 Null이 들어왔을 때, domain.People 객체를 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    void peopleNamesNullInput(String nullName) {
        List<String> names = Collections.singletonList(nullName);
        assertThrows(IllegalArgumentException.class
                , () -> new People(names));
    }

    @DisplayName("참여자 이름에 정상적인 입력값이 들어왔을 때, domain.People 객체를 생성할 수 있다.")
    @Test
    void peopleNamesValidInput() {
        List<String> names = List.of("abcde", "a1234", "12345", "a");
        assertDoesNotThrow(
                () -> {
                    new People(names);
                });
    }

    @DisplayName("참여자 수가 1이상 100이하가 아닐 때, domain.People 객체를 생성할 수 없다.")
    @Test
    void peopleNumbersInvalidInput() {
        List<String> zeroNames = new ArrayList<>();
        List<String> exceedNames = new ArrayList<>();

        for (int i = 0; i < 101; i++) {
            exceedNames.add(String.valueOf(i));
        }

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new People(zeroNames);
                        }),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new People(exceedNames);
                        })
        );

    }

    @DisplayName("참여자 수가 1이상 100이하 일 때, domain.People 객체를 생성할 수 있다.")
    @Test
    void peopleNumbersValidInput() {
        List<String> validNames = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            validNames.add(String.valueOf(i));
        }
        assertDoesNotThrow(() -> {
            new People(validNames);
        });
    }
}
