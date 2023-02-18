package model;

public enum LadderStep {
    //첫 STEP 길이는 플레이어 이름 길이 제한, 나머지 STEP 길이는 플레이어 이름 길이 제한 + 1로 설정한다.
    FIRST_STEP(String.format("%5s", "    |")),
    EMPTY_STEP(String.format("%6s", "     |")),
    EXIST_STEP(String.format("%6s", "-----|"));

    private final String step;

    LadderStep(String step) {
        this.step = step;
    }

    public String getStep() {
        return step;
    }
}
