package ladder.domain.paticipant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;
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

    @Test
    @DisplayName("문자열 리스트를 매개변수로 받아서 Name 리스트를 반환한다")
    void inviteParticipantsTest() {
        List<String> names = new ArrayList<>(List.of("aru", "pola", "jazz"));

        Participants participants = new Participants(names);

        List<Name> participantsNames = participants.getNames();
        assertThat(participantsNames.get(0)).isEqualTo(new Name("aru"));
        assertThat(participantsNames.get(1)).isEqualTo(new Name("pola"));
        assertThat(participantsNames.get(2)).isEqualTo(new Name("jazz"));
    }
}
