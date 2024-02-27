import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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
                    run("pobi,honux,crong,jk", "5");
                    assertThat(output()).contains(
                            "실행결과",
                            " pobi honux crong    jk",
                            "    |-----|     |-----|\n"
                                    + "    |     |-----|     |\n"
                                    + "    |-----|     |     |\n"
                                    + "    |     |-----|     |\n"
                                    + "    |-----|     |-----|"
                    );
                },
                1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1
        );
    }

    @DisplayName("참여자 이름 입력 예외 테스트")
    @Test
    void testInvalidPlayerNameLength() {
        assertSimpleTest(() -> {
            runException("jojojo,dora");
            assertThat(output()).contains("[ERROR] 참여자 이름은 최대 5글자입니다.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
