package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("이름을 생성한다.")
    @Test
    void createName() {
         // when
        Name name = new Name("pobi");

        // then
        assertThat(name).extracting("value").isEqualTo("pobi");
    }

    @DisplayName("이름 값이 동일하면 같은 이름으로 취급한다.")
    @Test
    void equals() {
        // when
        Name name1 = new Name("pobi");
        Name name2 = new Name("pobi");

        // then
        assertThat(name1).isEqualTo(name2);
    }
}
