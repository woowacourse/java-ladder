package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import model.items.Item;
import model.people.People;
import model.people.Person;
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
