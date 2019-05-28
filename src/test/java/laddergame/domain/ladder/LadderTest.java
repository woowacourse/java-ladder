package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리에서_이웃한_연결로를_추가할_때_예외발생하는지_검사() {
        Ladder ladder = new Ladder(4, 4);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(1, 3);
        /*
        |---|---|---|
        |---|---|   |
        |   |   |   |
        |   |   |   |
         */
        assertThat(ladder.isLinked(1, 1)).isFalse();
        assertThat(ladder.isLinked(1, 3)).isFalse();

        ladder.connectBridge(2, 2);
        assertThat(ladder.isLinked(2, 2)).isFalse();
    }

    @Test
    public void 사다리_높이가_1_너비가_1일_때_연결로_추가() {
        Ladder ladder = new Ladder(1, 1);
        /*
        |
         */
        ladder.connectBridge(1, 0);
        assertThat(ladder.isLinked(1, 1)).isFalse();
    }

    @Test
    public void 사다리_높이가_2_너비가_2일_때_연결로_추가() {
        Ladder ladder = new Ladder(2, 2);
        /*
        |---|
        |---|
         */
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);
        assertThat(ladder.isLinked(1, 1)).isTrue();
        assertThat(ladder.isLinked(2, 1)).isTrue();
    }

    @Test
    public void 사다리_높이가_3_너비가_3일_때_연결로_추가() {
        Ladder ladder = new Ladder(3, 3);
        /*
        |---|   |
        |---|   |
        |   |---|
         */
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(3, 2);
        assertThat(ladder.isLinked(1, 1)).isTrue();
        assertThat(ladder.isLinked(2, 1)).isTrue();
        assertThat(ladder.isLinked(3, 2)).isTrue();
    }

    @Test
    public void 사다리_너비가_1일_때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 1);
        assertThat(ladder.findIndexOfResult(1)).isEqualTo(1);

        ladder = new Ladder(2, 1);
        assertThat(ladder.findIndexOfResult(1)).isEqualTo(1);
    }

    @Test
    public void 사다리의_너비가_2일_때_경로를_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 2);
        ladder.connectBridge(1, 1);
        assertThat(ladder.findIndexOfResult(0)).isEqualTo(1);
        assertThat(ladder.findIndexOfResult(1)).isEqualTo(0);
    }

    @Test
    public void 사다리의_너비가_5일_때_제대로_찾는지() {
        Ladder ladder = new Ladder(1, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);
        //          |    |-----|   |-----|
        assertThat(ladder.findIndexOfResult(0)).isEqualTo(0);
        assertThat(ladder.findIndexOfResult(1)).isEqualTo(2);
        assertThat(ladder.findIndexOfResult(2)).isEqualTo(1);
        assertThat(ladder.findIndexOfResult(3)).isEqualTo(4);
        assertThat(ladder.findIndexOfResult(4)).isEqualTo(3);
    }

    @Test
    public void 레더_테스트_사다리의_높이가_2고_너비가_5일_때_제대로_찾는지() {
        Ladder ladder = new Ladder(2, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(2, 3);
        //          |     |------|      |------|
        //          |-----|      |------|      |
        assertThat(ladder.findIndexOfResult(0)).isEqualTo(1);
        assertThat(ladder.findIndexOfResult(1)).isEqualTo(3);
        assertThat(ladder.findIndexOfResult(2)).isEqualTo(0);
        assertThat(ladder.findIndexOfResult(3)).isEqualTo(4);
        assertThat(ladder.findIndexOfResult(4)).isEqualTo(2);
    }

    @Test
    public void 레더_테스트_사다리의_높이가_3고_너비가_5일_때_제대로_찾는지() {
        Ladder ladder = new Ladder(3, 5);
        ladder.connectBridge(1, 2);
        ladder.connectBridge(1, 4);;
        ladder.connectBridge(2, 1);
        ladder.connectBridge(2, 3);
        ladder.connectBridge(3, 3);
        //          |     |------|      |------|
        //          |-----|      |------|      |
        //          |     |      |------|      |
        assertThat(ladder.findIndexOfResult(0)).isEqualTo(1);
        assertThat(ladder.findIndexOfResult(1)).isEqualTo(2);
        assertThat(ladder.findIndexOfResult(2)).isEqualTo(0);
        assertThat(ladder.findIndexOfResult(3)).isEqualTo(4);
        assertThat(ladder.findIndexOfResult(4)).isEqualTo(3);
    }

    @Test
    public void 레더_테스트_사다리의_높이가_6고_너비가_3일_때_제대로_찾는지() {
        Ladder ladder = new Ladder(6, 3);
        ladder.connectBridge(1, 1);
        ladder.connectBridge(2, 1);
        ladder.connectBridge(3, 1);
        ladder.connectBridge(5, 2);
        //          |-----|      |
        //          |-----|      |
        //          |-----|      |
        //          |-----|      |
        //          |     |------|
        //          |     |      |
        assertThat(ladder.findIndexOfResult(0)).isEqualTo(2);
        assertThat(ladder.findIndexOfResult(1)).isEqualTo(0);
        assertThat(ladder.findIndexOfResult(2)).isEqualTo(1);
    }
}
