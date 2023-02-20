package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

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
}
