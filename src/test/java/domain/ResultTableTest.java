package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
}
