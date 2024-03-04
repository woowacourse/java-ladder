package laddergame.view;

import java.util.Arrays;

public enum ReservedWords {
    ALL("all");

    private final String word;

    ReservedWords(final String word) {
        this.word = word;
    }

    public static boolean isReserved(final String name) {
        return Arrays.stream(ReservedWords.values())
                .anyMatch(reservedWord -> reservedWord.word.equals(name));
    }
}

