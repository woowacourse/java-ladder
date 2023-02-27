package laddergame.domain.generator;

import laddergame.domain.ladder.line.StepPoint;

public interface StepPointGenerator {

    StepPoint generate(StepPoint previousValue);
}
