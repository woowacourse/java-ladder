package laddergame.domain.gameelements;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @DisplayName("게임 요소 이름에 예외적인 입력값이 들어왔을 때, Elements 객체를 생성할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef", "a@", ""})
    void elementNamesInvalidInput(String invalidElementName) {
        List<String> elementNames = Collections.singletonList(invalidElementName);
        assertThrows(IllegalArgumentException.class
                , () -> new Players(elementNames));
        assertThatThrownBy(() -> new Players(elementNames)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 요소의 이름은 5자 이내의 영숫자로 구성되어야 합니다.");
    }

    @DisplayName("게임 요소 이름에 정상적인 입력값이 들어왔을 때, Elements 객체를 생성할 수 있다.")
    @Test
    void elementsNamesValidInput() {
        List<String> elementsNames = List.of("abcde", "a1234", "12345", "a");
        assertDoesNotThrow(() -> {
            new Players(elementsNames);
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
                () -> assertThatThrownBy(() -> new Players(zeroNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("게임 참여자의 수는 1이상 100이하만 가능합니다."),

                () -> assertThatThrownBy(() -> new Players(exceedNames))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("게임 참여자의 수는 1이상 100이하만 가능합니다.")
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
            new Players(validNames);
        });
    }
}
