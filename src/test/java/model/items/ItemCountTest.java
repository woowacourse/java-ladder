package model.items;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.people.PersonCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemCountTest {
    @Test
    @DisplayName("참여 인원 수와 결과 목록의 수가 동일해야 한다.")
    void checkItemCountWithPersonCount() {
        int itemsCount = 4;
        PersonCount personCount = new PersonCount(3);
        assertThatThrownBy(() -> ItemCount.of(itemsCount, personCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여 인원 수와 결과 목록의 수가 동일하지 않습니다.");
    }
}
