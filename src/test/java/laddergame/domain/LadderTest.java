package laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderTest {

    @Test
    public void 레더_테스트_사다리의_너비가_1일때() {
        Ladder ladder = new Ladder(1, 1);
        assertThat(ladder.isLinked(1, 1)).isFalse();
    }

    @Test
    public void 사다리에서_이웃한_연결로를_추가할_때_예외발생하는지_검사() {
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
    public void 레더_테스트2() {
        Ladder ladder = new Ladder(1, 2);
        ladder.connectBridge(1, 1);
        assertThat(ladder.isLinked(1, 1)).isTrue();
    }

    @Test
    public void 레더_테스트3() {
        Ladder ladder = new Ladder(2, 2);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);
        assertThat(ladder.isLinked(1, 1)).isTrue();
        assertThat(ladder.isLinked(2, 1)).isTrue();
    }

    @Test
    public void 레더_테스트4() {
        Ladder ladder = new Ladder(3, 3);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(3, 2);
        assertThat(ladder.isLinked(1, 1)).isTrue();
        assertThat(ladder.isLinked(2, 1)).isTrue();
        assertThat(ladder.isLinked(3, 2)).isTrue();
    }

    @Test
    public void 레더_테스트_사다리의_너비가_1일때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 1);
        assertThat(ladder.findResultIndex(1)).isEqualTo(1);

        ladder = new Ladder(2, 1);
        assertThat(ladder.findResultIndex(1)).isEqualTo(1);
    }

    @Test
    public void 레더_테스트_사다리의_너비가_2일때_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 2);
        ladder.connectBridge(1, 1);
        assertThat(ladder.findResultIndex(1)).isEqualTo(2);
        assertThat(ladder.findResultIndex(2)).isEqualTo(1);
    }

    @Test
    public void 레더_테스트_사다리의_너비가_5일때_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);
        //          |    |-----|   |-----|
        assertThat(ladder.findResultIndex(1)).isEqualTo(1);
        assertThat(ladder.findResultIndex(2)).isEqualTo(3);
        assertThat(ladder.findResultIndex(3)).isEqualTo(2);
        assertThat(ladder.findResultIndex(4)).isEqualTo(5);
        assertThat(ladder.findResultIndex(5)).isEqualTo(4);
    }

    @Test
    public void 레더_테스트_사다리의_높이가_2고_너비가_5일때_제대로_찾는지() {
        Ladder ladder = new Ladder(2, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(2, 3);
        //          |     |------|      |------|
        //          |-----|      |------|      |
        assertThat(ladder.findResultIndex(1)).isEqualTo(2);
        assertThat(ladder.findResultIndex(2)).isEqualTo(4);
        assertThat(ladder.findResultIndex(3)).isEqualTo(1);
        assertThat(ladder.findResultIndex(4)).isEqualTo(5);
        assertThat(ladder.findResultIndex(5)).isEqualTo(3);
    }

    @Test
    public void 레더_테스트_사다리의_높이가_3고_너비가_5일때_제대로_찾는지() {
        Ladder ladder = new Ladder(3, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);;
        ladder.connectBridge(2, 1);
        ladder.connectBridge(2, 3);
        ladder.connectBridge(3, 3);
        //          |     |------|      |------|
        //          |-----|      |------|      |
        //          |     |      |------|      |
        assertThat(ladder.findResultIndex(1)).isEqualTo(2);
        assertThat(ladder.findResultIndex(2)).isEqualTo(3);
        assertThat(ladder.findResultIndex(3)).isEqualTo(1);
        assertThat(ladder.findResultIndex(4)).isEqualTo(5);
        assertThat(ladder.findResultIndex(5)).isEqualTo(4);
    }
}
