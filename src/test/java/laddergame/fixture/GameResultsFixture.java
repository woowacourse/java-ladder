package laddergame.fixture;

import laddergame.domain.GameResults;

import java.util.ArrayList;
import java.util.List;

public abstract class GameResultsFixture {
    public static GameResults createGameResults(final int size) {
        final List<String> resultValues = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            resultValues.add("name" + count);
        }
        return new GameResults(resultValues, NamesFixture.createNames(size));
    }
}
