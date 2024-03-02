package model;

import static org.assertj.core.api.Assertions.assertThat;

import model.generator.StepExistenceGenerator;
import org.junit.jupiter.api.Test;

public class StepExistenceGeneratorTest {
    @Test
    void 디딤판이_같은_층에서_연속해서_생성되지_않도록_한다() {
        boolean priorExistence = true;

        assertThat(StepExistenceGenerator.generateEachExistence(priorExistence)).isFalse();
    }

    @Test
    void 각_사다리층의_디딤판을_생성할_수_있는_공간은_참여자_수에따라_결정된다() {
        int numberOfParticipants = 5;

        assertThat(StepExistenceGenerator.generate(numberOfParticipants)).size().isEqualTo(4);
    }
}
