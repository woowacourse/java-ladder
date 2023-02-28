package domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {

    Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(3, 4);

        Layer layer1 = new Layer();
        layer1.makeLine(true);
        layer1.makeLine(false);
        layer1.makeLine(true);

        Layer layer2 = new Layer();
        layer2.makeLine(false);
        layer2.makeLine(true);
        layer2.makeLine(false);

        Layer layer3 = new Layer();
        layer3.makeLine(true);
        layer3.makeLine(false);
        layer3.makeLine(true);

        ladder.addLayer(layer1);
        ladder.addLayer(layer2);
        ladder.addLayer(layer3);
    }

    @DisplayName("플레이어가 이동하면 position 1씩 증가한다.")
    @Nested
    class move {

        Player player;

        @BeforeEach
        void setUp() {
            player = new Player("name1");
            player.initPosition(0);

        }

        @DisplayName("플레이어가 1회 이동했을 때 position의 x가 1만큼 증가한다.")
        @Test
        void move1() {
            player.move(ladder);
            assertThat(player.getXPosition()).isEqualTo(1);
        }

        @DisplayName("플레이어가 2회 이동했을 때 position의 x가 2만큼 증가한다.")
        @Test
        void move2() {
            player.move(ladder);
            player.move(ladder);
            assertThat(player.getXPosition()).isEqualTo(2);
        }

        @DisplayName("플레이어가 3회 이동했을 때 position의 x가 3만큼 증가한다.")
        @Test
        void move3() {
            player.move(ladder);
            player.move(ladder);
            player.move(ladder);
            assertThat(player.getXPosition()).isEqualTo(3);
        }

    }

}