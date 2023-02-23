package laddergame.domain.participant;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParticipantTest {

    private Participant participant;

    @BeforeAll
    void init() {
        final String name = "pobi";
        final int order = 0;
        participant = Participant.create(name, order);
    }

    @Test
    @DisplayName("참여자의 이름과 순서가 들어오면, Participant를 생성한다.")
    void create_thenSuccess() {
        assertThatCode(() -> Participant.create("pobi", 0))
                .doesNotThrowAnyException();

        assertThat(Participant.create("pobi", 0))
                .isInstanceOf(Participant.class);
    }

    @Test
    @DisplayName("타겟 사용자와 동일한 사용자의 이름이 들어오면, true를 반환한다.")
    void isSameName_givenSameName_thenTrue() {
        assertThat(participant.isSameName("pobi"))
                .isTrue();
    }

    @Test
    @DisplayName("타겟 사용자와 다른 사용자의 이름이 들어오면, false를 반환한다.")
    void isSameName_givenDiffName_thenFalse() {
        assertThat(participant.isSameName("pobi2"))
                .isFalse();
    }
}
