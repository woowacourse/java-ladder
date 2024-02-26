package laddergame.domain.gameelements;

import laddergame.domain.gameelements.people.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @DisplayName("게임 요소 이름에 예외적인 입력값이 들어왔을 때, Elements 객체를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "a@", ""})
    void elementNamesInvalidInput(String invalidElementName) {
        List<String> elementNames = List.of(invalidElementName);
        assertThrows(IllegalArgumentException.class
                , () -> new Elements(elementNames));
    }

    @DisplayName("Null이 들어왔을 때, Elements 객체를 생성할 수 없다.")
    @ParameterizedTest
    @NullSource
    void elementsNamesNullInput(String nullName) {
        List<String> elementNames = Collections.singletonList(nullName);
        assertThrows(IllegalArgumentException.class
                , () -> new Elements(elementNames));
    }

    @DisplayName("게임 요소 이름에 정상적인 입력값이 들어왔을 때, Elements 객체를 생성할 수 있다.")
    @Test
    void elementsNamesValidInput() {
        List<String> elementsNames = List.of("abcde", "a1234", "12345", "a");
        assertDoesNotThrow(() -> {
            new Elements(elementsNames);
        });
    }

    @DisplayName("게임 요소의 수가 1이상 100이하가 아닐 때, Elements 객체를 생성할 수 없다.")
    @Test
    void elementsNumbersInvalidInput() {
        List<String> zeroNames = new ArrayList<>();
        List<String> exceedNames = new ArrayList<>();

        for (int i = 0; i < 101; i++) {
            exceedNames.add(String.valueOf(i));
        }

        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Elements(zeroNames);
                        }),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> {
                            new Elements(exceedNames);
                        })
        );

    }

    @DisplayName("게임 요소의 수가 1이상 100이하 일 때, Elements 객체를 생성할 수 있다.")
    @Test
    void elementsNumbersValidInput() {
        List<String> validNames = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            validNames.add(String.valueOf(i));
        }
        assertDoesNotThrow(() -> {
            new Elements(validNames);
        });
    }

}
