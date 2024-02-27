package model.ladder;

@FunctionalInterface
public interface StepStatusGenerator {
    StepStatus generate();
}
