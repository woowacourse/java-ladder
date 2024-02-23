package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeopleTest {

    @Test
    @DisplayName("최소 2명 미만의 이름이 입력될 경위 예외를 발생시킨다.")
    void leastParticipantTest() {
        assertThatThrownBy(() -> new People("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참겨자는 2명 이상은 허용한다.")
    void greatParticipantTest() {
        assertThatCode(() -> new People("a,aa"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("중복된 참가자 이름이 있으면 예외를 발생한다.")
    void duplicateParticipantTest() {
        assertThatThrownBy(() -> new People("a,a,v"))
                .isInstanceOf(IllegalStateException.class);
    }

}
