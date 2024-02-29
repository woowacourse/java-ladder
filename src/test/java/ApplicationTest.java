import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @DisplayName("사다리 생성 결과 출력")
    @Test
    void testLadderGameResult() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,honux,crong,jk", "꽝,5000,꽝,3000", "5", "pobi", "all");
                    assertThat(output()).containsSubsequence(
                            "사다리 결과",
                            " pobi honux crong    jk",
                            "    |-----|     |-----|",
                            "    |     |-----|     |",
                            "    |-----|     |     |",
                            "    |     |-----|     |",
                            "    |-----|     |-----|",
                            "    꽝  5000     꽝  3000",
                            "실행 결과",
                            "꽝",
                            "pobi : 꽝",
                            "honux : 3000",
                            "crong : 꽝",
                            "jk : 5000"
                    );
                },
                1, 1, 0, 1, 1, 0, 0, 1, 1, 1
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
