package ladder.domain;

class LadderStair {
    private boolean isExist;
    private boolean isEnd = false;

    private LadderStair(boolean isExist) {
        this.isExist = isExist;
    }

    static LadderStair start() {
        return new LadderStair(false);
    }

    LadderStair next(boolean isNextExist) {
        if(isEnd)
            throw new IllegalArgumentException();
        if(isExist && isNextExist)
            throw new IllegalArgumentException();
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
