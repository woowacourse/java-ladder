package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StepExistenceGeneratorTest {
    @Test
    void 디딤판이_같은_층에서_연속해서_생성되지_않도록_한다() {
        boolean priorExistence = true;

        assertThat(StepExistenceGenerator.generate(priorExistence)).isFalse();
    }
}
