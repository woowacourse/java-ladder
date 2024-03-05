package model.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import model.items.Item;
import model.people.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {
    @Test
    @DisplayName("결과 목록을를생성한다.")
    void createResult() {
        Person chali = new Person("찰리");
        Person moly = new Person("몰리");
        Item item = new Item("꽝");

        assertThatCode(() -> new Results(
                List.of(new Result(chali, item), new Result(moly, item))
        ));
    }

    @Test
    @DisplayName("결과 목록에서 사람에 해당하는 결과를 조회한다.")
    void findItem() {
        Person chali = new Person("찰리");
        Person moly = new Person("몰리");
        Item item = new Item("꽝");

        Results results = new Results(List.of(new Result(chali, item), new Result(moly, item)));
        assertThat(results.findItemByPerson("몰리")).isEqualTo(item);
    }
}
