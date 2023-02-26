package laddergame.controller;

import java.util.Arrays;

public enum SearchType {

    FIND_ALL("all"),
    FIND_BY_NAME(null),
    QUIT("Q");

    SearchType(String keyword) {
        this.keyword = keyword;
    }

    private final String keyword;

    public static SearchType match(String keyword) {
        return Arrays.stream(values())
                .filter(type -> type.isSameKeyword(keyword))
                .findFirst()
                .orElse(FIND_BY_NAME);
    }

    private boolean isSameKeyword(String keyword) {
        if (this.keyword == null) {
            return false;
        }
        return this.keyword.equalsIgnoreCase(keyword);
    }
}
