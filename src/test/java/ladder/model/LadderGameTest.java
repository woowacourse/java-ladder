package ladder.model;

import ladder.model.generator.MemberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        String[] names = {"pobi", "hunux", "jk", "crong"};
        List<Member> member = MemberGenerator.generateMembers(names);
        List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");
        int [][] linkedStatus = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 0},
                {0, 1, 0},
                {1, 0, 1}
        };
        ladderGame = new LadderGame(member, linkedStatus, results);
    }

    @Test
    void 사다리_높이에_따라_row_생성되는지_확인() {
        int rowCount = ladderGame.getLadderHeight();
        assertThat(rowCount).isEqualTo(5);
    }
}
