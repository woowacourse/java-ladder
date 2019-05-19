package ladder.domain;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
class LadderResultTest {
    Players players;
    Items items;
    LineResult lineResult;
    LadderResult ladderResult;
    Map<Player, Item> result;

    @BeforeEach
    void setUp() {
        players = Players.newBuilder("pobi, hello, mynam, is");
        items = Items.newBuilder("pass, 1000, 2000, star",players.size());
        lineResult = LineResult.newBuilder(Arrays.asList(3,2,0,1));

        ladderResult = LadderResult.newBuild(players, items, lineResult);
        result = new HashMap<>();
        result.put(Player.newBuilder("pobi"), Item.newBuilder("star"));
        result.put(Player.newBuilder("hello"), Item.newBuilder("2000"));
        result.put(Player.newBuilder("mynam"), Item.newBuilder("pass"));
        result.put(Player.newBuilder("is"), Item.newBuilder("1000"));
    }

    @Test
    void newBuild() {
        assertThat(ladderResult.getResult()).isEqualTo(result);
    }

    @Test
    void 이름_가져오기() {
        assertThat(ladderResult.matchItem("pobi")).isEqualTo("star");
    }

    @Test
    void 이름_전부_가져오기() {
        StringBuilder sb = new StringBuilder();
        sb.append("pobi : star\n");
        sb.append("hello : 2000\n");
        sb.append("mynam : pass\n");
        sb.append("is : 1000");
        assertThat(ladderResult.matchItem("all")).isEqualTo(sb.toString());
    }
}