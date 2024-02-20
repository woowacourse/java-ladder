package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StepGeneratorTest {
    @Test
    void 디딤판이_같은_층에서_연속해서_생성되지_않도록_한다() {
        boolean beforeValue = true;
        StepGenerator generator = new StepGenerator();
        Assertions.assertEquals(false, generator.generateStep(beforeValue));
    }
}
