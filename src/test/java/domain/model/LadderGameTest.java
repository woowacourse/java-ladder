package domain.model;

import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Result;
import domain.vo.Width;
import domain.wrapper.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderGameTest {

    @Test
    void test1() {
        Ladder ladder = new Ladder(new Height(3), new Width(3));
        Layer layer1 = new Layer();
        layer1.makeLine(true);
        layer1.makeLine(false);
        layer1.makeLine(true);
        Layer layer2 = new Layer();
        layer2.makeLine(false);
        layer2.makeLine(true);
        layer2.makeLine(false);
        ladder.addLayer(layer1);
        ladder.addLayer(layer2);
        ladder.addLayer(layer1);

        Player player1 = Player.of(new Name("p1"), Position.of(0,0));
        Player player2 = Player.of(new Name("p2"), Position.of(1,0));
        Player player3 = Player.of(new Name("p3"), Position.of(2,0));

        Result result1 = new Result("꽝");
        Result result2 = new Result("1000");
        Result result3 = new Result("2000");

        LadderGame ladderGame = new LadderGame(
                ladder,
                List.of(player1, player2, player3),
                List.of(result1, result2, result3)
        );

        ladderGame.play();
    }
}


// - x -
// x - x
// - x -