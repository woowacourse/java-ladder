package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.participant.Participant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantTest {
    @Test
    void 참여자_이름이_다섯글자를_넘으면_예외가_발생한다() {
        String name = "엘라릴리애쉬";

        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 참여자_이름이_빈값_혹은_공백이면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참여자_이름이_all이면_예외가_발생한다() {
        String name = "all";

        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참여자_이름이_일치하는지_확인할_수_있다() {
        String validName = "릴리";
        String invalidName = "엘라";
        Participant participant = new Participant(validName);

        assertThat(participant.hasEquivalentName(validName)).isTrue();
        assertThat(participant.hasEquivalentName(invalidName)).isFalse();
    }
}
