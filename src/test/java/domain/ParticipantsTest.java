package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ParticipantsTest {

    @DisplayName("참가자들 이름 중복 에외 처리 테스트")
    @Test
    void validateDuplicatedNameTest() {
        assertThatThrownBy(() -> new Participants(List.of("test1", "test2", "test2")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
