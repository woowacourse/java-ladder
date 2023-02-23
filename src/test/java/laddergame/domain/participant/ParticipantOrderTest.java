package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class ParticipantOrderTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("참여자의 순서를 가지고 있는, ParticipantOrder를 생성한다.")
    void create_thenSuccess(final int validOrder) {
        assertThatCode(() -> ParticipantOrder.create(validOrder))
                .doesNotThrowAnyException();

        assertThat(ParticipantOrder.create(validOrder))
                .isInstanceOf(ParticipantOrder.class);
    }
}
