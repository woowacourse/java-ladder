package model;

import java.util.function.IntUnaryOperator;

public enum Pass {
    LEFT(index -> index - 1), // "--ㅣ  "
    RIGHT(index -> index + 1),// "  ㅣ--"
    NOTHING(index -> index);  // "  ㅣ  "

    private final IntUnaryOperator nextLineIndex;

    Pass(IntUnaryOperator nextLineIndex) {
        this.nextLineIndex = nextLineIndex;
    }

    public int nextindex(int playerIndex) {
        return nextLineIndex.applyAsInt(playerIndex);
    }
}
