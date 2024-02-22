package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    @Test
    @DisplayName("참여자 최대 인원 테스트")
    void participantsIsMaximumTest() {
        List<String> names = new ArrayList<>(
                List.of("aru", "pola", "jazz", "hogi", "pobi", "bri", "ato", "zzang", "siso", "takan", "kaki"));

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 인원은 최대 10명까지 가능합니다.");
    }

    @Test
    @DisplayName("참여자 이름 중복 여부 테스트")
    void participantsNameDuplicatedTest() {
        List<String> names = new ArrayList<>(List.of("aru", "pola", "jazz", "pola"));

        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 이름은 중복을 허용하지 않습니다");
    }
}
