package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("결과를 보려는 사람이 사다리 참여자에 없는 경우 예외가 발생한다.")
    void result() {
        Map<Person, Item> matchedResult = Map.of(
                new Person("몰리"), new Item("꽝")
        );

        Result result = new Result(matchedResult);
        assertThatThrownBy(() -> result.findItemByPerson(new Person("찰리")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과를 보려는 사람이 사다리 참여자에 존재하지 않습니다.");
    }
}
