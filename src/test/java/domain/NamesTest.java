package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {
    @Test
    @DisplayName("참여자 이름 개수가 적절하면 해당 개수만큼 참여자 이름 생성")
    void testGetNames() {
        List<Name> expected = List.of(new Name("a"), new Name("b"));
        Names names = new Names(expected);

        List<Name> actual = names.getNames();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("참여자 이름 개수가 적절하면 해당 사람 개수를 반환할 수 있음")
    void testGetNameCount() {
        List<Name> givenNames = List.of(new Name("a"), new Name("b"));
        Names names = new Names(givenNames);

        int actual = names.getNameCount();
        int expected = 2;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}