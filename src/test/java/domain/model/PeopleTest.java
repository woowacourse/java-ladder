package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeopleTest {

    @Test
    @DisplayName("최소 2명 이상의 참가자들이 필요하다")
    void leastParticipantTest() {
        assertThatThrownBy(() -> new People("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 참가자 이름이 있으면 예외를 발생한다.")
    void duplicateParticipantTest() {
        assertThatThrownBy(() -> new People("a,a,v"))
                .isInstanceOf(IllegalStateException.class);
    }

}
