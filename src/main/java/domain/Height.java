package domain;

import domain.validator.HeightValidator;

public class Height {

    private final int height;

    public Height(int height) {
        HeightValidator heightValidator = new HeightValidator();
        heightValidator.checkNegativeNumber(height);
        this.height = height;
    }

    public boolean isSameHeight(int count) {
        return count < height;
    }
}
