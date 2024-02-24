package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PeopleTest {

    @Test
    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다.")
    void separateByCommas() {
        // given
        People people = new People("pobi,honux,crong,jk");

        // when
        int count = people.count();

        // then
        assertThat(count).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("사다리 게임에 참여하는 사람이 두 명 이상이어야 한다.")
    @ValueSource(strings = {"pobi", ",,,"})
    void createInsufficientSizePeople(String names) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People(names));
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    void createExceedLengthName() {
        // given
        String names = "pobipobi, honux";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People(names));
    }

    @Test
    @DisplayName("이름이 1글자 미만이면 예외가 발생한다.")
    void createEmptyName() {
        // given
        String names = ", honux";

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People(names));
    }

    @Test
    @DisplayName("이름의 글자 수를 셀 때 앞뒤 공백은 포함하지 않는다.")
    void countByRemovingSpaces() {
        // given
        String names = "  pobi  , honux";

        // when & then
        assertThatCode(() -> new People(names))
                .doesNotThrowAnyException();
    }
}
