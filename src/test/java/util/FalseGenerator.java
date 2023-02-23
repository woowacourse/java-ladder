package util;

import domain.Bridge;

public class FalseGenerator implements BooleanGenerator {
    @Override
    public Boolean generate() {
        return false;
    }
}
