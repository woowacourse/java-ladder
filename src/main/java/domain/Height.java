package domain;

import laddervalidate.HeightValidator;

public class Height {
    private static final int FINISH_NUMBER = 0;

    private int height;

    public Height(String height) {
        HeightValidator heightValidator = new HeightValidator();
        heightValidator.checkNumberMissMatch(height);
        heightValidator.checkNegativeNumber(height);
        this.height = Integer.parseInt(height);
    }

    public boolean isPossibleCount() {
        return this.height > FINISH_NUMBER;
    }

    public void minusHeight() {
        this.height--;
    }
}
