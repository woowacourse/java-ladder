package ladder.domain;

class LadderStair {
    private static final String END_LINE_EXCEPTION_MASSAGE = "해당 줄은 이미 끝난 줄입니다.";
    private static final String CONSECUTIVE_LADDER_STAIR_EXCEPTION_MASSAGE = "사다리 디딤대는 가로로 연속해서 존재할 수 없습니다.";

    private boolean isExist;
    private boolean isEnd = false;

    private LadderStair(boolean isExist) {
        this.isExist = isExist;
    }

    static LadderStair start() {
        return new LadderStair(false);
    }

    LadderStair next(boolean isNextExist) {
        if (isEnd)
            throw new IllegalArgumentException(END_LINE_EXCEPTION_MASSAGE);
        if (isExist && isNextExist)
            throw new IllegalArgumentException(CONSECUTIVE_LADDER_STAIR_EXCEPTION_MASSAGE);
        isExist = isNextExist;
        return new LadderStair(isNextExist);
    }

    void end() {
        isEnd = true;
    }

    boolean isExist() {
        return isExist;
    }
}
