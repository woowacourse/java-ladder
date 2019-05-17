package com.woowacourse.ladder.domain;

public class Height {
    private final int height;

    public Height(String height) {
        if (!isValidHeight(height)) {
            throw new IllegalArgumentException("올바른 높이 입력을 해주세요");
        }
        this.height = Integer.parseInt(height);
    }

    private boolean isValidHeight(String height) {
        if (!isNumber(height)) {
            return false;
        }
        return Integer.parseInt(height) > 1;
    }

    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getHeight() {
        return height;
    }
}
