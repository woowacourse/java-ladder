package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PeopleTest {

    @Test
    @DisplayName("최소 2명 이상의 참가자들이 필요하다")
    void leastParticipantTest() {
        assertThatThrownBy(() -> new People(List.of("a")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 참가자 이름이 있으면 예외를 발생한다.")
    void duplicateParticipantTest() {
        assertThatThrownBy(() -> new People(List.of("a", "a", "v")))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "0,a",
            "1,b"
    })
    @DisplayName("순서에 알맞는 참가자 이름을 반환한다")
    void getPersonNameByOrderTest(int order,String expected) {
        //given
        People people = new People(List.of("a", "b"));
        //when
        String actual=people.getNameByOrder(order).getName();
        //then
        assertThat(expected).isEqualTo(actual);

    }

    @Test
    @DisplayName("참가자들 목록에 포함된 사람인지 확인한다.")
    void checkRightParticipant () {
        People people = new People(List.of("a", "b", "c"));

        assertThatThrownBy(()->people.findProperParticipant("d"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(people.findProperParticipant("a")).isEqualTo("a");
    }
}
