package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MissionTest {

    @Test
    void 미션_생성_값_입력() {
        Mission mission1 = new Mission("꽝");
        Mission mission2 = new Mission("5000");
        Mission mission3 = new Mission("3000");

        Assertions.assertEquals(mission1.getMission(), "꽝");
        Assertions.assertEquals(mission2.getMission(), "5000");
        Assertions.assertEquals(mission3.getMission(), "3000");
    }

    @Test
    void 미션_글자수가_5글자_초과이면_예외_처리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Mission("다섯글자이상"));
    }
}
