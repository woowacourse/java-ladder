package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LayerTest {
    @Test
    void 각_사다리층의_디딤판을_생성할_수_있는_공간은_참여자_수에따라_결정된다() {
        int numberOfParticipants = 5;

        assertThat(new Layer(numberOfParticipants).getLayerSize()).isEqualTo(4);
    }
}
