package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class ParticipantsTest {

    @DisplayName("참가자 간 이름이 중복되면 에외가 발생한다.")
    @Test
    void occurExceptionIfNameIsDuplicated() {
        assertThatThrownBy(() -> new Participants(List.of("test1", "test2", "test2")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
