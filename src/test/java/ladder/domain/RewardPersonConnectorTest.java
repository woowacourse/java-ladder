package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardPersonConnectorTest {
    List<Integer> allResult;
    Person person;
    LadderRewards ladderRewards;
    RewardPersonConnector rewardPersonConnector;
    LadderGameData ladderGameData;
    List<Line> lines;

    @BeforeEach
    void setUp() {
        allResult = Arrays.asList(1, 2, 3);
        person = new Person(Arrays.asList("pobi", "brown", "woni"));
        ladderRewards = new LadderRewards(Arrays.asList("꽝", "5000", "꽝"));
        ladderGameData = new LadderGameData(person, ladderRewards);
        lines = Arrays.asList(new Line(Arrays.asList(false, false, false, false)));
        rewardPersonConnector = new RewardPersonConnector(Ladder.newLadderUsingDecidedLine(lines), ladderGameData);
    }

    @Test
    void 생성자확인() {
        assertThat(rewardPersonConnector).isEqualTo(new RewardPersonConnector(Ladder.newLadderUsingDecidedLine(lines), ladderGameData));
    }

    @Test
    void 결과_출력() {
        assertThat(rewardPersonConnector.getResult("woni")).isEqualTo("꽝");
        assertThat(rewardPersonConnector.getResult("all")).isEqualTo("pobi : 꽝\nbrown : 5000\nwoni : 꽝\n");
    }
}

