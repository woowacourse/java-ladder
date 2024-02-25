package laddergame.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.player.Players;
import laddergame.domain.point.Point;
import laddergame.dto.DrawnLadderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {


    @DisplayName("사다리 게임이 초기화 된다.")
    @Test
    void create() {
        // given
        final List<String> input = List.of("pobi", "honux", "crong", "jk");

        final Players names = new Players(input);
        final LadderHeight height = new LadderHeight(5);

        final LadderGame ladderGame = new LadderGame(() -> Point.EXIST);

        // when
        final Ladder ladder = ladderGame.createLadder(names, height);

        // then
        assertThat(ladder.getLines()).hasSize(5)
                .extracting("points")
                .containsExactly(
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST),
                        List.of(Point.EXIST, Point.EMPTY, Point.EXIST));
    }
}
