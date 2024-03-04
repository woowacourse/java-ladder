package model.ladder.generator;

import model.ladder.StepStatus;

@FunctionalInterface
public interface StepStatusGenerator {
    StepStatus generate();
}
