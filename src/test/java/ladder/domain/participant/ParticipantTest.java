package ladder.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantTest {
    @Test
    @DisplayName("참가자 이름의 앞뒤 공백을 제거한다.")
    void trimNameTest() {
        // given
        final String name = "mia ";

        // when
        final Participant mia = new Participant(name);

        // then
        assertEquals("mia", mia.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"miamia", "potato", ""})
    @DisplayName("참가자 이름이 1~5자가 아니면 예외가 발생한다.")
    void checkNameLengthTest(final String name) {
        // when & then
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 1에서 5자 사이로 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"감1자", "미아a", ".#a", "1234"})
    @DisplayName("참가자 이름이 영어가 아니면 예외가 발생한다.")
    void checkAlphabeticNameTest(final String name) {
        // when & then
        assertThatThrownBy(() -> new Participant(name))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("이름은 영어로 입력해 주세요.");
    }
}
