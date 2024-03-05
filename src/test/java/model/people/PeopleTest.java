package model.people;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        //given
        People people = new People("a,aaa");

        //when & then
        assertThat(people.getParticipants())
                .hasSize(2);

    }

    @Test
    @DisplayName("중복된 참가자 이름이 있으면 예외를 발생한다.")
    void duplicateParticipantTest() {
        assertThatThrownBy(() -> new People("a,a,v"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("특정 참가자가 몇 번째 참가자인지 알려준다.")
    void findIndexByPersonTest() {
        //given
        People people = new People("프람,초롱,호티");

        //when
        int indexOfPerson = people.findIndex(new Person("프람"));

        //then
        assertThat(indexOfPerson)
                .isEqualTo(0);
    }

}
