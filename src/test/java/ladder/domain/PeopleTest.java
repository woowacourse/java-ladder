package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PeopleTest {

    private List<Name> names;

    @BeforeEach
    void setUp() {
        Name pobi = new Name("pobi");
        Name honux = new Name("honux");
        Name crong = new Name("crong");
        Name jk = new Name("jk");
        names = new ArrayList<>(List.of(pobi, honux, crong, jk));
    }

    @Test
    @DisplayName("사람 이름이 중복이라면 예외가 발생한다.")
    void createDuplicatedNames() {
        names.add(new Name("pobi"));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People(names));
    }

    @Test
    @DisplayName("이름이 2개 이하라면 예외가 발생한다.")
    void nameLengthExceptionTest() {
        List<Name> towNames = names.subList(0, 2);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People(towNames));
    }

    @Test
    @DisplayName("가장 긴 이름의 길이를 찾을 수 있다.")
    void findMaxNameLength() {
        // given
        People people = new People(names);

        // when
        int maxNameLength = people.findMaxNameLength();

        // then
        assertThat(maxNameLength).isEqualTo(5);
    }
}
