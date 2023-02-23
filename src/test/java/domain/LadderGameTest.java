package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import helper.StubTestDigitsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class LadderGameTest {
    private static LadderGame ladderGame;
    private static Players players;
    private static Ladder ladder;

    @BeforeAll
    static void set() {
        players = new Players(List.of("a", "b", "c", "d"));
        StubTestDigitsGenerator randomDigitsGenerator = new StubTestDigitsGenerator(
                List.of(1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0)
        );
        ladder = new Ladder(4, players.getCount() - 1, randomDigitsGenerator);
        ladderGame = new LadderGame(players, ladder);
    }
    
    
    @DisplayName("플레이어의 위치를 가져와서 사다리를 탄다.")
    @Test
    void move() {
            // 오른쪽확인 (현재 인덱스확인)
            // 있으면 오른쪽으로 이동
            // 없으면 왼쪽확인 -1
            // 있으면 왼쪽으로 이동
            // 없으면 패스

    
    }

    @DisplayName("참여자의 위치를 받아 오른쪽에 다리가 있으면 건넌다.")
    @Test
    void move_bridge_to_right() {
        Position position = new Position(0);
        Line line = ladder.getLines().get(0);

        ladderGame.moveRight(line, position);

        assertThat(position.getIndex()).isEqualTo(1);
    }

    @DisplayName("참여자의 위치를 받아 왼쪽에 다리가 있으면 건넌다.")
    @Test
    void move_bridge_to_left() {
        Position position = new Position(1);
        Line line = ladder.getLines().get(0);

        ladderGame.moveLeft(line, position);

        assertThat(position.getIndex()).isEqualTo(0);
    }

    @DisplayName("참여자의 위치를 받아 양쪽에 다리가 없는 경우 건너지 않는다.")
    @Test
    void move_bridge_stay() {
        Position position = new Position(1);
        Line line = ladder.getLines().get(2);

        ladderGame.move(line,position);

        assertThat(position.getIndex()).isEqualTo(1);
    }

    @DisplayName("모든 사다리를 타고난 뒤의 최종 위치를 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"a,0", "b,2", "c,3", "d,1"})
    void move_brdige(String name, int resultIndex) {
        int startIndex = players.getOrder(name);
        Position position = new Position(startIndex);

        for (Line line : ladder.getLines()) {
            ladderGame.move(line, position);
        }

        assertThat(position.getIndex()).isEqualTo(resultIndex);
    }

}
