package laddergame.fixture;

import laddergame.domain.GameResults;

import java.util.List;

public abstract class GameResultsFixture {
    public static GameResults createResultsSize2() {
        return new GameResults(List.of("hello", "helo"), NamesFixture.getNamesSize2());
    }

    public static GameResults createResultsSize3() {
        return new GameResults(List.of("hello", "helo", "hi"), NamesFixture.getNamesSize3());
    }
}
