package model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class StepExistenceGeneratorTest {
    @Test
    void 디딤판이_같은_층에서_연속해서_생성되지_않도록_한다() {
        boolean priorExistence = true;
        assertFalse(StepExistenceGenerator.generate(priorExistence));
    }
}
