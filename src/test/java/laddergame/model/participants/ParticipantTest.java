package laddergame.model.participants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParticipantTest {
    @DisplayName("참여할 사람의 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "어쩌다마주친그대", "그대나의챔피언너와나의챔피언"})
    void validateNameLength(String given) {
        //when //then
        assertThatThrownBy(() -> new Participant(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여할 사람의 이름은 null이거나 공백이면 안된다.")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void validateNameNotNullAndNotBlank(String given) {
        //when //then
        assertThatThrownBy(() -> new Participant(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 같은 두 참여자가 동일한 객체인지 판별한다.")
    @Test
    void equals() {
        //given
        String given = "daon";
        //when
        Participant first = new Participant(given);
        Participant second = new Participant(given);
        //then
        assertThat(first).isEqualTo(second);
    }

    @DisplayName("이름이 같은 두 참여자가 동일한 해시코드를 갖는지 판별한다.")
    @Test
    void hashcode() {
        //given
        String given = "daon";
        //when
        Participant first = new Participant(given);
        Participant second = new Participant(given);
        //then
        assertThat(first.hashCode()).isEqualTo(second.hashCode());
    }
}
