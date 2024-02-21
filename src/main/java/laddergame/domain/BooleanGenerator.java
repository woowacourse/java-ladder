package laddergame.domain;

import java.util.List;

@FunctionalInterface
public interface BooleanGenerator {

    List<Boolean> generateUntil(final int size);
}
