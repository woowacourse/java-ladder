import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @DisplayName("참여자의 이름은 최대 5글자까지 부여할 수 있다.")
    @Test
    void participantNameThrowException() {
        Assertions.assertThatThrownBy(() -> new Participant("asdfsda"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자의 이름은 최대 5글자입니다.");
    }

    @DisplayName("참여자의 이름이 5글자 이하일 시 생성에 성공한다.")
    @Test
    void participantName() {
        Assertions.assertThatCode(() -> new Participant("pobi"))
                .doesNotThrowAnyException();
    }

    @DisplayName("참가자의 이름은 null 일 수 없다")
    @Test
    void participantNameIsNull() {
        assertThatThrownBy(() -> new Participant(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 이름은 null 이거나 공백일 수 없습니다.");
    }

}
