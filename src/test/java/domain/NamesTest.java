package domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NamesTest {
    @Test
    @DisplayName("사람 이름은 중복을 허용하지 않는다.")
    void isNameDuplicate() {
        List<String> rawNames = List.of("pobi", "pobi");

        assertThrows(IllegalArgumentException.class, () -> new Names(rawNames));
    }

    @Test
    @DisplayName("전체 사람 수를 반환한다.")
    void getTotalPersonCount() {
        List<String> rawNames = List.of("pobi", "crong", "honux");
        Names names = new Names(rawNames);

        assertEquals(3, names.size());
    }

    @Test
    @DisplayName("전체 사람 수는 이름 리스트가 비어있다면 0을 반환한다.")
    void isNameListEmptyReturnZero() {
        Names names = new Names(List.of());

        assertEquals(0, names.size());
    }

    @Test
    @DisplayName("전체 사람 중, 첫 번째 사람의 이름을 반환한다.")
    void getFirstName() {
        List<String> rawNames = List.of("pobi", "crong", "honux");
        Names names = new Names(rawNames);

        assertEquals("pobi", names.firstName());
    }

    @Test
    @DisplayName("주어진 인덱스에 해당하는 사람 이름을 반환한다.")
    void findNameByIndex() {
        List<String> rawNames = List.of("pobi", "crong", "honux");
        Names names = new Names(rawNames);

        int testIndex = 2;
        assertEquals("honux", names.nameOf(testIndex));
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", ",", ""})
    @DisplayName("사람 이름은 최소 개수는 2개이다.")
    void isValidNamesCount(String values) {
        List<String> rawNames = List.of(values.split(","));

        assertThrows(IllegalArgumentException.class, () -> new Names(rawNames));
    }
}
