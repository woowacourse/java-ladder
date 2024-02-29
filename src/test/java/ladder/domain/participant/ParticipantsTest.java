package ladder.domain.participant;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    private static final int MAXIMUM_RECEPTION_COUNT = 10;

    @Test
    @DisplayName("참여자 최대 인원 테스트")
    void participantsIsMaximumTest() {
        List<String> names = new ArrayList<>(
                List.of("aru", "pola", "jazz", "hogi", "pobi", "bri", "ato", "zzang", "siso", "takan", "kaki"));

        Assertions.assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 인원은 최대 " + MAXIMUM_RECEPTION_COUNT + "명까지 가능합니다.");
    }

    @Test
    @DisplayName("참여자 이름 중복 여부 테스트")
    void participantsNameDuplicatedTest() {
        List<String> names = new ArrayList<>(List.of("aru", "pola", "jazz", "pola"));

        Assertions.assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 이름은 중복을 허용하지 않습니다");
    }

    @Test
    @DisplayName("이름에 걸맞는 position을 찾을 때 이름이 없는 경우 error")
    void findNotExistNamePosition() {
        List<String> names = new ArrayList<>(List.of("aru", "pola", "jazz"));
        Participants participants = new Participants(names);

        Name name = new Name("gugu");

        Assertions.assertThatThrownBy(() -> participants.findNamePosition(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 이름이 존재하지 않습니다.");
    }
}
