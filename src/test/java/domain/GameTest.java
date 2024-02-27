package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strategy.RandomConnectionStrategy;

public class GameTest {

    @Test
    @DisplayName("게임 객체 생성 성공")
    void test_ok_createObject() {
        Members members = Members.from("a,b,c,d");

        Lines lines = Lines.of(4, 5, new RandomConnectionStrategy());

        Results results = Results.of(List.of("a!", "b!", "c!", "d!"), 4);

        assertThatCode(() -> new Game(members, lines, results))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이동 성공: 사다리를 타고 참여자와 결과를 매칭한다.")
    void test_ok_matchResult() {

        Members members = Members.from("a,b,c,d");

        Lines lines = Lines.of(4, 5, new RandomConnectionStrategy() {
            @Override
            public Connection generateConnection() {
                return Connection.DISCONNECTED;
            }
        });

        Results results = Results.of(List.of("a!", "b!", "c!", "d!"), 4);

        Game game = new Game(members, lines, results);

        HashMap<String, Result> actual = game.matchResult();

        assertThat(actual.get("a").getValue()).isEqualTo("a!");
        assertThat(actual.get("b").getValue()).isEqualTo("b!");
        assertThat(actual.get("c").getValue()).isEqualTo("c!");
        assertThat(actual.get("d").getValue()).isEqualTo("d!");
    }
}
