package ladder.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0 2019-05-15
 */
class RuleTest {
    @Test
    void ruleInputPlayerNames_빈값_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputPlayerNames("");
        });
    }

    @Test
    void ruleInputPlayerNames_스페이스_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputPlayerNames(" ");
        });
    }

    @Test
    void ruleInputPlayerNames_빈값_두개_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputPlayerNames(" , ");
        });
    }

    @Test
    void ruleInputPlayerNames_앞에_빈값_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputPlayerNames(", hee");
        });
    }

    @Test
    void ruleInputPlayerNames_중간_빈값_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputPlayerNames("hee , ,gi");
        });
    }

    @Test
    void ruleInputPlayerNames_6자이상_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputPlayerNames("heebong");
        });
    }

    @Test
    void rulePlayerNameLength_빈값_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.rulePlayerNameLength("");
        });
    }

    @Test
    void rulePlayerNameLength_6글자_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.rulePlayerNameLength("sdfghs");
        });
    }

    @Test
    void rulePlayerCountSize_0_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.rulePlayerCountSize(0);
        });
    }

    @Test
    void ruleLadderDepthRange_0_예외_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleLadderDepthRange(0);
        });
    }

    @Test
    void ruleInputReward_사이즈_초과_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputReward("1,2,3", 2);
        });
    }

    @Test
    void ruleInputReward_사이즈_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputReward("1,2,3", 2);
        });
    }

    @Test
    void ruleInputPlayerNames_중복_이름_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rule.ruleInputPlayerNames("1,2,3,2");
        });
    }
}