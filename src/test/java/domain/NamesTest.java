package domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {
    @Test
    @DisplayName("사람 이름은 중복을 허용하지 않는다.")
    void isNameDuplicate() {
        List<String> rawNames = List.of("pobi", "pobi");

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Names(rawNames));
    }

    @Test
    @DisplayName("전체 사람 수를 반환한다.")
    void getTotalPersonNumber() {
        List<String> rawNames = List.of("pobi", "crong", "honux");
        Names names = new Names(rawNames);

        Assertions.assertEquals(3, names.size());
    }
}
