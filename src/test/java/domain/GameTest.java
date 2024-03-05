package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectionStrategy;

public class GameTest {

    @Test
    @DisplayName("게임 객체 생성 성공")
    void test_ok_createObject() {
        Members members = Members.from(List.of("a", "b", "c", "d"));

        Ladder ladder = Ladder.of(5, 4, new RandomConnectionStrategy());

        Rewards rewards = Rewards.of(List.of("a!", "b!", "c!", "d!"), 4);

        assertThatCode(() -> new Game(members, ladder, rewards))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이동 성공: 사다리를 타고 참여자와 결과를 매칭한다. - 모두 연결되지 않은 경우")
    void test_ok_matchResult_allDisconnected() {

        /*
        a     b     c     d
        |     |     |     |
        |     |     |     |
        |     |     |     |
        |     |     |     |
        |     |     |     |
       a!    b!    c!    d!
         */

        Members members = Members.from(List.of("a", "b", "c", "d"));

        Ladder ladder = Ladder.of(5, 4, new RandomConnectionStrategy() {
            @Override
            public Connection generateConnection() {
                return Connection.DISCONNECTED;
            }
        });

        Rewards rewards = Rewards.of(List.of("a!", "b!", "c!", "d!"), 4);

        Game game = new Game(members, ladder, rewards);

        GameResult actual = game.matchResult();

        ResultTarget targetA = ResultTarget.of("a", members.getMembers());
        assertThat(actual.getResultByTarget(targetA).getGameResult().get(new Member("a")).getValue()).isEqualTo("a!");

        ResultTarget targetB = ResultTarget.of("b", members.getMembers());
        assertThat(actual.getResultByTarget(targetB).getGameResult().get(new Member("b")).getValue()).isEqualTo("b!");

        ResultTarget targetC = ResultTarget.of("c", members.getMembers());
        assertThat(actual.getResultByTarget(targetC).getGameResult().get(new Member("c")).getValue()).isEqualTo("c!");

        ResultTarget targetD = ResultTarget.of("d", members.getMembers());
        assertThat(actual.getResultByTarget(targetD).getGameResult().get(new Member("d")).getValue()).isEqualTo("d!");
    }

    @Test
    @DisplayName("이동 성공: 사다리를 타고 참여자와 결과를 매칭한다.")
    void test_ok_matchResult() {

        /*
        a     b     c     d
        |-----|     |-----|
        |-----|     |-----|
        |-----|     |-----|
       a!    b!    c!    d!
         */

        Members members = Members.from(List.of("a", "b", "c", "d"));

        Ladder ladder = Ladder.of(3, 4, new RandomConnectionStrategy() {
            @Override
            public Connection generateConnection() {
                return Connection.CONNECTED;
            }
        });

        Rewards rewards = Rewards.of(List.of("a!", "b!", "c!", "d!"), 4);

        Game game = new Game(members, ladder, rewards);

        GameResult actual = game.matchResult();

        ResultTarget targetA = ResultTarget.of("a", members.getMembers());
        assertThat(actual.getResultByTarget(targetA).getGameResult().get(new Member("a")).getValue()).isEqualTo("b!");

        ResultTarget targetB = ResultTarget.of("b", members.getMembers());
        assertThat(actual.getResultByTarget(targetB).getGameResult().get(new Member("b")).getValue()).isEqualTo("a!");

        ResultTarget targetC = ResultTarget.of("c", members.getMembers());
        assertThat(actual.getResultByTarget(targetC).getGameResult().get(new Member("c")).getValue()).isEqualTo("d!");

        ResultTarget targetD = ResultTarget.of("d", members.getMembers());
        assertThat(actual.getResultByTarget(targetD).getGameResult().get(new Member("d")).getValue()).isEqualTo("c!");
    }
}
