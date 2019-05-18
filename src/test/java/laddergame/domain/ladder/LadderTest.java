package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 레더_테스트_사다리의_너비가_1일때() {
        Ladder ladder = new Ladder(1, 1);
        assertThat(ladder.isLinked(1, 1)).isFalse();
    }

    @Test
    public void 연속된_연결로를_추가할때_검사_4X4사다리() {
        Ladder ladder = new Ladder(4, 4);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(1, 3);

        assertThat(ladder.isLinked(1, 1)).isFalse();
        assertThat(ladder.isLinked(1, 3)).isFalse();

        ladder.connectBridge(2, 2);

        assertThat(ladder.isLinked(2, 2)).isFalse();
    }

    @Test
    public void 연속된_연결로를_추가할때_추가가_안되는지_검사_1X2사다리() {
        Ladder ladder = new Ladder(1, 2);
        ladder.connectBridge(1, 1);

        assertThat(ladder.isLinked(1, 1)).isTrue();
    }

    @Test
    public void 레더_테스트_2X2크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(2, 2);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);

        assertThat(ladder.isLinked(1, 1)).isTrue();
        assertThat(ladder.isLinked(2, 1)).isTrue();
    }

    @Test
    public void 레더_테스트_3X3크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(3, 3);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(3, 2);

        assertThat(ladder.isLinked(1, 1)).isTrue();
        assertThat(ladder.isLinked(2, 1)).isTrue();
        assertThat(ladder.isLinked(3, 2)).isTrue();
    }

    @Test
    public void 레더_테스트_1X1크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 1);
        assertThat(ladder.findDestination(1)).isEqualTo(1);

        ladder = new Ladder(2, 1);
        assertThat(ladder.findDestination(1)).isEqualTo(1);
    }

    @Test
    public void 레더_테스트_1X2크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 2);
        ladder.connectBridge(1, 1);

        assertThat(ladder.findDestination(1)).isEqualTo(2);
        assertThat(ladder.findDestination(2)).isEqualTo(1);
    }

    @Test
    public void 레더_테스트_1X5크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);

        assertThat(ladder.findDestination(1)).isEqualTo(1);
        assertThat(ladder.findDestination(2)).isEqualTo(3);
        assertThat(ladder.findDestination(3)).isEqualTo(2);
        assertThat(ladder.findDestination(4)).isEqualTo(5);
        assertThat(ladder.findDestination(5)).isEqualTo(4);
    }

    @Test
    public void 레더_테스트_2X5크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(2, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(2, 3);

        assertThat(ladder.findDestination(1)).isEqualTo(2);
        assertThat(ladder.findDestination(2)).isEqualTo(4);
        assertThat(ladder.findDestination(3)).isEqualTo(1);
        assertThat(ladder.findDestination(4)).isEqualTo(5);
        assertThat(ladder.findDestination(5)).isEqualTo(3);
    }

    @Test
    public void 레더_테스트_3X5크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(3, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(2, 3);
        ladder.connectBridge(3, 3);

        assertThat(ladder.findDestination(1)).isEqualTo(2);
        assertThat(ladder.findDestination(2)).isEqualTo(3);
        assertThat(ladder.findDestination(3)).isEqualTo(1);
        assertThat(ladder.findDestination(4)).isEqualTo(5);
        assertThat(ladder.findDestination(5)).isEqualTo(4);
    }

    @Test
    public void 레더_테스트_6X3크기일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(6, 3);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(3, 1);
        ladder.connectBridge(5, 2);

        assertThat(ladder.findDestination(1)).isEqualTo(3);
        assertThat(ladder.findDestination(2)).isEqualTo(1);
        assertThat(ladder.findDestination(3)).isEqualTo(2);
    }
}
