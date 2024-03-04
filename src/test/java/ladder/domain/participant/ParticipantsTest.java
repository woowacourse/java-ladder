package ladder.domain.participant;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    private static final int MAXIMUM_RECEPTION_COUNT = 10;
    private static final String SEE_ALL_PARTICIPANT_COMMEND = "all";

    @DisplayName("참여자 최대 인원 테스트")
    @Test
    void participantsIsMaximumTest() {
        List<String> names = new ArrayList<>(
                List.of("aru", "pola", "jazz", "hogi", "pobi", "bri", "ato", "zzang", "siso", "takan", "kaki"));

        Assertions.assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 인원은 최대 " + MAXIMUM_RECEPTION_COUNT + "명까지 가능합니다.");
    }

    @DisplayName("참여자 이름 중복 여부 테스트")
    @Test
    void participantsNameDuplicatedTest() {
        List<String> names = new ArrayList<>(List.of("aru", "pola", "jazz", "pola"));

        Assertions.assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자 이름은 중복을 허용하지 않습니다");
    }

    @DisplayName("이름에 걸맞는 position을 찾을 때 이름이 없는 경우 error")
    @Test
    void findNotExistNamePosition() {
        List<String> names = new ArrayList<>(List.of("aru", "pola", "jazz"));
        Participants participants = new Participants(names);

        Name name = new Name("gugu");

        Assertions.assertThatThrownBy(() -> participants.findNamePosition(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 이름이 존재하지 않습니다.");
    }

    @DisplayName("이름에 all을 받지 않는다.")
    @Test
    void isParticipantHasNameAll() {
        List<String> names = new ArrayList<>(List.of(SEE_ALL_PARTICIPANT_COMMEND, "pola", "jazz"));

        Assertions.assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(SEE_ALL_PARTICIPANT_COMMEND + " 이라는 이름은 사용할 수 없습니다.");
    }
}
