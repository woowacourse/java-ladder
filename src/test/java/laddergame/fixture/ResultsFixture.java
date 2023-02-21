package laddergame.fixture;

import laddergame.domain.Results;

import java.util.List;

public abstract class ResultsFixture {
    public static Results createResultsSize2() {
        return new Results(List.of("hello", "helo"), NamesFixture.getNamesSize2());
    }

    public static Results createResultsSize3() {
        return new Results(List.of("hello", "helo", "hi"), NamesFixture.getNamesSize3());
    }
}
