package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectionStrategy;

public class GameTest {

    @Test
    @DisplayName("게임 객체 생성 성공")
    void test_ok_createObject() {
        Members members = Members.from(List.of("a", "b", "c", "d"));

        Ladder ladder = Ladder.of(4, 5, new RandomConnectionStrategy());

        Results results = Results.of(List.of("a!", "b!", "c!", "d!"), 4);

        assertThatCode(() -> new Game(members, ladder, results))
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

        Ladder ladder = Ladder.of(4, 5, new RandomConnectionStrategy() {
            @Override
            public Connection generateConnection() {
                return Connection.DISCONNECTED;
            }
        });

        Results results = Results.of(List.of("a!", "b!", "c!", "d!"), 4);

        Game game = new Game(members, ladder, results);

        GameResult actual = game.matchResult();

        assertThat(actual.getResultByMemberName("a").getValue()).isEqualTo("a!");
        assertThat(actual.getResultByMemberName("b").getValue()).isEqualTo("b!");
        assertThat(actual.getResultByMemberName("c").getValue()).isEqualTo("c!");
        assertThat(actual.getResultByMemberName("d").getValue()).isEqualTo("d!");
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

        Ladder ladder = Ladder.of(4, 3, new RandomConnectionStrategy() {
            @Override
            public Connection generateConnection() {
                return Connection.CONNECTED;
            }
        });

        Results results = Results.of(List.of("a!", "b!", "c!", "d!"), 4);

        Game game = new Game(members, ladder, results);

        GameResult actual = game.matchResult();

        assertThat(actual.getResultByMemberName("a").getValue()).isEqualTo("b!");
        assertThat(actual.getResultByMemberName("b").getValue()).isEqualTo("a!");
        assertThat(actual.getResultByMemberName("c").getValue()).isEqualTo("d!");
        assertThat(actual.getResultByMemberName("d").getValue()).isEqualTo("c!");
    }
}
