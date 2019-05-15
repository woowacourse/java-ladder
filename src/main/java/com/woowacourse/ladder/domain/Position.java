package com.woowacourse.ladder.domain;

public class Position {
    private final int widthPos;
    private final int heightPos;

    Position(final int widthPos, final int heightPos) {
        this.widthPos = widthPos;
        this.heightPos = heightPos;
    }

    public boolean isMatch(Position position) {
        return (this.heightPos == position.heightPos) && (this.widthPos == position.widthPos);
    }

    public boolean isMatchWidth(int widthPos){
        return this.widthPos == widthPos;
    }
}
