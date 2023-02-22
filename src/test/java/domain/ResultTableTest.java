package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTableTest {

    ResultTable resultTable;

    @BeforeEach
    void setUp() {
        resultTable = new ResultTable();
    }

    @Test
    @DisplayName("initialize를 통해 user를 전달하면 value에 null을 할당한다.")
    void initialize() {
        User polo = new User("polo");

        resultTable.initialize(polo);
        Reward reward = resultTable.getRewardByUser(polo);

        assertThat(reward).isNull();
    }

    @Test
    @DisplayName("value가 null인 key를 List로 반환한다.")
    void getUserWithoutReward() {
        User polo = new User("polo");
        User pobi = new User("pobi");
        User mako = new User("mako");
        User fox = new User("fox");
        resultTable.initialize(polo);
        resultTable.initialize(pobi);
        resultTable.initialize(mako);
        resultTable.initialize(fox);
        Reward first = new Reward("1");
        Reward second = new Reward("2");
        resultTable.save(polo,first);
        resultTable.save(mako,second);

        List<User> users = resultTable.getUsersWithoutReward();

        assertThat(users).containsExactly(pobi, fox);
    }
}
