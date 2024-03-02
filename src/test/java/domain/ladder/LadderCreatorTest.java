package domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderCreatorTest {
    @Test
    @DisplayName("사다리 생성자가 생성될 때 예외가 발생하지 않음")
    void testCreateNameCreator() {
        Assertions.assertThatCode(LadderCreator::new).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리 생성자에서 사다리 생성")
    void testCreate() {
        LadderCreator ladderCreator = new LadderCreator();
        Ladder ladder = ladderCreator.create(5, 2, () -> Bridge.EXIST);
        Assertions.assertThat(ladder).isNotNull();
    }
}