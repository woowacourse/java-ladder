package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PeopleTest {

    @Test
    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다.")
    void createNames() {
        // given
        People people = new People("pobi,honux,crong,jk");

        // when
        int count = people.count();

        // then
        assertThat(count).isEqualTo(4);
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    void createInvalidNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People("pobipobi,honux,crong,jk"));
    }

    @Test
    @DisplayName("이름에 공백은 포함하지 않는다.")
    void createValidNames() {
        // given
        String name = "  jk  ";

        // when & then
        assertThatCode(() -> new People(name))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("가장 긴 이름의 길이를 찾을 수 있다.")
    void findMaxNameLength() {
        // given
        String names = "pobi,honux,crong,jk";
        People people = new People(names);

        // when
        int maxNameLength = people.findMaxNameLength();

        // then
        assertThat(maxNameLength).isEqualTo(5);
    }
}