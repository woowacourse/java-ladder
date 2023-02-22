package domain.model;

import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import domain.wrapper.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {

    @Test
    void move() {
        Layer layer = new Layer();
        layer.makeLine(true);
        layer.makeLine(false);
        layer.makeLine(true);
        Ladder ladder = new Ladder(new Height(3), new Width(3));
        ladder.addLayer(layer);
        ladder.addLayer(layer);
        ladder.addLayer(layer);

        Player player = Player.of(new Name("name1"), Position.of(0));

        player.move(ladder);
        assertThat(player.getXPosition()).isEqualTo(1);
        player.move(ladder);
        assertThat(player.getXPosition()).isEqualTo(0);
        player.move(ladder);
        assertThat(player.getXPosition()).isEqualTo(1);

    }
}