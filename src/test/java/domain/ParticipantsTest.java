package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import helper.AbstractTestFixture;

public class ParticipantsTest extends AbstractTestFixture {

    @Test
    void 참가자가_2명_미만이면_IllegalArgumentException을_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(createParticipantsFrom("a")));
    }

    @Test
    void 참가자는_2명_이상이어야_한다() {
        assertThatNoException()
                .isThrownBy(() -> new Participants(createParticipantsFrom("a", "b")));
    }

    @Test
    void 중복된_참가자는_IllgealArgumentException을_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(createParticipantsFrom("땡칠", "땡칠")));
    }

    @ParameterizedTest
    @CsvSource(value = {"a,0", "c,2", "e,4"})
    void 특정_참가자의_시작점을_알_수_있다(String name, int expectedPosition) {
        Participants participants = new Participants(createParticipantsFrom("a", "b", "c", "d", "e"));

        Position startPosition = participants.findPositionOf(name);

        assertThat(startPosition).isEqualTo(new Position(expectedPosition));
    }

    @Test
    void 특정_참가자를_찾지_못하면_예외를_던진다() {
        Participants participants = new Participants(createParticipantsFrom("a", "b", "c", "d", "e"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> participants.findPositionOf("unknown"));
    }
}
