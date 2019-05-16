package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void 사다리_높이에_따라_row_생성되는지_확인() {
        String[] names = {"pobi", "crong"};
        List<Member> member = Members.generateMembers(names);
        LadderGame ladderGame = new LadderGame(member, 3);
        int rowCount = ladderGame.getLadderHeight();
        assertThat(rowCount).isEqualTo(3);
    }
}
