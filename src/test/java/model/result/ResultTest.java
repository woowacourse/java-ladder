package model.result;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.items.Item;
import model.people.Person;
import model.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("결과를 생성한다.")
    void createResult() {
        Person person = new Person("찰리");
        Item item = new Item("꽝");
        assertThatCode(() -> new Result(person, item));
    }
}
