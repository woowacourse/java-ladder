package laddergame.util;

import java.util.Arrays;

public enum ReservedWords {
    ALL("all");

    private final String word;

    ReservedWords(final String word) {
        this.word = word;
    }

    public static boolean isIncluded(final String name) {
        return Arrays.stream(ReservedWords.values())
                .anyMatch(reservedWord -> reservedWord.word.equals(name));
    }
}

