package com.woowacourse.ladder.domain;

public class Height {
    private final int height;

    public Height(String height) {
        this.height = Integer.parseInt(height);
    }

    public int getHeight() {
        return height;
    }
}
