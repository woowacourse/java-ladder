package domain;

import laddervalidate.HeightValidator;

public class Height {
    HeightValidator heightValidator = new HeightValidator();
    private int height;
    public Height(String height) {
        heightValidator.checkNumberMissMatch(height);
        heightValidator.checkNumberRange(height);
        this.height = Integer.parseInt(height);
    }

    public boolean isPossibleCount() {
        return this.height > 0;
    }

    public void minusHeight() {
        this.height--;
    }

}
