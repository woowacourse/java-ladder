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
}
