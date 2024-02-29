package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class NameTest {

    @DisplayName("적절한 참가자 이름이 주어지면 잘 생성된다.")
    @Test
    void createName() {
        //given
        String name = "crong";

        //when & then
        assertThatCode(() -> new Name(name)).doesNotThrowAnyException();
    }


    @DisplayName("참가자 이름이 1글자 미만, 5글자를 초과하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"crrong", ""})
    void overMaximumNameLength(String name) {
        //given
        final String playerName = name;

        //when & then
        assertThatThrownBy(() -> new Name(playerName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Name.INVALID_NAME_LENGTH);
    }

    @DisplayName("게임 명령어와 동일한 이름이 주어지면 예외를 던진다.")
    @Test
    void notAllowedName() {
        //given
        String name = Commands.TERMINATE.getValue();

        //when & then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Name.UNAVAILABLE_NAME);
    }

    @DisplayName("주어진 이름과 같은 이름이다.")
    @Test
    void sameName() {
        //given
        Name name = new Name("crong");
        String target = "crong";

        //when
        boolean result = name.isSame(target);

        //then
        assertThat(result).isTrue();
    }

    @DisplayName("주어진 이름과 다른 이름이다.")
    @Test
    void notSameName() {
        //given
        Name name = new Name("crong");
        String target = "pobi";

        //when
        boolean result = name.isSame(target);

        //then
        assertThat(result).isFalse();
    }

}
