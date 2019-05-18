package com.woowacourse.laddergame.domain.vo;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeightVo {
    private static final Pattern HEIGHT_PATTERN = Pattern.compile("^([1-9])([0-9])*$");
    private final int height;

    public HeightVo(String height) {
        checkValidation(height);
        this.height = Integer.parseInt(height);
    }

    private void checkValidation(String height) {
        checkNull(height);
        checkPattern(height);
    }

    private void checkNull(String height) {
        if (height == null) {
            throw new IllegalArgumentException("Null 은 입력할 수 없습니다");
        }
    }

    private void checkPattern(String height) {
        Matcher matcher = HEIGHT_PATTERN.matcher(height);
        if (!matcher.find()) {
            throw new IllegalArgumentException("정상적인 사다리 높이가 아닙니다");
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeightVo)) return false;
        HeightVo heightVo = (HeightVo) o;
        return getHeight() == heightVo.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight());
    }
}
