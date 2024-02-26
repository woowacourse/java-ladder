package ladder.domain.participant;

import ladder.exception.participant.InvalidNameLengthException;
import ladder.exception.participant.NonAlphabeticNameException;
import ladder.exception.participant.ProhibitedNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {
    @Test
    @DisplayName("참가자 이름의 앞뒤 공백을 제거한다.")
    void trimNameTest() {
        // given
        final String name = "mia ";

        // when
        final Name mia = new Name(name);

        // then
        assertEquals("mia", mia.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"miamia", "potato", ""})
    @DisplayName("참가자 이름이 1~5자가 아니면 예외가 발생한다.")
    void checkNameLengthTest(final String value) {
        // when & then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(InvalidNameLengthException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"감1자", "미아a", ".#a", "1234"})
    @DisplayName("참가자 이름이 영어가 아니면 예외가 발생한다.")
    void checkAlphabeticNameTest(final String value) {
        // when & then
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(NonAlphabeticNameException.class);
    }

    @Test
    @DisplayName("참가자 이름이 all이면 예외가 발생한다.")
    void prohibitedNameTest() {
        assertThatThrownBy(() -> new Name("all"))
                .isInstanceOf(ProhibitedNameException.class);
    }
}
