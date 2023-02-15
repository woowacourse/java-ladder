package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Nested
    static class NameLengthTest {
        @DisplayName("1 이상 5 이하 글자가 들어오면 name이 정상적으로 생성된다.")
        @ParameterizedTest
        @ValueSource(strings = {"에단", "준팍"})
        void givenOneMoreFiveLess_thenSuccess(final String name) {
            assertThatCode(() -> new Name(name))
                    .doesNotThrowAnyException();
        }

        @DisplayName("1미만 5글자 초과 글자가 들어오면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"", "에단준팍짱짱", "준팍에단고마원"})
        void givenFiveMoreChar_thenFailed(final String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"에단", "준팍", "또링", "코일", "블랙캣", "백여우"})
    @DisplayName("이름 길이를 반환한다.")
    void givenName_thenReturnNameLength(final String input) {
        //given
        final Name name = new Name(input);

        //when
        final int length = name.getNameLength();

        //then
        assertThat(length).isEqualTo(input.length());
    }
}