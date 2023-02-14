package domain;

import exception.EmpytInputException;
import exception.InvalidParticipantsCountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @DisplayName("참가자들의 이름이 조건에 맞는다면 객체를 생성한다.")
    @Test
    void participantsSuccess() {
        try {
            new Participants("pobi,honux,crong,jk");
        } catch (IllegalArgumentException exception) {
            Assertions.fail("조건에 맞는 참가자 이름이 입력된 경우 객체가 생성되어야 합니다.");
        }
    }

    @DisplayName("참가자들의 이름이 빈값인 경우 오류를 반환한다.")
    @Test
    void participantsEmpty() {
        Assertions.assertThatThrownBy(() -> new Participants("")).isExactlyInstanceOf(EmpytInputException.class);
    }

    @DisplayName("참가자들의 이름이 공백만 입력된 경우 오류를 반환한다.")
    @Test
    void participantsBlank() {
        Assertions.assertThatThrownBy(() -> new Participants("    ")).isExactlyInstanceOf(EmpytInputException.class);
    }

    @DisplayName("참가자들의 이름이 10명을 초과해 입력된 경우 오류를 반환한다.")
    @Test
    void participantsOverTen() {
        Assertions.assertThatThrownBy(() -> new Participants("a,b,c,d,e,f,g,h,i,j,k"))
            .isExactlyInstanceOf(InvalidParticipantsCountException.class);
    }
}
